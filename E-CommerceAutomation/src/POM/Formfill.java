package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Formfill {
WebDriver driver;
@FindBy(id="id_gender2")
WebElement title;


public Formfill(WebDriver d)
{
	driver=d;
	PageFactory.initElements(d, this);
}


@FindBy(name="customer_firstname")
WebElement firstName;


@FindBy(name="customer_lastname")
WebElement lastName;

@FindBy(name="passwd")
WebElement Password;

@FindBy(id="days")
WebElement date;

@FindBy(id="months")
WebElement Month;

@FindBy(id="years")
WebElement year;

@FindBy(name="optin")
WebElement Offers;


@FindBy(id="company")
WebElement Company;

@FindBy(name="address1")
WebElement Address;

@FindBy(name="address2")
WebElement Address2;


@FindBy(name="city")
WebElement City;

@FindBy(name="id_state")
WebElement State;

@FindBy(name="postcode")
WebElement ZIPcode;
 
@FindBy(name="other")
WebElement Otherinfo;

@FindBy(name="id_country")
WebElement Country;

@FindBy(name="phone_mobile")
WebElement Mobile;

@FindBy(name="submitAccount")
WebElement Register;

public void Gender()
{
title.click();
}

public void fName(String firstname)
{
	firstName.sendKeys("Shruti");
}

public void lName(String Lastname)
{
	lastName.sendKeys("Bekkeri");
}

public void password(String pword)
{
	Password.sendKeys("12345");
}

public void specialOffers()
{
	Offers.click();
}


public void companyName()
{
	Company.sendKeys("Innata");
}


public void address()
{
	Address.sendKeys("KingDrive");
}

public void address2()
{
	Address2.sendKeys("101");
}


public void city()
{
	City.sendKeys("Chicago");
}

public void state(String StateName)
{
	Select s=new Select(State);
	s.selectByValue(StateName);
}


public void zip()
{
	ZIPcode.sendKeys("60612");
}
 public void countryName(String countryy)
 {
	 Select n= new Select(Country);
	 n.selectByValue(countryy);
 }

public void otherinfo()
{
	Otherinfo.sendKeys("Buzz");	
}


public void mobilenum()
{
	Mobile.sendKeys("124566");
}

public void register()
{
	Register.click();
}
/*public void Date(int Date)
{
	Select s=new Select(date);
	s.selectByIndex(Date);
}
public void month(String mon)
{
	Select t=new Select(Month);
	t.selectByValue(mon);
}
public void yearr(String yr)
{
	Select r = new Select(year);
	List<WebElement> y = r.getOptions();
	
	for(int i=0;i<y.size();i++)
	{
		System.out.println(y.get(i).getText());
		if(y.get(i).getText().equals(yr))
		
		{
			y.get(i).click();
			
		}
		
	}*/


public void selectDropdown(String Xpath,String value)
{
List<WebElement> list = driver.findElements(By.xpath(Xpath));
	

	for(int i=0;i<list.size();i++)
	{
		String values = list.get(i).getText();
		if(values.equals(value)) {
			list.get(i).click();
		}
		
		
	}
	
	
	
}


}