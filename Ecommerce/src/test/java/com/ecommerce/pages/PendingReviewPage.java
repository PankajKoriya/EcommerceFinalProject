package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PendingReviewPage {
	
	WebDriver driver;
	
	By edit_link = By.xpath("//table[@id='reviwGrid_table']/tbody/tr[1]/td[10]/a");
	
	public PendingReviewPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public void clickOnEditLink()
	{
		driver.findElement(edit_link).click();
	}
	
	

}
