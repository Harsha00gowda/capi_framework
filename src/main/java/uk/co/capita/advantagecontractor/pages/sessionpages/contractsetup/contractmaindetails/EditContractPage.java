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
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class EditContractPage extends BasePage{

	@FindBy(xpath = ProjectConstants.DESCRIPTION_EDIT_TXTBOX)
	public WebElement description_edit_txtbox;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateContract_button;
	
	//constructor
	public EditContractPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editContractDetailsAndUpdate(String description) throws InterruptedException{
		
		test.log(LogStatus.INFO, "In editContractDetailsAndUpdate method");
		//try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DESCRIPTION_EDIT_TXTBOX)));
			description_edit_txtbox.clear();	
			
			description_edit_txtbox.sendKeys(description);
			updateContract_button.click();
			
			//validate if contract update is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
			
			
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit contract");
//				EditContractPage editContractPage = new EditContractPage(driver, wait, test);
//				PageFactory.initElements(driver, editContractPage);
//				return editContractPage;
//			}
		
		test.log(LogStatus.INFO, "Contract edited successfully");
		ContractListPage contractListPage = new ContractListPage(driver, wait, test);
		PageFactory.initElements(driver, contractListPage);
		return contractListPage;








	}

}
