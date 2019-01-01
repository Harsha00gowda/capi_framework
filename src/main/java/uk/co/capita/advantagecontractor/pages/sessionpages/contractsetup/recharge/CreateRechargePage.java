package uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.recharge;

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

public class CreateRechargePage extends BasePage{
	

	@FindBy(xpath = ProjectConstants.RESOURCECODE_TXTBOX)
	public WebElement resourceCode_txtbox;
	
	@FindBy(xpath = ProjectConstants.LINENO_TXTBOX)
	public WebElement lineNo_txtbox;
	
	@FindBy(xpath = ProjectConstants.SOR_DROPDOWN)
	public WebElement sor_dropdpwn;
	
	@FindBy(xpath = ProjectConstants.SOR_OPTION)
	public WebElement sor_option;	
	
	@FindBy(xpath = ProjectConstants.UPLIFT_TXTBOX)
	public WebElement uplift_txtbox;
	
	@FindBy(xpath = ProjectConstants.RECHARGEFLAG_CHECKBOX)
	public WebElement rechargeFlag_chkbox;
	
	@FindBy(xpath = ProjectConstants.CREATERECHARGE_ICON)
	public WebElement createRecharge_icon;
	
	
	//constructor
	public CreateRechargePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

	public Object enterRechargeDetailsAndSave(String resourceCode, String lineNo, String sor, String upliftPercent, String rechargeFlag) {
		test.log(LogStatus.INFO, "In enterRechargeDetailsAndSave method");
		
//		try{
		resourceCode_txtbox.sendKeys(resourceCode);
		lineNo_txtbox.sendKeys(lineNo);
		sor_dropdpwn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.SOR_OPTION)));
		sor_option.click();
		uplift_txtbox.sendKeys(upliftPercent);
		if(rechargeFlag.equalsIgnoreCase("Y"))
			rechargeFlag_chkbox.click();
		createRecharge_icon.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_SUCCESS_MSG)));
//		} catch(Throwable t){
//			test.log(LogStatus.INFO, "Unable to enter Recharge details and save");
//			CreateRechargePage createRechargePage = new CreateRechargePage(driver, wait, test);
//			PageFactory.initElements(driver, createRechargePage);
//			return createRechargePage;
//		}
	
		test.log(LogStatus.INFO, "Able to enter Recharge details and save");
		RechargeListPage rechargeListPage = new RechargeListPage(driver, wait, test);
		PageFactory.initElements(driver, rechargeListPage);
		return rechargeListPage;
		
		
		
	}

}
