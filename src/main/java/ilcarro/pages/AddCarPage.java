package ilcarro.pages;

import ilcarro.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddCarPage extends BasePage {
    public AddCarPage(WebDriver driver) {
        super(driver);
    }

    public void enterLocation(String location) {
        WebElement locationInput = driver.findElement(By.id("pickUpPlace"));
        type(locationInput, location);
    }


    public void selectAddressFromDropdown(String address) {
        // Явное ожидание появления списка
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By suggestionsLocator = By.cssSelector(".pac-item");

        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));

        // Ищем все варианты в списке
        List<WebElement> suggestions = driver.findElements(suggestionsLocator);
        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText().trim();
            System.out.println("Suggestion found: " + suggestionText);
            // Если в тексте присутствует "Haifa"
            if (suggestionText.contains("Haifa")) {
                // Обрезаем текст начиная с первого вхождения "Haifa"
                int index = suggestionText.indexOf("Haifa");
                String cutText = suggestionText.substring(index).trim();
                System.out.println("Cut text: " + cutText);
                // Сравниваем обрезанный текст с ожидаемым (например, "Haifa, Israel")
                if (cutText.equalsIgnoreCase(address)) {
                    new Actions(driver).moveToElement(suggestion).click().perform();
                    break;
                }
            }
        }
    }

    public void fillCarDetails(String manufacture, String model, String year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement manufactureInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("make")));
        type(manufactureInput, manufacture);

        WebElement modelInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("model")));
        type(modelInput, model);

        WebElement yearInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));
        type(yearInput, year);
    }

    public void selectFuelType(String fuelType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fuelDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fuel")));

        // Создаем объект Select для работы с элементом <select>
        Select fuelSelect = new Select(fuelDropdown);

        // Выбираем вариант по значению атрибута value, например, "Diesel"
        fuelSelect.selectByValue(fuelType);
    }

    public void selectSeats(String seats) {
        WebElement seatsInput = driver.findElement(By.id("seats"));
        type(seatsInput, seats);
    }


    public void enterCarClass(String carClass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement carClassInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("class")));
        type(carClassInput, carClass);
    }

    public void enterRegNumber(String regNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement regNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serialNumber")));
        type(regNumberInput, regNumber);
    }

    public void enterPrice(String price) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement priceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price")));
        type(priceInput, price);
    }
}
