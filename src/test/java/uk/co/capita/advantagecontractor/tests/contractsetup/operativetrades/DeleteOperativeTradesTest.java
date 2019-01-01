package uk.co.capita.advantagecontractor.tests.contractsetup.operativetrades;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.co.capita.advantagecontractor.basetest.BaseTest;
import uk.co.capita.advantagecontractor.pages.LaunchPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractDetailsMainPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.contractmaindetails.ContractListPage;
import uk.co.capita.advantagecontractor.pages.sessionpages.contractsetup.operatives.OperativesListPage;
import uk.co.capita.advantagecontractor.util.DataUtil;
import uk.co.capita.advantagecontractor.util.ProjectConstants;

import java.util.Hashtable;

public class DeleteOperativeTradesTest extends BaseTest {
	public String testCaseName = this.getClass().getSimpleName(); 
	public String module = "Repairs and Contract Set Up";

	@Test(dataProvider = "getTestData")
	public void deleteOperativeTrade(Hashtable<String, String> table) throws InterruptedException{

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

		//Click on Contractors bar and go to contractor operative screen of the contract
		page = contractDetailsMainPage.goToOperativesSection();
		if (page instanceof ContractDetailsMainPage){
			reportFailure("Unable to view Contractor Operatives section of a contract");
		}
		test.log(LogStatus.INFO, "Able to view Contractor Operatives of a contract");
		OperativesListPage operativesListPage = (OperativesListPage)page;

		//Delete trade for created contractor operative
		page = operativesListPage.searchAndDeleteOperativeTrade(table.get("TradeDescription"));
		if (page instanceof OperativesListPage){
			reportFailure("Unable to go to Delete Operative Trade page");
		}
		test.log(LogStatus.INFO, "Able to to go to Delete Operative Trade page");

	}
	
	@DataProvider(name = "getTestData")
	public Object[][] getTestData(){
		Object[][] data = DataUtil.getData(xls, module, testCaseName);
		return data;
	}
	
}
