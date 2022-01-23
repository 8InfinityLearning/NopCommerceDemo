package com.test.features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.utils.BaseClass;

public class Feature_CheckOutPage 
{
	BaseClass baseClass = new BaseClass();  
	Feature_LoginPage loginPage = new Feature_LoginPage(); 
	Feature_UserRegister userRegister = new Feature_UserRegister();
	Feature_ComputersSection computerSection = new Feature_ComputersSection();
	Feature_ShoppingCart shoppingCart = new Feature_ShoppingCart();
	WebElement targetWebElem_Computers;
	
	@BeforeClass
	public void before_ComputersVal() throws InterruptedException
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
		  shoppingCart.validate_ShoppingCart();
	}
  @Test
  public void validate_CheckoutFeature() throws InterruptedException 
  {
  
	
	   boolean banner_BillingAddress= loginPage.chromeDriver.findElement(By.xpath("//li[@id='opc-billing']//div[@class='step-title']")).isDisplayed();
	   
	   loginPage.softassert.assertEquals(banner_BillingAddress, true);
	   try 
	   {
	   loginPage.chromeDriver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("Infinity");
	   
	   targetWebElem_Computers =   loginPage.chromeDriver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
	   
	   loginPage.selectDropDownVal(targetWebElem_Computers, 133);
	   
	   loginPage.chromeDriver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Infinity City");

	   loginPage.chromeDriver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("#8, 8088");

	   loginPage.chromeDriver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("55555");
	   
	   loginPage.chromeDriver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("1234567890");
	   
	   loginPage.chromeDriver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();
	   
	   }
	   catch(Exception e)
	   {
		 
		   loginPage.chromeDriver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();

		   System.out.println(e);
	   }
	   
	   Thread.sleep(3000);
	   
	   loginPage.chromeDriver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]")).click();
	   
	   loginPage.chromeDriver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
	   
	   Thread.sleep(3000);
	   
	   loginPage.chromeDriver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]")).click();

	   Thread.sleep(3000);

	   loginPage.chromeDriver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]")).click();

	   //Thread.sleep(8000);
	   
	   WebDriverWait wait2 = new WebDriverWait(loginPage.chromeDriver, 1000);
	   
	   wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("xpath_of_element_to_be_invisible")));
	   
	   loginPage.chromeDriver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]")).click();

	   //loginPage.chromeDriver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]")).click();

	   loginPage.chromeDriver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();

	   
  }
}
