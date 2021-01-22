package com.OrangeHRM;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Library.GetDateCurrent;
import com.Page.LoginPage;
import com.Testbase.Testing;
import com.Utility.Log;
import com.Utility.TestUtil;

public class LoginPageTest extends Testing{
	LoginPage LoginPage;
	

public LoginPageTest() {
	super();
	}
	
@BeforeTest
	public void setup() throws IOException {
		initialization();
		
		LoginPage= new LoginPage();
		Log.info("orange hrm launched successfully");
		Test=reports.createTest("login test");
		
	}
	
	@Test(priority = 1)
	public void loginPageLogoTest() {
		System.out.println("bbbbbbbbbbbbbbbbb");
		boolean flag=LoginPage.logoValid();
		Log.info("logo image display status :"+cureentDate+flag);
		Test.pass("logo image display status :"+flag);
		
	}
	
	@Test(priority = 2)
	public void loginPagevalidtest() {
		String title=LoginPage.loginPagetitle();
		
		Assert.assertEquals("OrangeHRM", title);
		Log.info("loginpage successfully validate of page title");
		Test.pass("loginpage successfully validate of page title");
		
	}
	
	@DataProvider
	public Object[][] getDATA() throws IOException {
		Object data[][]=TestUtil.getTestData("OrangeHRM");
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getDATA")
	public void logintest(String un1, String pw2) throws InterruptedException, IOException {
		
		LoginPage.loginPagevalid(un1, pw2);
		String currenturl=driver.getCurrentUrl();
		if(currenturl.contains("dashboard")) {
			Log.info("successfully login in to homepage");
			Test.pass("successfully login in to homepage");
			LoginPage.logout();
			
			}else {
			Log.info("failed to login to homepage");
			
			TakesScreenshot	ts=(TakesScreenshot)driver;
			File bing_ScreenShot=ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(bing_ScreenShot,new File("E:\\JavaProgrammes\\Home\\mahesh\\ss\\"+getDate()+".png"));
				
				
			}

	}
	
	
	
	@AfterTest
	public void tearDown() {
		reports.flush();
		driver.quit();
	}
	
	
	
}
