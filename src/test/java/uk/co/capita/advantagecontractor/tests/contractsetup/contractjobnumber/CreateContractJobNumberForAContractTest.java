package uk.co.capita.advantagecontractor.tests.contractsetup.contractjobnumber;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import uk.co.capita.advantagecontractor.basetest.BaseTest;
import uk.co.capita.advantagecontractor.pages.LaunchPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.contractjobnumber.ContractJobNumberListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractorsetup.contractjobnumber.ContractJobNumberPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractDetailsMainPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.util.DataUtil;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreateContractJobNumberForAContractTest extends BaseTest {

	public String testCaseName = this.getClass().getSimpleName(); 
	public String module = "Repairs and Contract Set Up";
	
	@Test(dataProvider = "getTestData")
	public void createContractJobNumberForAContract(Hashtable<String, String> table) throws InterruptedException{

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
				
		//search for a contract and click on it
		page = contractListPage.searchAndviewContract(table.get("Contract"));
			if (page instanceof ContractListPage){
			reportFailure("Unable to search for the contract and view it");
		}
				
			test.log(LogStatus.INFO, "Able to search for the contract and view it");
			ContractDetailsMainPage contractDetailsMainPage = (ContractDetailsMainPage)page;
			
			//Click on Contract job number accordion of the contract
			page = contractDetailsMainPage.goToContractJobNumberAccordion();
			if (page instanceof ContractDetailsMainPage){
				reportFailure("Unable to view Contract job number section of a contract");
			}
		test.log(LogStatus.INFO, "Able to view Contract job number section of a contract after clicking on contract job number accordion");
			ContractJobNumberListPage contractJobNumberListPage = (ContractJobNumberListPage)page;

			//Click on Edit contract job number for the contract
			page = contractJobNumberListPage.goToEditContractJobNumberPage();
			if (page instanceof ContractJobNumberListPage){
				reportFailure("Unable to go to Edit contract job number page");
			}
			test.log(LogStatus.INFO, "Able to to go to Contract job number page");
			ContractJobNumberPage contractJobNumberPage = (ContractJobNumberPage)page;
			
			
			//Enter Contract job number details and update
			page = contractJobNumberPage.enterContractJobNumberDetailsAndUpdate(table.get("AutoPrefix"), table.get("Manualprefix"), table.get("AutoStart"), table.get("AutoEnd"), table.get("AutoNext"), table.get("ManualStart"), table.get("ManualEnd"));
			if (page instanceof ContractJobNumberPage){
				reportFailure("Unable to enter Contract job number details and update");
			}
			test.log(LogStatus.INFO, "Able to enter Contract job number details and update"); 
			
	}
	
	@DataProvider(name = "getTestData")
	public Object[][] getTestData(){
		Object[][] data = DataUtil.getData(xls, module, testCaseName);
		return data;
	}


}
