package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/GSMArenaNews.feature",
        glue = "com.qaprosoft.carina.demo.cucumber.steps",
        format={"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
        //,plugin = "json:target/cucumber1.json"
)
public class CucumberWebSampleTest extends CucumberRunner {
    //do nothing here as everything is declared in "GSMArenaNews.feature" and steps

}
