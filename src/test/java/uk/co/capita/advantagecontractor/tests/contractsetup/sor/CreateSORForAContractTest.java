package uk.co.capita.advantagecontractor.tests.contractsetup.sor;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import uk.co.capita.advantagecontractor.basetest.BaseTest;
import uk.co.capita.advantagecontractor.pages.LaunchPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractDetailsMainPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.EditContractPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.CreatePriorityPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.priorities.PrioritiesListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sor.CreateSORPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sor.EnterTradeAndCostDetailsAndSavePage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.sor.SORListPage;
import uk.co.capita.advantagecontractor.util.DataUtil;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

public class CreateSORForAContractTest extends BaseTest{

	public String testCaseName = this.getClass().getSimpleName(); 
	public String module = "Repairs and Contract Set Up";

	@Test(dataProvider = "getTestData")
	public void createSORForAContract(Hashtable<String, String> table) throws InterruptedException{

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
		page = contractListPage.searchAndviewContract(xls.getCellData("Repairs and Contract Set Up", "ContractName", 2));
		if (page instanceof ContractListPage){
			reportFailure("Unable to search for the contract and view it");
		}
		
		test.log(LogStatus.INFO, "Able to search for the contract and view it");
		ContractDetailsMainPage contractDetailsMainPage = (ContractDetailsMainPage)page;

		//Click on Schedule Of Rates bar of the contract
		page = contractDetailsMainPage.goToSORSection();
		if (page instanceof ContractDetailsMainPage){
			reportFailure("Unable to view SOR section of a contract");
		}
		test.log(LogStatus.INFO, "Able to view SOR section of a contract after clicking on SOR bar");
		SORListPage sorListPage = (SORListPage)page;

		//Click on Create SOR button for the contract
		page = sorListPage.goToCreateSORPage();
		if (page instanceof SORListPage){
			reportFailure("Unable to go to Create SOR page");
		}
		test.log(LogStatus.INFO, "Able to to go to Create SOR page");
		CreateSORPage createSORPage = (CreateSORPage)page;
		
		
		//Enter SOR details and click on Next button
		page = createSORPage.enterSORDetailsAndNext(table.get("SOR"), table.get("Description"), table.get("Priority"), table.get("Date"), table.get("Method of Recharge"));
		if (page instanceof CreateSORPage){
			reportFailure("Unable to enter SOR details and click on Next button");
		}
		
		test.log(LogStatus.INFO, "Able to enter SOR details and click on Next button");
		EnterTradeAndCostDetailsAndSavePage enterTradeAndCostDetailsAndSavePage = (EnterTradeAndCostDetailsAndSavePage)page;
	
		//Enter Trade and Cost Details and save
		page = enterTradeAndCostDetailsAndSavePage.enterTradeAndCostDetailsAndSave();
		if (page instanceof EnterTradeAndCostDetailsAndSavePage){
			reportFailure("Unable to enter Trade and Cost details and click on Save button");
		}
		
		test.log(LogStatus.PASS, "Able to enter Trade and Cost details and click on Save button");
	
	
	
	
	
	}
		
	
	@DataProvider(name = "getTestData")
	public Object[][] getTestData(){
		Object[][] data = DataUtil.getData(xls, module, testCaseName);
		return data;
	}
	
	
	
	
	}
