package com.test.utils;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseClass 
{

	public static WebDriver chromeDriver;
	public static Select selectDropdown;
	
	public SoftAssert softassert = new SoftAssert();
	
	public	Actions actions ;
	
  @Test
  public static void OpenApplication() 
  {
	  chromeDriver.manage().window().maximize();
	  chromeDriver.get("https://demo.nopcommerce.com/");
  }
	
  @BeforeMethod
  public void invokeBrowser() 
  {
	  System.setProperty("webdriver.chrome.driver", "src//main//resources//drivers//chromedriver.exe");
	  
	  chromeDriver = new ChromeDriver();
  }

  @AfterMethod
  public void closeBrowser() 
  {
	  chromeDriver.close();
  }

  public void selectDropDownVal(WebElement dropdownElem, int webElementRef)
  {
	  selectDropdown = new Select(dropdownElem);
	  selectDropdown.selectByIndex(webElementRef);
  }
  
  public void naviagetToWebElem(WebElement targetWebElem) 
	{
	  actions  = new Actions(chromeDriver);
	  actions.moveToElement(targetWebElem).build().perform();

	}
  
  
}
