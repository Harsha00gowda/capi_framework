package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.jobtypes;

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

public class CreateJobTypePage extends BasePage{

	
	@FindBy(xpath = ProjectConstants.JOBTYPE_DROPDOWN)
	public WebElement jobType_dropdown;
	
	@FindBy(xpath = ProjectConstants.JOBTYPESEARCH_TXTBOX)
	public WebElement jobTypeSearch_txtBox;
	
	@FindBy(xpath = ProjectConstants.OPTION_JPBTYPE)
	public WebElement option_jobType;
	
	@FindBy(xpath = ProjectConstants.EFFDATE_TXTBOX)
	public WebElement effDate_txtBox;
	
	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement creatjobType_btn;

	
	
	
	
	
	//constructor
	public CreateJobTypePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterJobTypeDetailsAndSave(String jobType, String effectiveDate) throws InterruptedException {
		test.log(LogStatus.INFO, "In enterJobTypeDetailsAndSave method");
		
//		try{
		jobType_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.JOBTYPESEARCH_TXTBOX)));
		jobTypeSearch_txtBox.sendKeys(jobType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPTION_JPBTYPE)));
		option_jobType.click();
		effDate_txtBox.sendKeys(effectiveDate);
		creatjobType_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Job Type details and save");
//			CreateJobTypePage createJobTypePage = new CreateJobTypePage(driver, wait, test);
//			PageFactory.initElements(driver, createJobTypePage);
//			return createJobTypePage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Job type details and save");
		JobTypesListPage jobTypesListPage = new JobTypesListPage(driver, wait, test);
		PageFactory.initElements(driver, jobTypesListPage);
		return jobTypesListPage;
		
		
		
	}

}
