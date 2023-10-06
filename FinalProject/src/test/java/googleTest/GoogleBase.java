package googleTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class GoogleBase {
	public WebDriver driver;

	public GoogleBase(WebDriver driver) {
        this.driver = driver;
    }
	
	public void Type(String name, By locator) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(name);
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void printAllElements(List<WebElement> list){
		for (int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public void clearInput(By locator) {
		WebElement element = driver.findElement(locator);
		element.clear();
	}
	
	public void click(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
}
