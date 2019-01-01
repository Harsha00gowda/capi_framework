package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails;

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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.contractjobnumber.ContractJobNumberListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.jobcosting.ContractJobCostingListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.attachcontractors.ContractorListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.autopivaluebands.AutoPIValueBandsListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contactdetails.ContactDetailsListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractdiary.DiaryListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractorvariance.ContractorVarianceListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.jobtypes.JobTypesListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.mainataincertificates.MaintainCertificatesListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.operatives.OperativesListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.PrioritiesListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.recharge.RechargeListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sor.SORListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.systemoptions.SystemOptionsListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class ContractDetailsMainPage extends BasePage{

	@FindBy(xpath = ProjectConstants.PRIORITIES_BAR)
	public WebElement priorities_bar;
	
	@FindBy(xpath = ProjectConstants.LOADING_ICON)
	public WebElement loading_icon;
	
	@FindBy(xpath = ProjectConstants.SYSTEMOPTIONS_BAR)
	public WebElement systemoptions_bar;
	
	@FindBy(xpath = ProjectConstants.AUTOPIVAL_BAR)
	public WebElement autoPIVal_bar;
	
	@FindBy(xpath = ProjectConstants.JOBTYPES_BAR)
	public WebElement jobTypes_bar;
	
	@FindBy(xpath = ProjectConstants.CONTRACTORS_BAR)
	public WebElement contractors_bar;	
	
	@FindBy(css = ProjectConstants.CONTRACTOROPERATIVES_BAR)
	public WebElement contractorOperatives_bar;	
	
	@FindBy(xpath = ProjectConstants.DIARY_BAR)
	public WebElement diary_bar;

	@FindBy(xpath = ProjectConstants.MAINTAINCERTIFICATES_BAR)
	public WebElement maintaincertificates_bar;
	
	@FindBy(xpath = ProjectConstants.SOR_BAR)
	public WebElement sor_bar;
	
	@FindBy(xpath = ProjectConstants.CONTRACTRECHARGE_BAR)
	public WebElement contractRecharge_bar;

	@FindBy(xpath = ProjectConstants.CONTACTDETAILS_BAR)
	public WebElement contactdetails_bar;
	
	@FindBy(xpath = ProjectConstants.JOBNUMBER_BAR)
	public WebElement jobNumber_bar;
	
	@FindBy(xpath = ProjectConstants.CONTRACTORS_ACCORDIAN)
	public WebElement contractors_accordian;
	
	@FindBy(xpath = ProjectConstants.CONTACTORVARIANCE_ACCORDION)
	public WebElement contractorvariance_accordion;

	@FindBy(xpath = ProjectConstants.JOBCOSTING_BAR)
	public WebElement jobCosting_bar;
	
	
	//constructor
	public ContractDetailsMainPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}

	public Object goToPrioritiesSection(){
		test.log(LogStatus.INFO, "In goToPrioritiesSection method");
		try{
			priorities_bar.click();
		//validate if click on priorities bar is successful
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Priorities section");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Priorities section after clicking on Priorities bar");
		PrioritiesListPage prioritiesListPage = new PrioritiesListPage(driver, wait, test);
		PageFactory.initElements(driver, prioritiesListPage);
		return prioritiesListPage;
			
		
	}

	public Object goToSystemOptionsSection() {
		test.log(LogStatus.INFO, "In goToSystemOptions method");
		try{
			systemoptions_bar.click();
		//validate if click on system options bar is successful
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to System Options section");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to System Options section after clicking on System Options bar");
		SystemOptionsListPage systemOptionsListPage = new SystemOptionsListPage(driver, wait, test);
		PageFactory.initElements(driver, systemOptionsListPage);
		return systemOptionsListPage;
			
	}

	public Object goToMaintainCertificates() {
		test.log(LogStatus.INFO, "In goToMaintainCertificates method");
		try{
			maintaincertificates_bar.click();
			//validate if click on system options bar is successful
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));


		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Maintain certificates section");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}


		test.log(LogStatus.INFO, "Able to go to Maintain certificates section after clicking on maintain certificates bar");
		MaintainCertificatesListPage certificatesOptionsListPage = new MaintainCertificatesListPage(driver, wait, test);
		PageFactory.initElements(driver, certificatesOptionsListPage);
		return certificatesOptionsListPage;

	}

	public Object goToAutoPIValBandSection() {
		test.log(LogStatus.INFO, "In goToAutoPIValBandSection method");
		try{
			autoPIVal_bar.click();
		//validate if click on system options bar is successful
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Auto PI Value Bands section");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Auto PI Value Bands section after clicking on Auto PI Value Bands bar");
		AutoPIValueBandsListPage autoPIValueBandsListPage = new AutoPIValueBandsListPage(driver, wait, test);
		PageFactory.initElements(driver, autoPIValueBandsListPage);
		return autoPIValueBandsListPage;
	}

	public Object goToJobTypesSection() {
		test.log(LogStatus.INFO, "In goToJobTypesSection method");
		try{
		jobTypes_bar.click();
		//validate if click on system options bar is successful
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Auto PI Value Bands section");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Auto PI Value Bands section after clicking on Auto PI Value Bands bar");
		JobTypesListPage jobTypesListPage = new JobTypesListPage(driver, wait, test);
		PageFactory.initElements(driver, jobTypesListPage);
		return jobTypesListPage;
	}

	public Object goToOperativesSection() throws InterruptedException {
		test.log(LogStatus.INFO, "In goToOperativesSection method");
		//try{
			//click on COntractors bar first and then on Contractor Operatives bar
			contractors_bar.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProjectConstants.CONTRACTOROPERATIVES_BAR)));
			contractorOperatives_bar.click();
		//validate if Contractor Operatives section is displayed
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to go to Contractor Operatives section");
//			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
//			PageFactory.initElements(driver, contractDetailsMainPage);
//			return contractDetailsMainPage;
//		}
		
		
		test.log(LogStatus.INFO, "Able to go to Contractor Operatives section");
		OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
		PageFactory.initElements(driver, operativesListPage);
		return operativesListPage;
	}

	public Object goToContractorSection() throws InterruptedException {
		test.log(LogStatus.INFO, "In goToContractorSection method");
		try{
			//click on Contractors bar
			contractors_bar.click();
			//validate if Contractor section is displayed
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Contractor section of a contract");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Contractor section of a contractor");
		ContractorListPage contractorListPage = new ContractorListPage(driver, wait, test);
		PageFactory.initElements(driver, contractorListPage);
		return contractorListPage;
	}

	public Object goToDiarySection() throws InterruptedException {
		test.log(LogStatus.INFO, "In goToDiarySection method");
		try{
			//click on on Diary bar
			diary_bar.click();
			//validate if Diary section is displayed
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Diary section of a contract");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Diary section of a contractor");
		DiaryListPage diaryListPage = new DiaryListPage(driver, wait, test);
		PageFactory.initElements(driver, diaryListPage);
		return diaryListPage;
	}


	public Object goToContactDetails() {
		test.log(LogStatus.INFO, "In goToContactDetails method");
		try{
			contactdetails_bar.click();
			//validate if click on contact details bar is successful
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));

		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Contact details section");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		test.log(LogStatus.INFO, "Able to go to Contact details section after clicking on contact details bar");
		ContactDetailsListPage contactDetailsList = new ContactDetailsListPage(driver, wait, test);
		PageFactory.initElements(driver, contactDetailsList);
		return contactDetailsList;
	}

	public Object goToSORSection() throws InterruptedException {
		test.log(LogStatus.INFO, "In goToSORSection method");
		try{
			//click on on SOR bar
			sor_bar.click();
			//validate if Diary section is displayed
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to SOR section of a contract");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to SOR section of a contractor");
		SORListPage sorListPage = new SORListPage(driver, wait, test);
		PageFactory.initElements(driver, sorListPage);
		return sorListPage;

	}

	public Object goToRechargeSection() {
		test.log(LogStatus.INFO, "In goToRechargeSection method");
		try{
			//click on on SOR bar
			contractRecharge_bar.click();
			//validate if Contract Recharge section is displayed
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Recharge section of a contract");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Recharge section of a contractor");
		RechargeListPage rsechargeListPage = new RechargeListPage(driver, wait, test);
		PageFactory.initElements(driver, rsechargeListPage);
		return rsechargeListPage;
	}

	public Object goToContractJobNumberAccordion() {
		test.log(LogStatus.INFO, "In goToContractJobNumberAccordion method");
		try{
			jobNumber_bar.click();
		//validate if click on system options bar is successful
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
			Thread.sleep(5000);	
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Contract job number section section");
			ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
			PageFactory.initElements(driver, contractDetailsMainPage);
			return contractDetailsMainPage;
		}
		
		test.log(LogStatus.INFO, "Able to go to Contract job number section after clicking on Contract job number accordion");
		ContractJobNumberListPage contractJobNumberListPage = new ContractJobNumberListPage(driver, wait, test);
		PageFactory.initElements(driver, contractJobNumberListPage);
		return contractJobNumberListPage;
	}

public Object goToContractorsSection() {
		
		test.log(LogStatus.INFO, "In goToContractorsSection method");
	try {	
		//click on on Contractors Accordion
		contractors_accordian.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
		
		contractorvariance_accordion.click();
		
	} catch(Throwable t){
		test.log(LogStatus.INFO, "Unable to go to Priorities section");
		ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
		PageFactory.initElements(driver, contractDetailsMainPage);
		return contractDetailsMainPage;
	}
		
		test.log(LogStatus.INFO, "Able to go to Contractors section of a contract");
		ContractorVarianceListPage contractorVarianceListPage = new ContractorVarianceListPage(driver, wait, test);
		PageFactory.initElements(driver, contractorVarianceListPage);
		return contractorVarianceListPage;
	}

public Object goToContractJobCostingAccordion() {
	test.log(LogStatus.INFO, "In goToContractJobCostingAccordion method");
	try{
		jobCosting_bar.click();
	//validate if click on system options bar is successful
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
		//Thread.sleep(5000);	
	
	} catch(Throwable t){
		test.log(LogStatus.INFO, "Unable to go to Contract job costing section section");
		ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
		PageFactory.initElements(driver, contractDetailsMainPage);
		return contractDetailsMainPage;
	}
	
	test.log(LogStatus.INFO, "Able to go to Contract job costing section after clicking on Contract job costing accordion");
	ContractJobCostingListPage contractJobCostingListPage = new ContractJobCostingListPage(driver, wait, test);
	PageFactory.initElements(driver, contractJobCostingListPage);
	return contractJobCostingListPage;
}


}
