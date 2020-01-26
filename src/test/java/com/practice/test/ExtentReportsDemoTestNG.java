package com.practice.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoTestNG {
	static WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	public static String browserName=null;
	public static JSONObject empjsonobject;

	@BeforeSuite
	public void setup() throws IOException, ParseException {

		htmlReporter = new ExtentHtmlReporter("extent1.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader(".\\src\\main\\resources\\Employee.json");

		Object obj = jsonparser.parse(reader);
		empjsonobject = (JSONObject) obj;
		
		String fname=(String) empjsonobject.get("firstName");
		String lname=(String) empjsonobject.get("lastName");

	}

	@BeforeTest
	public void setupTest() {
		
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")){

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		

	}
	
	else if(browserName.equalsIgnoreCase("firefox")){
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	}

	@Test
	public void test1() throws IOException, InterruptedException {
		
		//String users[]=data.split(",");

		driver.get("http://www.facebook.com");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("email")).sendKeys((String)empjsonobject.get("firstName"));
		driver.findElement(By.id("pass")).sendKeys((String)empjsonobject.get("lastName"));
		
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");

	}

	/*@Test
	public void test2() throws IOException {
		driver.navigate().to("http://www.facebook.com");
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");

	}*/
	@AfterTest
	public void tearDownTest() {

		// calling flush writes everything to the log file
		PropertiesFile.setProperties();
		driver.close();
		driver.quit();
		

	}
	@AfterSuite
	public void tearDown() {

		// calling flush writes everything to the log file
		extent.flush();

	}
	
	/*@DataProvider(name="dp")
	public String[] readJson() throws IOException,ParseException{
	
	JSONParser jsonparser = new JSONParser();

	FileReader reader = new FileReader(".\\src\\main\\resources\\TestData.json");

	Object obj = jsonparser.parse(reader);
	JSONObject userLoginJsonObj = (JSONObject) obj;
	
	JSONArray userLoginsArray=(JSONArray)userLoginJsonObj.get("userLogins");
	
	String arr[]=new String[userLoginsArray.size()];
	
	for(int i=0;i<userLoginsArray.size();i++){
		
		JSONObject users=(JSONObject)userLoginsArray.get(i);
		String user=(String)users.get("username");
		String pass=(String)users.get("password");
		
		arr[i]=user+","+pass;
	}
	
	return arr;
}*/
}
