package Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Excelutilities.ExcelutilEx1;

public class TestingExcel {
@Test
public void Testingfunctions() throws IOException
{
	String path="/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book6.xlsx";
	ExcelutilEx1 ca = new ExcelutilEx1();
int rowcounting = ExcelutilEx1.getRowCount(path, "Sheet1");
int cellcounting = ca.cellCount(path, "Sheet1", 0);
String celldatainfo = ca.cellData(path,"Sheet1", 0, 1);
System.out.println(rowcounting);
System.out.println(cellcounting);
System.out.println(celldatainfo);
}

}
