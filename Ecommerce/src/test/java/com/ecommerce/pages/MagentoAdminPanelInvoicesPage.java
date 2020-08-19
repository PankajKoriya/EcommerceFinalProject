package com.ecommerce.pages;

import java.sql.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecommerce.utilities.ExplicitWait;

public class MagentoAdminPanelInvoicesPage {
	
	WebDriver driver;
	By invoiceDateColumn = By.xpath("//table[@id='sales_invoice_grid_table']/thead/tr/th[3]/span/a");
	By invoiceDateColumnFirstCell = By.xpath("//table[@id='sales_invoice_grid_table']/tbody/tr[1]/td[3]");
	By invoiceDateColumnSecondCell = By.xpath("//table[@id='sales_invoice_grid_table']/tbody/tr[2]/td[3]");
	
	public MagentoAdminPanelInvoicesPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public void clickOnInvoicesDatecolumn()
	{
		driver.findElement(invoiceDateColumn).click();
	}
	
	public String getInvoiceDateColumnFirstCellValue()
	{
		ExplicitWait.waitForElement(driver, driver.findElement(invoiceDateColumnFirstCell));
		return driver.findElement(invoiceDateColumnFirstCell).getText();
	}
	
	public String getInvoiceDateColumnSecondCellValue()
	{
		ExplicitWait.waitForElement(driver, driver.findElement(invoiceDateColumnSecondCell));
		return driver.findElement(invoiceDateColumnSecondCell).getText();
	}

}
