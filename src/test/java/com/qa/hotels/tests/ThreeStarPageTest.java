package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ThreeStarHotels;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;

public class ThreeStarPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ThreeStarHotels ThreeStarHotels;
    ElementUtil elementUtil ;
	
		
	
	@BeforeTest
	public void setUp() throws InterruptedException{
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName= prop.getProperty("browser");
	driver = basePage.init_driver(browserName);
	
	driver.get(prop.getProperty("url"));
	homePage = new HomePage(driver);
	ThreeStarHotels = homePage.fillUpMyInformation();
	ThreeStarHotels = new ThreeStarHotels(driver);	


}

@Test(priority=1)
public void verifyHomePageTitleTest()  {
	//Thread.sleep(5000);
	String title = homePage.getPageTitle();
	System.out.println("Three hotels Page Title is :" + title);
	
	Assert.assertEquals(title,AppConstants.THREESTARSHOTEL_PAGE_TITLE);
	
}
@Test(priority=2)
public void verifyselectMyInformationTest() {
	ThreeStarHotels.selectmyInformatin();
}
@Test(priority=3 , enabled=true)
public void verifymyHiltonsTest() throws InterruptedException {
	ThreeStarHotels.myHiltonsAvailables();
	
}

@AfterTest
public void tearDown() {
	driver.quit();
	

}

}
	
	
	
