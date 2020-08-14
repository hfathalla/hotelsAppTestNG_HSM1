package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.FiveStarHotels;
import com.qa.hotels.page.FourStarHotels;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ThreeStarHotels;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;

public class FourStarPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ElementUtil elementUtil;
	ThreeStarHotels threeStarHotels;
	FourStarHotels fourStarHotels;
	FiveStarHotels fiveStarHotels;

	@BeforeTest
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
	prop = basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
	
		driver.get(prop.getProperty("url"));
	homePage = new HomePage(driver);
        threeStarHotels =homePage.gotoThreeStarHotels();
		threeStarHotels=new ThreeStarHotels(driver);

		threeStarHotels =homePage.gotoThreeStarHotels();
		threeStarHotels=new ThreeStarHotels(driver);
	
		fourStarHotels=threeStarHotels.gotoFourStarHotels();
	fourStarHotels=new FourStarHotels(driver);
	

	}

	
	@Test(priority=2)
	public void verifyFourStarCityCenter() throws InterruptedException {
		fourStarHotels.fourStarCityCenter();
	}
	@AfterTest
    public void tearDown() {
		driver.quit();
	}

		
		

	}

	  
