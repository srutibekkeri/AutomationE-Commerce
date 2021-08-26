package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPrinteddress {
	WebDriver driver;
	public SearchPrinteddress(WebDriver d)
	{
		 driver = d;
		PageFactory.initElements(d, this);
	}
	@FindBy(name="search_query")
	WebElement searchbutton;
	
	@FindBy(name="submit_search")
	WebElement clicksearch;
	
	@FindBy(className="icon-th-list")
	WebElement List;
	
	
	
	@FindBy(how=How.XPATH,using="(//span[contains(.,'More')])[1]")
	WebElement More;
	
	@FindBy(id="send_friend_button")
	WebElement Sendfriend;
	
	@FindBy(id="friend_name")
	WebElement friendname;
	
	@FindBy(id="friend_email")
	WebElement friendemail;
	
	@FindBy(how=How.XPATH,using="(//span[contains(.,'Send')])[2]")
	WebElement clicksend;
	
	@FindBy(how=How.XPATH,using="//input[@type='button']")
	WebElement okbutton;
	
	public void search(String searchdress)
	{
		searchbutton.sendKeys(searchdress);
	}
	
	public void searching()
	{
		clicksearch.click();
	}
	
	public void lists()
	{
		List.click();
	}
	
	
	
	public void clickmore()
	{
		More.click();
	}
	public void sendfriend()
	{
		Sendfriend.click();
	}
	
	public void friendnames()
	{
		friendname.sendKeys("tina");
	}
	
	public void friendeid()
	{
		friendemail.sendKeys("test@gmail.com");
	}
	public void clicksends()
	{
		clicksend.click();
	}
	public void ok()
	{
		okbutton.click();
	}
}
