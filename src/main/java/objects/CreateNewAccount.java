package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Commons;

public class CreateNewAccount {

	Commons commons;

	public CreateNewAccount(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(id = "first_name")
	WebElement firstName;
	@FindBy(id = "last_name")
	WebElement lastName;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "create_password")
	WebElement password;
	@FindBy(xpath = "//input[@value='Create']")
	WebElement createButton;

	private void firstName(String value) {
		commons.inputValues(firstName, value);
	}

	private void lastName(String value) {
		commons.inputValues(lastName, value);
	}

	private void email(String value) {
		commons.inputValues(email, value);
	}

	private void password(String value) {
		commons.inputValues(password, value);
	}
	
	private void clickCreate() {
		commons.click(createButton);
	}
	
	public void createNewAccountSteps(String value1, String value2, String value3, String value4) {
		firstName(value1);
		lastName(value2);
		email(value3);
		password(value4);
		clickCreate();
	}
}
