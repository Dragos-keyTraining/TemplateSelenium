package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestNgListener implements IResultListener {

	public void onTestStart(ITestResult result) {

		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+++ Started test case : " + result.getMethod().getMethodName() );
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Start time : " + timeStamp);
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");

	}

	public void onTestSuccess(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+++ Pass test case : " + result.getMethod().getMethodName() );
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("End time : " + timeStamp);
		Log.info("--------------------------------------------------");
	}

	public void onTestFailure(ITestResult result) {
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.error("+++ Failed test case : " + result.getMethod().getMethodName() );
		Log.error("++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.error("Failed time : " + timeStamp);
		Log.error(result.getThrowable());
		Log.error("++++++++++++++++++++++++++++++++++++++++++++++");
	}

	public void onTestSkipped(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+++ Skipped test case : " + result.getMethod().getMethodName() );
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++");

	}
	
	
	

}
