package com.spartaglobal.automationpractice_eng28;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = {"src/test/resources/features/"},
        tags = {"@demo"}
)

public class JunitCucumberRunner {



}
