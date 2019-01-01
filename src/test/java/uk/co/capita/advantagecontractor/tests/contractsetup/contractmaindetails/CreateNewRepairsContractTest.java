package uk.co.capita.advantagecontractor.tests.contractsetup.contractmaindetails;

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
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.CreateContractPage;
import uk.co.capita.advantagecontractor.util.DataUtil;
import uk.co.capita.advantagecontractor.util.ProjectConstants;
import uk.co.capita.advantagecontractor.util.RandomStringGenerator;

public class CreateNewRepairsContractTest extends BaseTest{

	public String testCaseName = this.getClass().getSimpleName(); 
	public String module = "Repairs and Contract Set Up";
	public static String contract = RandomStringGenerator.getAlphaNumeric();
	
	@Test(dataProvider = "getTestData")
	public void createNewRepairsContract(Hashtable<String, String> table) throws InterruptedException{
		
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
		
		//go to Contract List page
		LaunchPage launchPage = new LaunchPage(driver, wait, test);
		PageFactory.initElements(driver, launchPage);
		Object page = launchPage.goToContractListPage(table.get("Browser"));

		if (page instanceof LaunchPage){
			reportFailure("Unable to go to Contract List page of the AUT");
		}
		test.log(LogStatus.INFO, "Able to go to Contract List page of the AUT");
		ContractListPage contractListPage = (ContractListPage)page;
		
		//create new contract
		page = contractListPage.goToCreateContractPage();
		if((page instanceof ContractListPage)){
			reportFailure("Unable to go to Create Contract page");
		}
		test.log(LogStatus.INFO, "Able to go to Create Contract page of the AUT");
		CreateContractPage createContractPage = (CreateContractPage) page;
		
		//enter contract details and save
		page = createContractPage.enterContractDetailsAndSave(contract, table.get("Description"));
		if((page instanceof CreateContractPage)){
			reportFailure("Unable to create a new Contract");
		} else{
		
		//code to verify the message after successful creation has to come here
		storeContractNameinXls(contract);
		test.log(LogStatus.PASS, "Able to create a new contract successfully");
		}

	}


		@DataProvider(name = "getTestData")
		public Object[][] getTestData(){
			Object[][] data = DataUtil.getData(xls, module, testCaseName);
			return data;
		}




}
