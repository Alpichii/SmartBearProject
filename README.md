SmartBearProject
Cucumber BDD Framework created for UI testing with Java 8 and Maven Build Tool by Alper Uluslu

This repository contains a collection of sample selenium-cucumber-java projects and libraries that demonstrate how to use the tool and develop automation script using the Cucumber BDD framework with Java as programming language. It generate HTML and JSON reporters as well. It also generate screen shots for your tests if you enable it and also generate error shots for your failed test cases as well.

Develop automation scripts using BDD approach - Cucumber-Java There are already many predefined StepDefinitions which is packaged under /steps/Commonsteps.java will help you speed up your automation development that support both your favorite workaday helpers methods.

HTML Report: To generate HTML report use mvn test -Dcucumber.options="–plugin html:target/result.html"

JSON Report: To generate a JSON report Use mvn test -Dcucumber.options="–plugin json:target/result.json"

Create a fork of the project into your own repository. Make all your necessary changes and create a pull request with a description on what was added or removed and details explaining the changes in lines of code. If approved, project owners will merge it.
