package ExcelSamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic.AutoConstants;

public class ParallelExcecution implements AutoConstants {
@Test
public void test1() throws InterruptedException {
	System.out.println("I am inside test1");
	
	System.setProperty(CHROME_KEY, CHROME_VALUE);
	ChromeDriver driver = new ChromeDriver();
driver.get("https://www.google.com/");

Thread.sleep(3000);
}
@Test
public void test2() throws InterruptedException {
	System.out.println("I am inside test2");
	
	System.setProperty(CHROME_KEY, CHROME_VALUE);
	ChromeDriver driver = new ChromeDriver();

driver.get("https://www.amazon.com/");
Thread.sleep(3000);

}
}