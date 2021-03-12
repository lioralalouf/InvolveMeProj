package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu extends BasePage {
	@FindBy(css = "div.text-sm.flex.items-start.md\\:flex-grow > a:nth-child(1)")
	private WebElement projectsLink;
	@FindBy(css = "div.text-sm.flex.items-start.md\\:flex-grow > a:nth-child(2)")
	private WebElement templatesLink;
	@FindBy(css = "div.text-sm.flex.items-start.md\\:flex-grow > a:nth-child(3)")
	private WebElement analyticsLink;
	@FindBy(css = "div.text-sm.flex.items-start.md\\:flex-grow > a:nth-child(4)")
	private WebElement integrationsLink;
	@FindBy(css = "div.text-sm.flex.items-start.md\\:flex-grow > a:nth-child(5)")
	private WebElement affliateLink;

	public TopBarMenu(WebDriver driver) {
		super(driver);

	}

	public void chooseProjects(WebElement el) {
		click(projectsLink);

	}

	public void chooseTemplates(WebElement el) {
		click(templatesLink);

	}

	public void chooseAnalytics(WebElement el) {
		click(analyticsLink);

	}

	public void chooseIntegrations(WebElement el) {
		click(integrationsLink);
	}

	public void chooseAffiliate(WebElement el) {
		click(affliateLink);
	}

}
