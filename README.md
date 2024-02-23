# Automation Testing Framework

## Welcome!🚀  

We welcome contributions to enhance the Automation Testing Framework. If you have additional test cases to add or any valuable suggestions, feel free to contribute.  
Any suggestion/ tips/ tricks are welcome, I will be very grateful to learn from you. 😊🎓


## Overview

This repository contains an automation testing framework built from scratch for learning purposes. The framework is designed to automate tests for a dummy website, [Practice Automation Testing](https://practice.automationtesting.in), which is freely available for automation practice.

## Features

- **Test Automation Framework**: A custom-built automation testing framework.
- **Test Cases for Dummy Website**: Automated test cases for the [Practice Automation Testing](https://practice.automationtesting.in) website.
- **Support for Multiple Browsers**: The framework supports running tests on multiple browsers, enhancing cross-browser compatibility testing.

## Technologies Used

- **Programming Language**: Java.
- **Testing Framework**: Selenium.
- **Build Tool**: Maven.
- **Reporting Tool**: Allure.

## Getting Started

### Prerequisites

- allure cli.

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/Vivekkr0311/SeleniumAutomationJava.git

## Contribution Process 🛠️


1. **Create a New Branch:**
   - Fork the repository.
   - Create a new branch for your changes:

     ```bash
     git checkout -b your-branch-name
     ```

2. **Add New Test Cases:**
   - Feel free to add more test cases to enhance the coverage.
   - Implement your automation logic and ensure the new tests pass successfully.

3. **Create a Pull Request (PR):**
   - Push your changes to your forked repository.
   - Create a Pull Request from your branch to the main repository.

4. **Review and Merge:**
   - We will review your PR and provide feedback if needed.
   - Once approved, your changes will be merged into the main branch.
   


### How run this framework ??🏁💻   
1. Navigate to the regression.xml file:  
   Open a terminal or command prompt.  
   Change the directory to where your project is located.  
   Locate the regression.xml file in your project.  
2. Run the Regression Tests:  
   Execute the regression tests by running the regression.xml file.  
   You can use your preferred test runner or the command-line interface to run the XML file.  
   
### To get the test report:📊📈   
1. Navigate to the Allure Reports Directory:  
   Open a terminal or command prompt.  
   Change the directory to your project.  
2. Run the Allure Serve Command:  
   Execute the following command:  
   ```  $ allure serve /allure-reports ```  
   This command starts a server on your local IP, serving the Allure report.
   or just go to  ```src/main/java/com/Vivek/Utils/AllureReportGenerator.java ```
   and execute it.
   Make sure you have allure cli installed in your system.  

### Access the Allure Report:🌐📊  
1. Open a web browser and go to the provided local IP address.  
2. You should see the generated Allure report with detailed information about your test runs  
