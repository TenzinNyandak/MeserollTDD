package test.createAccount;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import base.BaseClass;

public class CreateAccountTest extends BaseClass{
	
	@Test
	public void SignUp() {
		homePage.clickCreateAnAccount();
		createNewAccount.createNewAccountSteps("CREATE ACCOUNT", "Tenzin", "Nyandak", "tenzinbmx@gmail.com", "Meseroll");
	}

}
