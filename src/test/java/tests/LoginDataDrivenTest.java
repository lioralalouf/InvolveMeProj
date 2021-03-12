package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.LoginPage;

@Epic("Login")
@Feature("log in with not valid credentials")
public class LoginDataDrivenTest extends BaseTest {
	
	@Override
	public void validLogin() {
	}
	@Severity(SeverityLevel.CRITICAL)
	@Story("As A user, I supposed not to be able login with not valid credantials and getting the right error message.")
	@Test(dataProvider ="getData", description = "getting the right error message for not valid data")
	@Description("Insert not valid credantials and checking the error message I got")
	public void tc01_loginNotValidData(String user, String password, String error) {
		LoginPage lp = new LoginPage(driver);
		lp.login(user, password);
		String expected = error;
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] getData(){
		String[][] names = {
				{"alalouflior@gmail.co.il","Sean151114","These credentials do not match our records."},
				{"alalouflior@gmail.com","1234","These credentials do not match our records."},
				{"alalouflior@gmail.co.il","1234","These credentials do not match our records."},	
		};
		return names;
		
	}

}
