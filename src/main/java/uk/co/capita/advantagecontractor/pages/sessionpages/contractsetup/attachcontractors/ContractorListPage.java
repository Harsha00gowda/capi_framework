package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.attachcontractors;

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

public class ContractorListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.ADDCONTRACTOR_BTN)
	public WebElement addContractor_btn;
	
	
	
	@FindBy(xpath = ProjectConstants.EDITCONTRACTOR_ICON)
	public WebElement editContractor_icon;
	
	
	@FindBy(xpath = ProjectConstants.DELETECONTRACTOR_ICON)
	public WebElement deleteContractor_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	
	//constructor
	public ContractorListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}
	
	public Object goToAddContractorPage(){
		
		test.log(LogStatus.INFO, "In goToAddContractorPage method");
		try{
			addContractor_btn.click();
		//validate if click on createOperative_btn is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADDCONTRACTOR_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Add Contractor page");
			ContractorListPage contractorListPage = new ContractorListPage(driver, wait, test);
			PageFactory.initElements(driver, contractorListPage);
			return contractorListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Add Contractor page");
		AddContractorToAContractPage addContractorToAContractPage = new AddContractorToAContractPage(driver, wait, test);
		PageFactory.initElements(driver, addContractorToAContractPage);
		return addContractorToAContractPage;
	
	}

	//delete the only attached contractor-no need to pass the name of the contractor to be deleted 
	//as we have not parameterized attach contractor, we are attaching any contractor available first in the dropdown
	public Object clickOnEdit() throws InterruptedException{
		test.log(LogStatus.INFO, "In clickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITCONTRACTOR_ICON)));
			editContractor_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to click on edit icon of attached contractor");
			ContractorListPage contractorListPage = new ContractorListPage(driver, wait, test);
			PageFactory.initElements(driver, contractorListPage);
			return contractorListPage;
			
		}
		test.log(LogStatus.INFO, "Able to click on edit icon of attached contractor");
		EditContractorPage editContractorPage = new EditContractorPage(driver, wait, test);
		PageFactory.initElements(driver, editContractorPage);
		return editContractorPage;
		
	}



	public Object deleteAttachedContractor() {
		test.log(LogStatus.INFO, "In deleteAttachedContractor method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETECONTRACTOR_ICON)));
			deleteContractor_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to delete attached contractor");
			ContractorListPage contractorListPage = new ContractorListPage(driver, wait, test);
			PageFactory.initElements(driver, contractorListPage);
			return contractorListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to delete attached contractor");
		return null;	}

	}

	


