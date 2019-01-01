package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.systemoptions;

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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.CreatePriorityPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.PrioritiesListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class SystemOptionsListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createSysOption_btn;
	
	@FindBy(xpath = ProjectConstants.OPTION_SEARCH_TXTBOX)
	public WebElement option_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITSYSOPTION_ICON)
	public WebElement editsysoption_icon;
	
	
	@FindBy(xpath = ProjectConstants.DELETESYSOPTION_ICON)
	public WebElement deleteSysOption_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement create_btn;
	
	//constructor
	public SystemOptionsListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateSystemOptionsPage(){
		
		test.log(LogStatus.INFO, "In goToCreateSystemOptionsPage method");
		try{
			createSysOption_btn.click();
		//validate if click on Create System Options button is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATESYSOPTIONS_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create System Options page");
			SystemOptionsListPage prioritiesListPage = new SystemOptionsListPage(driver, wait, test);
			PageFactory.initElements(driver, prioritiesListPage);
			return prioritiesListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create System Options page");
		CreateSystemOptionsPage createSystemOptionsPage = new CreateSystemOptionsPage(driver, wait, test);
		PageFactory.initElements(driver, createSystemOptionsPage);
		return createSystemOptionsPage;
	
	}
	
	public Object searchAndClickOnEdit(String option) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPTION_SEARCH_TXTBOX)));
			option_search_txtbox.sendKeys(option);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITSYSOPTION_ICON)));
			editsysoption_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified System Option");
			SystemOptionsListPage systemOptionsListPage = new SystemOptionsListPage(driver, wait, test);
			PageFactory.initElements(driver, systemOptionsListPage);
			return systemOptionsListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified System Option");
		EditSystemOptionsPage editSystemOptionsPage = new EditSystemOptionsPage(driver, wait, test);
		PageFactory.initElements(driver, editSystemOptionsPage);
		return editSystemOptionsPage;
		
	}



	public Object searchAndDeleteSystemOption(String option) {
		test.log(LogStatus.INFO, "In searchAndDeleteSystemOption method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPTION_SEARCH_TXTBOX)));
			option_search_txtbox.sendKeys(option);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETESYSOPTION_ICON)));
			//contract_search_result.click();
			deleteSysOption_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and delete specified system option");
			SystemOptionsListPage systemOptionsListPage = new SystemOptionsListPage(driver, wait, test);
			PageFactory.initElements(driver, systemOptionsListPage);
			return systemOptionsListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified system option");
		return null;	}

	}

	


