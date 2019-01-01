package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contactdetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class EditContactPage extends BasePage{

	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateContact_button;

	@FindBy(xpath = ProjectConstants.CONTACTNAME)
	public WebElement updated_contactname;

	@FindBy(xpath = ProjectConstants.EDITPOPUP_TITLE)
	public WebElement editpopup;

	@FindBy(xpath = ProjectConstants.CONTACTNAME_TXT)
	public WebElement contactname;

	//constructor
	public EditContactPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editContactDetailsAndUpdate(String UpdatedContactName) throws InterruptedException{
		test.log(LogStatus.INFO, "In editContactDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITPOPUP_TITLE)));
		String headerTitle = editpopup.getText();
		Assert.assertEquals(headerTitle, "Edit Contact");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTNAME_TXT)));
		contactname.clear();
		contactname.sendKeys(UpdatedContactName);
		editpopup.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 500);");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_BTN)));
		updateContact_button.click();
			                    //validate if contact update is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTNAME)));
		String updatedText = updated_contactname.getText();
		Assert.assertEquals(updatedText, UpdatedContactName);
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit priority");
//				EditPriorityPage editPriorityPage = new EditPriorityPage(driver, wait, test);
//				PageFactory.initElements(driver, editPriorityPage);
//				return editPriorityPage;
//			}
		test.log(LogStatus.INFO, "Contact edited successfully");
		ContactDetailsListPage contactDetailsListPage = new ContactDetailsListPage(driver, wait, test);
		PageFactory.initElements(driver, contactDetailsListPage);
		return contactDetailsListPage;
	}
	
	
}
