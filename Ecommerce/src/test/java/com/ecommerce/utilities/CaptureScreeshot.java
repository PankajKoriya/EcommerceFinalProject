package com.ecommerce.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreeshot {
	
	public static String screenshot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String dest = "C:\\Users\\pankaj.koriya\\git\\EcommerceFinalProject\\Ecommerce\\Screenshots\\Ecommerce_" + CaptureScreeshot.getDateAndTime() + ".png";
		
		try
		{
		FileHandler.copy(src, new File(dest));
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return dest;
		
	}
	
	public static String getDateAndTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	
	public static String getDate()
	{
		Date date = new Date();
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		return sdt.format(date);
	}

}
