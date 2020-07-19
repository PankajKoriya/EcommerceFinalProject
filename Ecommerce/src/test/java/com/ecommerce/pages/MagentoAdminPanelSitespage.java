package com.ecommerce.pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MagentoAdminPanelSitespage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH , using="(//ul[@id='nav']/li/ul/li/a)[1]")
	WebElement ordersMenu;
	
	@FindBy(how=How.ID,using="sales_order_grid_filter_status")
	WebElement statusDropdown;
	
	@FindBy(how=How.XPATH, using="//button[@title='Search']")
	WebElement searchBtn;
	
	@FindBy(how=How.XPATH, using="(//table[@id='sales_order_grid_table']/tbody/tr/td/input)[1]")
	WebElement firstOrderChk;
	
	@FindBy(how=How.XPATH, using="//select[@id='sales_order_grid_massaction-select']")
	WebElement actionsDropdown;
	
	@FindBy(how=How.XPATH, using="//button[@title='Submit']")
	WebElement submitBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='messages']/ul/li/ul/li/span")
	WebElement errorMsg;
	
	@FindBy(how=How.XPATH, using="(//ul[@id='nav']/li/a)[1]")
	WebElement siteMenu;
	
	
	public MagentoAdminPanelSitespage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public void MoveCursorToSites()
	{
		Actions action = new Actions(driver);
		action.moveToElement(siteMenu).perform();
	}
	public void clickOnOrdersMenu()
	{
		ordersMenu.click();
	}
	
	public void selectFromStatusdd(String status)
	{
		Select statusdd = new Select(statusDropdown);
		statusdd.selectByVisibleText(status);
	}
	
	public void clickOnSearchBtn()
	{
		searchBtn.click();
	}
	
	public void clickOnFirstOrderChk()
	{
		firstOrderChk.click();
	}
	
	public void selectFromActions(String action)
	{
		Select actionsdd = new Select(actionsDropdown);
		actionsdd.selectByVisibleText(action);
	}
	
	public void clickOnSubmitBtn()
	{
		submitBtn.click();
	}
	
	public String getErrorMsg()
	{
		return errorMsg.getText();
	}
	
	public String verifyDownloadedInvoice() throws InterruptedException
	{
		Thread.sleep(10000);
	     File getLatestFile = getLatestFilefromDir("C:\\Users\\pankaj.koriya\\Downloads");
	     String fileName = getLatestFile.getName();
	     return fileName;
	     
	}
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
}
	


