package pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuizPage extends BasePage {
	// quiz
	@FindBy(css = ".c-button.btn")
	private WebElement nextBtn;
	@FindBy(css = ".c-answer.answer-behaviour")
	private List<WebElement> listOfAnswers;

	// last user form after quiz
	@FindBy(css = ".input-label.firstName-label input")
	private WebElement firstName;
	@FindBy(css = ".input-label.lastName-label input")
	private WebElement lasttName;
	@FindBy(css = ".input-label.email-label input")
	private WebElement userEmail;
	@FindBy(css = ".el-checkbox__input span")
	private WebElement agreeCheckbox;
	@FindBy(css = ".c-button.btn")
	private WebElement viewResultsBtn;
	@FindBy(css = ".c-score-container span:nth-child(2)")
	private WebElement score;
	@FindBy(css = ".c-button.btn")
	private WebElement retakeQuiz;
	@FindBy(css = ".share-icon.fa.fa-twitter-square")
	private WebElement twiterShare;
	@FindBy(css = ".share-icon.fa.fa-facebook-square")
	private WebElement facebookShare;
	@FindBy(css = ".feedback-text")
	private WebElement feedbackText;

	// correct anwers
	@FindBy(css = "body > div.row.no-gutters > div.modal-mask > div > div.modal-container.desktop > div > div > div.standalone-project-main.vcentered.center-center > div > div.c-question-container.content-item.is-snappable > div > button:nth-child(4) > i.answer-click")
	private WebElement true1;
	@FindBy(css = "body > div.row.no-gutters > div.modal-mask > div > div.modal-container.desktop > div > div > div.standalone-project-main.vcentered.center-center > div > div.c-question-container.content-item.is-snappable > div > button:nth-child(3) > i.answer-click")
	private WebElement true2;
	@FindBy(css = "body > div.row.no-gutters > div.modal-mask > div > div.modal-container.desktop > div > div > div.standalone-project-main.vcentered.center-center > div > div.c-question-container.content-item.is-snappable > div > button:nth-child(5) > i.answer-click")
	private WebElement true3;

	// not active yet
	@FindBy(css = "")
	private WebElement quizScoreMessage;

	public QuizPage(WebDriver driver) {
		super(driver);
	}

	// click next button of quiz
	public void clickNext() {
		click(nextBtn);
	}

	// Try 1 - clicking answers directly on buttons -Not Working
	public void fillCorrect3From3Quiz() {
		click(nextBtn);
		click(true1);
		click(nextBtn);
		click(true2);
		click(nextBtn);
		click(true3);
		click(nextBtn);
	}

	// Try 2 - clicking answers by position -Not Working
	public void answerQuestions() {
		List<WebElement> buttons = driver
				.findElements(By.cssSelector(".c-answer.answer-behaviour.btn.btn-secondary.shadow>.answer-click"));
		for (WebElement el : buttons) {
			buttons.get(2).click();
		}

	}

	// Try 3 - clicking by mouse hover on answer
	public void moveToQuizAnswer(String text) {
		for (WebElement el : listOfAnswers) {
			moveTo(el.findElement(By.xpath("//h3[contains(text(),'" + text + "')]")));
			click(el);
			click(nextBtn);
		}
	}

	// choosing answer by text from a list
	public void fillInQuiz(String text) {
		sleep(3000);
		for (WebElement el : listOfAnswers) {
			String answer = getText(el);
			if (answer.equalsIgnoreCase(text)) {
				sleep(2000);
				click(el);
				click(nextBtn);
				break;
			}

		}

	}

	public void fillInQuizWithoutNext(String text) {
		sleep(3000);
		for (WebElement el : listOfAnswers) {
			String answer = getText(el);
			if (answer.equalsIgnoreCase(text)) {
				sleep(2000);
				click(el);
				break;

			}
		}
	}

	public void fillInDetails(String fName, String lName, String email) {
		sleep(1000);
		click(firstName);
		fillText(firstName, fName);
		click(lasttName);
		fillText(lasttName, lName);
		click(userEmail);
		fillText(userEmail, email);
		sleep(1500);
		click(agreeCheckbox);
		scrollMouse(viewResultsBtn);
		click(viewResultsBtn);
		sleep(1500);
	}

	// get quiz score
	public String getScore() {
		String userScore = getText(score);
		return userScore;
		
		
		
	}

	public String getAlertText() {
		sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		return alertText;
	}
	public void clickAlertRetake() {
		click(retakeQuiz);
	}
	public void clickAlertFacebook() {
		click(facebookShare);
	}
	public void clickAlertTwiter() {
		click(twiterShare);
	}
	public void alertClick() {
		alertOK();
	}

	public String feedbackText() {
		String feedback = getText(feedbackText);
		return feedback;
	}
}
