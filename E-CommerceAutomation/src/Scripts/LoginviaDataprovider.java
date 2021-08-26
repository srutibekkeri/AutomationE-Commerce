package Scripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excelutilities.ExcelutilEx1;
import Generic.BaseTest;
import POM.CreateAnaccount;

public class LoginviaDataprovider extends BaseTest{
@DataProvider(name="LoginDetails")
public String[][] getData() throws IOException
{
	System.setProperty("webdriver.chrome.driver","/Users/abhaymanoli/chromedriver");
	String path="/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book6.xlsx";
	int rownum = ExcelutilEx1.getRowCount(path, "Sheet1");
	int cellnum = ExcelutilEx1.cellCount(path, "Sheet1", 1);
	String[][] login = new String[rownum][cellnum];
	for(int i=1;i<rownum;i++)
	{
		for(int j=0;j<cellnum;j++)
		{
			login[i-1][j]=ExcelutilEx1.cellData(path, "Sheet1", i, j);
		}
	}
	return login;
}



@Test(dataProvider="LoginDetails")
public void logging(String email, String pw)
{
	CreateAnaccount ca = new CreateAnaccount(driver);
	ca.login(email);
	ca.enterPassword(pw);
	ca.clicksignin();
}
}