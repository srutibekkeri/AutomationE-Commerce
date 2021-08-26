package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class WomenPage extends BaseTest{
	
	@FindBy(how=How.XPATH,using="//a[.='Women']")
	@CacheLookup
	WebElement Womenhover;
	
	@FindBy(how=How.XPATH,using="(//a[@title='T-shirts'])[1]")
	WebElement Tshirt;
	
	@FindBy(how=How.XPATH,using="//img[@title='Faded Short Sleeve T-shirts']")
	@CacheLookup
	WebElement teehover;
	
	@FindBy(how=How.XPATH,using="(//a[@data-id-product='1'])[1]")
	@CacheLookup
	WebElement AddCart1;
	@FindBy(how=How.XPATH,using="//a[@title='Proceed to checkout']")
	WebElement Proceedcheck;
	
	@FindBy(how=How.XPATH,using="(//span[contains(.,'Proceed to checkout')])[2]")
	WebElement checkout;
	
	@FindBy(how=How.XPATH,using="//input[@type='checkbox']")
	WebElement CheckBox;
	
	@FindBy(how=How.XPATH,using=" (//span[contains(.,'Proceed to checkout')])[2]")
	WebElement checkout2;
	
	@FindBy(className="bankwire")
	WebElement Bankwirepay;
	
	@FindBy(how=How.XPATH,using="//span[contains(.,'I confirm my order')]")
	WebElement Confirmorder;
	
	public WomenPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}



public void womenmhover() {
	Actions ac= new Actions(driver);
	ac.moveToElement(Womenhover).perform();
}

public void tshirts()
{
	Tshirt.click();
}



public void selecttee()
{
	WebElement tshirt = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
	Actions ac= new Actions(driver);
	ac.moveToElement(tshirt).perform();
	
}

public void addcart()
{
	AddCart1.click();
}
public void proceedtocheck()
{
	Proceedcheck.click();
}
public void finalcheck()
{
	checkout.click();
}
public void tickcheckBox()
{
	CheckBox.click();
}
public void checkingout()
{
	checkout2.click();
}
public void payment()

{
	Bankwirepay.click();
}
public void confirm()
{
	Confirmorder.click();	
}
}