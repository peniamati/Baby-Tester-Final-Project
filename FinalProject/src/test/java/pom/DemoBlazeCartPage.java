package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeCartPage extends DemoBlazeBase{ 
	List<String> inputs = new ArrayList<String>();
	List<String> checkInputs = new ArrayList<String>();
	
	public DemoBlazeCartPage(WebDriver driver){
		super(driver);
	}
	
	public WebElement getPlaceOrderButton() {
		By placeOrderButtonBy = By.xpath("//button[contains(text(),'Place Order')]");
		return findElement(placeOrderButtonBy);
	}
	
	public void waitVisibilityOfElementLocatedByXpath(WebDriverWait wait, String string) {
		By xpathBy = By.xpath("//a[contains(text(),'" + string + "')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpathBy));
	}
	
	public void waitVisibilityOfElementLocatedByID(WebDriverWait wait, String string) {
		By IDBy = By.id(string);
		wait.until(ExpectedConditions.visibilityOfElementLocated(IDBy));
	}
	
	public void waitVisibilityOfElementLocatedByClassName(WebDriverWait wait, String string) {
		By classNameBy = By.className(string);
		wait.until(ExpectedConditions.visibilityOfElementLocated(classNameBy));
	}
	
	public WebElement getStringInputField(String string) {
		return findElement(By.id(string));
	}
	
	public WebElement getPurchaseButton() {
		By purchaseButtonBy = By.cssSelector("[onclick=\"purchaseOrder()\"]");
		return findElement(purchaseButtonBy);
	}
	
    public void formIsDisplayed(WebDriverWait wait) {
    	String totalStringId = "totalp";
        waitVisibilityOfElementLocatedByID(wait, totalStringId);
    }
    
    public void fillField(String string) {
        WebElement inputField = getStringInputField(string);
        inputField.sendKeys(string);
    }
    
    public void fillTheInputs(WebDriverWait wait) {
    	inputs.add("name");
    	checkInputs.add("name");
    	inputs.add("country");
    	inputs.add("city");
    	inputs.add("card");
    	checkInputs.add("card");
    	inputs.add("month");
    	inputs.add("year");
    	formIsDisplayed(wait);
        for(String cadena :inputs) {
           fillField(cadena);
        }
    }
    
    public void clickPurchaseButton() {
    	getPurchaseButton().click();
    }
    
    public void clickPlaceOrderButton() {
    	getPlaceOrderButton().click();
    }
    
    public boolean checkInputFields() {
    	WebElement inputFieldsTextList;
    	inputFieldsTextList = findElement(By.xpath("//body/div[10]/p[1]"));
    	boolean inputsCorrect = true;
    	for(String string: checkInputs) {
			if (!inputFieldsTextList.getText().contains(string)) {
    			inputsCorrect = false;
    			return inputsCorrect;
    		}	
    	}
    	return inputsCorrect;
    }
}
