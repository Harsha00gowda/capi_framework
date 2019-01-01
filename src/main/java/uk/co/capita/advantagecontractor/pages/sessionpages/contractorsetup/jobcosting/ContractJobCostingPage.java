package uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.jobcosting;

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

public class ContractJobCostingPage extends BasePage{
	
	@FindBy(xpath = ProjectConstants.CONTRACTCOSTING_PAGETITLE)
	public WebElement contractJobCosting_pagetitle;
	
	@FindBy(xpath = ProjectConstants.COSTINGLEVELJOB_RADIOBTN)
	public WebElement costingLevelJob_radiobtn;

	@FindBy(xpath = ProjectConstants.SMV_RADIOBTN)
	public WebElement smv_radiobtn;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BUTTON)
	public WebElement update_btn;
	
	public ContractJobCostingPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object enterContractJobCostingDetailsAndUpdate() throws InterruptedException {
		test.log(LogStatus.INFO, "In enterContractJobCosting Details And Update method");
		
//		try{
		costingLevelJob_radiobtn.click();
		smv_radiobtn.click();
		update_btn.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Able to enter Priority details and save");
//				CreatePriorityPage createPriorityPage = new CreatePriorityPage(driver, wait, test);
//				PageFactory.initElements(driver, createPriorityPage);
//				return createPriorityPage;
//			}
		
			test.log(LogStatus.INFO, "Able to enter Contract job costing details and save");
			ContractJobCostingListPage contractJobCostingListPage = new ContractJobCostingListPage(driver, wait, test);
			PageFactory.initElements(driver, contractJobCostingListPage);
			return contractJobCostingListPage;
		
	
		}

}
