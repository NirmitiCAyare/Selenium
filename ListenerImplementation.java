package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	
	public void onTestStart(ITestResult result ) {
		// TODO Auto-generated method stub
		System.out.println("Execution is started");
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"Execution is started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is passed",true);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message=result.getThrowable().toString();
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is failed"+message,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is skipped",true);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		//Reporter.log("Execution is started",true);
		
		//use ExtentSparkReporter class just to configure extent report
		
		JavaUtil jUtil=new JavaUtil();
		
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Nirmitee");
		
		//use ExtentReports class to generate extent reports 
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chromeversion", "122");
		report.setSystemInfo("Author", "Nirmitee");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("Execution is finish",true);
		
		report.flush();
		
	}

	public static void main(String[] args) {
		
	}
}
