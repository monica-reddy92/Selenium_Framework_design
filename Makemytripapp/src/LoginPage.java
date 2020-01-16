package com.makemytrip.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.util.TestUtil;

public class LoginPage extends TestBase
{
	

	@FindBy(xpath="//p[contains(text(),'Login or Create Account')]")
	WebElement loginOption;
	
	@FindBy(id="username")
	WebElement emailID;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//p[contains(text(),'Login or Create Account')]")
	WebElement loginElement;
	
	@FindBy(xpath="//img[@alt='Make My Trip']")
	WebElement loginPageLogo;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	WebElement continuebtn;
	
	@FindBy(xpath="//button[@data-cy=\"login\"]")
	WebElement loginbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//page actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateMakemyTripImage()
	{
		return loginPageLogo.isDisplayed();
	}
	WebDriverWait wait = new WebDriverWait(driver,20);
	public FlightsPage login(String un, String pwd)
	{
		loginOption.click();
		emailID.sendKeys(un);
		wait.until(ExpectedConditions.visibilityOf(continuebtn)).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", continuebtn); 
		password.sendKeys(pwd);
		loginbtn.click();
		return new FlightsPage();
}
}





