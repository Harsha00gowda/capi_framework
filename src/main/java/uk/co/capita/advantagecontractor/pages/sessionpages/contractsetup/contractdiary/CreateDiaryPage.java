package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractdiary;

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

public class CreateDiaryPage extends BasePage{
	
	@FindBy(xpath = ProjectConstants.CREATE_PAGETITLE)
	public WebElement createDiary_pagetitle;
	
	@FindBy(xpath = ProjectConstants.DIARYSTATUS_DROPDOWN)
	public WebElement diaryStatus_dropdown;
	
	@FindBy(xpath = ProjectConstants.DIARYSTATUS_NML_OPTION)
	public WebElement diaryStatus_nml_option;
	
	@FindBy(xpath = ProjectConstants.DIARYSTATUS_SVR_OPTION)
	public WebElement diaryStatus_svr_option;
	
	@FindBy(xpath = ProjectConstants.DIARYSTATUS_CNF_OPTION)
	public WebElement diaryStatus_cnf_option;
	
	@FindBy(xpath = ProjectConstants.CREATE_BTN)
	public WebElement createDiary_btn;
	
	
	
	
	//constructor
	public CreateDiaryPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterDiaryDetailsAndSave(String diaryStatus, String diaryTxt) {
		test.log(LogStatus.INFO, "In enterDiaryDetailsAndSave method");
		
//		try{
		diaryStatus_dropdown.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DIARYSTATUS_NML_OPTION)));
		if(diaryStatus.equalsIgnoreCase("Normal"))
			diaryStatus_nml_option.click();
		else if(diaryStatus.equalsIgnoreCase("Severe"))
			diaryStatus_svr_option.click();
		else if(diaryStatus.equalsIgnoreCase("Confidential")){
			diaryStatus_cnf_option.click();
			//if we select this option a new field appears to enter password
			//this is not implemented currently
			//to be coded later
		}

		createDiary_btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Diary details and save");
//			CreateDiaryPage createDiaryPage = new CreateDiaryPage(driver, wait, test);
//			PageFactory.initElements(driver, createDiaryPage);
//			return createDiaryPage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Diary details and save");
		DiaryListPage diaryListPage = new DiaryListPage(driver, wait, test);
		PageFactory.initElements(driver, diaryListPage);
		return diaryListPage;
		
		
		
	}

}
