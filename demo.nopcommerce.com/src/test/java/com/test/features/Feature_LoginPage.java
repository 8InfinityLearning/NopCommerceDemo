package com.test.features;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.utils.*;


public class Feature_LoginPage extends BaseClass
{

	Feature_LoginPage loginPage ;  
	boolean userSuccessfulLogin ;


	   @BeforeClass
	   public void before_RegisterVal()
	   {
		   invokeBrowser();
		  OpenApplication();
		   loginPage = new Feature_LoginPage();

	   }
		
  
	   @Test
  		public void openLoginPage() 
	   {
		
		   loginPage.chromeDriver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
   		   
	   }
	   
	   @Test
	   public void validate_LoginPage()
	   {
		   openLoginPage();
		   
		   loginPage.chromeDriver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Infinity1@Learning.com");;
		   
		   loginPage.chromeDriver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678088");
		   
		   loginPage.chromeDriver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

		   userSuccessfulLogin = loginPage.chromeDriver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).isDisplayed(); 
		 
		   //loginPage.softassert.assertEquals(userSuccessfulLogin, true);


	   }
	}
