package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.mainataincertificates;

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

public class CreateCertificatePage extends BasePage {

    @FindBy(xpath = ProjectConstants.CREATECERTIFICATES_PAGETITLE)
    public WebElement createCertificates_pagetitle;

    //@FindBy(xpath = ProjectConstants.CERTIFICATEREFERENCE_TEXTFIELDTITLE)
    //public WebElement createCertificates_textfieldtitle;

    @FindBy(xpath = ProjectConstants.CERTIFICATEREFERENCE_TXTBOX)
    public WebElement reference_txtbox;

    //@FindBy(xpath = ProjectConstants.CERTIFICATECONTRACTOR_TEXTFIELDTITLE)
    //public WebElement contractor_textfieldtitle;

    @FindBy(xpath = ProjectConstants.CERTIFICATECONTRACTOR_DROPDOWN)
    public WebElement contractor_dropdown;

    @FindBy(xpath = ProjectConstants.CERTIFICATECONTRACTOR_SELECTLIST)
    public WebElement contractor_selectlist;

    //@FindBy(xpath = ProjectConstants.CERTIFICATEDISCRIPTION_TITLE)
    //public WebElement discription_textfieldtitle;

    @FindBy(xpath = ProjectConstants.CERTIFICATEDISCRIPTION_TXTBOX)
    public WebElement discription_txtbox;

    @FindBy(xpath = ProjectConstants.CREATE_BTN)
    public WebElement createCertificate_btn;

    @FindBy(xpath = ProjectConstants.CREATE_SUCCESS_MSG)
    public WebElement successMessage_text;

    @FindBy(xpath = ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)
    public WebElement createdDescription_text;

    public CreateCertificatePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
        super(driver, wait, test);
    }

    public Object enterCertificateDetailsAndSave(String Reference, String Description) throws InterruptedException {
        test.log(LogStatus.INFO, "In enterCertificatesDetailsAndSave method");
//		try{
        String titleText = createCertificates_pagetitle.getText();
        Assert.assertEquals(titleText, "Create certificate");
        reference_txtbox.sendKeys(Reference);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CERTIFICATEDISCRIPTION_TXTBOX)));
        discription_txtbox.sendKeys(Description);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CERTIFICATECONTRACTOR_DROPDOWN)));
        contractor_dropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CERTIFICATECONTRACTOR_SELECTLIST)));
        contractor_selectlist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_BTN)));
        createCertificate_btn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATEDCERTIFICATEDISCRIPTION_TXT)));
        String createdText = createdDescription_text.getText();
        Assert.assertEquals(createdText, Description);
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Able to enter Certificates details and save");
//			CreateSystemOptionsPage createSystemOptionsPage = new CreateSystemOptionsPage(driver, wait, test);
//			PageFactory.initElements(driver, createSystemOptionsPage);
//			return createSystemOptionsPage;
//		}

        test.log(LogStatus.INFO, "Able to enter Certificates details and save");
        MaintainCertificatesListPage certificatesListPage = new MaintainCertificatesListPage(driver, wait, test);
        PageFactory.initElements(driver, certificatesListPage);
        return certificatesListPage;



    }
}
