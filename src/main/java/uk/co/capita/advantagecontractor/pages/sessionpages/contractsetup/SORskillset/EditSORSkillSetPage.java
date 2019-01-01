package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sorskillset;

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

public class EditSORSkillSetPage extends BasePage{

	@FindBy(xpath = ProjectConstants.CERTIFICATEDISCRIPTION_TXTBOX)
	public WebElement descr_txtbox;

	@FindBy(xpath = ProjectConstants.UPDATE_BTN)
	public WebElement updateSkillSet_button;

	@FindBy(xpath = ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)
	public WebElement updatedDescription_text;

	@FindBy(xpath = ProjectConstants.EDITSKILLSET_HEADER)
	public WebElement edit_header;

	@FindBy(xpath = ProjectConstants.SKILLSET_EFFECTIVEDATE)
	public WebElement effective_date;



	//constructor
	public EditSORSkillSetPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object editSkillSetDetailsAndUpdate(String Skill) throws InterruptedException{
		test.log(LogStatus.INFO, "In editSkillSetDetailsAndUpdate method");
		//try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.EDITSKILLSET_HEADER)));
		String header = edit_header.getText();
		Assert.assertEquals(header, "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SKILLSET_EFFECTIVEDATE)));
		effective_date.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_BTN)));
		updateSkillSet_button.click();
			                    //validate if skill set update is successful
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.UPDATE_SUCCESS_MSG)));
//			} catch(Throwable t){
//				test.log(LogStatus.INFO, "Unable to edit priority");
//				EditPriorityPage editPriorityPage = new EditPriorityPage(driver, wait, test);
//				PageFactory.initElements(driver, editPriorityPage);
//				return editPriorityPage;
//			}
		test.log(LogStatus.INFO, "Skill Set edited successfully");
		SORSkillSetListPage sorSkillSetListPage = new SORSkillSetListPage(driver, wait, test);
		PageFactory.initElements(driver, sorSkillSetListPage);
		return sorSkillSetListPage;
	}
	
	
}
