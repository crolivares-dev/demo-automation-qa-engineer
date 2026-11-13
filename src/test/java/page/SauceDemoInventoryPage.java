package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceDemoInventoryPage extends BasePage {

    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(css = ".inventory_item:nth-child(1) button")
    private WebElement firstProductButton;

    @FindBy(css = ".inventory_item:nth-child(2) button")
    private WebElement secondProductButton;

    @FindBy(css = ".inventory_item:nth-child(1) .inventory_item_name")
    private WebElement firstProductTitle;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public SauceDemoInventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.isDisplayed() && pageTitle.getText().equals("Products");
    }

    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductButton));
        firstProductButton.click();
    }

    public void removeFirstProductFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductButton));
        firstProductButton.click();
    }

    public void addSecondProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(secondProductButton));
        secondProductButton.click();
    }

    public void clickFirstProductTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductTitle));
        firstProductTitle.click();
    }

    public boolean isProductAddedToCart() {
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        return cartBadge.isDisplayed() && cartBadge.getText().equals("1");
    }

    public String getCartBadgeText() {
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        return cartBadge.getText();
    }

    public boolean isCartBadgeInvisible() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("shopping_cart_badge")));
    }
}