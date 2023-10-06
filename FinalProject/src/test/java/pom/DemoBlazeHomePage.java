package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeHomePage extends DemoBlazeBase{
	String homePageUrlString = "https://www.demoblaze.com/index.html";
	
	public DemoBlazeHomePage(WebDriver driver){
		super(driver);
	}
	
	public void get(WebDriver driver, String url) {
		get(url);
	}
	
	public WebElement getWebElementByPath(String string) {
		By xpathBy = By.xpath("//a[contains(text(),'" + string + "')]");
		return findElement(xpathBy);
	}
	
	public WebElement getAddToCartButton() {
		By addToCartButtonBy = By.linkText("Add to cart");
		return findElement(addToCartButtonBy);
	}
	
	public void waitBannerElementIsDisplayed(WebDriverWait wait) {
		By iDBy = By.id("nava");
		wait.until(ExpectedConditions.visibilityOfElementLocated(iDBy));
	}
	
	public void waitPresenceOfElementLocatedByPath(WebDriverWait wait, String string) {
		By xpathBy = By.xpath("//a[contains(text(),'" + string + "')]");
		wait.until(ExpectedConditions.presenceOfElementLocated(xpathBy));
	}
	
	public void addProductToCart(String category, String product, WebDriverWait wait) {
    	waitBannerElementIsDisplayed(wait);
    	WebElement categoryElement = getWebElementByPath(category);
        categoryElement.click();
        waitPresenceOfElementLocatedByPath(wait, product);
    	WebElement productElement = getWebElementByPath(product);
        productElement.click();
        String cartString = "Add to cart";
    	waitPresenceOfElementLocatedByPath(wait, cartString);
    	WebElement buttonElement = getAddToCartButton();
        buttonElement.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        get(homePageUrlString);
	}
	
	public void addProductsToCart(WebDriverWait wait) {
		addProductToCart("Phones", "Nexus 6", wait);
    	addProductToCart("Laptops", "MacBook air", wait);
    	addProductToCart("Monitors", "ASUS Full HD", wait);
	}
}

