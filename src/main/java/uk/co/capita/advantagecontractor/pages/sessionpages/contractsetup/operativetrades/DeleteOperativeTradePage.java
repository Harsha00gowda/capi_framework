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

public class DeleteOperativeTradePage extends BasePage{

	@FindBy(xpath = ProjectConstants.NO_RECORD_TEXT)
	public WebElement norecord_txt;

	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;

	@FindBy(xpath = ProjectConstants.DELETE_POPUP)
	public WebElement delete_message;

	//constructor
	public DeleteOperativeTradePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object deleteOperativeTrade() throws InterruptedException {
		test.log(LogStatus.INFO, "In deleteOperativeTrade method");
		//try{
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
		//} catch(Throwable t){
		//	test.log(LogStatus.INFO, "Unable to delete Operative trade details");
		//	DeleteOperativeTradePage deleteOperativeTradePage = new DeleteOperativeTradePage(driver, wait, test);
		//	PageFactory.initElements(driver, deleteOperativeTradePage);
		//	return deleteOperativeTradePage;
		//}
	
		test.log(LogStatus.INFO, "Able to delete Operative trade details");
		OperativesListPage operativesListPage = new OperativesListPage(driver, wait, test);
		PageFactory.initElements(driver, operativesListPage);
		return operativesListPage;

	}

}
