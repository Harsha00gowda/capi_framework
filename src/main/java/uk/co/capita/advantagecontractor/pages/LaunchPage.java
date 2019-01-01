package uk.co.capita.advantagecontractor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.capita.advantagecontractor.basepage.BasePage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.operativesetup.operativemaindetails.OperativeMainDetailsListPage;
import uk.co.capita.advantagecontractor.util.ProjectConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{

	public LaunchPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
	}

//The following method launches the AUT and takes the user to login page	
	public Object goToLoginPage(String browserType){
		test.log(LogStatus.INFO, "Going to Login Page...");

		driver.navigate().to(ProjectConstants.TEST_URL);
		//the following code clicks on "Continue to this website (not recommended)" text and will push us to the site.
		//This is specifically required for IE
		if(browserType.equalsIgnoreCase("IE")){
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		
		//validate if Login page is displayed
		if(!isElementPresent(ProjectConstants.LOGIN_BUTTON)){
			test.log(LogStatus.INFO, "LoginPage did not appear");
			LaunchPage launchPage = new LaunchPage(driver, wait, test);
			PageFactory.initElements(driver, launchPage);
			return launchPage;
		}
		test.log(LogStatus.INFO, "Reached Login Page...");
		LoginPage loginPage = new LoginPage(driver, wait, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}


	//The following method launches the AUT and takes the user to Contract List page-this method to be deleted when we get login page	
		public Object goToContractListPage(String browserType) throws InterruptedException{
			test.log(LogStatus.INFO, "Going to Contract List Page...");
			driver.navigate().to(ProjectConstants.TEST_URL);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
			//Thread.sleep(25000);
			//the following code clicks on "Continue to this website (not recommended)" text and will push us to the site.
			//This is specifically required for IE
//			if(browserType.equalsIgnoreCase("IE")){
//			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
//			}
			
			//validate if Contract List Page is displayed
			if(!isElementPresent(ProjectConstants.CREATE_BTN)){
				test.log(LogStatus.INFO, "Contract List Page did not appear");
				LaunchPage launchPage = new LaunchPage(driver, wait, test);
				PageFactory.initElements(driver, launchPage);
				return launchPage;
			}
			test.log(LogStatus.INFO, "Reached Contract List Page...");
			ContractListPage contractListPage = new ContractListPage(driver, wait, test);
			PageFactory.initElements(driver, contractListPage);
			return contractListPage;
		}

	//The following method launches the AUT and takes the user to Operative page-this method to be deleted when we get login page
	public Object goToOperativePage(String browserType) throws InterruptedException{
		test.log(LogStatus.INFO, "Going to Operative Page...");
		driver.navigate().to(ProjectConstants.TEST_URL);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.LOADING_ICON)));
		//make sure page is fully loaded to proceed further
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.CREATE_BTN)));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProjectConstants.OPERATIVE_ICON)));

		//Thread.sleep(25000);
		//the following code clicks on "Continue to this website (not recommended)" text and will push us to the site.
		//This is specifically required for IE
//			if(browserType.equalsIgnoreCase("IE")){
//			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
//			}
//validate if Contract List Page is displayed
		if(!isElementPresent(ProjectConstants.OPERATIVE_ICON)){
			test.log(LogStatus.INFO, "Operative icon did not appear");
			LaunchPage launchPage = new LaunchPage(driver, wait, test);
			PageFactory.initElements(driver, launchPage);
			return launchPage;
		}
		test.log(LogStatus.INFO, "Operative icon available to click...");
		OperativeMainDetailsListPage operativelistpage = new OperativeMainDetailsListPage(driver, wait, test);
		PageFactory.initElements(driver, operativelistpage);
		return operativelistpage;
	}

}
