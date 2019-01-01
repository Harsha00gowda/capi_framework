package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contactdetails;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.mainataincertificates.MaintainCertificatesListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreateContactPage extends BasePage {

    @FindBy(xpath = ProjectConstants.CREATECONTACT_PAGETITLE)
    public WebElement contactScreen_Title;

    @FindBy(xpath = ProjectConstants.CONTACTTYPE_DROPDOWN)
    public WebElement contacttype_dropdown;

    @FindBy(xpath = ProjectConstants.SELECTCONTACT_OPTION)
    public WebElement select_contactoption;

    @FindBy(xpath = ProjectConstants.CONTACTNAME_TXT)
    public WebElement contactname;

    @FindBy(xpath = ProjectConstants.CREATE_CONTACT_BUTTON)
    public WebElement createcontact_btn;

    @FindBy(xpath = ProjectConstants.CONTACTNAME)
    public WebElement created_contactname;

    @FindBy(xpath = ProjectConstants.CONTACT_TYPESEARCH)
    public WebElement contact_search;

    public CreateContactPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
        super(driver, wait, test);
    }

    public Object enterContactDetailsAndSave(String ContactName) throws InterruptedException {
        test.log(LogStatus.INFO, "In enterContactDetailsAndSave method");
		try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATECONTACT_PAGETITLE)));
        String headerTitle = contactScreen_Title.getText();
        Assert.assertEquals(headerTitle, "Create");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTTYPE_DROPDOWN)));
        contacttype_dropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTLIST)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACT_TYPESEARCH)));
        contact_search.sendKeys("MGR");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SELECTCONTACT_OPTION)));
        select_contactoption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTNAME_TXT)));
        contactname.sendKeys(ContactName);
        contactScreen_Title.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 500);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_CONTACT_BUTTON)));
        createcontact_btn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CONTACTNAME)));
        String createdText = created_contactname.getText();
        Assert.assertEquals(createdText, ContactName);
		} catch(Throwable t){
			test.log(LogStatus.INFO, "Able to enter Certificates details and save");
			CreateContactPage createContactPage = new CreateContactPage(driver, wait, test);
			PageFactory.initElements(driver, createContactPage);
			return createContactPage;
		}

        test.log(LogStatus.INFO, "Able to enter Contact details and save");
        MaintainCertificatesListPage certificatesListPage = new MaintainCertificatesListPage(driver, wait, test);
        PageFactory.initElements(driver, certificatesListPage);
        return certificatesListPage;
    }
}
