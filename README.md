# Automation Project Engineering 28

## Selenium Configuration and properties

In this framework we have abstracted the Selenium configuration to make handling local environment paths easier for collaborative work.

To ensure environments are not polluted by various configurations outside of production each user will need to create their own file please follow the below steps:

* Create a folder in the root of this project called `resources`
* Within the `resources` folder create a file called `selenium.properties`.
* within the `selenium.properties` file input the below settings:
    * `chromedriverpath=/enter/the/path/to/the/driver`
    * `firefoxdriverpath=/enter/the/path/to/the/driver`
    
Please review the `SeleniumConfig` class for details.