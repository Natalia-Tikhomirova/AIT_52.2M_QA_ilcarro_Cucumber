package ilcarro.pages;

import ilcarro.core.BasePage;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    public void enterCredentials(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
    }

    @FindBy(xpath = "//button[.='Y’alla!']")
    WebElement yallaButton;

    public void clickOnYallaButton() {
        click(yallaButton);
    }

    @FindBy(className = "message")
    WebElement message;

    public void verifyTextMessage(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // увеличиваем время ожидания
        wait.until(ExpectedConditions.textToBePresentInElement(message, text)); // ждем, пока нужный текст появится
        String actualMessage = message.getText(); // создаем локальную переменную для фактического текста
        System.out.println("Current message text: " + actualMessage); // вывод для диагностики
        Assert.assertEquals(text, actualMessage); // сравниваем ожидаемый и фактический текст
    }


    public void enterInValidCredentials(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");
        enterCredentials(email,password);
    }
}
