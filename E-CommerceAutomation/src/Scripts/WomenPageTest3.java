package Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.ReadConfig;
import POM.CreateAnaccount;
import POM.WomenPage;

public class WomenPageTest3 extends BaseTest{

	@Test
	public void womenhovering() throws InterruptedException, IOException
	{
		String Scrollinto="//span[.='Availability']";
		String scroll2="(//tr[@class='cart_total_price'])[1]";
		String Scroll3="//td[contains(.,'Total shipping')]";
		String Scroll4= "//p[contains(., 'Please confirm your order by clicking \"I confirm my order.')]";
		
		WomenPage wp=new WomenPage(driver);
		wp.womenmhover();
		wp.tshirts();
		ScrollIntoview(Scrollinto);
		Thread.sleep(5000);
		wp.selecttee();
		wp.addcart();
		wp.proceedtocheck();
		ScrollIntoview(scroll2);
		Thread.sleep(2000);
		wp.finalcheck();
		Thread.sleep(2000);
		screenshot(driver,"scnshot1");
		
		ReadConfig readConfig = new ReadConfig();
		CreateAnaccount CreateAcc = new CreateAnaccount(driver);
		Thread.sleep(2000);
		CreateAcc.login(readConfig.getuserName());
		CreateAcc.enterPassword(readConfig.getpassword());
		CreateAcc.clicksignin();
		
		String ActualText = "Use the delivery address as the billing address.";
		String expectedtext = driver.findElement(By.xpath("//label[contains(.,' the delivery address as the billing address.')]")).getText();
		if(ActualText.equals(expectedtext))
		{
			System.out.println("validated");
			screenshot(driver,"scrshot2");
		}
		else
		{
			System.out.println("failed");
			screenshot(driver,"scnshot3");
		}
		wp.finalcheck();
		wp.tickcheckBox();
		wp.checkingout();
		ScrollIntoview(Scroll3);
		String ActualPrice="$18.51";
		String expectedprice=driver.findElement(By.xpath("(//span[contains(.,'$18.51')])[3]")).getText();
		if(ActualPrice.equals(expectedprice))
		{
			System.out.println("Totalprice is correct");
		}
		else {
			System.out.println("Total price is incorrect");
		}
		wp.payment();
		ScrollIntoview(Scroll4);
		wp.confirm();
		String expectedCompleteorder;
		String ActualCompleteText="Your order on My Store is complete.";
	  expectedCompleteorder = driver.findElement(By.xpath("//strong[contains(.,'Your order on My Store is complete.')]")).getText();
		if(ActualCompleteText.equals(expectedCompleteorder))
		{
			System.out.println("Validation completed");
		}
		else {
			System.out.println("Validation failed");
		}
	}
}
