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
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class AddContractorToAContractPage extends BasePage{
	

	
	@FindBy(xpath = ProjectConstants.CONTRACTOR_DROPDOWN)
	public WebElement contractor_dropdown;

	@FindBy(xpath = ProjectConstants.CONTRACTOR_OPTION)
	public WebElement contractor_option;
	
	@FindBy(xpath = ProjectConstants.ADDTOCONTR_BTN)
	public WebElement addToContract_btn;

	
	//constructor
	public AddContractorToAContractPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	//The following method does not receive any contractor name as parameter as we will select
	//the first contractor available in the dropdown
	public Object enterContractorDetailsAndAttach() throws InterruptedException {
		test.log(LogStatus.INFO, "In enterContractorDetailsAndAttach method");
		
//		try{

		contractor_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTRACTOR_OPTION)));
		Thread.sleep(8000);//intentionally using thread.sleep
		contractor_option.click();
		Thread.sleep(4000);//intentionally using thread.sleep
		addToContract_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to attach a contractor to a contract");
//			AddContractorToAContractPage addContractorToAContractPage = new AddContractorToAContractPage(driver, wait, test);
//			PageFactory.initElements(driver, createOperativePage);
//			return createOperativePage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Operative details and save");
		ContractorListPage contractorListPage = new ContractorListPage(driver, wait, test);
		PageFactory.initElements(driver, contractorListPage);
		return contractorListPage;
		
		
		
	}

}
