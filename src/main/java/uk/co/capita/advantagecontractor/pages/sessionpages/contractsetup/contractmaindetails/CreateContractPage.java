package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails;

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
import uk.co.capita.advantagecontractor.pages.LoginPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreateContractPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CONTRACT_TXTBOX)
	public WebElement contract_txtbox;
	
	@FindBy(xpath = ProjectConstants.DESCRIPTION_TXTBOX)
	public WebElement description_txtbox;
	
	@FindBy(xpath = ProjectConstants.INVOICETYPE_DROPDOWN)
	public WebElement invoiceType_dropdown;
	
	@FindBy(xpath = ProjectConstants.INVOICETYPE_OPTION)
	public WebElement invoiceType_option;
	
	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createContract_button;

	//constructor
		public CreateContractPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
			super(driver, wait, test);
		}

		public Object enterContractDetailsAndSave(String contract, String description) throws InterruptedException{
			
			test.log(LogStatus.INFO, "In enterContractDetailsAndSave method");
			//try{
				contract_txtbox.sendKeys(contract);
				description_txtbox.sendKeys(description);
				invoiceType_dropdown.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.INVOICETYPE_OPTION)));
				invoiceType_option.click();
				createContract_button.click();
				
				//validate if Create Contract is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
				
				
//				} catch(Throwable t){
//					test.log(LogStatus.INFO, "Unable to create contract");
//					CreateContractPage createContractPage = new CreateContractPage(driver, wait, test);
//					PageFactory.initElements(driver, createContractPage);
//					return createContractPage;
//				}
			
			test.log(LogStatus.INFO, "Contract created successfully");
			ContractListPage contractListPage = new ContractListPage(driver, wait, test);
			PageFactory.initElements(driver, contractListPage);
			return contractListPage;
			
			
			
			
			
		}




}
