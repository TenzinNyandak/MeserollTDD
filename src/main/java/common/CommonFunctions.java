package common;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reporting.Loggers;

public class CommonFunctions {
	
	public void click(WebElement element) {
		try {
			element.click();
			Loggers.getLog(element + " : This element has been clicked");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element not found");
			Assert.fail();
		}
	}
	
	public String getText(WebElement element) {
		String valueString = null;
		try {
			valueString = element.getText();
			Loggers.getLog(element + " : has value ---> " + valueString);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element not found");
			Assert.fail();
		}
		return valueString;
	}

	public String getCurrentUrl(WebDriver driver) {
		Loggers.getLog("Current url is : "+ driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public void inputValues(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Loggers.getLog(value + " : This values has been passed into ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}

}
