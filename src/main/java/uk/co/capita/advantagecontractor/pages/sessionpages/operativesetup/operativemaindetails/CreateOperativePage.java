package uk.co.capita.advantagecontractor.pages.sessionpages.operativesetup.operativemaindetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreateOperativePage extends BasePage {

    @FindBy(xpath = ProjectConstants.OPERATIVE_CLOCKNUMBER_TXT)
    public WebElement clocknumber_txtbox;

    @FindBy(xpath = ProjectConstants.OPERATIVE_CONTRACTOR_DROPDOWN)
    public WebElement contractor_dropdown;

    @FindBy(xpath = ProjectConstants.SELECT_CONTRACTOR_OPTION)
    public WebElement select_option;

    @FindBy(xpath = ProjectConstants.CREATE_BTN)
    public WebElement operative_createbtn;

    public CreateOperativePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
        super(driver, wait, test);
    }

    public Object enterOperativeDetailsAndSave(String ClockNumber) throws InterruptedException{
        test.log(LogStatus.INFO, "In enterContractDetailsAndSave method");
        //try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERATIVE_CLOCKNUMBER_TXT)));
        clocknumber_txtbox.clear();
        clocknumber_txtbox.sendKeys(ClockNumber);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 500);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERATIVE_CONTRACTOR_DROPDOWN)));
        contractor_dropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.LIST)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SELECT_CONTRACTOR_OPTION)));
        select_option.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_BTN)));
        operative_createbtn.click();
                //validate if Create Operative is successful
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//				} catch(Throwable t){
//					test.log(LogStatus.INFO, "Unable to create contract");
//					CreateContractPage createContractPage = new CreateContractPage(driver, wait, test);
//					PageFactory.initElements(driver, createContractPage);
//					return createContractPage;
//				}

        test.log(LogStatus.INFO, "Operative created successfully");
        OperativeMainDetailsListPage operativelistpage = new OperativeMainDetailsListPage(driver, wait, test);
        PageFactory.initElements(driver, operativelistpage);
        return operativelistpage;

    }
}
