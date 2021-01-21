package com.Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Testing {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports reports;
	public static ExtentTest Test;
	public static String cureentDate=null;
	
	public Testing() { 
		try {
			FileInputStream file= new FileInputStream("E:\\JavaProgrammes\\Home\\mahesh\\src\\main\\java\\com\\Config\\config.properties");
			prop=new Properties();
			prop.load(file);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driverfiles/geckodriver.exe");
			driver = new FirefoxDriver();
		}	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		String urlapp=prop.getProperty("url");
		driver.get(urlapp);
		
	}
	
	public static  String getDate() {
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy:hh:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}
	
	
		
	@BeforeSuite
	public void  extentReports() {
		  
		ExtentHtmlReporter extent=new ExtentHtmlReporter("./reports/file.html");
		reports=new ExtentReports();
		reports.attachReporter(extent);
		extent.config().setChartVisibilityOnOpen(true);
		extent.config().setDocumentTitle("extent report demo");
		extent.config().setReportName("test report");
		extent.config().setTestViewChartLocation(ChartLocation.TOP);
		extent.config().setTheme(Theme.STANDARD);
		
		
		reports.setSystemInfo("os", "windows");
		reports.setSystemInfo("browser", "firefox");
		
		
			}
	
	
	}