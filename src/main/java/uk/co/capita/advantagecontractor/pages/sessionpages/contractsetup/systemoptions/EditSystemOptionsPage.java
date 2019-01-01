package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.systemoptions;

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

public class EditSystemOptionsPage extends BasePage{

	@FindBy(xpath = ProjectConstants.DESCRI_TXTBOX)
	public WebElement descri_txtbox;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateSysOption_button;
	
	
	
	//constructor
	public EditSystemOptionsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	
	public Object editSystemOptionDetailsAndUpdate(String description) throws InterruptedException {
		test.log(LogStatus.INFO, "In editSystemOptionDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DESCRI_TXTBOX)));
		descri_txtbox.clear();	
		
		descri_txtbox.sendKeys(description);
		updateSysOption_button.click();
		
		//validate if system option update is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
		
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to edit system option");
//			EditSystemOptionsPage editSystemOptionsPage = new EditSystemOptionsPage(driver, wait, test);
//			PageFactory.initElements(driver, editSystemOptionsPage);
//			return editSystemOptionsPage;
//		}
	
	test.log(LogStatus.INFO, "System Option edited successfully");
	SystemOptionsListPage systemOptionsListPage = new SystemOptionsListPage(driver, wait, test);
	PageFactory.initElements(driver, systemOptionsListPage);
	return systemOptionsListPage;
	}
	
	
}
