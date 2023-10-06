package googleTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultsPage extends GoogleBase{
	public By resultsCssSelector = By.cssSelector("[jsname='UWckNb']");
	public By searchedPageSelector = By.cssSelector("[class=\"e9EfHf\"]");
	
	public GoogleResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean pageIsVisible() {
		return findElement(searchedPageSelector).isDisplayed();
	}
	
	public List<WebElement> getResultsList() {
		return findElements(resultsCssSelector);
	}
	
	public WebElement getFirstResultElement(List<WebElement> list) {
		return list.get(0);
	}
	
	public void searchedElementAppearsFirst() {
		pageIsVisible();
		List<WebElement> resultsElements = getResultsList();
		WebElement firstElement = getFirstResultElement(resultsElements);
		assertTrue(firstElement.getText().contains("store.steampowered.com"));
	}
}
