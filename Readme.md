
# Test Automation Framework

This framework is a Java-based test automation framework developed using Java 17, TestNG for testing, and integrates various libraries for data-driven testing, fake data generation, cloud testing with LambdaTest, and headless mode for faster execution. It includes integration with Maven for build and execution, Extent Reports for reporting, and Log4j for logging.




## 🚀 About Me
Hi, My Name is Sasidhar Gandikota and I have 5 years if experience in Automation Testing using technologies like Selenium Webdriver, RestAssured, Appium.

My major expertise is in Java Programming Language.

## Author

- [@sasidhar121](https://github.com/sasidhar121)
- EmailAddress: sasidhargandikota10@gmail.com

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/sasidhar121)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sasidhar-gandikota/)




## Prerequisites

Before you begin, ensure the following software is installed:

**Java 17** or higher
**Maven**(for building and running tests)
- Download Link: https://maven.apache.org/download.cgi
Git (for version control and cloning the repository)
LambdaTest credentials (for cloud execution)
Also, ensure the following dependencies are included:

TestNG
OpenCSV
Gson
Apache POI
Faker
LambdaTest
ExtentReports
Log4j
Prerequisites

## Features
- **Java 17 Compatibility** – Built using Java 17, ensuring compatibility with the latest features and performance improvements.
- **TestNG Integration** – Uses TestNG for advanced testing capabilities like parallel execution and parameterized tests.
- **Data-Driven Testing** – Supports data-driven testing using OpenCSV for flexible and reusable test scenarios.
- **Fake Data Generation** – Utilizes the Faker library to generate realistic fake data for testing purposes.
- **Cloud Test Execution with LambdaTest** – Integrates LambdaTest for running tests on the cloud across multiple browsers and OS combinations.
- **Headless Mode for Faster Execution** – Supports headless mode for faster execution, especially in CI/CD environments.
- **Command-Line Interface (CLI) Support** – Allows test execution via CLI with parameters for browser, LambdaTest, and headless mode.
- **Maven Integration** – Uses Maven Surefire Plugin for smooth test execution, dependency management, and integration with CI/CD tools.
- **Cross-Browser Testing** – Ensures compatibility across multiple browsers (Chrome, Firefox, Safari, Edge, etc.).
- **Logging and Reporting** – Generates detailed logs using Log4j for debugging and creates visually rich HTML reports with ExtentReports for test execution insights.

## Technologies Used:
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- ExtentReports
- Log4j
## Installation

**Clone the Repository**

```bash
  git clone https://github.com/your-repository/test-automation-framework.git


  cd test-automation-framework
  
```


**Cloud Execution on LambdaTest**

```bash
  mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X

```

**Cloud Execution on Chrome Browser on local Machine in Headless Mode:**

```bash
  mvn test -Dbrowser=chrome -DisLambdaTest=tfalse -DisHeadless=true -X
```

## Reports and Logs
After test execution, the following will be generated:

- Extent Report: A detailed HTML report can be found in the reports/ directory (report.html).
##Logs: 
Logs are generated using Log4j and stored in the logs/ directory.

## Integrated the project with GitHub Actions
This Automation Framework is integrated with github actions.
The tests will be executed at 11:30PM IST every single day.

The reports will be archived in gh-pages branch 
You can view the html reports at :
https://sasidhar121.github.io/Test-Automation-Framework/report.html
