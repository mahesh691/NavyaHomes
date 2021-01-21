package com.OrangeHRM;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.Page.HomePage;
import com.Page.LoginPage;
import com.Page.addemployeepage;
import com.Testbase.Testing;
import com.Utility.Log;
import com.Utility.TestUtil;

public class AddemployeePageTest extends Testing {
	HomePage HomePage;
	LoginPage LoginPage;
	addemployeepage addemployeepage; 
	
	public AddemployeePageTest() {
		super(); 
	}
	
	
	@BeforeTest
	public void setup() throws InterruptedException { 
		initialization();
		HomePage=new HomePage();
		LoginPage= new LoginPage();
		Log.info("orange hrm launched successfully");
		Test=reports.createTest("addemployee page  test");	
		LoginPage.loginPagevalid(prop.getProperty("username"), prop.getProperty("password"));
		Test.pass("successfully login page ");
		
	}
	@Test(priority = 1)
	public void verifyemployeepagelbeltest() throws InterruptedException   {
		addemployeepage=HomePage.clickonaddemployee();
		Thread.sleep(5000);
		String adelabel=addemployeepage.verifyaddemployeelabel();
		if(adelabel.equals("Add Employee")){
			Test.pass("successfully addemplyeepage opened:");
			Log.info("successfully  addemplyeepage opened:");
		}else {
			Assert.fail("failed to addemplyeepage opened:");
			Log.info("failed to addemplyeepage opened:");
		}
		
	}
	
	@DataProvider
	public Object[][] getaddempdata() throws IOException{
		
		Object[][] data=TestUtil.getTestData("OHRMaddE");
		return data;
		
	}
	@Test(priority = 2, dataProvider  = "getaddempdata")
	public void addemployeepagetest(String fn1,String ln1) throws InterruptedException  {
		HomePage.clickonaddemployee();
		addemployeepage.createNewEmployee(fn1, ln1);
		HomePage.clickonaddemployee();
		Test.pass(fn1+" success");
		
	}
	
	

	@AfterTest
	public void tearDown() {
		reports.flush();
		driver.close();
	}	
}
