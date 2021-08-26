package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginwithGrid {
	WebDriver driver;
	@Test(priority=1)
public void setUp() throws MalformedURLException
{
		String node="http://192.168.0.3:4444/wd/hub";
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.MAC);
		System.setProperty("webdriver.chrome.driver","/Users/abhaymanoli/chromedriver");
		 driver = new RemoteWebDriver(new URL(node),cap);	
}
	@Test(priority=2)
	public void Login()
	{
		driver.get("https://demo.nopcommerce.com/");
		String Actualtitle = driver.getTitle();
		String Expected = "nopCommerce demo store";
			Assert.assertEquals( Actualtitle,Expected);
	}
}
