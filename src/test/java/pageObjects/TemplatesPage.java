package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplatesPage extends TopBarMenu {
	// templates - buttons
	@FindBy(css = ".btn.btn-secondary.btn-preview")
	private WebElement specificPreview;
	@FindBy(css = ".btn.btn-primary")
	private WebElement specificChoose;
	@FindBy(css = "#new-project-form > div.form-group div:nth-child(3) div button")
	private WebElement specificStartEditing;
	@FindBy(css = ".btn.btn-primary")
	private WebElement chooseBtn;
	@FindBy(css = "[name='project_name']")
	private WebElement projectNameInput;
	@FindBy(css = ".e-close.nav-link")
	private WebElement saveBtn;
	
	//templates - lists
	@FindBy(css = ".c-thumbnail.gallery-item")
	private List<WebElement> listOfTemplates;
	@FindBy(css = ".btn.btn-secondary.btn-preview")
	private List<WebElement> listOfPreviews;
	@FindBy(css = ".btn.btn-primary")
	private List<WebElement> listOfChoose;
	@FindBy(css = ".modal-btn-start.swal-button")
	private List<WebElement> listOfStartEditBtn;;
	@FindBy(css = ".select-header")
	private List<WebElement> listOfProjectType;
	
	// filters
	@FindBy(css = "#filter-all")
	private WebElement allBtn;
	@FindBy(css = "#filter-quiz")
	private WebElement quizBtn;
	@FindBy(css = "#filter-survey")
	private WebElement surveyBtn;
	@FindBy(css = "#filter-calculator")
	private WebElement calculatorBtn;
	@FindBy(css = "#filter-form")
	private WebElement formBtn;
	@FindBy(css = "#filter-payment")
	private WebElement paymentFormBtn;
	@FindBy(css = "#filter-leadpage")
	private WebElement LeadPageBtn;
	@FindBy(css = "#filter-promotion")
	private WebElement promotionBtn;
	@FindBy(css = "#filter-personality_test")
	private WebElement personalityTestBtn;
	@FindBy(css = "#filter-linklist")
	private WebElement linkTestBtn;
	
	@FindBy(css = ".nav-link.category-filter")
	private List<WebElement> listOffilters;

	public TemplatesPage(WebDriver driver) {
		super(driver);
	}
	
	//choose type of filter - didnt work for me from a a list
	public void chooseFilterAll() {
		sleep(2000);
		click(allBtn);
		sleep(1000);
	}
	public void chooseFilterSurvey() {
		click(surveyBtn);
		sleep(1000);
	}
	public void chooseFilterCalculator() {
		click(calculatorBtn);
		sleep(1000);
	}
	public void chooseFilterForm() {
		click(formBtn);
		sleep(1000);
	}
	public void chooseFilterPaymentForm() {
		click(paymentFormBtn);
		sleep(1000);
	}
	public void chooseFilterLeadPage() {
		click(LeadPageBtn);
		sleep(1000);
	}
	public void chooseFilterPromotion() {
		click(promotionBtn);
		sleep(1000);
	}
	public void chooseFilterPersonalityTest() {
		click(personalityTestBtn);
		sleep(1000);
	}
	public void chooseFilterLinkList() {
		click(linkTestBtn);
		sleep(1000);
	}
	public void chooseFilterQuiz() {
		click(quizBtn);
		sleep(1000);
	}
	//choose filter from a list - Not Working
	public void chooseFilter(String name) {
		for (WebElement el : listOffilters) {
			String filter = getText(el);
			if (filter.equalsIgnoreCase(name)) {
				sleep(2500);
				click(el);
				
			}
			
		}
		
	}
	//mouse hover by text on a template 
	public void moveToTemplatePreview(String text) {
		for (WebElement el : listOfTemplates) {
			String templateName = el.findElement(By.cssSelector(".details-container>h3")).getText();
			if (text.equalsIgnoreCase(templateName)) {
				moveTo(el);
				//click on preview 
				WebElement previewEl = el.findElement(By.cssSelector(".btn-preview"));
				click(previewEl);
				sleep(4000);
				break;
			}
		}
	}
	//mouse hover by text on a template 
	public void moveToTemplateChoose(String text) {
		sleep(1000);
		for (WebElement el : listOfTemplates) {
			String templateName = el.findElement(By.cssSelector(".details-container>h3")).getText();
			if (text.equalsIgnoreCase(templateName)) {
				moveTo(el);
				//click on choose 
				WebElement previewEl = el.findElement(By.cssSelector(".btn.btn-primary"));
				click(previewEl);
				sleep(4000);
				break;
			}
		}
	}
	
	//click on template's review from a list - Not Working
	public void clickPreview(String text) {
		for (WebElement el : listOfPreviews) {
			String listName = getText(el);
			if (el.isDisplayed()) {
				if (listName.equalsIgnoreCase(text)) {
					sleep(3000);
					click(el);
					break;

				}

			}

		}

	}
	//click on specific preview button
	public void previewTemplate() {
		click(specificPreview);
	}
	//clicking on specific choose button
	public void chooseTemplate() {
		click(specificChoose);
	}
	//fill name for the project
	public void FillProjectName(String name) {
		waitForLoad(driver);
		moveTo(projectNameInput);
		click(projectNameInput);
		fillText(projectNameInput, name);
	}
	//click on start editing button
	public void clickStartEditing() {
		click(specificStartEditing);
	}
	//click on save button
	public void save() {
		click(saveBtn);
		sleep(2000);
	}
	//click on choose button from a list - Not Working
	public void clickOnProjectType(String text) {
		for (WebElement el : listOfChoose) {
			String option = getText(el);
			if (option.toLowerCase().contains(text)) {
				sleep(1500);
				click(el);
				break;
				
			}
			
		}
	
	}
	//return number of templates
	public int numberOfTemplates() {
		return listOfTemplates.size();
	}
}
