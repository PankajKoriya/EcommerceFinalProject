package com.ecommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	static Properties pro;
	
		public ConfigDataProvider()
		{
			File file = new File("./ConfigDataProvider/Config.properties");
			try
			{
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();  
			pro.load(fis);
			}
			catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
		}
		public static String getValue(String keyToSearch)
		{
			return pro.getProperty(keyToSearch);
		}
		

}
