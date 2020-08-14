package com.qa.hotels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;





public class HomePage extends BasePage {


WebDriver driver;
ElementUtil elementUtil;



By dest = By.id("qf-0q-destination");
By checkin =By.id("qf-0q-localised-check-in") ;

By checkOut = By.xpath("//input[@id='qf-0q-localised-check-out']");
By room = By.id("qf-0q-rooms");

By adults =By.xpath("//select[@id='qf-0q-room-0-adults']");


By child=By.xpath("//select[@id='qf-0q-room-0-children']");
By child1=By.xpath("//select[@id='qf-0q-room-0-child-0-age']");
By child2 = By.xpath("//select[@name='q-room-0-child-1-age']");

By searchBtn = By.xpath("//button[@type='submit']");

public HomePage(WebDriver driver) {
	this.driver = driver;
	elementUtil = new ElementUtil(driver);
}
public String getPageTitle(){
	return elementUtil.doGetPageTitle();
}
public ThreeStarHotels fillUpMyInformation() {
//driver.findElement(text).click();
elementUtil.doSendKeys(dest,"Boston, Massachusetts, United States of America" );
elementUtil.doSendKeys(checkin,"08/02/2020 ");
elementUtil.doSendKeys(checkOut, "08/03/2020");

elementUtil.selectDropdownByVisibleText(driver, room, "1");	
elementUtil.selectDropdownByVisibleText(driver, adults, "2");	
elementUtil.selectDropdownByVisibleText(driver, child, "2");

elementUtil.selectDropdownByVisibleText(driver, child1, "4");
elementUtil.selectDropdownByVisibleText(driver, child2,"9");

//Thread.sleep(2000);
elementUtil.doClick(searchBtn);
//WebElement element =driver.findElement(Search);
//element.click();

return new ThreeStarHotels(driver);	
}	
public ThreeStarHotels  gotoThreeStarHotels(){
	fillUpMyInformation();
	
	return new ThreeStarHotels(driver);


	 


	
}

}
