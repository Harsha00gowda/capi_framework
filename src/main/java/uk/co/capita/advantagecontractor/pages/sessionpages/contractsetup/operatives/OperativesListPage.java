package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.operatives;

import org.junit.Assert;
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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractDetailsMainPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.operativetrades.AddOperativeTradePage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.CreatePriorityPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.PrioritiesListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class OperativesListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATEOPERATIVE_BTN)
	public WebElement createOperative_btn;
	
	@FindBy(xpath = ProjectConstants.OPERCODE_SEARCH_TXTBOX)
	public WebElement operativeCode_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITOPERATIVE_ICON)
	public WebElement editOperative_icon;

	@FindBy(xpath = ProjectConstants.DELETEOPERATIVE_ICON)
	public WebElement deleteOperative_icon;
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;

	@FindBy(xpath = ProjectConstants.ADDOPERATIVE_BUTTON)
	public WebElement add_trade_button;

	@FindBy(css = ProjectConstants.TRADE_DESCRIPTION_SEARCH)
	public WebElement description_search;

	@FindBy(xpath = ProjectConstants.TRADE_DELETE_ICON)
	public WebElement trade_delete;

	@FindBy(xpath = ProjectConstants.NO_RECORD_TEXT)
	public WebElement norecord_txt;

	@FindBy(xpath = ProjectConstants.DELETE_POPUP)
	public WebElement delete_message;


	
	
	//constructor
	public OperativesListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}
	
	public Object goToCreateOperativePage(){
		
		test.log(LogStatus.INFO, "In goToCreateOperativePage method");
		//try{
			createOperative_btn.click();
		//validate if click on createOperative_btn is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEOPERATIVE_PAGETITLE)));
				
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to go to Create Operative page");
//			OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
//			PageFactory.initElements(driver, operativesListPage);
//			return operativesListPage;
//		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Operative page");
		CreateOperativePage createOperativePage = new CreateOperativePage(driver, wait, test);
		PageFactory.initElements(driver, createOperativePage);
		return createOperativePage;
	
	}
	
	public Object searchAndClickOnEdit(String operativeCode) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERCODE_SEARCH_TXTBOX)));
			operativeCode_search_txtbox.sendKeys(operativeCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITOPERATIVE_ICON)));
			editOperative_icon.click();
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Operative");
//			OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
//			PageFactory.initElements(driver, operativesListPage);
//			return operativesListPage;
//			
//		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Operative");
		EditOperativePage editOperativePage = new EditOperativePage(driver, wait, test);
		PageFactory.initElements(driver, editOperativePage);
		return editOperativePage;
		
	}



	public Object searchAndDeleteOperative(String operativeCode) throws InterruptedException {
		test.log(LogStatus.INFO, "In searchAndDeleteOperative method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERCODE_SEARCH_TXTBOX)));
			operativeCode_search_txtbox.sendKeys(operativeCode);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETEOPERATIVE_ICON)));

			deleteOperative_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to search and delete specified Operative");
//			OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
//			PageFactory.initElements(driver, operativesListPage);
//			return operativesListPage;
//			
//		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified Operative");
		return null;	}

	public Object goToAddOperativeTradePage(){
		test.log(LogStatus.INFO, "In goToCreateOperativeTradePage method");
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1200);");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATED_OPERATIVENAME)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERATIVETRADE_TITLE)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADDOPERATIVE_BUTTON)));
		add_trade_button.click();
		//validate if click on add_trade_button is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADD_OPERATIVETRADE_POPUP_TITLE)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to go to Create Operative page");
//			OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
//			PageFactory.initElements(driver, operativesListPage);
//			return operativesListPage;
//		}


		test.log(LogStatus.INFO, "Able to go to Create Operative page");
		AddOperativeTradePage addOperativeTradePage = new AddOperativeTradePage(driver, wait, test);
		PageFactory.initElements(driver, addOperativeTradePage);
		return addOperativeTradePage;

	}

	public Object searchAndDeleteOperativeTrade(String tradeDescription) throws InterruptedException {
		test.log(LogStatus.INFO, "In searchAndDeleteOperativeTrade method");
		//try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1200);");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.TRADE_DESCRIPTION_SEARCH)));
		description_search.sendKeys(tradeDescription);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.TRADE_DELETE_ICON)));
		trade_delete.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_POPUP)));
		String deletePopup = delete_message.getText();
		Assert.assertEquals(deletePopup,"Are you sure you want to delete the record from the system?\n" +
				"Select YES to delete or NO to cancel\n" + "Yes\n" + "No");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
		yes_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.NO_RECORD_TEXT)));
		String recordText = norecord_txt.getText();
		Assert.assertEquals(recordText, "No record found");
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to search and delete specified Operative");
//			OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
//			PageFactory.initElements(driver, operativesListPage);
//			return operativesListPage;
//		}
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search the specified Operative Trade to delete");
		return null;	}

	}

	


