package Excelutilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ExcelSamples.Excelutil4;
import ExcelSamples.Excelutils;

public class SigninusingExcel {
	@Test
public void signinExcel() throws IOException
{
	System.setProperty("webdriver.chrome.driver","/Users/abhaymanoli/chromedriver");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Excelutil4.getTestDatalist().get(1).get("UserName"));
	driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(Excelutil4.getTestDatalist().get(1).get("Password"));
	driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
	
	
}
}
