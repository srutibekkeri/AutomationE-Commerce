package Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.ReadConfig;
import POM.CreateAnaccount;
import POM.Formfill;

public class CreateAccount_TestCase1 extends BaseTest{

	String Date_xpath="//select[@name='days']//option";
	String month_xpath="//select[@name='months']//option";
	String year_xpath="//select[@name='years']//option";
	@Test
	public void enterEmail() throws IOException
	{
		ReadConfig readConfig = new ReadConfig();
		CreateAnaccount CreateAcc = new CreateAnaccount(driver);
		
		//CreateAcc.enterEmailId(readConfig.getuserName());
		CreateAcc.enterEmailId("testinnata22@gmail.com");
		CreateAcc.clickOnCreate();
		
		
	Formfill formfilling = new Formfill(driver);
	formfilling.Gender();
	 formfilling.fName("Shruti");
	 
	 formfilling.lName("Bekkeri");
	 formfilling.password("12345");
	 /*formfilling.Date(4);
	 formfilling.month("1");
	 formfilling.yearr("2021  ");*/
	 formfilling.selectDropdown(Date_xpath,"2  ");
	 formfilling.selectDropdown(month_xpath,"January ");
	 formfilling.selectDropdown(year_xpath,"2020  ");
	 formfilling.specialOffers();
	 formfilling.companyName();
	 formfilling.address();
	 formfilling.address2();
	 formfilling.city();
	 formfilling.state("13");
	 formfilling.zip();
	 formfilling.otherinfo();
	 formfilling.countryName("21");
	 formfilling.mobilenum();
	 formfilling.register();
	 
	String title = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
	if(title.equals("Welcome to your account. Here you can manage all of your personal information and orders."))
			{
		System.out.println("Account is verified");
			}
	else {
		System.out.println("Validation failed");
	}
	}
	
	
	
}


