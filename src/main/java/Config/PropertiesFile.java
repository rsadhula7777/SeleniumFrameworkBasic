package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.practice.test.ExtentReportsDemoTestNG;

public class PropertiesFile {
	
	static String projectpath=System.getProperty("user.dir");
	static Properties prop=new Properties();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getProperties();
		setProperties();
		getProperties();
		

	}
	
	public static void getProperties(){
		
		
		
		
		
		try {
			
			
			InputStream input=new FileInputStream(projectpath+"/src/main/java/config/config.properties");
			prop.load(input);
			String browser=prop.getProperty("browser");
			System.out.println(browser);
			ExtentReportsDemoTestNG.browserName=browser;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setProperties(){
		
		try {
			OutputStream output=new FileOutputStream(projectpath+"/src/main/java/config/config.properties");
			/*prop.setProperty("browser","firefox");
			prop.setProperty("result", "pass");*/
			try {
				prop.store(output,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
