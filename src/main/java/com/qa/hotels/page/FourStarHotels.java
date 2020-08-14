package com.qa.hotels.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class FourStarHotels  extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	HomePage homePage;	
	By  fourstar =By.id("f-star-rating-4");
	By  fifthstar =By.id("f-star-rating-5");
	By distance = By.linkText("Distance");
	By citycenter = By.xpath("//a[text()='City center']");
	By hotelMiles = By.linkText("//ul[@class='property-landmarks']/li[contains(text(),'City center')]");




	public FourStarHotels(WebDriver driver) {
	this.driver=driver;
	elementUtil =new ElementUtil(driver);

	javaScriptUtil=new JavaScriptUtil(driver);
	}
	public void fourStarCityCenter() throws InterruptedException {
		elementUtil.doClick(fifthstar);
		Thread.sleep(5000);
		elementUtil.moveToElement(distance,citycenter);
		for (int second =0;;second++) {
		if (second>=60) {
		break;	
		}
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
	}	
	List<WebElement> hotelNames = driver.findElements(By.xpath("//*[@class='hotel-wrap']//h3"));
	List<WebElement> miles = driver.findElements(hotelMiles);
	for (int i = 0; i < hotelNames.size(); i++) {

	String text = miles.get(i).getText();
	String hotelMilesr=text.substring(0,3);
	double radius = Double.parseDouble(hotelMilesr);

	if (radius<10) {
		System.out.println("five stars hotels: " +hotelNames.get(i).getText() + " " + radius);
	}
	}


	}
	public FiveStarHotels gotoFiveStarHotels() throws InterruptedException {
		fourStarCityCenter();
		return new FiveStarHotels(driver);
	

}
}
	
