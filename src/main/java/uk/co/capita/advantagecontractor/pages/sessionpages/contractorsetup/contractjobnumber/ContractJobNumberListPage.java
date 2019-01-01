package uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.contractjobnumber;

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

public class ContractJobNumberListPage extends BasePage {
	
	@FindBy(xpath = ProjectConstants.EDITCONTRACTJOBNUMBER_ICON)
	public WebElement editContractjobnumber_icon;

	public ContractJobNumberListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		// TODO Auto-generated constructor stub
	}
	
public Object goToEditContractJobNumberPage(){
		
		test.log(LogStatus.INFO, "In goToContractJobNumberAccordion method");
		try{
			editContractjobnumber_icon.click();
		//validate if click on Contract job number Accordion is successful
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTRACTJOBNUMBER_PAGETITLE)));
				
		
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Unable to go to Edit contract job number page");
			ContractJobNumberListPage contractJobNumberListPage = new ContractJobNumberListPage(driver, wait, test);
			PageFactory.initElements(driver, contractJobNumberListPage);
			return contractJobNumberListPage;
		}
		
		
		test.log(LogStatus.INFO, "Able to go to Edit contract job number page");
		ContractJobNumberPage contractJobNumberPage = new ContractJobNumberPage(driver, wait, test);
		PageFactory.initElements(driver, contractJobNumberPage);
		return contractJobNumberPage;
	
	}



}
