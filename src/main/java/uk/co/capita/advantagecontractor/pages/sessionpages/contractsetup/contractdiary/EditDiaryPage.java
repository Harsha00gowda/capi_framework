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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.EditContractPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class EditDiaryPage extends BasePage{

	@FindBy(xpath = ProjectConstants.DAIRYTXT_TXTBOX)
	public WebElement dairyTxt_txtbox;
	
	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateDiary_button;
	
	
	
	//constructor
	public EditDiaryPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editDiaryDetailsAndUpdate(String updatedDiaryTxt) throws InterruptedException{
		
		test.log(LogStatus.INFO, "In editDiaryDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
		dairyTxt_txtbox.clear();	
			
		dairyTxt_txtbox.sendKeys(updatedDiaryTxt);
		updateDiary_button.click();
			
			//validate if Diary update is successful
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
			
			
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit priority");
//				EditDiaryPage editDiaryPage = new EditDiaryPage(driver, wait, test);
//				PageFactory.initElements(driver, editDiaryPage);
//				return editDiaryPage;
//			}
		
		test.log(LogStatus.INFO, "Diary edited successfully");
		DiaryListPage diaryListPage = new DiaryListPage(driver, wait, test);
		PageFactory.initElements(driver, diaryListPage);
		return diaryListPage;
	}
	
	
}
