package com.deesite.runners;

import com.deesite.utils.DriverManager;
import com.deesite.utils.GlobalParams;
import com.deesite.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber"
                , "summary"
                , "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"
                , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources"},
        glue = {"com.deesite.stepdefinitions"},
        snippets = CAMELCASE,
        dryRun = false,
        monochrome = true,
        strict = true,
        tags = "@test"
        //,tags = {"@foo", "not @bar"}
)
public class RunCucumberTest {
    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());

        new ServerManager().startServer();
        new DriverManager().initializeDriver();
    }

    @AfterClass
    public static void quit() {
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
    }
}

// Execution commands from terminal
// mvn test -DplatformName="Android" -Dudid="" -DdeviceName="Samsung" -DsystemPort="10002" -DchromeDriverPort="11002"
// mvn test -DplatformName="iOS" -Dudid="C4311B04-0443-41DE-95FB-117CF55B41F7" -DdeviceName="iPhoneX" -DsystemPort="10002" -DwebkitDebugProxyPort="11003"


// For Parallel reporting
// mvn test -Dcucumber.options="--plugin html:target/android/cucumber --plugin de.monochromata.cucumber.report.PrettyReports:target/android/cucumber-html-reports --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" -DplatformName="Android" -Dudid="" -DdeviceName="Samsung" -DsystemPort="10002" -DchromeDriverPort="11002"
// mvn test -Dcucumber.options="--plugin html:target/ios/cucumber --plugin de.monochromata.cucumber.report.PrettyReports:target/ios/cucumber-html-reports --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" -DplatformName="iOS" -Dudid="6DEFD2AF-F73A-4AC0-ABB4-893E80E85371" -DdeviceName="iPhone 11 Pro" -DsystemPort="10002" -DwebkitDebugProxyPort="11003"

