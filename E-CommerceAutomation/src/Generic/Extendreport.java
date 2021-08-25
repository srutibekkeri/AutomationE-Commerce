package Generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ExcelSamples.ExtentReportEx;

public class Extendreport  extends TestListenerAdapter{
	WebDriver driver;
	public	ExtentHtmlReporter ExHtml;
	public ExtentReports exReport;
	public ExtentTest exTest;
	
	@BeforeTest
	public void onStart(ITestContext testContext)
	{
	String TimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String ReportName="TestRepoet"+TimeStamp+".html";
	
		 ExHtml = new ExtentHtmlReporter("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/test-output/"+ReportName);
		 ExHtml.loadConfig("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/extend-config.xml");
		 ExHtml.config().setDocumentTitle("Automation Test Report"); //title of report
		 ExHtml.config().setReportName("Functional Test report"); //name of report
		 ExHtml.config().setTheme(Theme.DARK);
		 
	 exReport = new ExtentReports();
	 exReport.attachReporter(ExHtml);
	 exReport.setSystemInfo("HostName", "LocalHost");
	 exReport.setSystemInfo("OS", "macOS");
	 exReport.setSystemInfo("TesterName", "Shruti");
	 exReport.setSystemInfo("Browser", "Chrome");
	 
		 
	}
	public void onTestSuccess(ITestResult tr) {
		exTest=exReport.createTest(tr.getName());
		exTest.log(Status.PASS, "testCase passed is  "+tr.getName());
	  }

	  @Override
public void onTestFailure(ITestResult tr){
		  
		  if(tr.getStatus()==ITestResult.FAILURE)
			{
			  exTest=exReport.createTest(tr.getName());
				exTest.log(Status.FAIL, "Test case failed is "+tr.getName());
				
				exTest.log(Status.FAIL, "Test case error is "+tr.getThrowable());
				String pth=null;
				try {
					pth = BaseTest.screenshot(driver, tr.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				exTest.log(Status.FAIL, (Markup) exTest.addScreenCaptureFromPath(pth));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			}
	/*  public void onTestFailure(ITestResult tr) {
		  
		  exTest=exReport.createTest(tr.getName());
		  exTest.log(Status.FAIL, "testCase Failed is  "+tr.getName());
		  String path="/Users/abhaymanoli/Desktop/Screenshots"+tr.getName()+".png";
		 File F = new File(path);
		 if( F.exists())
		 {
			 try {
				exTest.fail("Screenshot below is"+exTest.addScreenCaptureFromPath(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }*/
		 
	  }
	  public void onFinish(ITestContext testContext)
	  {
		  exReport.flush(); 
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  exTest=exReport.createTest(tr.getName());
		  exTest.log(Status.SKIP, "testCase Skipped is  "+tr.getName());
	  }
	/*@AfterTest
	public void endReport()
	{
		exReport.flush();
}
	
	
	@Test
	public void verifytitle() {
		exTest=exReport.createTest("Verify title");
		String Actualtitle = driver.getTitle();
	String Expected = "nopCommerce demo stores";
		Assert.assertEquals( Actualtitle,Expected);
	}
	
		
	
	@Test
	public void login()
	{
		exTest=exReport.createTest("Verify login");
		 boolean enable = driver.findElement(By.className("ico-login")).isEnabled();
		  Assert.assertTrue(true);
	
	}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			exTest.log(Status.FAIL, "testCase Failed is  "+result.getName());
			exTest.log(Status.FAIL, "testCase error is  "+result.getThrowable());
		String screenpath = ExtentReportEx.screenshot(driver, result.getName());
			exTest.addScreenCaptureFromPath(screenpath);
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			exTest.log(Status.SKIP, "testCase Skipped is  "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			exTest.log(Status.PASS, "testCase passed is  "+result.getName());
		}*/
		
	}
	



