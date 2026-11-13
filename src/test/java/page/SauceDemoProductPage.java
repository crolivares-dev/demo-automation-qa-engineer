package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceDemoProductPage extends BasePage {

    @FindBy(css = "button[data-test^='add-to-cart']")
    private WebElement addToCartButton;

    public SauceDemoProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
}