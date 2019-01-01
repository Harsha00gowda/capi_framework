package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.operatives;

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

public class EditOperativePage extends BasePage{

	@FindBy(xpath = ProjectConstants.OPERNAME_EDIT_TXTBOX)
	public WebElement operName_txtBox;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateOperative_button;
	
	
	
	//constructor
	public EditOperativePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	
	public Object editOperativeDetailsAndUpdate(String operativeName) throws InterruptedException {
		test.log(LogStatus.INFO, "In editJobTypeDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERNAME_EDIT_TXTBOX)));
		operName_txtBox.clear();
		operName_txtBox.sendKeys(operativeName);
		updateOperative_button.click();
		
		//validate if Operative updated is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
		
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to edit Operative details of a contract");
//			EditOperativePage editOperativePage = new EditOperativePage(driver, wait, test);
//			PageFactory.initElements(driver, editOperativePage);
//			return editOperativePage;
//		}
	
	test.log(LogStatus.INFO, "Operative details of specified contract edited successfully");
	OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
	PageFactory.initElements(driver, operativesListPage);
	return operativesListPage;
	}
	
	
}
