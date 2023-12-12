package runTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/source/TechBlogCases.feature"
        ,glue={"stepDefinitions"}
        ,monochrome = true
)
public class RunnerTest {
}
