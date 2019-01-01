package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.recharge;

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

public class EditRechargePage extends BasePage{

	@FindBy(xpath = ProjectConstants.LINENO_TXTBOX)
	public WebElement lineNo_txtbox;
	
	@FindBy(xpath = ProjectConstants.CREATERECHARGE_ICON)
	public WebElement updateRecharge_icon;
	
	
	
	//constructor
	public EditRechargePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editRechargeDetailsAndUpdate(String lineNo) throws InterruptedException{
		
		test.log(LogStatus.INFO, "In editRechargeDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.LINENO_TXTBOX)));
			lineNo_txtbox.clear();	
			
			lineNo_txtbox.sendKeys(lineNo);
			updateRecharge_icon.click();
			
			//validate if Recharge update is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
			
			
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit recharge");
//				EditRechargePage editRechargePage = new EditRechargePage(driver, wait, test);
//				PageFactory.initElements(driver, editRechargePage);
//				return editRechargePage;
//			}
		
		test.log(LogStatus.INFO, "Recharge edited successfully");
		RechargeListPage rechargeListPage = new RechargeListPage(driver, wait, test);
		PageFactory.initElements(driver, rechargeListPage);
		return rechargeListPage;
	}
	
	
}
