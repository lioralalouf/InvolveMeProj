package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(css = ".nav.navbar-nav>.nav-item:nth-child(1)")
	private WebElement loginBtn;
	@FindBy(css = ".navbar-nav.mr-auto a ")
	private List<WebElement> listOfTabs;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// click on login tab
	public void pressLogin() {
		click(loginBtn);
	}

	// clicking on tab from list in top bar menu
	public void clickOnTabs(String name) {
		for (WebElement el : listOfTabs) {
			String tab = getText(el);
			if (tab.equalsIgnoreCase(name)) {
				click(el);
			}
		}
	}

}
