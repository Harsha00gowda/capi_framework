package uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.jobcosting;

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

public class ContractJobCostingListPage extends BasePage {
	
	@FindBy(xpath = ProjectConstants.EDITCONTRACTJOBCOSTING_ICON)
	public WebElement editContractjobcosting_icon;

	public ContractJobCostingListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
public Object goToEditContractCostingPage(){
		
		test.log(LogStatus.INFO, "In goToContractJobCostingAccordion method");
		try{
			editContractjobcosting_icon.click();
		//validate if click on Contract job costing Accordion is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTRACTCOSTING_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Edit contract job costing page");
			ContractJobCostingListPage contractJobCostingListPage = new ContractJobCostingListPage(driver, wait, test);
			PageFactory.initElements(driver, contractJobCostingListPage);
			return contractJobCostingListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Edit contract job costing page");
		ContractJobCostingPage contractJobCostingPage = new ContractJobCostingPage(driver, wait, test);
		PageFactory.initElements(driver, contractJobCostingPage);
		return contractJobCostingPage;
	
	}

}
