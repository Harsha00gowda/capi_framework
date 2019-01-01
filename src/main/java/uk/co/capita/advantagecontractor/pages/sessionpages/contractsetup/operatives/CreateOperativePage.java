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
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreateOperativePage extends BasePage{
	
	
	@FindBy(xpath = ProjectConstants.OPERCODE_TXTBOX)
	public WebElement operCode_txtBox;

	@FindBy(xpath = ProjectConstants.OPERNAME_TXTBOX)
	public WebElement operName_txtBox;
	
	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createOperative_btn;

	
	
	
	
	
	//constructor
	public CreateOperativePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterOperativeDetailsAndSave(String operativeCode, String operativeName) throws InterruptedException {
		test.log(LogStatus.INFO, "In enterJobTypeDetailsAndSave method");
		
//		try{

		operCode_txtBox.sendKeys(operativeCode);
		operName_txtBox.sendKeys(operativeName);
		createOperative_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Operative details and save");
//			CreateOperativePage createOperativePage = new CreateOperativePage(driver, wait, test);
//			PageFactory.initElements(driver, createOperativePage);
//			return createOperativePage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Operative details and save");
		OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
		PageFactory.initElements(driver, operativesListPage);
		return operativesListPage;
		
		
		
	}

}
