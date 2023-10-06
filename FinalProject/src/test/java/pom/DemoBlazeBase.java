package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class DemoBlazeBase {
	public WebDriver driver;
	
	public DemoBlazeBase(WebDriver driver) {
        this.driver = driver;
    }
	
	public void get(String url) {
		driver.get(url);
	}
	
	public void Type(String name, By locator) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(name);
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	public boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void click(By locator) {
		WebElement element = findElement(locator);
		element.click();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
}
