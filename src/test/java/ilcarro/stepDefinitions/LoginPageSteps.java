package ilcarro.stepDefinitions;

import ilcarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static ilcarro.core.BasePage.driver;

public class LoginPageSteps {
    @And("the user enters valid data")
    public void userEnterValidCredentials() {
        new LoginPage(driver).enterCredentials("test_qa@gmail.com", "Password@1");
    }

    @And("the user presses the Yalla button")
    public void userClickOnYallaButton() {
        new LoginPage(driver).clickOnYallaButton();
    }

    @Then("the user checks the display of the message about the successful login")
    public void userVerifySuccessLoginMessage() {
        new LoginPage(driver).verifyTextMessage("Logged in success");
    }

    @And("the user enters valid data and invalid password")
    public void userEntersInvalidPassword(DataTable table) {
        new LoginPage(driver).enterInValidCredentials(table);
    }

    @Then("the user checks the display of the message about the unsuccessful login")
    public void userCheckErrorMessage() {
        new LoginPage(driver).verifyTextMessage("\"Login or Password incorrect\"");
    }

    @And("The user enters the valid data {string} and {string}")
    public void userEnterCredentials(String email, String password) {
        new LoginPage(driver).enterCredentials(email,password);
    }


}
