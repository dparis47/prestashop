### Prerequisites
* Java JDK: 10 or higher
* Maven: 3.3.9 or higher

## Execution
* Testcase can be launched as a JUnit test with -Dconfig=path/to/config/config.json VM arguments.
* Test can be launched with ```mvn test -Dconfig=path/to/config/config.json```.
* A default config file is present in com.prestashop.data.config-sample.json
- timeout : maximum wait time before trying to perform action on element (error is returned if element never appears)
- isGrid : if true, selenium grid is used to execute test, if false, test is executed locally
- browser: CHROME or FIREFOX
- screenshot : NONE no screenshot taken, FAIL : screenshot taken only when a fail occurs, ALL : screenshot taken at all assertions

## Allure
* Allure files are generated in /allure-results.
* To generate the report execute : 
```path\to\allure\bin\allure generate -c path\to\allure\bin\allure serve```
