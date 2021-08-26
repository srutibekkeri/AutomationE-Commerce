package ExcelSamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelutil5 {
public void writeTest(String name,int i,int j) throws InvalidFormatException, IOException
{
	File src = new File("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book1.xlsx");//file is copied in src
	FileInputStream filesss = new FileInputStream(src);//input file is is stored in "filess"
	XSSFWorkbook workbook=new XSSFWorkbook(filesss);
	XSSFSheet sheet = workbook.getSheet("Sheet1");//sheet1 info is copied in "sheet"
	sheet.getRow(i).getCell(j).setCellValue(name);//dynamic row,column and name 
	FileOutputStream fout = new FileOutputStream(src);//path where data need to be edited
	workbook.write(fout);//write instruction
	workbook.close();//close workbook once editing is completed
	
}
@Test
public void testM() throws InvalidFormatException, IOException 
{
Excelutil5 et = new Excelutil5();
et.writeTest("new user", 1, 1);
}
}
