package Excelutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelutilEx1 {
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
		XSSFWorkbook workbook=new XSSFWorkbook("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book6.xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		String value = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
	}

	//number of columns//
	public static void getcellNumbers() throws IOException
	{
		XSSFWorkbook workbook=new XSSFWorkbook("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book6.xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");
	    double valuee1 = sheet.getRow(1).getCell(1).getNumericCellValue();
	    System.out.println(valuee1);
	}

	public static Map<String,String> getMapData() throws IOException
	{

		XSSFWorkbook workbook=new XSSFWorkbook("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book5.xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");
	    int lastrowcount = sheet.getLastRowNum();
	    System.out.println(lastrowcount);//printing last row count//
	
	TreeMap<String,String> testdata=new TreeMap<String,String>();//Map is used to print pair and treemap for sorted output

	for(int i=0;i<=lastrowcount;i++)//loop to traverse till lastrow
	{
		
		
		 XSSFRow row = sheet.getRow(i);//copy all row information in "row"
		 String key = row.getCell(0).getStringCellValue().trim();//first column info
		 String value = row.getCell(1).getStringCellValue().trim();//second column info
		 
	     testdata.put(key, value);//first column info is stored in "key" and second column info is stored in "value"
	}
		return testdata;//have to use return statement when we use any datatype for method other than void
	}
	public static List<Map<String,String>> getTestDatalist() throws IOException

	{

		Map<String,String>testdata=null;

		XSSFWorkbook workbook=new XSSFWorkbook("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book6.xlsx");

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		

	int lastrowcount = sheet.getPhysicalNumberOfRows();

	short lastcolumn = sheet.getRow(0).getLastCellNum();

	System.out.println(lastrowcount);

	System.out.println(lastcolumn);





	ArrayList list=new ArrayList();

	for(int i=0;i<lastcolumn;i++)

	{

	XSSFRow rowcount = sheet.getRow(0);

	XSSFCell cell = rowcount.getCell(i);



	String rowHeaders = cell.getStringCellValue();



	  list.add(rowHeaders);

	}



	ArrayList<Map<String,String>> testdataAll=new ArrayList<Map<String,String>>();

	for(int j=1;j<lastrowcount;j++) 

	{

	XSSFRow rows = sheet.getRow(j);

	testdata=new TreeMap<String,String>();





	for(int k=0;k<lastcolumn;k++)

	{

		String colvalues = rows.getCell(k).getStringCellValue();

		testdata.put((String) list.get(k),colvalues);

	}

	testdataAll.add(testdata);

	}





	return testdataAll;

	}


	public void writeTest(String name,int i,int j) throws InvalidFormatException, IOException
	{
		File src = new File("/Users/abhaymanoli/Desktop/Automation Workspace/E-CommerceAutomation/Excelfiles/Book1.xlsx");//file is copied in src
		FileInputStream filesss = new FileInputStream(src);
		XSSFWorkbook workbook=new XSSFWorkbook(filesss);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		sheet.getRow(i).getCell(j).setCellValue(name);
		FileOutputStream fout = new FileOutputStream(src);//path where data need to be edited
		workbook.write(fout);//write instruction
		workbook.close();//close workbook once editing is completed
		
	}
	public static int getRowCount(String Xfile,String sheetname) throws IOException
	{
		XSSFWorkbook workbook=new XSSFWorkbook(Xfile);

		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		return rowcount;
	}
	public static int cellCount(String Xfile,String sheetname, int rownumb) throws IOException
	{
		XSSFWorkbook workbook=new XSSFWorkbook(Xfile);

		XSSFSheet sheet = workbook.getSheet(sheetname);	
	  int Cellcount = sheet.getRow(rownumb).getLastCellNum();
		workbook.close();
		return Cellcount;
	}
	public static String cellData(String Xfile,String sheetname, int rownumb,int cellnumb) throws IOException
	{

		XSSFWorkbook workbook=new XSSFWorkbook(Xfile);

		XSSFSheet sheet = workbook.getSheet(sheetname);	
		
	  XSSFCell Celldata = sheet.getRow(rownumb).getCell(cellnumb);
	 
	DataFormatter formatter = new DataFormatter();
	String Cellvalues = formatter.formatCellValue(Celldata);
	return Cellvalues;
	  
	}
}
