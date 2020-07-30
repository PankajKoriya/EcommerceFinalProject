package com.ecommerce.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.pages.BackendLoginPage;
import com.ecommerce.pages.BaseClass;
import com.ecommerce.pages.MagentoAdminPanelHomePage;
import com.ecommerce.pages.MobileDetailPage;
import com.ecommerce.pages.MobilePage;
import com.ecommerce.pages.PendingReviewEditPage;
import com.ecommerce.pages.PendingReviewPage;
import com.ecommerce.pages.ProductReviewPage;

public class VerifyProductReviewMechanism extends BaseClass{
	
	@Test
	public void productReviewMechanism() throws InterruptedException
	{
		logger = extent.createTest("Verify Product Review Mechanism");
		
		ProductReviewPage prp = new ProductReviewPage(driver);
		BackendLoginPage blp = PageFactory.initElements(driver, BackendLoginPage.class);
		MagentoAdminPanelHomePage maphp = PageFactory.initElements(driver, MagentoAdminPanelHomePage.class);
		PendingReviewPage previewp = new PendingReviewPage(driver);
		PendingReviewEditPage prep = new PendingReviewEditPage(driver);
		MobileDetailPage mdp = new MobileDetailPage(driver);
		MobilePage mp = new MobilePage(driver);
		
		prp.goToProductReviewPage();
		String userSummary = prp.fillReviewAndSubmit("This is my thoughts about this product", "Simply summary", "Ohh god");
		
		blp.navigateToBackendLoginPage();
		blp.enterUsername("user01");
		blp.enterpassword("guru99com");
		blp.clickOnLoginBtn();
		
		maphp.closePopup();
		maphp.moveCursorToCatalog();
		maphp.moveCursorToReviewAndRatings();
		maphp.moveCursorToCustomerReview();
		maphp.clickOnPendingReviewsMenu();
		
		previewp.clickOnEditLink();
		
		prep.selectStatus("Approved");
		prep.clickOnSaveReview();
		
		driver.get("http://live.demoguru99.com/");
		mp.clickOnMobileMenu();
		mp.clickOnXperiaImg();
		
		Thread.sleep(3000);
		mdp.clickOnReviewsTab();
		String reviewSummary = mdp.getReviewSummary();
		
		Assert.assertTrue(reviewSummary.equalsIgnoreCase(userSummary));
		
	}

}
