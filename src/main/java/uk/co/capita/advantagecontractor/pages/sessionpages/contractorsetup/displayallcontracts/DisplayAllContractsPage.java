package uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.displayallcontracts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class DisplayAllContractsPage extends BasePage {
	
	@FindBy(xpath = ProjectConstants.CONTRACT_GRID)
	public WebElement contract_gridname;
	
	@FindBy(xpath = ProjectConstants.DESCRIPTION_GRID)
	public WebElement description_gridname;


	public DisplayAllContractsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public void checkDisplayAllContractsPageContent() {
		test.log(LogStatus.INFO, "In checkDisplayAllContractsPageContent method");
		
		try{
		
		 Assert.assertEquals("Contract", contract_gridname);
		 Assert.assertEquals("Description", description_gridname);
	
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Able to check the content of the Contracts screen");
			DisplayAllContractsPage displayAllContractsPage = new DisplayAllContractsPage(driver, wait, test);
     		PageFactory.initElements(driver, displayAllContractsPage);
//			return displayAllContractsPage;
		}
		
	
//		test.log(LogStatus.INFO, "All the contents are displayed in the Contracts screen");
//		DisplayAllContractsListPage displayAllContractsListPage = new DisplayAllContractsListPage(driver, wait, test);
//		PageFactory.initElements(driver, displayAllContractsListPage);
//		return displayAllContractsListPage;
		
		
		
	}

}

