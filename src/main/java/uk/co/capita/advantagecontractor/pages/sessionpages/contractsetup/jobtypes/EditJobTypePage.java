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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.EditContractPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class EditJobTypePage extends BasePage{

	@FindBy(xpath = ProjectConstants.ONCONTRACT_CHKBOX)
	public WebElement onContract_chkBox;
	
	@FindBy(xpath = ProjectConstants.UPDATEJOBTYPE_BTN)
	public WebElement updateJobType_button;
	
	
	
	//constructor
	public EditJobTypePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	
	public Object editJobTypeDetailsAndUpdate(String onContractFlag) throws InterruptedException {
		test.log(LogStatus.INFO, "In editJobTypeDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ONCONTRACT_CHKBOX)));
		onContract_chkBox.click();
		updateJobType_button.click();
		
		//validate if Job Type update is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
		
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to edit Job Type of a contract");
//			EditJobTypePage editJobTypePage = new EditJobTypePage(driver, wait, test);
//			PageFactory.initElements(driver, editJobTypePage);
//			return editJobTypePage;
//		}
	
	test.log(LogStatus.INFO, "Job Type of specified contract edited successfully");
	JobTypesListPage jobTypesListPage = new JobTypesListPage(driver, wait, test);
	PageFactory.initElements(driver, jobTypesListPage);
	return jobTypesListPage;
	}
	
	
}
