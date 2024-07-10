package bdd.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {

    private static final Logger logger = LogManager.getLogger(MyStepdefs.class);

    @Given("this works as intended")
    public void thisWorksAsIntended() {
        logger.info("Starting precondition step");
        Assertions.fail("Failure in this area-0");
    }

    @When("the test runner is called")
    public void theTestRunnerIsCalled() {
        logger.info("Starting precondition step-2");
        Assertions.assertTrue(true, "Failure in this area-1");
    }

    @Then("this lines are executed")
    public void thisLinesAreExecuted() {
        Assertions.assertTrue(true, "Failure in this area-2");
    }

    @Given("this works as intended now")
    public void thisWorksAsIntendedNow() {
        Assertions.assertTrue(true, "Failure in this area-0");
    }

    @Then("this lines are executed now")
    public void thisLinesAreExecutedNow() {
        Assertions.assertTrue(true, "Failure in this area-2");
    }
}
