package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsTypePage extends TopBarMenu{
	@FindBy(css = ".content-type")
	private List<WebElement> projectTypes;

	public ProjectsTypePage(WebDriver driver) {
		super(driver);
	}
	//choose project type from a list
	public void chooseProjectType(String name) {
		for (WebElement el : projectTypes) {
			String title = getText(el.findElement(By.cssSelector("div > div.title")));
			if (title.equalsIgnoreCase(name)) {
				el.click();
				break;
				
			}
			
		}
	}

}
