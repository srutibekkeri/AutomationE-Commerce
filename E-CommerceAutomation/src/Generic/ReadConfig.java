package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() throws IOException
	{
		File src = new File("./Configuration/Config.properties");
		FileInputStream Files = new	FileInputStream(src);
		Properties		 pro = new Properties();
		pro.load(Files);	
	}
	
	public String getUrl()
	{
		String BaseUrl = pro.getProperty("Url");
		return BaseUrl;
	}
	
	
	public String getuserName()
	{
	String UserNAme = pro.getProperty("email");
	return UserNAme;
	}
	
	public String getpassword()
	{
		String Password = pro.getProperty("Password");
		return Password;
	}
	 
}
