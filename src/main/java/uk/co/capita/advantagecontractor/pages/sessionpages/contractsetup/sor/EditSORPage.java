package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sor;

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

public class EditSORPage extends BasePage{

	@FindBy(xpath = ProjectConstants.SHORTDESCR_TXTBOX)
	public WebElement shortDescr_txtbox;
	
	@FindBy(xpath = ProjectConstants.NEXT_BTN)
	public WebElement nextSOR_button;
	
	
	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateSOR_button;
	
	//constructor
	public EditSORPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterSORDetailsAndUpdate(String editedDescription) throws InterruptedException{
		
		test.log(LogStatus.INFO, "In enterSORDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SHORTDESCR_TXTBOX)));
		shortDescr_txtbox.clear();	
		shortDescr_txtbox.sendKeys(editedDescription);
		nextSOR_button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_BTN)));
		updateSOR_button.click();
			
			//validate if SOR update is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SORUPDATE_SUCCESS_MSG)));
			
			
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit SOR");
//				EditSORPage editSORPage = new EditSORPage(driver, wait, test);
//				PageFactory.initElements(driver, editSORPage);
//				return editSORPage;
//			}
		
		test.log(LogStatus.INFO, "SOR edited successfully");
		SORListPage sorListPage = new SORListPage(driver, wait, test);
		PageFactory.initElements(driver, sorListPage);
		return sorListPage;
	}
	
	
}
