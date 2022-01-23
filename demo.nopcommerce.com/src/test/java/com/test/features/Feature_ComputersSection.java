package com.test.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.utils.BaseClass;

public class Feature_ComputersSection 
{
	BaseClass baseClass = new BaseClass();  
	Feature_LoginPage loginPage = new Feature_LoginPage(); 
	Feature_UserRegister userRegister = new Feature_UserRegister();
	WebElement targetWebElem_Computers;
	
	@BeforeClass
	public void before_ComputersVal()
	{
		   baseClass.invokeBrowser();
		   baseClass.OpenApplication();
		   //userRegister.validate_UserRegister();
		  loginPage.validate_LoginPage();
	}
  
	//@Parameters({"targetWebElem_Computers"})
	@Test
	public void validate_ComputerSection()
	{
		
		targetWebElem_Computers = baseClass.chromeDriver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
		
		baseClass.naviagetToWebElem(targetWebElem_Computers);
		
		baseClass.chromeDriver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")).click();
		
		baseClass.chromeDriver.findElement(By.xpath("//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")).click();
		
	//	baseClass.chromeDriver.findElement(By.xpath("//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")).click();

		
	
	}
}
