package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.LoginPage;
import pageObjects.ProjectsPage;

@Epic("Login")
@Feature("Log in with different credantiald valid and not valid.")
public class LoginTest extends BaseTest {

	@Severity(SeverityLevel.CRITICAL)
	@Story("As A user, I supposed to be able login with valid credantials and redirected to website home page.")
	@Test(description = "check that Im logged in with valid username and password ")
	@Description("Insert valid credantials and checking the error message I got")
	public void tc01_validLogin() {
		ProjectsPage pp = new ProjectsPage(driver);
		String actual = pp.getProjectsPageTitle();
		String expected = "Projects | involve.me";
		Assert.assertEquals(actual, expected);
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("As A user, When im logged out - i redirected to login page.")
	@Test(description = "When Im logged out, I redirected to the correct page with login button")
	@Description("log out")
	public void tc02_logOut() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.ChooseAccountOption("Log Out");
		LoginPage lp = new LoginPage(driver);
		boolean expected = lp.isLoginBtnDisplay();
		Assert.assertTrue(expected, "the login button is not displayed");
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("As A user, When im logged in with wrong user, Im getting the right error message.")
	@Test(description = "If Im login with wrong user name, Im getiing the right error message")
	@Description("try login with wrong user")
	public void tc03_loginWorngUser() {
		LoginPage lp = new LoginPage(driver);
		lp.login("alalouflior@gmail.co.il", "Sean151113");
		String expected = "These credentials do not match our records.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("As A user, When im logged in with wrong password, Im getting the right error message.")
	@Test(description = "If Im login with wrong password, Im getiing the right error message")
	@Description("try login with wrong password")
	public void tc04_loginWorngPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.login("alalouflior@gmail.com", "Sean151114");
		String expected = "These credentials do not match our records.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}
}
