package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.ProjectsPage;
import pageObjects.ProjectsTypePage;
import pageObjects.TemplatesPage;
@Epic("projects")
@Feature("projects creation")
public class ProjectTest extends BaseTest {
	@Severity(SeverityLevel.CRITICAL)
	@Story("As A user, .")
	@Test(description = "adding a new project to workSpace.")
	@Description("log out")
	public void tc01_addNewProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp = new ProjectsPage(driver);
		pp.addNewWorkSpace("lior");
		pp.creatMyFirstProject();
		ProjectsTypePage pt = new ProjectsTypePage(driver);
		pt.chooseProjectType("Quiz");
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplateChoose("Literature Pop Quiz");
		tp.FillProjectName("search1");
		tp.clickStartEditing();
		tp.save();
		pp = new ProjectsPage(driver);
		boolean expected = pp.searchingProject("search1", "search1");
		Assert.assertTrue(expected, "project has not been found");
	}
	@Test(description = "adding a new project to workSpace")
	public void tc02_addAnotherProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.createMoreProjects();
		ProjectsTypePage pt = new ProjectsTypePage(driver);
		pt.chooseProjectType("Quiz");
	    TemplatesPage tp = new TemplatesPage(driver);
	    tp.moveToTemplateChoose("Literature Pop Quiz");
		tp.FillProjectName("search2");
		tp.clickStartEditing();
		tp.save();
		boolean expected = pp.searchingProject("search2", "search1");
		pp.clearSearchInput();
	}
	@Test(description = "UI - Change projects's order display by different sorting")
	public void tc03_sortBy() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.tasksSortBy("name-asc");
		String actual = "search1";
		Assert.assertEquals(actual, pp.getFirstProject(0));
		pp.tasksSortBy("name-desc");
		actual = "search2";
		Assert.assertEquals(actual, pp.getFirstProject(0));
		pp.tasksSortBy("created-asc");
		actual = "search1";
		Assert.assertEquals(actual, pp.getFirstProject(0));
		pp.tasksSortBy("created-desc");
		actual = "search2";
		Assert.assertEquals(actual, pp.getFirstProject(0));

	}
	@Test(description = "Check that number of actual number of templates is correct")
	public void tc04_moveBetweenFilters() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.createMoreProjects();
		ProjectsTypePage pt = new ProjectsTypePage(driver);
		pt.chooseProjectType("Quiz");
	    TemplatesPage tp = new TemplatesPage(driver);
		tp.chooseFilterAll();
		int expected = 174;
		int actual = tp.numberOfTemplates();
		Assert.assertEquals(actual, expected);
		tp.chooseFilterSurvey();
		expected = 19;
		actual = tp.numberOfTemplates();
		Assert.assertEquals(actual, expected);
		tp.chooseFilterCalculator();
		expected = 15;
		actual = tp.numberOfTemplates();
		Assert.assertEquals(actual, expected);
		tp.chooseFilterQuiz();
		expected = 14;
		actual = tp.numberOfTemplates();
		Assert.assertEquals(actual, expected);
	}
	//@Test(description = "moving mouse to some template and click on preview" , dependsOnMethods = "tc02_addNewProject")
	public void tc05_previewTemplate() {
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
	}
}
