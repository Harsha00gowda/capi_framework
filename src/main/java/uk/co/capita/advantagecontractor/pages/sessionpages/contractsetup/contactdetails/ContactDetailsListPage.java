package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contactdetails;

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
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class ContactDetailsListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createContact_btn;

	@FindBy(xpath = ProjectConstants.DELETE_ICON)
	public WebElement contact_deleteicon;

	@FindBy(xpath = ProjectConstants.CONTACTUPDATE_ICON)
	public WebElement contactupdate_icon;

	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;

	@FindBy(xpath = ProjectConstants.NO_RECORD_TEXT)
	public WebElement norecord_txt;

	@FindBy(xpath = ProjectConstants.DELETE_POPUP)
	public WebElement delete_message;


	//constructor
	public ContactDetailsListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateContactDetailsPage(){
		test.log(LogStatus.INFO, "In goToCreateContactDetailsPage method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTDETAILS_HEADER)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_BTN)));
			createContact_btn.click();
		//validate if click on Contact bar is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATECONTACT_PAGETITLE)));
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Contact page");
			ContactDetailsListPage contactDetailsListPage = new ContactDetailsListPage(driver, wait, test);
			PageFactory.initElements(driver, contactDetailsListPage);
			return contactDetailsListPage;
		}
		test.log(LogStatus.INFO, "Able to go to Create Contacts page");
		CreateContactPage createContactPage = new CreateContactPage(driver, wait, test);
		PageFactory.initElements(driver, createContactPage);
		return createContactPage;
	}
	
	public Object searchAndClickOnEdit() throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTNAME)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTUPDATE_ICON)));
			contactupdate_icon.click();
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified Contact");
			ContactDetailsListPage certificatesListPage = new ContactDetailsListPage(driver, wait, test);
			PageFactory.initElements(driver, certificatesListPage);
			return certificatesListPage;
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Contact");
		EditContactPage editContactPage = new EditContactPage(driver, wait, test);
		PageFactory.initElements(driver, editContactPage);
		return editContactPage;
		
	}


	public Object deleteSelectedContact() {
		test.log(LogStatus.INFO, "In deleteSelectedContact method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTDETAILS_HEADER)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_ICON)));
			contact_deleteicon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_POPUP)));
			String deletePopup = delete_message.getText();
			Assert.assertEquals(deletePopup,"Are you sure you want to delete the record from the system?\n" +
					"Select YES to delete or NO to cancel\n" + "Yes\n" + "No");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.YES_BTN)));
			yes_btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_SUCCESS_MSG)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.NO_RECORD_TEXT)));
			String recordText = norecord_txt.getText();
			Assert.assertEquals(recordText, "No records available.");
					
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to delete the selected certificate");
			ContactDetailsListPage certificatesListPage = new ContactDetailsListPage(driver, wait, test);
			PageFactory.initElements(driver, certificatesListPage);
			return certificatesListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified system option");
		return null;	}

	}

	


