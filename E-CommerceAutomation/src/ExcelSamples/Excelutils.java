package ExcelSamples;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelutils {
public static void getRowCount() throws IOException
{
	XSSFWorkbook workbook=new XSSFWorkbook("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book1.xlsx");
    XSSFSheet sheet = workbook.getSheet("Sheet1");
    //number of rows//
    int rowcount = sheet.getPhysicalNumberOfRows();
System.out.println(rowcount);
}

//cell information//
public static void getCellData() throws IOException 
{
	XSSFWorkbook workbook=new XSSFWorkbook("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book1.xlsx");
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	String value = sheet.getRow(0).getCell(0).getStringCellValue();
	System.out.println(value);
}

//number of columns//
public static void getcellNumbers() throws IOException
{
	XSSFWorkbook workbook=new XSSFWorkbook("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book1.xlsx");
	XSSFSheet sheet = workbook.getSheet("Sheet1");
    double valuee1 = sheet.getRow(1).getCell(1).getNumericCellValue();
    System.out.println(valuee1);
}




public static void main(String[] args) throws IOException {
	Excelutils.getRowCount();
	Excelutils.getCellData();
	Excelutils.getcellNumbers();
}
}
