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
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class MaintainCertificatesListPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createCertificates_btn;

	@FindBy(xpath = ProjectConstants.OPTION_SEARCH_TXTBOX)
	public WebElement option_search_txtbox;

	@FindBy(xpath = ProjectConstants.UPDATE_ICON)
	public WebElement editCertificate_icon;


	@FindBy(xpath = ProjectConstants.DELETESYSOPTION_ICON)
	public WebElement deleteSysOption_icon;

	@FindBy(xpath = ProjectConstants.YES_BTN)
	public WebElement yes_btn;

	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement create_btn;

	@FindBy(xpath = ProjectConstants.DELETE_ICON)
	public WebElement deleteCertificate_icon;

	@FindBy(xpath = ProjectConstants.NO_RECORD_TEXT)
	public WebElement norecord_txt;

	@FindBy(xpath = ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)
	public WebElement createdDescription_text;

	@FindBy(xpath = ProjectConstants.DELETE_POPUP)
	public WebElement delete_message;

	//constructor
	public MaintainCertificatesListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToCreateMaintainCertificatesPage(){
		
		test.log(LogStatus.INFO, "In goToCreateMaintainCertificatesPage method");
		try{
			createCertificates_btn.click();
		//validate if click on Certifictaes bar is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATECERTIFICATES_PAGETITLE)));
				

		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Certificates page");
			MaintainCertificatesListPage certificatesListPage = new MaintainCertificatesListPage(driver, wait, test);
			PageFactory.initElements(driver, certificatesListPage);
			return certificatesListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Certificates page");
		CreateCertificatePage createCertificates = new CreateCertificatePage(driver, wait, test);
		PageFactory.initElements(driver, createCertificates);
		return createCertificates;
	
	}
	
	public Object searchAndClickOnEdit() throws InterruptedException{
		test.log(LogStatus.INFO, "In searchAndClickOnEdit method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_ICON)));
			editCertificate_icon.click();
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to search and click on edit icon of specified System Option");
			MaintainCertificatesListPage certificatesListPage = new MaintainCertificatesListPage(driver, wait, test);
			PageFactory.initElements(driver, certificatesListPage);
			return certificatesListPage;
		}
		test.log(LogStatus.INFO, "Able to search and click on edit icon of specified Certificates");
		EditCertificatePage editCertificatePage = new EditCertificatePage(driver, wait, test);
		PageFactory.initElements(driver, editCertificatePage);
		return editCertificatePage;
		
	}


	public Object deleteSelectedCertificate() {
		test.log(LogStatus.INFO, "In deleteCertificate method");
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DELETE_ICON)));
			deleteCertificate_icon.click();
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
			MaintainCertificatesListPage certificatesListPage = new MaintainCertificatesListPage(driver, wait, test);
			PageFactory.initElements(driver, certificatesListPage);
			return certificatesListPage;
			
		}
		
		//code to verify delete message should come here
		test.log(LogStatus.INFO, "Able to search and delete specified system option");
		return null;	}

	}

	


