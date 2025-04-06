package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaretsAmericanExpressPage {

	WebDriver driver;

	WebDriverWait wait;

	@FindBy(xpath = "//h2[contains(text(),'Carte Gold American Express')]/ancestor::a/parent::div/parent::div/following-sibling::div//span[contains(text(),'En savoir plus')]\r\n")
	private WebElement enSoviorPlusButton;

	public CaretsAmericanExpressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnSaviorPlusButton() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(enSoviorPlusButton));
		enSoviorPlusButton.click();
	}

}
