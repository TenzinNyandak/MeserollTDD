package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.Commons;

public class Register {
	
	WebDriver driver;
	Commons commons;

	public Register(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons; 
	}
	
	@FindBy(xpath = "(//a[text()='Create an Account'])[1]")
	WebElement createAnAccount;
	@FindBy(tagName = "title")
	WebElement title;
	
	private void clickCreateAnAccount() {
		commons.click(createAnAccount);
	}
	
//	private void getTitle(String expectedValue) {
//	Assert.assertEquals(expectedValue, commons.getText(title));
//	}
	
	private void getUrl(String expectedUrl) {
		commons.getCurrentUrl(driver);
	}
	
	public void registerSteps(String expectedUrl) {//String expectedValue
		clickCreateAnAccount();
		//	getTitle(expected);
		getUrl(expectedUrl);
	}
}
