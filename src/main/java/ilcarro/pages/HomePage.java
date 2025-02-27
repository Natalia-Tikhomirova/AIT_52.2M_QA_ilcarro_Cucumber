package ilcarro.pages;

import ilcarro.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void openHomePage() {
        driver.get("https://ilcarro.web.app/");

    }

    @FindBy(xpath = "//a[.=' Let the car work ']")
    WebElement letTheCarWorkLink;

    public void clickLetTheCarWork() {
        click(letTheCarWorkLink);
    }


    @FindBy(xpath = "//a[.=' Let the car work ']")
    WebElement homePageTitle;

    public boolean isHomePageTitlePresent() {
        return isElementPresent(homePageTitle);
    }

    @FindBy(xpath = "//a[.=' Log in ']")
    WebElement loginLink;

    public void clickOnLoginLink() {
        click(loginLink);
    }
}
