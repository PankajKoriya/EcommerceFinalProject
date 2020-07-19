package com.ecommerce.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.pages.BackendLoginPage;
import com.ecommerce.pages.BaseClass;
import com.ecommerce.pages.MagentoAdminPanelHomePage;
import com.ecommerce.pages.MagentoAdminPanelSitespage;

public class VerifyInvoicePrinted extends BaseClass{
	
	@Test
	public void printInvoice() throws InterruptedException
	{
		logger = extent.createTest("Verify invoice can be printed");
		
		BackendLoginPage bloginPage = PageFactory.initElements(driver, BackendLoginPage.class);
		
		MagentoAdminPanelHomePage homePage = PageFactory.initElements(driver, MagentoAdminPanelHomePage.class);
		
		MagentoAdminPanelSitespage sitespage = PageFactory.initElements(driver, MagentoAdminPanelSitespage.class);
		
		bloginPage.navigateToBackendLoginPage();
		
		logger.info("Navigated to backend login page");
		
		bloginPage.enterUsername("user01");
		
		logger.info("Username is entered to backend login page");
		
		bloginPage.enterpassword("guru99com");
		
		logger.info("Password is entered to backend login page");
	
		bloginPage.clickOnLoginBtn();
		
		logger.info("Clicked on login button");
		
		homePage.closePopup();
		
		sitespage.MoveCursorToSites();
		
		sitespage.clickOnOrdersMenu();
		
		sitespage.selectFromStatusdd("Canceled");
		
		sitespage.clickOnSearchBtn();
		
		Thread.sleep(5000);
		
		sitespage.clickOnFirstOrderChk();
		
		sitespage.selectFromActions("Print Invoices");
		
		sitespage.clickOnSubmitBtn();
		
		String errorMsg = sitespage.getErrorMsg();
		
		String actErrorMsg = "There are no printable documents related to selected orders.";
		
		Assert.assertTrue(errorMsg.equals(actErrorMsg));
		
		sitespage.selectFromStatusdd("Complete");
		
		sitespage.clickOnSearchBtn();
		
		Thread.sleep(5000);
		
		sitespage.clickOnFirstOrderChk();
		
		sitespage.selectFromActions("Print Invoices");
		
		sitespage.clickOnSubmitBtn();
		
		String nameOfDownloadedFile = null;
		
		try {
			nameOfDownloadedFile = sitespage.verifyDownloadedInvoice();
			
		} catch (InterruptedException e) {
			
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(nameOfDownloadedFile.contains("invoice2020-07-19"));	
	}

}
