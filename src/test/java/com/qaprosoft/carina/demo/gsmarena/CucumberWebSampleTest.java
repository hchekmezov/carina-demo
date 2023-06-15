package com.qaprosoft.carina.demo.gsmarena;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import com.zebrunner.carina.cucumber.CucumberRunner;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/GSMArenaNews.feature",
        glue = {"com/qaprosoft/carina/demo/gsmarena"},
        plugin = {"pretty",
                "html:target/cucumber-core-test-report.html",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
)
public class CucumberWebSampleTest extends CucumberRunner {
}
