package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import base.BaseClass;

public class FormPage {
	WebDriver driver;

	WebDriverWait wait;
	
	BaseClass base;
	
	@FindBy(xpath = "//input[@id='MR']/following-sibling::label")
	private WebElement mrRadioButton;
	
	@FindBy(xpath = "//input[@id='MS']/following-sibling::label")
	private WebElement msRadioButton;
	
	@FindBy(id = "fieldControl-input-firstName")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "fieldControl-input-lastName")
	private WebElement lastNameTextBox;
	
	@FindBy(id = "fieldControl-input-email")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//select[@id='countryCode']")
	private WebElement countryCodeDropdown;
	
	@FindBy(id = "fieldControl-input-mobilePhoneNumber")
	private WebElement mobileNumberTextBox;
	
	@FindBy(id="fieldControl-input-dateOfBirth")
	private WebElement dateOfBirthTextBox;
	
	@FindBy(xpath = "//button[contains(text(),'Sauvegarder et Continuer')]")
	private WebElement saveAndContinueButton;

	public FormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		base = new BaseClass(driver);
	}
	
	public void selectTheRadioButton(String typeOfRadiobutton) {
		if(typeOfRadiobutton.equalsIgnoreCase("mr")) {
			mrRadioButton.click();
		}else {
			msRadioButton.click();
		}
	}
	
	public void fillTheFormAndSubmit(String firstName,String lastName,String email,String dOB, String dropDownValue, String mobileNumber) {
		base.fillTheDataInTextBox(firstNameTextBox, firstName);
		base.fillTheDataInTextBox(lastNameTextBox, lastName);
		base.fillTheDataInTextBox(emailTextBox, email);
		base.fillTheDataInTextBox(dateOfBirthTextBox, dOB);
		base.selectFromDropdown(countryCodeDropdown, dropDownValue);
		base.fillTheDataInTextBox(mobileNumberTextBox, mobileNumber);
		base.clickOnTheElement(saveAndContinueButton);
	}
	
	public void verifyTheSaveandContinueExecutedSuccessfully() {
		SoftAssert soft = new SoftAssert();
		WebElement nextPageElement = driver.findElement(By.xpath("//h2[contains(text(),'Vos informations personnelles')]"));
		soft.assertTrue(nextPageElement.isDisplayed());
	}
	

}
