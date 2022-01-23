package com.test.features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.utils.BaseClass;

public class Feature_ShoppingCart 
{
	
	BaseClass baseClass = new BaseClass();  
	Feature_LoginPage loginPage = new Feature_LoginPage(); 
	Feature_UserRegister userRegister = new Feature_UserRegister();
	Feature_ComputersSection computerSection = new Feature_ComputersSection();
	WebElement targetWebElem_Computers;
	
	JavascriptExecutor js = (JavascriptExecutor) baseClass.chromeDriver;

	
	@BeforeClass
	public void before_ComputersVal()
	{
		   baseClass.invokeBrowser();
		   BaseClass.OpenApplication();
		  try
		  {
			  userRegister.validate_UserRegister();
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception is "+e);
			  loginPage.validate_LoginPage();
		  }
		  computerSection.validate_ComputerSection();
           
	}
	
	
  @Test
  public void validate_ShoppingCart() throws InterruptedException 
  {
	 
	  Thread.sleep(8000);

	//  baseClass.chromeDriver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();
		  
	  	  
	targetWebElem_Computers = baseClass.chromeDriver.findElement(By.xpath("//li[@id='topcartlink']"));
	
	
	baseClass.naviagetToWebElem(targetWebElem_Computers);
	
	String quant_ShoppingCart =  baseClass.chromeDriver.findElement(By.xpath("//span[@class='cart-qty']")).getText();
	
	baseClass.softassert.assertEquals(quant_ShoppingCart, "1");
	 
	String unit_price = baseClass.chromeDriver.findElement(By.xpath("//div[@class='price']")).getText();
	 
	baseClass.softassert.assertEquals(unit_price, "$1,259.00");

	baseClass.chromeDriver.findElement(By.xpath("//button[normalize-space()='Go to cart']")).click();
	
	
	baseClass.chromeDriver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	
	baseClass.chromeDriver.findElement(By.xpath("//button[@id='checkout']")).click();


	 
  }
}
