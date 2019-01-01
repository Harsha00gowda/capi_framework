package uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.contractjobnumber;

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


public class ContractJobNumberPage extends BasePage{
	
	@FindBy(xpath = ProjectConstants.CONTRACTJOBNUMBER_PAGETITLE)
	public WebElement contractJobNumber_pagetitle;
	
	@FindBy(xpath = ProjectConstants.AUTOMATICPREFIX_TXTBOX)
	public WebElement automaticPrefix_txtbox;
	
	@FindBy(xpath = ProjectConstants.MANUALPREFIX_TXTBOX)
	public WebElement manualPrefix_txtbox;
	
	@FindBy(xpath = ProjectConstants.AUTOMATICSTART_TXTBOX)
	public WebElement automaticStart_txtbox;
	
	@FindBy(xpath = ProjectConstants.AUTOMATICEND_TXTBOX)
	public WebElement automaticEnd_txtbox;
	
	@FindBy(xpath = ProjectConstants.AUTOMATICNEXT_TXTBOX)
	public WebElement automaticNext_txtbox;
	
	@FindBy(xpath = ProjectConstants.MANUALSTART_TXTBOX)
	public WebElement manualStart_txtbox;
	
	@FindBy(xpath = ProjectConstants.MANUALEND_TXTBOX)
	public WebElement manualEnd_txtbox;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BUTTON)
	public WebElement update_btn;
	
	@FindBy(xpath = ProjectConstants.UPDATE_SUCCESS_MSG)
	public WebElement updated_successful_msg;

	public ContractJobNumberPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object enterContractJobNumberDetailsAndUpdate(String AutoPrefix, String Manualprefix, String AutoStart, String AutoEnd, String AutoNext, String ManualStart, String ManualEnd ) throws InterruptedException {
		test.log(LogStatus.INFO, "In enterContractJobNumberDetailsAndUpdate method");
		
//		try{
		automaticPrefix_txtbox.clear();
			automaticPrefix_txtbox.sendKeys(AutoPrefix);
		manualPrefix_txtbox.clear();
			manualPrefix_txtbox.sendKeys(Manualprefix);
		automaticStart_txtbox.clear();
			automaticStart_txtbox.sendKeys(AutoStart);
		automaticEnd_txtbox.clear();
			automaticEnd_txtbox.sendKeys(AutoEnd);
		automaticNext_txtbox.clear();
			automaticNext_txtbox.sendKeys(AutoNext);
		manualStart_txtbox.clear();
			manualStart_txtbox.sendKeys(ManualStart);
		manualEnd_txtbox.clear();
			manualEnd_txtbox.sendKeys(ManualEnd);
		Thread.sleep(5000);
			update_btn.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Able to enter Priority details and save");
//				CreatePriorityPage createPriorityPage = new CreatePriorityPage(driver, wait, test);
//				PageFactory.initElements(driver, createPriorityPage);
//				return createPriorityPage;
//			}
		
			test.log(LogStatus.INFO, "Able to enter Contract job number details and save");
			ContractJobNumberListPage contractJobNumberListPage = new ContractJobNumberListPage(driver, wait, test);
			PageFactory.initElements(driver, contractJobNumberListPage);
			return contractJobNumberListPage;
		
	
}


}
