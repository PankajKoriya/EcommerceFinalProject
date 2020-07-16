package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.ExplicitWait;

public class MobileDetailPage {
	
	WebDriver driver;
	By sonyXpriceDetailPage = By.xpath("//span[@class='price']");
	
	public MobileDetailPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public String getPriceOfsonyXFromDetailsPage()
	{
		ExplicitWait.waitForElement(driver, driver.findElement(sonyXpriceDetailPage));
		
		return driver.findElement(sonyXpriceDetailPage).getText();
	}

}
