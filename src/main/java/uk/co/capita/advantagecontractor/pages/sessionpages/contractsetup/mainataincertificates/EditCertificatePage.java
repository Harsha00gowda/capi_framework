package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.mainataincertificates;

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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.PrioritiesListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class EditCertificatePage extends BasePage{

	@FindBy(xpath = ProjectConstants.CERTIFICATEDISCRIPTION_TXTBOX)
	public WebElement descr_txtbox;

	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateCertificates_button;

	@FindBy(xpath = ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)
	public WebElement updatedDescription_text;



	//constructor
	public EditCertificatePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editCertificatesDetailsAndUpdate(String UpdatedDescription) throws InterruptedException{
		test.log(LogStatus.INFO, "In editCertificatesDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CERTIFICATEDISCRIPTION_TXTBOX)));
		descr_txtbox.clear();
		descr_txtbox.sendKeys(UpdatedDescription);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_BTN)));
		updateCertificates_button.click();
			                    //validate if priority update is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)));
//		String updatedText = updatedDescription_text.getText();
//		Assert.assertEquals(updatedText, UpdatedDescription);
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit priority");
//				EditPriorityPage editPriorityPage = new EditPriorityPage(driver, wait, test);
//				PageFactory.initElements(driver, editPriorityPage);
//				return editPriorityPage;
//			}
		test.log(LogStatus.INFO, "Certificate edited successfully");
		MaintainCertificatesListPage certificatesListPage = new MaintainCertificatesListPage(driver, wait, test);
		PageFactory.initElements(driver, certificatesListPage);
		return certificatesListPage;
	}
	
	
}
