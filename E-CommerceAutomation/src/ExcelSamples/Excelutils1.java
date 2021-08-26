package ExcelSamples;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelutils1 {
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


	@Test   // .........main method
	public void testmethod() throws IOException
	{
		Map<String, String> data = Excelutils1.getMapData();//classname.methodname(since method is static)
		for(Entry<String, String> map:data.entrySet())//for each loop for multiple entries
		{
			
			
			System.out.println("keys  "+map.getKey()+"  values  "+map.getValue());    //print statement
		}
	}
}
