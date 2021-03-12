package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.ProjectsPage;
import pageObjects.ProjectsTypePage;
import pageObjects.QuizPage;
import pageObjects.TemplatesPage;
@Epic("quiz")
@Feature("preview quiz")
public class QuizPreviewTest extends BaseTest {

	@Test(description = "Test if the score of the quiz is correct 3 correct answers from 3 questions")
	public void tc01_fillInQuiz1() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp = new ProjectsPage(driver);
		pp.addNewWorkSpace("lior new workspace");
		pp.creatMyFirstProject();
		ProjectsTypePage pt = new ProjectsTypePage(driver);
		pt.chooseProjectType("Quiz");
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
		QuizPage qp = new QuizPage(driver);
		//start fill in the quiz
		qp.clickNext();
		qp.fillInQuiz("The Merry Adventures of Robin Hood");
		qp.fillInQuiz("The Great Gastby");
		qp.fillInQuiz("He decides to go to Vietnam");
		qp.fillInDetails("lior", "alalouf", "alalouflior@gmail.com");
		String expected = "3";
		String actual = qp.getScore();
		Assert.assertEquals(actual, expected);
	}
	@Test(description = "check If the alerts text is correct",dependsOnMethods = "tc01_fillInQuiz1")
	public void tc02_checkAlertsDisplay() {
		QuizPage qp = new QuizPage(driver);
		qp.clickAlertRetake();
		String actual = qp.getAlertText();
		String expected = "This option restarts the project and resets all data for the user. This does not work in the preview, click TRY IT to test it.";
		Assert.assertEquals(actual, expected);
		qp.alertClick();
		qp.clickAlertFacebook();
		expected = "The social share only works on published projects.";
		actual = qp.getAlertText();
		Assert.assertEquals(actual, expected);
		qp.alertClick();
		qp.clickAlertTwiter();
		actual = qp.getAlertText();
		Assert.assertEquals(actual, expected);
		qp.alertClick();
	}
	@Test(description = "Test if the score of the quiz is correct 2 correct answers from 3 questions")
	public void tc03_fillInQuiz2() {
		QuizPage qp = new QuizPage(driver);
		driver.navigate().back();
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
		//tp.previewTemplate();
		qp = new QuizPage(driver);
		qp.clickNext();
		qp.fillInQuiz("Romeo and Juliet");
		qp.fillInQuiz("The Great Gastby");
		qp.fillInQuiz("He decides to go to Vietnam");
		qp.fillInDetails("lior", "alalouf", "alalouflior@gmail.com");
		String expected = "2";
		String actual = qp.getScore();
		Assert.assertEquals(actual, expected);
	}
	@Test(description = "Test if the score of the quiz is correct 1 correct answers from 3 questions")
	public void tc04_fillInQuiz3() {
		QuizPage qp = new QuizPage(driver);
		driver.navigate().back();
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
		//tp.previewTemplate();
		qp = new QuizPage(driver);
		qp.clickNext();
		qp.fillInQuiz("Romeo and Juliet");
		qp.fillInQuiz("The Lone Ranger and Tonto Fistfight in Heaven");
		qp.fillInQuiz("He decides to go to Vietnam");
		qp.fillInDetails("lior", "alalouf", "alalouflior@gmail.com");
		String expected = "1";
		String actual = qp.getScore();
		Assert.assertEquals(actual, expected);
	}
	@Test(description = "Test if the score of the quiz is correct 0 correct answers from 3 questions")
	public void tc05_fillInQuiz4() {
		QuizPage qp = new QuizPage(driver);
		driver.navigate().back();
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
		//tp.previewTemplate();
		qp = new QuizPage(driver);
		qp.clickNext();
		qp.fillInQuiz("Romeo and Juliet");
		qp.fillInQuiz("The Lone Ranger and Tonto Fistfight in Heaven");
		qp.fillInQuiz("He makes a life long friend");
		qp.fillInDetails("lior", "alalouf", "alalouflior@gmail.com");
		String expected = "0";
		String actual = qp.getScore();
		Assert.assertEquals(actual, expected);
	}
	@Test(description="check if quiz's error messages are correct -Case A")
	public void tc06_assertWrongFeedbacksCaseA() {
		QuizPage qp = new QuizPage(driver);
		driver.navigate().back();
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
		//tp.previewTemplate();
		qp = new QuizPage(driver);
		qp.clickNext();
		qp.fillInQuizWithoutNext("Romeo and Juliet");
		String expected = "This 1883 novel was written by American illustrator and writer Howard Pyle.";
		String actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInQuizWithoutNext("The Lone Ranger and Tonto Fistfight in Heaven");
		expected = "Lone Ranger and Tonto belong to contemporary American tribal literature.";
		actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInQuizWithoutNext("He makes a life long friend");
		expected = "The novel describes soldiers' lives during the Vietnam war so a decision to join the army is most significant for the plot.";
		actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInDetails("lior", "alalouf", "alalouflior@gmail.com");
	}
	@Test(description="check if quiz's error messages are correct -Case B")
	public void tc07_assertWrongFeedbacksCaseB() {
		QuizPage qp = new QuizPage(driver);
		driver.navigate().back();
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
		//tp.previewTemplate();
		qp = new QuizPage(driver);
		qp.clickNext();
		qp.fillInQuizWithoutNext("The Merry Wives Of Windsor");
		String expected = "This 1883 novel was written by American illustrator and writer Howard Pyle.";
		String actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInQuizWithoutNext("The Lone Ranger and Tonto Fistfight in Heaven");
		expected = "Lone Ranger and Tonto belong to contemporary American tribal literature.";
		actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInQuizWithoutNext("He decides to immigrate to Canada");
		expected = "The novel describes soldiers' lives during the Vietnam war so a decision to join the army is most significant for the plot.";
		actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInDetails("lior", "alalouf", "alalouflior@gmail.com");
	}
	@Test(description="check if quiz's correct messages are correct")
	public void tc08_assertCorrectFeedbacks() {
		QuizPage qp = new QuizPage(driver);
		driver.navigate().back();
		TemplatesPage tp = new TemplatesPage(driver);
		tp.moveToTemplatePreview("Literature Pop Quiz");
		//tp.previewTemplate();
		qp = new QuizPage(driver);
		qp.clickNext();
		qp.fillInQuizWithoutNext("The Merry Adventures of Robin Hood");
		String expected = "This 1883 novel was written by American illustrator and writer Howard Pyle.";
		String actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInQuizWithoutNext("The Great Gastby");
		expected = "Lone Ranger and Tonto belong to contemporary American tribal literature.";
		actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInQuizWithoutNext("He decides to go to Vietnam");
		expected = "The novel describes soldiers' lives during the Vietnam war so a decision to join the army is most significant for the plot.";
		actual = qp.feedbackText();
		Assert.assertEquals(actual, expected);
		qp.clickNext();
		qp.fillInDetails("lior", "alalouf", "alalouflior@gmail.com");
	}
}
