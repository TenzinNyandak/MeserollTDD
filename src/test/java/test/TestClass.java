package test;

import org.testng.annotations.Test;
import base.BaseClass;

public class TestClass extends BaseClass{
	
	@Test
	public void SignUp() {
		homePage.clickCreateAnAccount();
		//createAccount.createAccountSteps("https://meserollshop.com/account/register");
		//register.registerSteps("https://meserollshop.com/account/register");
		createNewAccount.createNewAccountSteps("Tenzin", "Nyandak", "tenzinbmx@gmail.com", "Meseroll");
	}

}
