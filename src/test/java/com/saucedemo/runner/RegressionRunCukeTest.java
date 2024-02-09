package com.saucedemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created by Mahak
 * I create Runner class to run my test packs using @cucumberoptions tag annotation.
 * It contains the following -
 * Features = content root path of the feature file
 * Glue = source root path of the step definition folder
 * Plugin = Generates the reports such as extent report,cucumber.html, cucumber.json etc.
 * Tags = It is used to annotate and run a particular test pack such as smoke, sanity , regression
 * This class extends with AbstractTestNGCucumberTests, it follows inheritance concept
 * AbstractTestNGCucumberTests is used to integrate Cucumber with TestNG,
 * allowing you to run Cucumber tests using TestNG's infrastructure.
 * By extending this class in your test classes, you can take advantage of TestNG's features
 * while writing and executing Cucumber tests.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/saucedemo/steps",
        plugin = {"html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@regression"
)
public class RegressionRunCukeTest extends AbstractTestNGCucumberTests {
}
