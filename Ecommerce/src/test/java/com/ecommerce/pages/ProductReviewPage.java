package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.ConfigDataProvider;

public class ProductReviewPage {
	
	WebDriver driver;
	By review_field = By.id("review_field");
	By summary_field = By.id("summary_field");
	By nickname_field = By.id("nickname_field");
	By submit_btn = By.xpath("//button[@title='Submit Review']");
	
	public ProductReviewPage(WebDriver ldriver) {
			
		this.driver=ldriver;
	}
	public void goToProductReviewPage()
	{
		driver.get(ConfigDataProvider.getValue("productReviewPageUrl"));
	}
	
	public String fillReviewAndSubmit(String review, String summary, String nickName)
	{
		driver.findElement(review_field).sendKeys(review);
		driver.findElement(summary_field).sendKeys(summary);
		driver.findElement(nickname_field).sendKeys(nickName);
		driver.findElement(submit_btn).click();
		return summary;
	}

}
