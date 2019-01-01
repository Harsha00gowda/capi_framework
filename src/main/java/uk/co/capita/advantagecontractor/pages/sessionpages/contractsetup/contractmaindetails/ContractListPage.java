package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails;

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
import uk.co.capita.advantagecontractor.pages.LaunchPage;
import uk.co.capita.advantagecontractor.pages.LoginPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.LandingPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class ContractListPage extends BasePage {

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createContract_button;
	
	@FindBy(xpath = ProjectConstants.CONTRACT_SEARCH_TXTBOX)
	public WebElement contract_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.CONTRACT_SEARCH_RESULT)
	public WebElement contract_search_result;
	
	@FindBy(xpath = ProjectConstants.EDITCONTRACT_ICON)
	public WebElement editContract_icon;
	
	@FindBy(xpath = ProjectConstants.DELETECONTRACT_ICON)
	public WebElement deleteContract_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	//constructor
	public ContractListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}


	public Object goToCreateContractPage(){
		test.log(LogStatus.INFO, "In goToCreateContractPage method");
		try{
		createContract_button.click();
		//validate if click on Create Contract is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTRACT_TXTBOX)));
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Contract page");
			ContractListPage contractListPage = new ContractListPage(driver, wait, test);
			PageFactory.initElements(driver, contractListPage);
			return contractListPage;
		}
		
		
		test.log(LogStatus.INFO, "Clicked on Create Contract button successfully");
		CreateContractPage createContractPage = new CreateContractPage(driver, wait, test);
		PageFactory.initElements(driver, createContractPage);
		return createContractPage;
			
		
	}

	
	public Object searchAndviewContract(String contract) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndviewContract method");
		try{
			contract_search_txtbox.sendKeys(contract);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTRACT_SEARCH_RESULT)));
			contract_search_result.click();
			
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and view specified Contract");
			ContractListPage contractListPage = new ContractListPage(driver, wait, test);
			PageFactory.initElements(driver, contractListPage);
			return contractListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and view specified Contract");
		ContractDetailsMainPage contractDetailsMainPage = new ContractDetailsMainPage(driver, wait, test);
		PageFactory.initElements(driver, contractDetailsMainPage);
		return contractDetailsMainPage;
		
	}

	
	
	public Object searchAndClickOnEdit(String contract) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			
			contract_search_txtbox.sendKeys(contract);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITCONTRACT_ICON)));
			editContract_icon.click();
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Contract");
			ContractListPage contractListPage = new ContractListPage(driver, wait, test);
			PageFactory.initElements(driver, contractListPage);
			return contractListPage;
			
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Contract");
		EditContractPage editContractPage = new EditContractPage(driver, wait, test);
		PageFactory.initElements(driver, editContractPage);
		return editContractPage;
		
	}


	public Object searchAndDeleteContract(String contract) throws InterruptedException{
		
		test.log(LogStatus.INFO, "In searchAndClickOnDelete method");
		try{
			
			contract_search_txtbox.sendKeys(contract);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETECONTRACT_ICON)));
			deleteContract_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			//the following line can not be used as delete contract is not working.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));

					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and delete specified Contract");
			ContractListPage contractListPage = new ContractListPage(driver, wait, test);
			PageFactory.initElements(driver, contractListPage);
			return contractListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified Contract");
		return null;
	}



















}
