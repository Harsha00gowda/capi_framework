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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractDetailsMainPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class AutoPIValueBandsListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createAutoPIValBand_btn;
	
	@FindBy(xpath = ProjectConstants.PRIORITY_SEARCH_TXTBOX)
	public WebElement priority_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITAUTOPI_ICON)
	public WebElement editAutoPI_icon;
	
	@FindBy(xpath = ProjectConstants.DELETEAUTOPI_ICON)
	public WebElement deleteAutoPI_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	//constructor
	public AutoPIValueBandsListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateAutoPIValueBandPage(){
		
		test.log(LogStatus.INFO, "In goToCreateAutoPIValueBandPage method");
		try{
			createAutoPIValBand_btn.click();
		//validate if click on priorities bar is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Auto PI Value Bands page");
			AutoPIValueBandsListPage autoPIValueBandsListPage = new AutoPIValueBandsListPage(driver, wait, test);
			PageFactory.initElements(driver, autoPIValueBandsListPage);
			return autoPIValueBandsListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Auto PI Value Bands page");
		CreateAutoPIValueBandsPage createAutoPIValueBands = new CreateAutoPIValueBandsPage(driver, wait, test);
		PageFactory.initElements(driver, createAutoPIValueBands);
		return createAutoPIValueBands;
	
	}
	
	public Object clickOnEdit() throws InterruptedException{
		test.log(LogStatus.INFO, "In clickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITAUTOPI_ICON)));
			editAutoPI_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to click on edit icon of specified Auto PI value Band");
			AutoPIValueBandsListPage autoPIValueBandsListPage = new AutoPIValueBandsListPage(driver, wait, test);
			PageFactory.initElements(driver, autoPIValueBandsListPage);
			return autoPIValueBandsListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Auto PI value Band");
		EditAutoPIValueBandPage editAutoPIValueBandPage = new EditAutoPIValueBandPage(driver, wait, test);
		PageFactory.initElements(driver, editAutoPIValueBandPage);
		return editAutoPIValueBandPage;
		
	}

	public Object deleteAutoPIVal() {
		test.log(LogStatus.INFO, "In deleteAutoPIVal method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETEAUTOPI_ICON)));

			deleteAutoPI_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to delete specified auto pi value band");
			AutoPIValueBandsListPage autoPIValueBandsListPage = new AutoPIValueBandsListPage(driver, wait, test);
			PageFactory.initElements(driver, autoPIValueBandsListPage);
			return autoPIValueBandsListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to delete specified auto pi value band");
		return null;	
		}



	

}
