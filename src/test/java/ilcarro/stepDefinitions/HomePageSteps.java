package ilcarro.stepDefinitions;

import ilcarro.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static ilcarro.core.BasePage.driver;

public class HomePageSteps {

    // Здесь будут методы для шагов, связанных с домашней страницей
    @Given("the user launches a browser")
    public void userLaunchesBrowser(){
        new HomePage(driver).launchBrowser();

    }

    @When("the user opens the home page ilcarro")
    public void userOpensHomePage() {
        new HomePage(driver).openHomePage();
    }

    @Then("check that the heading of the home page is displayed")
    public void verifyHomePageTitle() {
        Assert.assertTrue(new HomePage(driver).isHomePageTitlePresent());
    }

    @And("the user closes the browser")
    public void userQuitBrowser() {
        new HomePage(driver).quitBrowser();
    }

    @And("the user clicks on the login link")
    public void userClickOnLoginLink() {
        new HomePage(driver).clickOnLoginLink();
    }


}
