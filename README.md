# DeeCucumberWeb

A Cucumber framework which can be used for automation testing for android and iOS using Appium with minimal changes.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
What things you need to install the software and how to install them

Download apks and ipas in below location from: - 
https://github.com/saucelabs/sample-app-mobile/releases

/Users/deepakarora/git/AppiumCucumberFramework/src/test/resources/apps


```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Navigate to project root folder within terminal or command prompt and execute following command: - 
Execution commands from terminal

``mvn test -DplatformName="Android" -Dudid="" -DdeviceName="Samsung" -DsystemPort="10002" -DchromeDriverPort="11002"``

``mvn test -DplatformName="iOS" -Dudid="C4311B04-0443-41DE-95FB-117CF55B41F7" -DdeviceName="iPhoneX" -DsystemPort="10002" -DwebkitDebugProxyPort="11003"``

For Parallel reporting

``mvn test -Dcucumber.options="--plugin html:target/android/cucumber --plugin de.monochromata.cucumber.report.PrettyReports:target/android/cucumber-html-reports --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" -DplatformName="Android" -Dudid="" -DdeviceName="Samsung" -DsystemPort="10002" -DchromeDriverPort="11002"``

``mvn test -Dcucumber.options="--plugin html:target/ios/cucumber --plugin de.monochromata.cucumber.report.PrettyReports:target/ios/cucumber-html-reports --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" -DplatformName="iOS" -Dudid="C4311B04-0443-41DE-95FB-117CF55B41F7" -DdeviceName="iPhone 11 X Pro" -DsystemPort="10002" -DwebkitDebugProxyPort="11003"``

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

TODO: Dee

Please read [CONTRIBUTING.md](https://dev.azure.com/DeeAutomation) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

TODO: Dee

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Deepak Arora** - *Initial work* - [DeeAutomation](https://dev.azure.com/DeeAutomation)

TODO: Dee

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License
TODO: Dee

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

