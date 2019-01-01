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
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreatePriorityPage extends BasePage{
	
	@FindBy(xpath = ProjectConstants.CREATE_PAGETITLE)
	public WebElement createPriority_pagetitle;
	
	@FindBy(xpath = ProjectConstants.PRIORITY_TXTBOX)
	public WebElement priority_txtbox;
	
	@FindBy(xpath = ProjectConstants.DESCR_TXTBOX)
	public WebElement desc_txtbox;
	
	@FindBy(xpath = ProjectConstants.TARGET_DAYS_TXTBOX)
	public WebElement targetdays_txtbox;
	
	@FindBy(xpath = ProjectConstants.TARGET_HOURS_TXTBOX)
	public WebElement targethours_txtbox;
	
	@FindBy(xpath = ProjectConstants.ACTIVE_CHKBX)
	public WebElement active_chkbx;
	
	@FindBy(xpath = ProjectConstants.JOBATTEND_CHKBX)
	public WebElement jobattend_chkbx;

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createprior_btn;
	
	
	
	
	//constructor
	public CreatePriorityPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterPriorityDetailsAndSave(String priority, String description, String activeFlag, String days, String hours, String jobAttFlag) {
		test.log(LogStatus.INFO, "In enterPriorityDetailsAndSave method");
		
//		try{
		priority_txtbox.sendKeys(priority);
		desc_txtbox.sendKeys(description);
		targetdays_txtbox.sendKeys(days);
		targethours_txtbox.sendKeys(hours);
		if(activeFlag.equalsIgnoreCase("Y"))
			active_chkbx.click();

		createprior_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Priority details and save");
//			CreatePriorityPage createPriorityPage = new CreatePriorityPage(driver, wait, test);
//			PageFactory.initElements(driver, createPriorityPage);
//			return createPriorityPage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Priority details and save");
		PrioritiesListPage prioritiesListPage = new PrioritiesListPage(driver, wait, test);
		PageFactory.initElements(driver, prioritiesListPage);
		return prioritiesListPage;
		
		
		
	}

}
