package uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.displayallcontracts;

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

public class DisplayAllContractsListPage extends BasePage {
	
	@FindBy(xpath = ProjectConstants.CONTRACT_GRID)
	public WebElement contract_gridname;
	
	@FindBy(xpath = ProjectConstants.DESCRIPTION_GRID)
	public WebElement description_gridname;

	public DisplayAllContractsListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
	public Object goToDisplayAllContractsPage() {
		
		test.log(LogStatus.INFO, "In goToDisplayAllContractsPage method");
		try{
	
		//validate if click on priorities bar is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTRACT_GRID)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DESCRIPTION_GRID)));
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Create Priorities page");
			DisplayAllContractsListPage displayAllContractsListPage = new DisplayAllContractsListPage(driver, wait, test);
			PageFactory.initElements(driver, displayAllContractsListPage);
			return displayAllContractsListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Create Priorities page");
		DisplayAllContractsPage displayAllContractsPage = new DisplayAllContractsPage(driver, wait, test);
		PageFactory.initElements(driver, displayAllContractsPage);
		return displayAllContractsPage;
	
	}

}
