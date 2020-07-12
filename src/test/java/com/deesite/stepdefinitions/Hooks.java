package com.deesite.stepdefinitions;

import com.deesite.utils.DriverManager;
import com.deesite.utils.GlobalParams;
import com.deesite.utils.ServerManager;
import com.deesite.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;


public class Hooks {
    @Before
    public void initialize() throws Exception {
        /* Moved into RunCucumberTest class.
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getDeviceName());
        new ServerManager().startServer();
        new DriverManager().initializeDriver();
        */
        new VideoManager().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        new VideoManager().stopRecording(scenario.getName());
        /* Moved into RunCucumberTest class.
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
        */
    }
}
