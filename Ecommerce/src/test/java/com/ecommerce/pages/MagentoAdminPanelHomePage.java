package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MagentoAdminPanelHomePage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH , using="(//ul[@id='nav']/li/ul/li/a)[1]")
	WebElement ordersMenu;
	
	@FindBy(how=How.XPATH, using="(//ul[@id='nav']/li/a/span)[1]")
	WebElement salesMenu;
	
	@FindBy(how=How.XPATH, using = "//ul[@id='nav']/li/ul/li[2]/a/span")
	WebElement invoicesMenu;
	
	@FindBy(how = How.XPATH, using="//a[@title='close']")
	WebElement closeBtn;
	
	@FindBy(how = How.XPATH, using="//ul[@id='nav']/li[2]/a")
	WebElement catalog_tab;
	
	@FindBy(how = How.XPATH, using="//ul[@id='nav']/li[2]/ul/li/a")
	WebElement reviewAndRatingsMenu;
	
	@FindBy(how = How.XPATH, using="(//ul[@id='nav']/li[2]/ul/li/ul/li/a)[1]")
	WebElement custReviewsMenu;
	
	@FindBy(how = How.XPATH, using="(//ul[@id='nav']/li[2]/ul/li/ul/li/ul/li/a)[1]")
	WebElement pendingReviewMenu;
	
	//By catalog_tab = By.xpath("//ul[@id='nav']/li[2]/a");
	//By reviewAndRatingsMenu = By.xpath("//ul[@id='nav']/li[2]/ul/li/a");
	//By custReviewsMenu = By.xpath("(//ul[@id='nav']/li[2]/ul/li/ul/li/a)[1]");
	//By pendingReviewMenu = By.xpath("(//ul[@id='nav']/li[2]/ul/li/ul/li/ul/li/a)[1]");
	
	public MagentoAdminPanelHomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public void closePopup()
	{
		closeBtn.click();
	}
	
	public void MoveCursorToSales()
	{
		Actions action = new Actions(driver);
		action.moveToElement(salesMenu).perform();
	}
	public void clickOnOrdersMenu()
	{
		ordersMenu.click();
	}
	public void clickOnInvoicesMenu()
	{
		invoicesMenu.click();
	}
	public void moveCursorToCatalog()
	{
		Actions action = new Actions(driver);
		action.moveToElement(catalog_tab);
		action.perform();
	}
	
	public void moveCursorToReviewAndRatings()
	{
		Actions action = new Actions(driver);
		action.moveToElement(reviewAndRatingsMenu);
		action.perform();
	}
	
	public void moveCursorToCustomerReview()
	{
		Actions action = new Actions(driver);
		action.moveToElement(custReviewsMenu);
		action.perform();
	}
	 
	public void clickOnPendingReviewsMenu()
	{
		pendingReviewMenu.click();
	}

}
