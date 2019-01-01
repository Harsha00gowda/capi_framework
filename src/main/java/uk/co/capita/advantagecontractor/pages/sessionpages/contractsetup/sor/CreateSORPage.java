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
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreateSORPage extends BasePage{
	
	@FindBy(xpath = ProjectConstants.CREATESOR_PAGETITLE)
	public WebElement createSOR_pagetitle;
	
	@FindBy(xpath = ProjectConstants.SOR_TXTBOX)
	public WebElement sor_txtbox;
	
	@FindBy(xpath = ProjectConstants.DESCR_TXTBOX)
	public WebElement desc_txtbox;
	
	@FindBy(xpath = ProjectConstants.PRIORITY_DROPDOWN)
	public WebElement priority_dropdown;
	
	@FindBy(xpath = ProjectConstants.PRIORITY_OPTION)
	public WebElement priority_option;
	
	@FindBy(xpath = ProjectConstants.DATE_TXTBOX)
	public WebElement date_txtbox;
	
	@FindBy(xpath = ProjectConstants.MTHDOFCHARGE_DROPDOWN)
	public WebElement mthOfCharge_dropdown;
	
	@FindBy(xpath = ProjectConstants.MTHDOFCHARGE_OPTION)
	public WebElement mthOfCharge_option;

	@FindBy(xpath = ProjectConstants.NEXT_BTN)
	public WebElement next_btn;
	
	
	
	
	//constructor
	public CreateSORPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterSORDetailsAndNext(String sor, String description, String priority, String date, String methodOfCharge) throws InterruptedException {
		test.log(LogStatus.INFO, "In enterPriorityDetailsAndSave method");
		
//		try{

		//Add SOR details first
		sor_txtbox.clear();
		sor_txtbox.sendKeys(sor);
		desc_txtbox.sendKeys(description);
		priority_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.PRIORITY_OPTION)));
		priority_option.click();
		date_txtbox.sendKeys(date);
		mthOfCharge_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.MTHDOFCHARGE_OPTION)));
		mthOfCharge_option.click();
		next_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADDTRADE_TITLE)));
		
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter SOR details and click on Next button");
//			CreateSORPage createSORPage = new CreateSORPage(driver, wait, test);
//			PageFactory.initElements(driver, CreateSORPage);
//			return CreateSORPage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Priority details and save");
		EnterTradeAndCostDetailsAndSavePage enterTradeAndCostDetailsAndSavePage = new EnterTradeAndCostDetailsAndSavePage(driver, wait, test);
		PageFactory.initElements(driver, enterTradeAndCostDetailsAndSavePage);
		return enterTradeAndCostDetailsAndSavePage;
		
		
		
	}

}
