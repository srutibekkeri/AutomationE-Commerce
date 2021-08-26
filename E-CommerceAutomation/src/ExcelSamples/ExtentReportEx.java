package ExcelSamples;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportEx {
	WebDriver driver;
	public	ExtentHtmlReporter ExHtml;
	public ExtentReports exReport;
	public ExtentTest exTest;
	
	@BeforeTest
	public void SetExtent()
	{
		 ExHtml = new ExtentHtmlReporter("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/test-output/myreport.html");
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

	@AfterTest
	public void endReport()
	{
		exReport.flush();
}
	@BeforeMethod()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/abhaymanoli/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}
	@Test
	public void verifytitle() {
		exTest=exReport.createTest("Verify title");
		String Actualtitle = driver.getTitle();
	String Expected = "nopCommerce demo stores";
		Assert.assertEquals( Actualtitle,Expected);
	}
	@Test
	public void logotest()
	{
		exTest=exReport.createTest("Verify logo");	
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertTrue(true);
		
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
		}
		
	}
	public static String screenshot(WebDriver driver,String name) throws IOException
	{
	//SimpleDateFormat date = new SimpleDateFormat(Date);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("/Users/abhaymanoli/Desktop/Screenshots/"+name+".png");
		FileUtils.copyFile(source, destination);
		return name;
}
}
