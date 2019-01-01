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

public class CreateSORSkillSetPage extends BasePage {

    @FindBy(xpath = ProjectConstants.CREATESORSKILLSET_PAGETITLE)
    public WebElement skillset_header;

    @FindBy(xpath = ProjectConstants.DIARYSTATUS_DROPDOWN)
    public WebElement skill_dropdownfield;

    @FindBy(xpath = ProjectConstants.SKILL_SELECT)
    public WebElement select_skilloption;

    @FindBy(xpath = ProjectConstants.CREATE_BTN)
    public WebElement createSkillSet_btn;

    @FindBy(xpath = ProjectConstants.CREATEDSKILL_TXT)
    public WebElement createdSkill_text;

    public CreateSORSkillSetPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
        super(driver, wait, test);
    }

    public Object enterSkillSetDetailsAndSave(String Skill) throws InterruptedException {
        test.log(LogStatus.INFO, "In enterSkillSetDetailsAndSave method");
//		try{
        String titleText = skillset_header.getText();
        Assert.assertEquals(titleText, "Create SOR skill set");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.DIARYSTATUS_DROPDOWN)));
        skill_dropdownfield.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.LIST)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SKILL_SELECT)));
        select_skilloption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_BTN)));
        createSkillSet_btn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDSKILL_TXT)));
        String createdText = createdSkill_text.getText();
        Assert.assertEquals(createdText, Skill);
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Able to enter Certificates details and save");
//			CreateSystemOptionsPage createSystemOptionsPage = new CreateSystemOptionsPage(driver, wait, test);
//			PageFactory.initElements(driver, createSystemOptionsPage);
//			return createSystemOptionsPage;
//		}

        test.log(LogStatus.INFO, "Able to enter Certificates details and save");
        SORSkillSetListPage sorSkillSetListPage = new SORSkillSetListPage(driver, wait, test);
        PageFactory.initElements(driver, sorSkillSetListPage);
        return sorSkillSetListPage;



    }
}
