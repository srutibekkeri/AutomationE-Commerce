package Scripts;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.SearchPrinteddress;

public class Printeddresstest4 extends BaseTest{
	@Test
	public void searching() throws InterruptedException
	{
		String Scroll5 = "//a[@id='color_13']";
		SearchPrinteddress pd=new SearchPrinteddress(driver);
		pd.search("printed dresses");
		pd.searching();
		Sortby();
		Thread.sleep(2000);
		pd.lists();
		ScrollIntoview(Scroll5);
		pd.clickmore();
		pd.sendfriend();
		pd.friendnames();
		pd.friendeid();
		pd.clicksends();
		pd.ok();
	//Alert alert = driver.switchTo().alert();
	//alert.dismiss();
		
	}
}
