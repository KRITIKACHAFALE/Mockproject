package Fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	
	public static String getInputData(String key) throws IOException {
		
	Properties prop = new Properties();
	
	FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\com.crm.finalproject\\src\\test\\resources\\Executablefile.properties");
	prop.load(fis);
	
	String data= prop.getProperty(key); 
	return data;
	
	}
}

