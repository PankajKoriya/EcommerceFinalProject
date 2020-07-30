package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.ExplicitWait;

public class MobileDetailPage {
	
	WebDriver driver;
	By sonyXpriceDetailPage = By.xpath("//span[@class='price']");
	By reviews_Tab = By.xpath("//li[@class='last']//span[text()='Reviews']"); 
	By summaryOfReview = By.xpath("//dl[@id='collateral-tabs']/dd/div/div/dl/dt[1]");
	
	public MobileDetailPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public String getPriceOfsonyXFromDetailsPage()
	{
		ExplicitWait.waitForElement(driver, driver.findElement(sonyXpriceDetailPage));
		
		return driver.findElement(sonyXpriceDetailPage).getText();
	}
	
	public void clickOnReviewsTab()
	{
		driver.findElement(reviews_Tab).click();
	}
	
	public String getReviewSummary()
	{
		return driver.findElement(summaryOfReview).getText();
	}

}
