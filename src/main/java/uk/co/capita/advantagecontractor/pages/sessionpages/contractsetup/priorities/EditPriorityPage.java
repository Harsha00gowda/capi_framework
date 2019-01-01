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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.EditContractPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class EditPriorityPage extends BasePage{

	@FindBy(xpath = ProjectConstants.DESCR_TXTBOX)
	public WebElement descr_txtbox;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updatePriority_button;
	
	
	
	//constructor
	public EditPriorityPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editPriorityDetailsAndUpdate(String description) throws InterruptedException{
		
		test.log(LogStatus.INFO, "In editPriorityDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DESCR_TXTBOX)));
		descr_txtbox.clear();	
			
			descr_txtbox.sendKeys(description);
			updatePriority_button.click();
			
			//validate if priority update is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
			
			
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit priority");
//				EditPriorityPage editPriorityPage = new EditPriorityPage(driver, wait, test);
//				PageFactory.initElements(driver, editPriorityPage);
//				return editPriorityPage;
//			}
		
		test.log(LogStatus.INFO, "Priority edited successfully");
		PrioritiesListPage prioritiesListPage = new PrioritiesListPage(driver, wait, test);
		PageFactory.initElements(driver, prioritiesListPage);
		return prioritiesListPage;
	}
	
	
}
