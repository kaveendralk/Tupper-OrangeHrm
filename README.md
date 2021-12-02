# Web UI Automation Suite

-> Project description goes here

## Getting Started

### Mac:
1. Install Java: https://www.oracle.com/java/technologies/javase-downloads.html
2. Install Homebrew: https://brew.sh/
3. Install Git: `brew install git`
4. Install Maven: `brew install maven`
5. Install Cucumber-Eclipse plugin feature via Eclipse market place

## Running the tests

### Modifying environment configuration

For local testing, you can add your config to [serenity.properties](serenity.properties)

When you need this config to apply to Jenkins and Docker:(To be done for feature implemenation)

Specific environment configuration is stored in *./serenity-configs/*
```
serenity-configs/
├── browserstack_webdriver.conf -future if required
├── environment_urls.conf
└── general_settings.conf
```
When adding a new environment, simply add the URL to the list in environment_urls.

general_settings will be applied to **all** config files. Add common serenity parameters in here.

When you want to test the serenity.properties that Jenkins will use:

### Maven command line to run the tests
Whether you are in your laptop or a container, to run all the testcases run the following command:

```
mvn clean verify serenity:aggregate
```

The reports will be generated in `target/site/serenity`

Run the tests like this for running the smoke test suite only 

```
mvn clean verify -Dcucumber.options="--tags @Sanitytestsuite"
```
mvn clean verify -Dcucumber.options="--tags @Ordercreation"
```

### Run tests manually (or using Eclipse) with browser launced

The code is run using:
Go to Pom.xml right click and select Maven build and type the following

```
mvn clean verify -Dcucumber.options="--tags @Sanitytestsuite"
```
mvn clean verify -Dcucumber.options="--tags @Ordercreation"
```

### Run tests manually (or using Eclipse) with headless chrome browser
webdriver.driver = chrome
webdriver.chrome.driver = ./drivers/chromedriver
chrome.switches=--window-size=1920,1080;--headless;

Ask vignesh nehru) if you have questions regarding how to set this setup in Eclipse.

## Contributing

ToDo

## Maintainers

#any one like to contribute to repo your ready to go :)

* **Vignesh Neru** - *Initial work* 

## Continuous integration (Jenkins)

ToDo

### Scheduling planned target for jenkins 

'`

Note:
If on Jenkins FOBSMOKETESTSUITE and BROKERWORKFLOW1 should not be executed at same time as both of them use set of values related to 'VigneshCompany'. 
They can be executed one after another 

Daily 

4. Tag QA automation developers PR check .(Dont commit to master branch directly - Create your own branch and submit for approval)


## Current Tags and what they do
