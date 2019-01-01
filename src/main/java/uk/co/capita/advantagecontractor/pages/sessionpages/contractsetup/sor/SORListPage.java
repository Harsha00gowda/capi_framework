package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sor;

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

public class SORListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createSOR_btn;
	
	@FindBy(xpath = ProjectConstants.SORCODE_SEARCH_TXTBOX)
	public WebElement sorCode_search_txtbox;
	
	@FindBy(xpath = ProjectConstants.EDITSOR_ICON)
	public WebElement editSOR_icon;
	
	@FindBy(xpath = ProjectConstants.DELETESOR_ICON)
	public WebElement deleteSOR_icon;
	
	@FindBy(xpath = ProjectConstants.DESCR_SEARCH_TXTBOX)
	public WebElement description_search_txtbox;
	
	
	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;
	
	//constructor
	public SORListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateSORPage(){
		
		test.log(LogStatus.INFO, "In goToCreateSORPage method");
		try{
			createSOR_btn.click();
		//validate if click on Create SOR bar is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATESOR_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create SOR page");
			SORListPage sorListPage = new SORListPage(driver, wait, test);
			PageFactory.initElements(driver, sorListPage);
			return sorListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create SOR page");
		CreateSORPage createSORPage = new CreateSORPage(driver, wait, test);
		PageFactory.initElements(driver, createSORPage);
		return createSORPage;
	
	}
	
	public Object searchAndClickOnEdit(String description) throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
//		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SORCODE_SEARCH_TXTBOX)));
			description_search_txtbox.sendKeys(description);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITSOR_ICON)));
			Thread.sleep(4000);
			editSOR_icon.click();


	
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified SOR");
//			SORListPage sorListPage = new SORListPage(driver, wait, test);
//			PageFactory.initElements(driver, sorListPage);
//			return sorListPage;
			
//		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified SOR");
		EditSORPage editSORPage = new EditSORPage(driver, wait, test);
		PageFactory.initElements(driver, editSORPage);
		return editSORPage;
		
	}

	public Object searchAndDeleteSOR(String description) throws InterruptedException {
		test.log(LogStatus.INFO, "In searchAndDeleteSOR method");
//		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SORCODE_SEARCH_TXTBOX)));
			description_search_txtbox.sendKeys(description);
			Thread.sleep(4000);
			deleteSOR_icon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));

			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
					
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to search and delete specified SOR");
//			SORListPage sorListPage = new SORListPage(driver, wait, test);
//			PageFactory.initElements(driver, sorListPage);
//			return sorListPage;
//			
//		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified SOR");
		return null;	
		}

	

}
