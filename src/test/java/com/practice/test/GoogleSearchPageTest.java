package com.practice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.practice.pages.GoogleSearchPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPageTest {
	
	static  WebDriver driver=null;
    
	@BeforeTest
	public void setUpTest() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
	   
	}
	
	@Test
	public static void googleSearchTest() throws InterruptedException{
		
		
		 
	    driver.get("https://www.google.com");
	    GoogleSearchPageObjects gsp=new GoogleSearchPageObjects(driver);
	    
	    gsp.setTextInSearchBox("A B C D");
	    Thread.sleep(3000);
	    gsp.clickSearchButton();
	    
	   
	}
	
	@AfterTest
	public void tearDown(){
		
		 driver.close();
		 driver.quit();
		
		
	}

}
