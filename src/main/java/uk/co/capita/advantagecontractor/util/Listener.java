package uk.co.capita.advantagecontractor.util;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import uk.co.capita.advantagecontractor.basetest.BaseTest;

public class Listener extends BaseTest implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		test = reports.startTest(arg0.getName());
    	test.log(LogStatus.FAIL,"This test is failed");
 //   	reports.endTest(test);
 //   	reports.flush();	
		}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		test = reports.startTest(arg0.getName());
		test.log(LogStatus.SKIP, "This test is skipped");
 //   	reports.endTest(test);
 //   	reports.flush();

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		test = reports.startTest(arg0.getName());
		test.log(LogStatus.PASS, "This test is Passed");
 //   	reports.endTest(test);
 //   	reports.flush();		
	}

}
