package uk.co.capita.advantagecontractor.tests;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import uk.co.capita.advantagecontractor.basetest.BaseTest;
import uk.co.capita.advantagecontractor.pages.LaunchPage;
import uk.co.capita.advantagecontractor.pages.LoginPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.LandingPage;
import uk.co.capita.advantagecontractor.util.DataUtil;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class LoginWithInvalidCredTest extends BaseTest{

	public String testCaseName = this.getClass().getSimpleName(); //or we can use "LoginTest";
	public String module = "Login";

	@Test(dataProvider = "getTestData")
	public void loginWithInvalidCredTest(Hashtable<String, String> table){

		test = reports.startTest(testCaseName);

        //verify module run mode
        if(!DataUtil.isModuleExecutable(xls, module)){//skip the test case if its module's run mode is N
            test.log(LogStatus.SKIP, "Skipping the test case - " + testCaseName + " - as Runmode of module - " + module + " - is N");
            throw new SkipException("Skipping the test case - " + testCaseName + " - as Runmode of module - " + module + " - is N");
        } else{    //if module's run mode is Y
            //verify TC run mode and DataSet run mode
            if(!DataUtil.isTestExecutable(xls, testCaseName) || table.get(ProjectConstants.TESTDATA_RUNMODECOL_NAME).equals("N")){
                test.log(LogStatus.SKIP, "Skipping the test case - " + testCaseName + " - as Runmode is N");
                throw new SkipException("Skipping the test case - " + testCaseName + " - as Runmode is N");
            }
        }


		test.log(LogStatus.INFO, "Starting " + testCaseName);
		initialize(table.get("Browser"));

		LaunchPage launchPage = new LaunchPage(driver, wait, test);
		PageFactory.initElements(driver, launchPage);
		Object page = launchPage.goToLoginPage(table.get("Browser"));

		if (page instanceof LaunchPage){
			reportFailure("Unable to go to Login page of the AUT");
		}
		test.log(LogStatus.INFO, "Able to go to Login page of the AUT");
		LoginPage loginPage = (LoginPage)page;

		//do login
		String actualResult = "";
		page = loginPage.doLogin(table.get("Username"), table.get("Password"));
		if(page instanceof LandingPage)
			actualResult = "Success";
		else
			actualResult = "Unsuccess";

		if(!actualResult.equalsIgnoreCase(table.get("Expected_Result")))
			reportFailure("Login Test Failed");
		test.log(LogStatus.PASS, testCaseName + " Pass");













	}
	@DataProvider(name = "getTestData")
	public Object[][] getTestData(){
		Object[][] data = DataUtil.getData(xls, module, testCaseName);
		return data;
	}
}
