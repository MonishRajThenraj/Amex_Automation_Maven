package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarteAmericanGoldenCardPage {
	
	
	WebDriver driver;

	WebDriverWait wait;

	@FindBy(xpath = "//p[contains(text(),'Elle Assure et vous Rassure')]/ancestor::div[2]/following-sibling::div//a[contains(text(),'Demandez votre Carte')]")
	private WebElement demandezVotreCarteButton;

	public CarteAmericanGoldenCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonThedemandezButton() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(demandezVotreCarteButton));
		demandezVotreCarteButton.click();
	}

}
