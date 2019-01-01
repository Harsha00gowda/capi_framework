package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractorvariance;

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

public class ContractorVarianceListPage extends BasePage {
	
	@FindBy(xpath = ProjectConstants.CREATETRADEVARIANCE_BTN)
	public WebElement createtradevariance_btn;
	
	@FindBy(xpath = ProjectConstants.CREATETRADEVARIANCE_PAGETITLE)
	public WebElement createtradevariance_pagetitle;
	
	@FindBy(xpath=ProjectConstants.VARIANCETRADESEARCH_TXTBOX)
	public WebElement tradesearch_txtbox;
	
	@FindBy(xpath=ProjectConstants.EDITTRADEVARIANCE_ICON)
	public WebElement edittradevariance_icon;
	
	@FindBy(xpath=ProjectConstants.DELETETRADEVARIANCE_ICON)
	public WebElement deletetradevariance_icon;
	
	@FindBy(xpath=ProjectConstants.YES_BTN)
	public WebElement yes_btn;

	public ContractorVarianceListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateTradeVariancePage() {
		
		test.log(LogStatus.INFO, "In goToContractorVariance Section method");
		
		try {
		//Click on Contractor variance accordion
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATETRADEVARIANCE_BTN)));
		
		//Click on Create trade variance button
		createtradevariance_btn.click();
		
		//validate if click on Contractor variance accordion is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATETRADEVARIANCE_PAGETITLE)));

		}catch(Throwable t) {
		test.log(LogStatus.INFO, "Unable to go to Create trade variance screen");
		
		ContractorVarianceListPage contractorVarianceListPage = new ContractorVarianceListPage(driver, wait, test);
		PageFactory.initElements(driver, contractorVarianceListPage);
		return contractorVarianceListPage;
		}
		
		test.log(LogStatus.INFO, "Able to go to Create Trade variance screen");
		CreateTradeVariancePage createTradeVariancePage = new CreateTradeVariancePage(driver, wait, test);
		PageFactory.initElements(driver, createTradeVariancePage);
		return createTradeVariancePage;
	}
	
	public Object searchAndClickOnEdit(String trade) {
		
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		
		try {
			
		/*	Thread.sleep(10000);
			tradesearch_txtbox.sendKeys(trade);
			Thread.sleep(8000);
			edittradevariance_icon.click();*/
			
	//	tradesearch_txtbox.sendKeys(trade);
		WebElement search = driver.findElement(By.xpath(ProjectConstants.VARIANCETRADESEARCH_TXTBOX));
			search.sendKeys("BR"); 
			
			Thread.sleep(5000);
			
			WebElement editicon = driver.findElement(By.xpath(ProjectConstants.EDITTRADEVARIANCE_ICON));
			editicon.click();
	
		} catch(Throwable t) {
			
		test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Trade variance");
		ContractorVarianceListPage contractorVarianceListPage = new ContractorVarianceListPage(driver, wait, test);
		PageFactory.initElements(driver, contractorVarianceListPage);
		return contractorVarianceListPage;
		
		}
		
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Trade variance");
		EditTradeVariancePage editTradeVariancePage = new EditTradeVariancePage(driver, wait, test);
		PageFactory.initElements(driver, editTradeVariancePage);
		return editTradeVariancePage;
		
	}
	
	public Object searchAndDeleteTradeVariance(String trade) {
		test.log(LogStatus.INFO, "In searchAndDeleteTradeVariance method" );
		
		try {
			Thread.sleep(10000);
			tradesearch_txtbox.sendKeys(trade);
			Thread.sleep(8000);
			//contract_search_result.click();
			deletetradevariance_icon.click();
			Thread.sleep(2000);
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
		
		} catch (Throwable t) {
			
			test.log(LogStatus.INFO, "Unable to search and delete specified Trade variance");
			ContractorVarianceListPage contractorVarianceListPage = new ContractorVarianceListPage(driver, wait, test);
			PageFactory.initElements(driver, contractorVarianceListPage);
			return contractorVarianceListPage;
		}
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified Trade variance");
		return null;
		
	}

}
