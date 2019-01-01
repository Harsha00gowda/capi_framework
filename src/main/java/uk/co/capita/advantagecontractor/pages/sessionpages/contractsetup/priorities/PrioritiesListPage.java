package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities;

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

public class PrioritiesListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createPriority_btn;
	
	@FindBy(xpath = ProjectConstants.PRIORITY_SEARCH_TXTBOX)
	public WebElement priority_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITPRIORITY_ICON)
	public WebElement editpriority_icon;
	
	@FindBy(xpath = ProjectConstants.DELETEPRIORITY_ICON)
	public WebElement deletePriority_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	//constructor
	public PrioritiesListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreatePriorityPage(){
		
		test.log(LogStatus.INFO, "In goToPrioritiesSection method");
		try{
			createPriority_btn.click();
		//validate if click on priorities bar is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Priorities page");
			PrioritiesListPage prioritiesListPage = new PrioritiesListPage(driver, wait, test);
			PageFactory.initElements(driver, prioritiesListPage);
			return prioritiesListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Priorities page");
		CreatePriorityPage createPriorityPage = new CreatePriorityPage(driver, wait, test);
		PageFactory.initElements(driver, createPriorityPage);
		return createPriorityPage;
	
	}
	
	public Object searchAndClickOnEdit(String priority) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.PRIORITY_SEARCH_TXTBOX)));
			priority_search_txtbox.sendKeys(priority);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITPRIORITY_ICON)));
			editpriority_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Priority");
			PrioritiesListPage prioritiesListPage = new PrioritiesListPage(driver, wait, test);
			PageFactory.initElements(driver, prioritiesListPage);
			return prioritiesListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Priority");
		EditPriorityPage editPriorityPage = new EditPriorityPage(driver, wait, test);
		PageFactory.initElements(driver, editPriorityPage);
		return editPriorityPage;
		
	}

	public Object searchAndDeletePriority(String priority) {
		test.log(LogStatus.INFO, "In searchAndDeletePriority method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.PRIORITY_SEARCH_TXTBOX)));
			priority_search_txtbox.sendKeys(priority);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETEPRIORITY_ICON)));
			//contract_search_result.click();
			deletePriority_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and delete specified Priority");
			PrioritiesListPage prioritiesListPage = new PrioritiesListPage(driver, wait, test);
			PageFactory.initElements(driver, prioritiesListPage);
			return prioritiesListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified Priority");
		return null;	
		}

	

}
