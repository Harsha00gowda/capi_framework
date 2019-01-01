package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.autopivaluebands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CreateAutoPIValueBandsPage extends BasePage{
	
	@FindBy(xpath = ProjectConstants.VALUEGREATERTHAN_ICON)
	public WebElement valGreaterThan_increaseValIcon;
	
	@FindBy(xpath = ProjectConstants.PERCENTAGE_TXTBOX)
	public WebElement percentage_txtbox;

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createautopi_btn;
	
	
	
	
	//constructor
	public CreateAutoPIValueBandsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterAutoPIValDetailsAndSave(String valGreaterThan, String percentage) throws InterruptedException {
		test.log(LogStatus.INFO, "In enterAutoPIValDetailsAndSave method");
		
//		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.VALUEGREATERTHAN_ICON)));
		for(int i = 0; i < Integer.parseInt(valGreaterThan); i++)
			valGreaterThan_increaseValIcon.click();
		percentage_txtbox.sendKeys("10");
		createautopi_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Able to enter Auto PI Band value details and save");
//			CreateAutoPIValueBandsPage createAutoPIValueBandsPage = new CreateAutoPIValueBandsPage(driver, wait, test);
//			PageFactory.initElements(driver, createAutoPIValueBandsPage);
//			return createAutoPIValueBandsPage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Auto PI Band value details and save");
		AutoPIValueBandsListPage autoPIValueBandsListPage = new AutoPIValueBandsListPage(driver, wait, test);
		PageFactory.initElements(driver, autoPIValueBandsListPage);
		return autoPIValueBandsListPage;
		
		
		
	}

}
