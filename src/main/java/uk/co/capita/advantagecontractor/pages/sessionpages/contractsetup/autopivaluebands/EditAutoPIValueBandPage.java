package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.autopivaluebands;

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

public class EditAutoPIValueBandPage extends BasePage{

	@FindBy(xpath = ProjectConstants.PERCENTAGE_ED_TXTBOX)
	public WebElement percentage_txtbox;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateAutoPIBand_button;
	
	
	
	//constructor
	public EditAutoPIValueBandPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editAutoPIBandValuePage(String percentage) throws InterruptedException{
		
		test.log(LogStatus.INFO, "In editAutoPIBandValuePage method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.PERCENTAGE_ED_TXTBOX)));
			percentage_txtbox.clear();	
			percentage_txtbox.sendKeys("33");
			updateAutoPIBand_button.click();
			
			//validate if priority update is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
			
			
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit auto pi value band");
//				EditAutoPIValueBandPage editAutoPIValueBandPage = new EditAutoPIValueBandPage(driver, wait, test);
//				PageFactory.initElements(driver, editAutoPIValueBandPage);
//				return editAutoPIValueBandPage;
//			}
		
		test.log(LogStatus.INFO, "Auto pi value band edited successfully");
		AutoPIValueBandsListPage autoPIValueBandsListPage = new AutoPIValueBandsListPage(driver, wait, test);
		PageFactory.initElements(driver, autoPIValueBandsListPage);
		return autoPIValueBandsListPage;
	}
	
	
}
