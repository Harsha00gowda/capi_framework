package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.systemoptions;

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

public class CreateSystemOptionsPage extends BasePage{
	
	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createprior_btn;
	
	@FindBy(xpath = ProjectConstants.OPTION_DROPDOWN)
	public WebElement option_dropdown;
	
	@FindBy(xpath = ProjectConstants.OPTION_ACTUALCOSTS)
	public WebElement option_actualcosts;
	
	@FindBy(xpath = ProjectConstants.VALUE_DROPDOWN)
	public WebElement value_dropdown;
	
	@FindBy(xpath = ProjectConstants.VALUE_Y)
	public WebElement value_y;
	
	
	
	
	
	//constructor
	public CreateSystemOptionsPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterSystemOptionsDetailsAndSave(String option, String value) throws InterruptedException {
		test.log(LogStatus.INFO, "In enterSystemOptionsDetailsAndSave method");
		
//		try{
		option_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPTION_ACTUALCOSTS)));
		option_actualcosts.click();
		
		value_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.VALUE_Y)));
		value_y.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ProjectConstants.CREATE_BTN)));

		createprior_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter System Option details and save");
//			CreateSystemOptionsPage createSystemOptionsPage = new CreateSystemOptionsPage(driver, wait, test);
//			PageFactory.initElements(driver, createSystemOptionsPage);
//			return createSystemOptionsPage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter System Option details and save");
		SystemOptionsListPage systemOptionsListPage = new SystemOptionsListPage(driver, wait, test);
		PageFactory.initElements(driver, systemOptionsListPage);
		return systemOptionsListPage;
		
		
		
	}

}
