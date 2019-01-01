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

public class EditTradeVariancePage extends BasePage {
	
	@FindBy(xpath = ProjectConstants.VARIANCEPERCENTAGE_TXTBOX)
	public WebElement variancepercentage_txtbox;
	
	@FindBy(xpath = ProjectConstants.ACTIVE_CHKBOX)
	public WebElement active_chkbox;
	
	@FindBy(xpath = ProjectConstants.UPDATETRADEVARIANCE_BTN)
	public WebElement updatetradevariance_btn;

	public EditTradeVariancePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object editTradeVarianceDetailsAndUpdate(String variance) throws InterruptedException {
		
		test.log(LogStatus.INFO, "In editTradeVarianceDetailsAndUpdate method");
		
		try {
		variancepercentage_txtbox.clear();
		variancepercentage_txtbox.sendKeys(variance);
		updatetradevariance_btn.click();
		
		//validate if trade variance update is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
		}catch(Throwable t) {
			test.log(LogStatus.INFO, "Unable to edit Trade variance");
			EditTradeVariancePage editTradeVariancePage = new EditTradeVariancePage(driver, wait, test);
			PageFactory.initElements(driver, editTradeVariancePage);
			return editTradeVariancePage;
		}
		test.log(LogStatus.INFO, "Trade variance edited successfully");
		ContractorVarianceListPage contractorVarianceListPage = new ContractorVarianceListPage(driver, wait, test);
		PageFactory.initElements(driver, contractorVarianceListPage);
		return contractorVarianceListPage;
	}

}