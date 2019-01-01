package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sorskillset;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class SORSkillSetListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_SKILLSET_BUTTON)
	public WebElement createSkillSet_btn;

	@FindBy(xpath = ProjectConstants.UPDATE_ICON)
	public WebElement editSkillSet_icon;

	@FindBy(xpath = ProjectConstants.DELETE_POPUP)
	public WebElement delete_message;

	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement create_btn;

	@FindBy(xpath = ProjectConstants.DELETE_ICON)
	public WebElement deleteSkillSet_icon;

	@FindBy(xpath = ProjectConstants.NO_RECORD_TEXT)
	public WebElement norecord_txt;

	@FindBy(xpath = ProjectConstants.SKILL_SEARCH)
	public WebElement skill_search;

	//constructor
	public SORSkillSetListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateSkillSetPage(){
		test.log(LogStatus.INFO, "In goToCreateSkillSetPage method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDSOR_TXT)));
			createSkillSet_btn.click();
		//validate if click on SOR bar is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATESORSKILLSET_PAGETITLE)));
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create skill set page");
			SORSkillSetListPage sorSkillSetListPage = new SORSkillSetListPage(driver, wait, test);
			PageFactory.initElements(driver, sorSkillSetListPage);
			return sorSkillSetListPage;
		}
		test.log(LogStatus.INFO, "Able to go to Create skill set page");
		CreateSORSkillSetPage createskillset = new CreateSORSkillSetPage(driver, wait, test);
		PageFactory.initElements(driver, createskillset);
		return createskillset;
	
	}
	
	public Object searchSkillSetAndClickOnEdit(String skill) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchSkillSetAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SKILL_SEARCH)));
			skill_search.sendKeys(skill);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDSKILL_TXT)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_ICON)));
			editSkillSet_icon.click();
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Skill Set");
			SORSkillSetListPage sorSkillSetListPage = new SORSkillSetListPage(driver, wait, test);
			PageFactory.initElements(driver, sorSkillSetListPage);
			return sorSkillSetListPage;
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Skill Set");
		EditSORSkillSetPage editSkillSet = new EditSORSkillSetPage(driver, wait, test);
		PageFactory.initElements(driver, editSkillSet);
		return editSkillSet;
		
	}

	public Object deleteSelectedSORSkillSet(String Skill) {
		test.log(LogStatus.INFO, "In deleteSelectedSORSkillSet method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SKILL_SEARCH)));
			skill_search.sendKeys(Skill);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDSKILL_TXT)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_ICON)));
			deleteSkillSet_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_POPUP)));
			String deletePopup = delete_message.getText();
			Assert.assertEquals(deletePopup,"Are you sure you want to delete the record from the system?\n" +
					"Select YES to delete or NO to cancel\n" + "Yes\n" + "No");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.NO_RECORD_TEXT)));
			String recordText = norecord_txt.getText();
			Assert.assertEquals(recordText, "No records found");
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to delete the selected certificate");
			SORSkillSetListPage sorSkillSetListPage = new SORSkillSetListPage(driver, wait, test);
			PageFactory.initElements(driver, sorSkillSetListPage);
			return sorSkillSetListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified skill set");
		return null;	}

	}

	


