package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.operativetrades;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.operatives.OperativesListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class AddOperativeTradePage extends BasePage{

	@FindBy(xpath = ProjectConstants.ADD_OPERATIVETRADE_POPUP_TITLE)
	public WebElement add_Title_Popup;

	@FindBy(xpath = ProjectConstants.OPERATIVE_TRADE_DROPDOWN)
	public WebElement trade_dropdown;

	@FindBy(xpath = ProjectConstants.ADD_TRADE_BUTTON)
	public WebElement addtrade_btn;

	@FindBy(xpath = ProjectConstants.ADD_TRADE_OPTION)
	public WebElement addtrade;

	@FindBy(xpath = ProjectConstants.ADDED_TRADE)
	public WebElement createdTrade;



	//constructor
	public AddOperativeTradePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object addOperativeTradeDetailsAndSave() throws InterruptedException {
		test.log(LogStatus.INFO, "In addOperativeTradeDetailsAndSave method");
//		try{
		String add_title = add_Title_Popup.getText();
		Assert.assertEquals(add_title, "Add Contractor Operative Trade");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERATIVE_TRADE_DROPDOWN)));
		trade_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.LIST)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADD_TRADE_OPTION)));
		addtrade.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADD_TRADE_BUTTON)));
		addtrade_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.ADDED_TRADE)));
		String added_trade = createdTrade.getText();
		Assert.assertEquals(added_trade, "All trades");
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Operative details and save");
//			CreateOperativePage createOperativePage = new CreateOperativePage(driver, wait, test);
//			PageFactory.initElements(driver, createOperativePage);
//			return createOperativePage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Operative details and save");
		OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
		PageFactory.initElements(driver, operativesListPage);
		return operativesListPage;

	}

}
