package googleTest;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage extends GoogleBase{
	public By ajaxSuggestionBoxCssSelector = By.id("Alh6id");
	public By ajaxSuggestionBoxImagesElementsCssSelector = By.cssSelector("[class=\"sbct sbre\"]");
	public By ajaxSuggestionBoxOptionsCssSelector = By.cssSelector("[jsaction=\"click:.CLIENT;mouseover:.CLIENT\"]");
 	public By searchBarID = By.id("APjFqb");
 	public List<String> autoList;
 	public List<String> automationList;
	
	public GoogleHomePage(WebDriver driver){
		super(driver);
	}
	
	public WebElement getSearchBarElement() {
		return findElement(searchBarID);
	}
	
	public void sendKeys(WebElement element, String string) {
		element.sendKeys(string);
	}
	
	public List<String> searchAndSaveSuggestionsIntoList(String string, WebDriverWait wait) {
		WebElement element = getSearchBarElement();
		element.sendKeys(string);
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, "auto"));
		WebElement suggestionBox = getAjaxSuggestionBox();
		wait.until(ExpectedConditions.visibilityOf(suggestionBox));
		List<WebElement> list = getAjaxSuggestionBoxOptions();
		List<String> stringList = new ArrayList<String>();
		saveWebElementsListIntoStringList(list, stringList);
		printAllStringElements(stringList, string);
		return stringList;
	}
	
	public void clearSearchBarAndHideSuggestions(WebDriverWait wait) {
		getSearchBarElement().clear();
		getSearchBarElement().sendKeys(Keys.ESCAPE);
		wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(getAjaxSuggestionBox())));
	}
	
	public WebElement getAjaxSuggestionBox() {
		return findElement(ajaxSuggestionBoxCssSelector);
	}
	
	public List<WebElement> getAjaxSuggestionBoxOptions() {
		return findElements(ajaxSuggestionBoxOptionsCssSelector);
	}
	
	public List<WebElement> getAjaxSuggestionBoxImagesElements() {
		return findElements(ajaxSuggestionBoxImagesElementsCssSelector);
	}
	
	public void firstImageElementFromAjaxSuggestionBox() {
		List<WebElement> imagesElements = getAjaxSuggestionBoxImagesElements();
		WebElement firstElement = imagesElements.get(0);
		firstElement.click();
	}
	
	public void saveWebElementsListIntoStringList(List<WebElement> list, List<String> stringsList) {
		for (int i=0; i<list.size(); i++) {
			stringsList.add(list.get(i).getText());
		}
	}
	
	public void printAllStringElements(List<String> list, String name) {
		System.out.println("Lista " + name);
		for (int i = 0; i < list.size(); i++) {
		    System.out.println(list.get(i));
		}
	}
	
	
	public boolean areStringsExtrictlyDifferents(List<String> list1, List<String> list2) {
		boolean iguales = true;
		for (int i=0; i<list1.size(); i++) {
			for (int f=0; f<list2.size(); f++) {
				if (list1.get(i) == list2.get(f)) {
					iguales = false;
					return iguales;
				}

			}
		}
		return iguales;
	}
	
	public void searchSuggestionBox(WebDriverWait wait) {
		autoList = searchAndSaveSuggestionsIntoList("auto", wait);
		clearSearchBarAndHideSuggestions(wait);
		automationList = searchAndSaveSuggestionsIntoList("automation", wait);
		assertTrue(areStringsExtrictlyDifferents(autoList, automationList));
		firstImageElementFromAjaxSuggestionBox();
	}
}
