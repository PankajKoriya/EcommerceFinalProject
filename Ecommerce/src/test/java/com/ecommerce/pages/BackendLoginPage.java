package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		driver.get("http://live.demoguru99.com/index.php/backendlogin");
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
