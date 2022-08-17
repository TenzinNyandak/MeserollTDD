package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Commons;

public class HomePage {

	Commons commons;

	public HomePage(WebDriver driver, Commons commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(id = "customer_register_link")
	WebElement createAnAccount;
	
	public void clickCreateAnAccount() {
		commons.click(createAnAccount);
		
	}

}
