package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	WebDriver driver;

	WebDriverWait wait;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	}

	public void launch_A_URL(String Url) {
		driver.get(Url);
	}

	public void clickIfExists(By locator) {
		if (driver.findElements(locator).size() > 0) {
			driver.findElement(locator).click();
			System.out.println("Element clicked.");
		}
	}

	public void fillTheDataInTextBox(WebElement textBox, String value) {
		textBox.clear();
		textBox.sendKeys(value);
	}

	public void selectFromDropdown(WebElement dropDown, String value) {
		Select select = new Select(dropDown);

		select.selectByValue(value);
	}

	public void clickOnTheElement(WebElement elementToBeClicked) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", elementToBeClicked);

	}

}
