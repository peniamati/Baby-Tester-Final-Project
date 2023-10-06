package stepDefinitionsOLD;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.DemoBlazeCartPage;
import pom.DemoBlazeHomePage;

public class DemoBlazeTestDefinitionsOLD {

    public static WebDriver driver;
    public WebDriverWait wait;
    public DemoBlazeHomePage objDemoBlazeHomePage;
    public DemoBlazeCartPage objDemoBlazeCartPage;
    public String homePageUrlString = "https://www.demoblaze.com/index.html";
    public String cartPageUrlString = "https://www.demoblaze.com/cart.html";

    @Given("I open the DemoBlaze home page")
    public void iOpenTheDemoBlazeHomePage() {
    	if (driver == null) {
    		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(homePageUrlString);
		}
    	else {
    		driver.get(homePageUrlString);
    	}
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	objDemoBlazeHomePage = new DemoBlazeHomePage(driver);
    }

    @And("I click category {string} section")
    public void iClickCategorySection(String string) {
    	WebElement categoryElement = objDemoBlazeHomePage.getWebElementByPath(string);
        categoryElement.click();;
    }

    @And("I select {string} product")
    public void iSelectProduct(String string) {
        objDemoBlazeHomePage.waitPresenceOfElementLocatedByPath(wait, string);
    	WebElement productElement = objDemoBlazeHomePage.getWebElementByPath(string);
        productElement.click();
    }

    @When("I press Add to cart button")
    public void iPressAddToCartButton() {
    	String string = "Add to cart";
    	objDemoBlazeHomePage.waitPresenceOfElementLocatedByPath(wait, string);
    	WebElement buttonElement = objDemoBlazeHomePage.getAddToCartButton();
        buttonElement.click();
    }

    @Then("I should {string} added product")
    public void iShouldSeeProductAdded(String string) {
    	Assert.assertTrue(string.equals("success"));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Given("I open the DemoBlaze cart page")
    public void iOpenTheDemoBlazeCartPage() {
    	driver.get(cartPageUrlString);
    	objDemoBlazeCartPage = new DemoBlazeCartPage(driver);
    	wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @And("I click on place order button")
    public void iClickPlaceOrderButton() {
        WebElement placeOrderButton = objDemoBlazeCartPage.getPlaceOrderButton();
        placeOrderButton.click();
    }

    @And("i fill the name={string} field")
    public void iFillNameField(String string) {
    	String totalStringId = "totalm";
        objDemoBlazeCartPage.waitVisibilityOfElementLocatedByID(wait, totalStringId);
        WebElement nameField = objDemoBlazeCartPage.getStringInputField("name");
        nameField.sendKeys(string);
    }

    @And("i fill the country={string} field")
    public void iFillCountryField(String string) {
    	WebElement countryField = objDemoBlazeCartPage.getStringInputField("country");
        countryField.sendKeys(string);
    }

    @And("i fill the city={string} field")
    public void iFillCityField(String string) {
    	WebElement cityField = objDemoBlazeCartPage.getStringInputField("city");
    	cityField.sendKeys(string);
    }

    @And("i fill the credit card={string} field")
    public void iFillCreditCardField(String string) {
    	WebElement creditCardField = objDemoBlazeCartPage.getStringInputField("card");
        creditCardField.sendKeys(string);
    }

    @And("i fill the month={string} field")
    public void iFillMonthField(String string) {
    	WebElement monthField = objDemoBlazeCartPage.getStringInputField("month");
        monthField.sendKeys(string);
    }

    @And("i fill the year={string} field")
    public void iFillYearField(String string) {
    	WebElement yearField = objDemoBlazeCartPage.getStringInputField("year");
        yearField.sendKeys(string);
    }

    @When("I click purchase button")
    public void iClickPurchaseButton() {
        WebElement purchaseButton = objDemoBlazeCartPage.getPurchaseButton();
        purchaseButton.click();
    }

    @Then("I should confirmed purchase")
    public void iShouldSeePurchaseConfirmation() {
    	String string = "sweet-alert";
        objDemoBlazeCartPage.waitVisibilityOfElementLocatedByClassName(wait, string);
//        driver.quit();
    }

}
