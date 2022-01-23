package com.test.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.utils.BaseClass;

public class Feature_UserRegister 
{
	BaseClass baseClass = new BaseClass();  
	WebElement dropdownElem ;
	boolean userSuccessfulRegis ;
	Feature_LoginPage loginPage = new Feature_LoginPage();
	
   @BeforeClass
   public void before_RegisterVal()
   {
	   baseClass.invokeBrowser();
	   baseClass.OpenApplication();
   }
	
   @Test
   public void navigateTo_RegisterPage() 
  {
	   System.out.println("This is Demo");
	   baseClass.chromeDriver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();;
  }
   
   @Test
   public void validate_UserRegister()
   {
	   navigateTo_RegisterPage();
	   baseClass.chromeDriver.findElement(By.xpath("//input[@id='gender-male']")).click();
	   baseClass.chromeDriver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Infinity");
	   baseClass.chromeDriver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Learning");
	   
	   dropdownElem = baseClass.chromeDriver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
	   
	   baseClass.selectDropDownVal(dropdownElem, 8);
	   
	   dropdownElem = baseClass.chromeDriver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));

	   baseClass.selectDropDownVal(dropdownElem, 8);

	   dropdownElem = baseClass.chromeDriver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));

	   baseClass.selectDropDownVal(dropdownElem, 8);
	   
	   baseClass.chromeDriver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Infinity1@Learning.com");
	   
	   baseClass.chromeDriver.findElement(By.xpath("//input[@id='Password']")).sendKeys("12345678088");

	   baseClass.chromeDriver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("12345678088");

	   baseClass.chromeDriver.findElement(By.xpath("//button[@id='register-button']")).click();

   try {
	   userSuccessfulRegis = baseClass.chromeDriver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).isDisplayed();
	   
	   baseClass.softassert.assertEquals(userSuccessfulRegis, true);
   }
   catch(Exception e)
   {
	   System.out.println(e);
	   loginPage.validate_LoginPage();
   }
   }
   
}
