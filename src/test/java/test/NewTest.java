package test;

import org.testng.annotations.Test;

import page.CaretsAmericanExpressPage;
import page.CarteAmericanGoldenCardPage;
import page.FormPage;
import page.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class NewTest {
	 protected WebDriver driver;
	 HomePage home ;
	 CaretsAmericanExpressPage caePage;
	 CarteAmericanGoldenCardPage cagPage;
	 FormPage form;

	    @BeforeClass
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	    }
	    
	    @Test
	    public void NavigateAndFillTheForm() {
	    	home = new HomePage(driver);
	    	home.launchTheApplication();
	    	home.acceptThePopup();
	    	home.clickOnCarteAmericanExpressButton();
	    	
	    	caePage = new CaretsAmericanExpressPage(driver);
	    	caePage.clickOnSaviorPlusButton();
	    	home.acceptThePopup();
	    	
	    	cagPage = new CarteAmericanGoldenCardPage(driver);
	    	cagPage.clickonThedemandezButton();
	    	home.acceptThePopup();
	    	
	    	form = new FormPage(driver);
	    	form.selectTheRadioButton("MR");
	    	form.fillTheFormAndSubmit("Monish","Thenraj","test123@email.com","26/10/1997","Inde","9012345678");
	    	form.verifyTheSaveandContinueExecutedSuccessfully();
	    		    	
	    }
	    
	    @AfterClass
	    public void closeDriver() {
	    	driver.quit();  // Closes all browser windows and stops WebDriver
	    }
	    
	    
}
