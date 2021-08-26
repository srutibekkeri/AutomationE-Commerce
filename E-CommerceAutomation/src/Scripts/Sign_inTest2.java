package Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.CreateAnaccount;

public class Sign_inTest2 extends BaseTest{
	@DataProvider(name="SignIn")
	public Object[][] dataset()
	{
		return new Object[][]
				{
			/*8{"varshi0805@yahoo.com","sujan" },
			{"test@gmail.com","rftyh"},*/
			{"mangofruitssss@gmail.com","12345"}
				};
	}

	@Test(dataProvider= "SignIn")
	public void signin(String USname, String pw) throws IOException
	{
		CreateAnaccount CreateAcc = new CreateAnaccount(driver);
		CreateAcc.login(USname);
		CreateAcc.enterPassword(pw);
		CreateAcc.clicksignin();
		
		String expectedtext = driver.findElement(By.className("info-account")).getText();
		String Actualtext = "Welcome to your account. Here you can manage all of your personal information and orders.";
		if(expectedtext.equals(Actualtext))
		{
			Assert.assertTrue(true);
		}
		else {
			
			Assert.assertTrue(false);
			//screenshot(driver, "Screenshot1");
			System.out.println("not validated");
		}
			
		//Assert.assertEquals(Actualtext, expectedtext);
		//System.out.println("Page verified");
		
		
	
}
}