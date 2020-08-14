package com.qa.hotels.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class ThreeStarHotels extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	HomePage homePage;	
		
	By star3 = By.xpath("//input[@id='f-star-rating-3']");
	By distance = By.xpath("//a[text(),'Distance']");
	By hotel = By.xpath("//div[@class='description rep-module']");
	By cityCenter = By.xpath("//a[text(),'City center']");
	By nameCont = By.xpath("//input[@id='f-name']");
	By arrowclick = By.xpath("//button[@id='f-name-cta']");
	By destination = By.xpath("//a[@data-menu= 'sort-submenu-distance");
	By Hilton = By.xpath("//a[contains(text(),'Hilton')]");
	By miles = By.xpath("//ul[class='property-landmarks']/li[contaoins(text(),'City center')]");	
		
		
		
		
		
			
	public ThreeStarHotels(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	public String getTitleThreeStars() {
		return elementUtil.waitForGetPageTitle(AppConstants.THREESTARSHOTEL_PAGE_TITLE);
		

		}
	public void selectmyInformatin() {
	elementUtil.waitForElementVisible(star3);
	elementUtil.doClick(star3);
	elementUtil.waitForElementPresent(distance);
	elementUtil.moveToElement(distance, Hilton);
	elementUtil.waitForElementPresent(cityCenter);
	elementUtil.doClick(cityCenter);
	elementUtil.doClick(arrowclick);
	}
	public void myHiltonsAvailables()  {
		
		By hotelMiles = By.xpath("//ul[@class='property-landmarks']/li[contains(text(), 'City center')]");
		elementUtil.doClick( star3);
		//Thread.sleep(3000);
		elementUtil.moveToElement(distance, hotelMiles);
		for(int second = 0;; second++){
			if(second >=60){
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
			//Thread.sleep(3000);
		}	
		List<WebElement> hotelNames = driver.findElements(By.xpath("//*[@class='hotel-wrap']//h3"));
		List<WebElement> miles = driver.findElements(hotelMiles);
		for (int i = 0; i < hotelNames.size(); i++) {
		
		String text = miles.get(i).getText();
		String hotelMilesr=text.substring(0,3);
		double radius = Double.parseDouble(hotelMilesr);
		
		if (radius<10) {
			System.out.println("Three stars hotels: " +hotelNames.get(i).getText() + " " + radius);
		}
		}
		 if(hotelNames.contains(Hilton)) {
			 System.out.println(hotel);
			  
		 }else {
			 System.out.println("Hilton is not available");
		 }
	 }
	public void selectmyDestination() {
		// TODO Auto-generated method stub
		
	}


	public FourStarHotels gotoFourStarHotels() {
		// TODO Auto-generated method stub
		return null;
	}
 
}
	

	
