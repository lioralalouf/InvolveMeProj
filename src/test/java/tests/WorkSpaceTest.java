package tests;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProjectsPage;
import pageObjects.ProjectsTypePage;
import pageObjects.TemplatesPage;

public class WorkSpaceTest extends BaseTest {

	@Test(description = "Adding A new workspace, check it has been added")
	public void tc01_addWorkSpace() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewWorkSpace("my new workspace");
		boolean expected = pp.checkIfWorkspaceExist("my new workspace");
		Assert.assertTrue(expected, "workspace has not been added");
	}

	@Test(description = "rename the workSpace's name, check it has been renamed")
	public void tc02_renameWorkSpace() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewWorkSpace("before rename");
		pp.renameWorkSpace("after rename");
		boolean expected = pp.checkIfWorkspaceExist("after rename");
		Assert.assertTrue(expected, "workspace has not been renamed");
	}

	@Test(description = "checking that confirm delete button isnt clickable - case 1")
	public void tc03_notValidDeleteCaseA() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewWorkSpace("delete");
		pp.fillDeleteWorkSpace("dele");
		boolean isClickable = pp.checkDeleteButtonClickable();
		Assert.assertFalse(isClickable, "The Button is clickable although it shouldnt");
		pp.cancelDelete();
	}

	@Test(description = "checking that confirm delete button isnt clickable - case 2")
	public void tc04_notValidDeleteCaseB() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.clickOnChosenWorkSpace("delete");
		pp.fillDeleteWorkSpace("deleted");
		boolean isClickable = pp.checkDeleteButtonClickable();
		Assert.assertFalse(isClickable, "The Button is clickable although it shouldnt");
		pp.cancelDelete();
	}

	@Test(description = "delete workSpace, check it has been deleted")
	public void tc05_validDelete() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.clickOnChosenWorkSpace("delete");
		pp.fillDeleteWorkSpace("delete");
		pp.clickDeleteWorkSpace();
		boolean expected = pp.checkIfWorkspaceExist("delete");
		Assert.assertFalse(expected, "workspace has not been deleted");
	}

	@Test(description = "choosing specific work space, check the workspace title is correct")
	public void tc06_chooseWorksSpace() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.clickOnChosenWorkSpace("my new workspace");
		String expected = "my new workspace2";
		String actual = pp.getWorkspaceTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "check if the project Im searching for is in search results")
	public void tc07_searchExistingProject() {
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
		pp.createMoreProjects();
		pt = new ProjectsTypePage(driver);
		pt.chooseProjectType("Quiz");
		tp = new TemplatesPage(driver);
		tp.moveToTemplateChoose("Literature Pop Quiz");
		tp.FillProjectName("search2");
		tp.clickStartEditing();
		tp.save();
		pp = new ProjectsPage(driver);
		boolean expected = pp.searchingProject("1", "1");
		System.out.println(expected);
		Assert.assertTrue(expected, "the searched phrase has not been found");
	}

	 @Test(description = "check that Im not getting project doesnt exist in search results")
	public void tc08_searchNotExistingProject() {
		ProjectsPage pp = new ProjectsPage(driver);
		boolean expected = pp.searchingProject("3", "3");
		Assert.assertFalse(expected, "the searched project has been found although it shouldnt");
	}
}
