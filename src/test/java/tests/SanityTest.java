package tests;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProjectsPage;
import pageObjects.ProjectsTypePage;
import pageObjects.TemplatesPage;

public class SanityTest extends BaseTest {

	@Test(description = "Log in/Move between tabs in homepage/Create work space/Create project")
	public void sanity() {
		HomePage hp = new HomePage(driver);
		hp.clickOnTabs("Templates");
		hp.clickOnTabs("Analytics");
		hp.clickOnTabs("Integrations");
		hp.clickOnTabs("Affiliate Program");
		hp.clickOnTabs("Projects");
		ProjectsPage pp = new ProjectsPage(driver);
		pp = new ProjectsPage(driver);
		pp.addNewWorkSpace("lior new workspace");
		pp.creatMyFirstProject();
		ProjectsTypePage pt = new ProjectsTypePage(driver);
		pt.chooseProjectType("Quiz");
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplateChoose("Literature Pop Quiz");
		tp.FillProjectName("project1");
		tp.clickStartEditing();
		tp.save();
	}

}
