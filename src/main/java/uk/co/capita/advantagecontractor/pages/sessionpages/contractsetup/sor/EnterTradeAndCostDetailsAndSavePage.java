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

public class EnterTradeAndCostDetailsAndSavePage extends BasePage{

	@FindBy(xpath = ProjectConstants.ADDTRADE_BTN)
	public WebElement addTrade_btn;
	
	@FindBy(xpath = ProjectConstants.ADD_BTN)
	public WebElement add_btn;	
	
	@FindBy(xpath = ProjectConstants.TRADE_DROPDOWN)
	public WebElement trade_dropdown;
	
	@FindBy(xpath = ProjectConstants.TRADE_OPTION)
	public WebElement trade_option;
	
	@FindBy(xpath = ProjectConstants.ADDCOST_BTN)
	public WebElement addCost_btn;
	
	@FindBy(xpath = ProjectConstants.CREATECOST_BTN)
	public WebElement createCost_btn;
	
	@FindBy(xpath = ProjectConstants.COSTCODE_DROPDOWN)
	public WebElement costCode_dropdown;
	
	@FindBy(xpath = ProjectConstants.COSTCODE_OPTION)
	public WebElement costCode_option;
	
	
	
	
	//constructor
	public EnterTradeAndCostDetailsAndSavePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}

	public Object enterTradeAndCostDetailsAndSave() {
		test.log(LogStatus.INFO, "In enterTradeAndCostDetailsAndSave method");
//		try{
			addTrade_btn.click();
		//validate if click on Add Trade button is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADD_BTN)));
		//Enter Trade details and Add	
			trade_dropdown.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.TRADE_OPTION)));
			trade_option.click();
			add_btn.click();
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Trade Details and Save");
//			EnterTradeAndCostDetailsAndSavePage enterTradeAndCostDetailsAndSavePage = new EnterTradeAndCostDetailsAndSavePage(driver, wait, test);
//			PageFactory.initElements(driver, enterTradeAndCostDetailsAndSavePage);
//			return enterTradeAndCostDetailsAndSavePage;
//		}		
			
//			try{
			addCost_btn.click();
			//validate if click on Add Cost button is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATECOST_BTN)));
			costCode_dropdown.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.COSTCODE_OPTION)));
			costCode_option.click();
			createCost_btn.click();
//			} 	catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Cost Details and Save");
//			EnterTradeAndCostDetailsAndSavePage enterTradeAndCostDetailsAndSavePage = new EnterTradeAndCostDetailsAndSavePage(driver, wait, test);
//			PageFactory.initElements(driver, enterTradeAndCostDetailsAndSavePage);
//			return enterTradeAndCostDetailsAndSavePage;
//		}
		
		
		test.log(LogStatus.INFO, "Able to enter Trade and Cost Details and save");
		SORListPage sorListPage = new SORListPage(driver, wait, test);
		PageFactory.initElements(driver, sorListPage);
		return sorListPage;
	}

}
