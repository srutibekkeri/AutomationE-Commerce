package ExcelSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Handle_Alert {
public WebDriver driver;

@Test
public void login() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "/Users/abhaymanoli/chromedriver");
	 driver = new ChromeDriver();
    driver.get("http://demo.guru99.com/V1/index.php");
	driver.manage().window().maximize();
	
	driver.findElement(By.name("uid")).sendKeys("mngr344286");
	driver.findElement(By.name("password")).sendKeys("Avesune23");
	driver.findElement(By.name("btnLogin")).click();
	
	
	Thread.sleep(3000);
	
	if(isAlerPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		//Assert.assertTrue(false);
		System.out.println("login failed");
	}
	else {
		//Thread.sleep(3000);
		Assert.assertTrue(true);
		System.out.println("login passed");
		driver.findElement(By.xpath("//a[contains(.,'Log out')]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
	}
}
public boolean isAlerPresent()
{
	try {
		driver.switchTo().alert();
		
		
		return true;
	}
	catch(NoAlertPresentException ex)
	{
		
		return false;
	}
}

}
