package Generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConstants{

	
public WebDriver driver;
	
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void openApplication ( String br) throws IOException
	{
		
		ReadConfig readConfig = new ReadConfig();
		
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			driver.manage().window().maximize();
				
		}
		if(br.equals("firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(readConfig.getUrl());
				
		}
	
		
	}
	public static String screenshot(WebDriver driver,String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	String path = "/Users/abhaymanoli/Desktop/Screenshots/"+name+".png";
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		return path;
		
	}
	
	public void ScrollIntoview(String Xpath)
	{
		WebElement ScrollElement = driver.findElement(By.xpath(Xpath));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ScrollElement);
	}
	
	public void Sortby()
	{
	WebElement sorted = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		Select s=new Select(sorted);
		s.selectByValue("price:asc");
	}
	
	
	
	
	}
	/*@AfterMethod
	public void closeApplication()
	{
		driver.close();
	}*/

