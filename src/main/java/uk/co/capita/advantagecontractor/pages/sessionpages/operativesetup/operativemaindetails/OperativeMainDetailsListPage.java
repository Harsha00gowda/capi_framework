package uk.co.capita.advantagecontractor.pages.sessionpages.operativesetup.operativemaindetails;

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

public class OperativeMainDetailsListPage extends BasePage {

    @FindBy(xpath = ProjectConstants.CREATE_BTN)
    public WebElement createOperative_button;

    @FindBy(xpath = ProjectConstants.OPERATIVE_ICON)
    public WebElement operative_icon;

    @FindBy(xpath = ProjectConstants.OPERATIVE_TITLE)
    public WebElement page_title;

    @FindBy(xpath = ProjectConstants.YES_BTN)
    public WebElement yes_btn;

    public OperativeMainDetailsListPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
        super(driver, wait, test);
    }

    public Object goToCreateOperativePage(){
        test.log(LogStatus.INFO, "In goToCreateOperativePage method");
        //try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ProjectConstants.OPERATIVE_ICON)));
            operative_icon.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERATIVE_TITLE)));
            String title = page_title.getText();
            Assert.assertEquals(title,"Operative");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_BTN)));
            createOperative_button.click();
            //validate if click on Create Operative is successful
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.OPERATIVE_DETAILS_TITLE)));
        /*} catch(Throwable t){
            test.log(LogStatus.INFO, "Unable to go to Create Operative page");
            OperativeMainDetailsListPage operativelistpage = new OperativeMainDetailsListPage(driver, wait, test);
            PageFactory.initElements(driver, operativelistpage);
            return operativelistpage;
        }*/
        test.log(LogStatus.INFO, "Clicked on Create Operative button successfully");
        CreateOperativePage createOperativePage = new CreateOperativePage(driver, wait, test);
        PageFactory.initElements(driver, createOperativePage);
        return createOperativePage;
    }

}
