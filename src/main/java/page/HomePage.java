package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BaseClass;

public class HomePage {
	WebDriver driver;
	BaseClass base;
	
	private By acceptButton = By.xpath("//button[text()='Tout Accepter']");
	
	private By carteAmericanExpressButton = By.xpath("(//span[contains(text(),'Les Cartes AMERICAN EXPRESS')]/parent::a)[3]");
	
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		base=new BaseClass(this.driver);
	}
	
	public void launchTheApplication() {
		base.launch_A_URL( "https://www.americanexpress.com/fr-fr/?inav=NavLogo");
	}
	
	public void acceptThePopup() {
		base.clickIfExists(acceptButton);
	}
	
	public void clickOnCarteAmericanExpressButton() {
		String url = driver.findElement(carteAmericanExpressButton).getAttribute("href");
		base.launch_A_URL(url);
	}

}
