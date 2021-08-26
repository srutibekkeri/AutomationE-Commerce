package Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Excelutilities.ExcelutilEx1;
import Generic.BaseTest;
import POM.ExcelPOM;

public class SigninExcelTest7 extends BaseTest {
@Test
public void ExcelSignin() throws IOException
{
	ExcelPOM  ca = new ExcelPOM (driver);
	ca.login(ExcelutilEx1.getTestDatalist().get(0).get("Email id"));
	
	
}
}
