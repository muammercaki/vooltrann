package com.voltran.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/voltran/features",
        glue = {"gluecode"},
        // plugin = {"pretty"}
        // plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:path/report.html"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter: target/cucumber-reports/report.html"},
        monochrome = true

)
public class TestRunner {

}
