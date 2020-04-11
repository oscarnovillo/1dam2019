package dao;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Entry point for running the Cucumber tests in JUnit.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    features = "classpath:features")
public class CucumberTest {

  /**
   * This class should be empty, step definitions should be in separate classes.
   */

}

