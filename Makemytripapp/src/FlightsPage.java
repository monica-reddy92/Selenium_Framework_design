package com.makemytrip.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.qa.base.TestBase;

public class FlightsPage extends TestBase {

	@FindBy(xpath="//p[@data-cy='loggedInUser']")
	public WebElement welcomeText;
	
	@FindBy(xpath="//p[@data-cy='returnDefaultText']")
	WebElement returnDate;
	
	@FindBy(xpath="//li[@data-cy='oneWayTrip']")
	public WebElement oneWayradioBtn;
	
	
	public FlightsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//page actions
		public String validateFlightsPageTitle()
		{
			return driver.getTitle();
		}
	
		public String validateFlightsPageUserName()
		{
			return welcomeText.getText();
		}
	
		public String getReturnDateValue()
		{
			return returnDate.getText();
		}
}
