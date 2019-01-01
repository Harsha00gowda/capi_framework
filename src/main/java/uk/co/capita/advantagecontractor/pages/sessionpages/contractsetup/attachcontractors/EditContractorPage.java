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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.EditContractPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class EditContractorPage extends BasePage{

	@FindBy(xpath = ProjectConstants.ACTIVEONCONTRACT_CHKBOX)
	public WebElement activeOnContractFlag;
	
	@FindBy(xpath = ProjectConstants.UPDATECONTRACTOR_BTN)
	public WebElement updateContractor_button;
	
	
	
	//constructor
	public EditContractorPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	
	public Object editAttachedContractorAndUpdate() throws InterruptedException {
		test.log(LogStatus.INFO, "In editAttachedContractorAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ACTIVEONCONTRACT_CHKBOX)));
		//deselecting the check box
		activeOnContractFlag.click();
		//reselecting the checkbox
		activeOnContractFlag.click();//selecting this flag again because we need this flag to be Y for maintain certificate test cases

		updateContractor_button.click();
		
		//validate if Operative updated is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
		
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to edit attached contractor");
//			EditContractorPage editContractorPage = new EditContractorPage(driver, wait, test);
//			PageFactory.initElements(driver, editContractorPage);
//			return editContractorPage;
//		}
	
	test.log(LogStatus.INFO, "Attached contractor details of specified contract edited successfully");
	ContractorListPage contractorListPage = new ContractorListPage(driver, wait, test);
	PageFactory.initElements(driver, contractorListPage);
	return contractorListPage;
	}
	
	
}
