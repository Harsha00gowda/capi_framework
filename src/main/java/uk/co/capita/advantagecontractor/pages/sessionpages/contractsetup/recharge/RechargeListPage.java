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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractDetailsMainPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class RechargeListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.ADDCONTRACTRECHARGE_BTN)
	public WebElement addContractRecharge_btn;
	
	@FindBy(xpath = ProjectConstants.RESOURCECODE_SEARCH_TXTBOX)
	public WebElement resourceCode_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITRECHARGE_ICON)
	public WebElement editRecharge_icon;
	
	@FindBy(xpath = ProjectConstants.DELETERECHARGE_ICON)
	public WebElement deleteRecharge_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	//constructor
	public RechargeListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateRechargePage(){
		
		test.log(LogStatus.INFO, "In goToCreateRechargePage method");
		try{
			addContractRecharge_btn.click();
		//validate if click on addContractRecharge_btn is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.RESOURCECODE_TXTBOX)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Recharge page");
			RechargeListPage rechargeListPage = new RechargeListPage(driver, wait, test);
			PageFactory.initElements(driver, rechargeListPage);
			return rechargeListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Recharge page");
		CreateRechargePage createRechargePage = new CreateRechargePage(driver, wait, test);
		PageFactory.initElements(driver, createRechargePage);
		return createRechargePage;
	
	}
	
	public Object searchAndClickOnEdit(String resourceCode) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.RESOURCECODE_SEARCH_TXTBOX)));
			resourceCode_search_txtbox.sendKeys(resourceCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITRECHARGE_ICON)));
			editRecharge_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Recharge");
			RechargeListPage rechargeListPage = new RechargeListPage(driver, wait, test);
			PageFactory.initElements(driver, rechargeListPage);
			return rechargeListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Recharge");
		EditRechargePage editRechargePage = new EditRechargePage(driver, wait, test);
		PageFactory.initElements(driver, editRechargePage);
		return editRechargePage;
		
	}

	public Object searchAndDeleteRecharge(String resourceCode) {
		test.log(LogStatus.INFO, "In searchAndDeleteRecharge method");
		try{
			Thread.sleep(5000);
			resourceCode_search_txtbox.sendKeys(resourceCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETERECHARGE_ICON)));
			deleteRecharge_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and delete specified Recharge");
			RechargeListPage rechargeListPage = new RechargeListPage(driver, wait, test);
			PageFactory.initElements(driver, rechargeListPage);
			return rechargeListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified Recharge");
		return null;	
		}

	

}
