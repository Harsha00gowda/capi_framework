package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractdiary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractDetailsMainPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class DiaryListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createDiary_btn;
	
	@FindBy(xpath = ProjectConstants.DIARY_SEARCH_TXTBOX)
	public WebElement 	diaryTxt_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITDIARY_ICON)
	public WebElement editDiary_icon;
	
	@FindBy(xpath = ProjectConstants.DELETEDIARY_ICON)
	public WebElement deleteDiary_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	//constructor
	public DiaryListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateDiaryPage(){
		
		test.log(LogStatus.INFO, "In goToCreateDiaryPage method");
		//try{
			createDiary_btn.click();
		//validate if click on Create diary button is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_PAGETITLE)));
				
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to go to Create Diary page");
//			DiaryListPage diaryListPage = new DiaryListPage(driver, wait, test);
//			PageFactory.initElements(driver, diaryListPage);
//			return diaryListPage;
//		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Diary page");
		CreateDiaryPage createDiaryPage = new CreateDiaryPage(driver, wait, test);
		PageFactory.initElements(driver, createDiaryPage);
		return createDiaryPage;
	
	}
	
	public Object searchAndClickOnEdit(String diaryText) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DIARY_SEARCH_TXTBOX)));
			diaryTxt_search_txtbox.sendKeys(diaryText);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITDIARY_ICON)));
			editDiary_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Diary");
			DiaryListPage diaryListPage = new DiaryListPage(driver, wait, test);
			PageFactory.initElements(driver, diaryListPage);
			return diaryListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Diary");
		EditDiaryPage editDiaryPage = new EditDiaryPage(driver, wait, test);
		PageFactory.initElements(driver, editDiaryPage);
		return editDiaryPage;
		
	}

	public Object searchAndDeleteDiary(String diaryText) {
		test.log(LogStatus.INFO, "In searchAndDeleteDiary method");
		try{
			Thread.sleep(5000);
			diaryTxt_search_txtbox.sendKeys(diaryText);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETEDIARY_ICON)));
			deleteDiary_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and delete specified Diary");
			DiaryListPage diaryListPage = new DiaryListPage(driver, wait, test);
			PageFactory.initElements(driver, diaryListPage);
			return diaryListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified Diary");
		return null;	
		}

	

}
