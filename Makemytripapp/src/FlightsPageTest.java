package com.makemytrip.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.pages.FlightsPage;
import com.makemytrip.qa.pages.LoginPage;

public class FlightsPageTest extends TestBase {

	LoginPage loginPage;
	FlightsPage flightsPage;
	WebDriverWait wait;
	
	public FlightsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		flightsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		wait = new WebDriverWait(driver,50);
	}
	
	@Test(priority=1)
	public void FlightsPageTitleTest(){
		wait.until(ExpectedConditions.textToBePresentInElement(flightsPage.welcomeText,"Hey Traveller"));
		String title = flightsPage.validateFlightsPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
	}
	
	@Test(priority=2)
	public void FlightsPageUserNameTest(){
		wait.until(ExpectedConditions.textToBePresentInElement(flightsPage.welcomeText,"Hey Traveller"));
		String userName = flightsPage.validateFlightsPageUserName();
		System.out.println(userName);
		Assert.assertEquals(userName, "Hey Traveller");
	}
	
	@Test(priority=3)
	public void verifyReturnStatusForOneWayTest()
	{
	wait.until(ExpectedConditions.textToBePresentInElement(flightsPage.welcomeText,"Hey Traveller"));
	flightsPage.oneWayradioBtn.click();
	Assert.assertEquals(flightsPage.getReturnDateValue(),"Tap to add a return date for bigger discounts");
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
