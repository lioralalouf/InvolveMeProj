package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	@FindBy(css = "[name='email']")
	private WebElement userEmail;
	@FindBy(css = "[name='password']")
	private WebElement userPassword;
	@FindBy(css = ".btn.btn-primary.btn-lg")
	private WebElement loginBtn;
	@FindBy(css = ".alert.alert-danger")
	private WebElement errorMsg;


	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//fill in userName and Password fields
	public void login(String user, String password) {
		fillText(userEmail, user);
		fillText(userPassword, password);
		click(loginBtn);
	}
	public String getErrorMsg(){
		return getText(errorMsg);
	}
	public boolean isLoginBtnDisplay() {
		if (loginBtn.isDisplayed()) {
			
		}
		return true;
		
	}

}
