package googleTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchBar {
	public WebDriver driver;
	public String urlString = "http://www.google.com/";
	public WebDriverWait wait;
	public GoogleHomePage objGoogleHomePage;
	public GoogleResultsPage objGoogleResultsPage;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(urlString);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Test
	public void test_Search_Suggestion_Box(){
		objGoogleHomePage = new GoogleHomePage(driver);
		objGoogleResultsPage = new GoogleResultsPage(driver);
		objGoogleHomePage.searchSuggestionBox(wait);
		objGoogleResultsPage.searchedElementAppearsFirst();
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
