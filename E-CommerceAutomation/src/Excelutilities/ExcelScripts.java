package Excelutilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import ExcelSamples.Excelutil4;
import ExcelSamples.Excelutil5;
import ExcelSamples.Excelutils;
import ExcelSamples.Excelutils1;

public class ExcelScripts {
@Test
public void testmethod() throws IOException
{
	Map<String, String> data = Excelutils1.getMapData();
	for(Entry<String, String> map:data.entrySet())
	{
		
		
		System.out.println("keys  "+map.getKey()+"  values  "+map.getValue());    
	}
}
@Test
public void testMethod() throws IOException
{
List<Map<String, String>> data = Excelutil4.getTestDatalist();

for(Map<String,String> var: data)
{
System.out.println(var);
}
}
@Test
public void testM() throws InvalidFormatException, IOException 
{
Excelutil5 et = new Excelutil5();
et.writeTest("new user", 1, 1);
}
}
