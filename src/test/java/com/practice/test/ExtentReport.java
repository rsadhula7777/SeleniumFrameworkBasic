package com.practice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	
	static WebDriver driver=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extentReports.html");
		
		//craete extent reporter & attach
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test=extent.createTest("MyFirstTest", "Google");
		
		WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
	     
	     test.log(Status.INFO, "Starting TestCase");
	     
	     driver.get("https://www.google.com");
	     test.pass("landed in google page");
	     
	     extent.flush();
		
		
		
		

	}

}
