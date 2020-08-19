package com.ecommerce.testcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.BackendLoginPage;
import com.ecommerce.pages.BaseClass;
import com.ecommerce.pages.MagentoAdminPanelHomePage;
import com.ecommerce.pages.MagentoAdminPanelInvoicesPage;

public class VerifySortingForInvoiceDateColumn extends BaseClass{
	
	@Test
	public void verifySort() throws ParseException
	{
		logger = extent.createTest("Verify Invoice date column sorting");
		
		BackendLoginPage blp = PageFactory.initElements(driver, BackendLoginPage.class);
		MagentoAdminPanelHomePage maphp = PageFactory.initElements(driver, MagentoAdminPanelHomePage.class);
		MagentoAdminPanelInvoicesPage mapip = new MagentoAdminPanelInvoicesPage(driver);
		
		blp.navigateToBackendLoginPage();
		blp.enterUsername("user01");
		blp.enterpassword("guru99com");
		blp.clickOnLoginBtn();
		
		maphp.closePopup();
		maphp.MoveCursorToSales();
		maphp.clickOnInvoicesMenu();
		
		String sdate1 = mapip.getInvoiceDateColumnFirstCellValue();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
		
		Date date1 = sdf1.parse(sdate1);
		
		String sdate2 = mapip.getInvoiceDateColumnSecondCellValue();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
		
		Date date2 = sdf2.parse(sdate2);
		
		if(date1.after(date2))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		mapip.clickOnInvoicesDatecolumn();
		
		String sdate3 = mapip.getInvoiceDateColumnFirstCellValue();
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
		
		Date date3 = sdf3.parse(sdate3);
		
		String sdate4 = mapip.getInvoiceDateColumnSecondCellValue();
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
		
		Date date4 = sdf4.parse(sdate4);
		
		if(date3.before(date2))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
