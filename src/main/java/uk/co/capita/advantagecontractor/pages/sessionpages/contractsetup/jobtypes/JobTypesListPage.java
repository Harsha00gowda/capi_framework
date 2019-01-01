package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.jobtypes;

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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.CreatePriorityPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.PrioritiesListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class JobTypesListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createJobType_btn;
	
	@FindBy(xpath = ProjectConstants.JOBTYPE_SEARCH_TXTBOX)
	public WebElement jobType_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITJOBTYPE_ICON)
	public WebElement editJobType_icon;
	
	
	@FindBy(xpath = ProjectConstants.DELETEJOBTYPE_ICON)
	public WebElement deleteJobType_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	
	//constructor
	public JobTypesListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}
	
	public Object goToCreateJobTypePage(){
		
		test.log(LogStatus.INFO, "In goToCreateJobTypePage method");
		try{
			createJobType_btn.click();
		//validate if click on createJobType_btn is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEJOBTYPE_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Job Type page");
			JobTypesListPage jobTypesListPage = new JobTypesListPage(driver, wait, test);
			PageFactory.initElements(driver, jobTypesListPage);
			return jobTypesListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Job Type page");
		CreateJobTypePage createJobTypePage = new CreateJobTypePage(driver, wait, test);
		PageFactory.initElements(driver, createJobTypePage);
		return createJobTypePage;
	
	}
	
	public Object searchAndClickOnEdit(String jobType) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.JOBTYPE_SEARCH_TXTBOX)));
			jobType_search_txtbox.sendKeys(jobType);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITJOBTYPE_ICON)));
			editJobType_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Job Type");
			JobTypesListPage jobTypesListPage = new JobTypesListPage(driver, wait, test);
			PageFactory.initElements(driver, jobTypesListPage);
			return jobTypesListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Job Type");
		EditJobTypePage editJobTypePage = new EditJobTypePage(driver, wait, test);
		PageFactory.initElements(driver, editJobTypePage);
		return editJobTypePage;
		
	}



	public Object searchAndDeleteJobType(String jobType) {
		test.log(LogStatus.INFO, "In searchAndDeleteSystemOption method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.JOBTYPE_SEARCH_TXTBOX)));
			jobType_search_txtbox.sendKeys(jobType);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETEJOBTYPE_ICON)));
			//contract_search_result.click();
			deleteJobType_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and delete specified Job Type");
			JobTypesListPage jobTypesListPage = new JobTypesListPage(driver, wait, test);
			PageFactory.initElements(driver, jobTypesListPage);
			return jobTypesListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified Job Type");
		return null;	}

	}

	


