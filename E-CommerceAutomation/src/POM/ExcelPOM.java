package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;


public class ExcelPOM extends BaseTest{
	public ExcelPOM(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	@FindBy(name="email")
	@CacheLookup
	WebElement Emailid;

	@FindBy(name="passwd")
	@CacheLookup
	WebElement Password;

	@FindBy(name="SubmitLogin")
	@CacheLookup
	WebElement Sigin;
	public void login(Object email)
	{
		Emailid.sendKeys((CharSequence[]) email);
	}

	public void enterPassword(Object pw) {
		Password.sendKeys((CharSequence[]) pw);
	}

	public void clicksignin()
	{
		Sigin.click();
	}
}
