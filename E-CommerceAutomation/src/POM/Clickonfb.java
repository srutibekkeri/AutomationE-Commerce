package POM;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class Clickonfb  extends BaseTest{
	WebDriver driver;
	public Clickonfb(WebDriver d)
	{
		 driver = d;
		PageFactory.initElements(d, this);
	}
	@FindBy(className="facebook")
	WebElement Fb;
	
	@FindBy(how=How.XPATH,using="//div[@aria-label='Join Group']")
	WebElement Joingroup;
	
	
	
	public void fb()
	{
		Fb.click();
		
	}
	
	public void joingroup()
	{
		Joingroup.click();
	}
	
	public void Switchtochild()
	{
	String parentwindow = driver.getWindowHandle();
	Fb.click();
	Set<String> childwindow = driver.getWindowHandles();
	
	
	for(String cc:childwindow)
	{
		System.out.println(cc);
		if(!childwindow.equals(parentwindow))
		{
			driver.switchTo().window(cc);
			
		}
	}
	joingroup();
	driver.switchTo().window(parentwindow);
}
}