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

public class CreateTradeVariancePage extends BasePage {
	
	@FindBy(xpath = ProjectConstants.TRADE_DROPDOWN1)
	public WebElement trade_dropdown;
	
	@FindBy(xpath = ProjectConstants.TRADE_SELECTLIST)
	public WebElement trade_selectlist;
	
	@FindBy(xpath = ProjectConstants.EFFECTIVEDATE_FIELD)
	public WebElement effectivedate_field;
	
	@FindBy(xpath = ProjectConstants.EFFECTIVEDATE_SELECT)
	public WebElement effectivedate_select;
	
	@FindBy(xpath = ProjectConstants.CREATETRADEVARIANCE_BTN)
	public WebElement createtradevariance_btn;

	public CreateTradeVariancePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object enterTradeVarianceDetailsAndSave() throws InterruptedException {
		
		test.log(LogStatus.INFO, "In enterTradeVarianceDetailsAndSave method");
		
		try {
		//Select trade from the dropdown list
		trade_dropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ProjectConstants.TRADE_SELECTLIST)));
		trade_selectlist.click();
		
		//Select effective date
		effectivedate_field.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ProjectConstants.EFFECTIVEDATE_SELECT)));
		//Thread.sleep(5000);
		effectivedate_select.click();
		
		//Click on create button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ProjectConstants.CREATETRADEVARIANCE_BTN)));
		createtradevariance_btn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
		}catch(Throwable t) {
			test.log(LogStatus.INFO, "Unable to enter Trade variance details and save");
			CreateTradeVariancePage createTradeVariancePage = new CreateTradeVariancePage(driver, wait, test);
			PageFactory.initElements(driver, createTradeVariancePage);
			return createTradeVariancePage;
		}
		test.log(LogStatus.INFO, "Able to enter Trade variance details and save");
		ContractorVarianceListPage contractorVarianceListPage = new ContractorVarianceListPage(driver, wait, test);
		PageFactory.initElements(driver, contractorVarianceListPage);
		return contractorVarianceListPage;
	}

}
