package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PendingReviewEditPage {
	
	WebDriver driver;
	By status_dropdown = By.id("status_id");
	By saveReview_btn = By.xpath("//div[@id='anchor-content']//button[@id='save_button']");
	
	public PendingReviewEditPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public void selectStatus(String status)
	{
		Select select = new Select(driver.findElement(status_dropdown));
		select.selectByVisibleText(status);
	}
	
	public void clickOnSaveReview()
	{
		driver.findElement(saveReview_btn).click();
	}
}
