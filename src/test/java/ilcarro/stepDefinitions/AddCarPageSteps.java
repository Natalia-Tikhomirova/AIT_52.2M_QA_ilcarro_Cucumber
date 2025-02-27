package ilcarro.stepDefinitions;

import ilcarro.core.BasePage;
import ilcarro.pages.AddCarPage;
import ilcarro.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static ilcarro.core.BasePage.driver;

public class AddCarPageSteps {

    HomePage homePage = new HomePage(driver);
    AddCarPage addCarPage = new AddCarPage(driver);

    @And("the user clicks on {string}")
    public void theUserClicksOn(String element) {
        homePage.clickLetTheCarWork();
    }

    @And("the user clicks on {string} in the success popup")
    public void theUserClicksOnInTheSuccessPopup(String buttonText) {
        driver.findElement(By.xpath("//button[.='" + buttonText + "']")).click();
    }


    @And("the user enters the location {string}")
    public void theUserEntersTheLocation(String location) {
        addCarPage.enterLocation(location);
    }

    @And("the user selects address {string} from the dropdown")
    public void selectAddressFromDropdown(String address) {
        addCarPage.selectAddressFromDropdown(address);
    }

    @And("the user fills in car details:")
    public void theUserFillsInCarDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String manufacture = data.get(0).get(1).trim();
        String model = data.get(1).get(1).trim();
        String year = data.get(2).get(1).trim();
        addCarPage.fillCarDetails(manufacture, model, year);
    }


    @And("the user selects fuel type {string} from the dropdown")
    public void theUserSelectsFuelTypeFromTheDropdown(String fuelType) {
        addCarPage.selectFuelType("Diesel");
    }

    @And("the user selects seats {string}")
    public void theUserSelectsSeats(String seats) {
        addCarPage.selectSeats(seats);
    }


    @And("the user enters car class {string}")
    public void theUserEntersCarClass(String carClass) {
        addCarPage.enterCarClass(carClass);
    }

    @And("the user enters registration number {string}")
    public void theUserEntersRegistrationNumber(String regNumber) {
        addCarPage.enterRegNumber(regNumber);
    }

    @And("the user enters price {string}")
    public void theUserEntersPrice(String price) {
        addCarPage.enterPrice(price);
    }

    @And("the user clicks on {string} button")
    public void theUserClicksOnButton(String element) {
        driver.findElement(By.xpath("//button[.='" + element + "']")).click();
    }
}
