package Scripts;

import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.Clickonfb;

public class FacebookTest6 extends BaseTest{
@Test
public void facebook()
{
	Clickonfb fb1=new Clickonfb(driver);
	fb1.Switchtochild();
	
}
}
