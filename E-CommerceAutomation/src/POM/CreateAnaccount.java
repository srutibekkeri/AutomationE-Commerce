package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class CreateAnaccount  extends BaseTest{
WebDriver driver;
@FindBy(id="email_create")
@CacheLookup
WebElement emailId;

@FindBy(name="SubmitCreate")
@CacheLookup
WebElement SubmitButton;


@FindBy(name="email")
@CacheLookup
WebElement Emailid;

@FindBy(name="passwd")
@CacheLookup
WebElement Password;

@FindBy(name="SubmitLogin")
@CacheLookup
WebElement Sigin;

public CreateAnaccount(WebDriver d)
{
	driver=d;
	PageFactory.initElements(d, this);
}


public void enterEmailId(String mailid)
{
	emailId.sendKeys(mailid);
}

public void clickOnCreate()
{
	SubmitButton.click();
}

public void login(String email)
{
	Emailid.sendKeys(email);
}

public void enterPassword(String pw) {
	Password.sendKeys(pw);
}

public void clicksignin()
{
	Sigin.click();
}

}
