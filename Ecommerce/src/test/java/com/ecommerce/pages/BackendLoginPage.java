package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ecommerce.utilities.ConfigDataProvider;

public class BackendLoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "username") WebElement uNametxt;
	@FindBy(id = "login") WebElement pwdtxt;
	@FindBy(xpath = "//input[@title='Login']") WebElement loginBtn;
	
	public BackendLoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public void navigateToBackendLoginPage()
	{
		driver.get(ConfigDataProvider.getValue("backendLoginUrl"));
	}
	
	public void enterUsername(String uName)
	{
		uNametxt.sendKeys(uName);
	}
	
	public void enterpassword(String pwd)
	{
		pwdtxt.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}

}
