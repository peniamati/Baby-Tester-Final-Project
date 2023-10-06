package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.DemoBlazeCartPage;
import pom.DemoBlazeHomePage;

public class DemoBlazeStepDefinitions {
	public static WebDriver driver;
    public WebDriverWait wait;
    public DemoBlazeHomePage objDemoBlazeHomePage;
    public DemoBlazeCartPage objDemoBlazeCartPage;
    public String homePageUrlString = "https://www.demoblaze.com/index.html";
    public String cartPageUrlString = "https://www.demoblaze.com/cart.html";

    @Given("I am at the home page and I added 3 products to cart")
    public void iAmAtDemoBlazeHomePageAndAddedProductsToCart() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePageUrlString);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	objDemoBlazeHomePage = new DemoBlazeHomePage(driver);
    	objDemoBlazeHomePage.addProductsToCart(wait);
    }

    @And("I open the DemoBlaze cart page")
    public void iOpenTheDemoBlazeCartPage() {
    	driver.get(cartPageUrlString);
    	objDemoBlazeCartPage = new DemoBlazeCartPage(driver);
    	wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @And("I click on place order button")
    public void iClickPlaceOrderButton() {
        objDemoBlazeCartPage.clickPlaceOrderButton();
    }
    
    @And("I fill the inputs")
    public void fillTheInputs() {
    	objDemoBlazeCartPage.fillTheInputs(wait);
    }

    @When("I click purchase button")
    public void iClickPurchaseButton() {
        objDemoBlazeCartPage.clickPurchaseButton();
    }

    @Then("I should confirmed purchase")
    public void iShouldSeePurchaseConfirmation() {
        objDemoBlazeCartPage.waitVisibilityOfElementLocatedByClassName(wait, "sweet-alert");
	    assertTrue(objDemoBlazeCartPage.checkInputFields());
        driver.quit();
    }
}
