package com.ecommerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MagentoAdminPanelHomePage {
	
	@FindBy(how = How.XPATH, using="//a[@title='close']")
	WebElement closeBtn;
	
	public void closePopup()
	{
		closeBtn.click();
	}

}
