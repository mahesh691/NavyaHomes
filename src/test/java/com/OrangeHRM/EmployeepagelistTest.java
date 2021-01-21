package com.OrangeHRM;

import org.testng.annotations.Test;
import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Page.Employeelistpage;
import com.Page.HomePage;
import com.Page.LoginPage;
import com.Page.addemployeepage;
import com.Testbase.Testing;
import com.Utility.Log;

public class EmployeepagelistTest extends Testing {

	HomePage HomePage;
	LoginPage LoginPage;
	addemployeepage addemployeepage;
	Employeelistpage Employeelistpage;
	public EmployeepagelistTest() {
		super(); 
	}
	
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		HomePage=new HomePage();
		LoginPage= new LoginPage();
		Employeelistpage=new Employeelistpage();
		Log.info("orange hrm launched successfully");
		Test=reports.createTest("Employee page test");	
		LoginPage.loginPagevalid(prop.getProperty("username"), prop.getProperty("password"));
		Test.pass("successfully login page ");
	}
	
	@Test(priority = 1)
	public void addempleelistlabletest() throws InterruptedException {
		HomePage.clickonaddemployeelist();

		System.out.println(Employeelistpage.addemplistlabel());
	}


	@Test(priority = 2)
	public void empleelistTest() throws InterruptedException, IOException {
		HomePage.clickonaddemployeelist();
		Thread.sleep(10000);
		Employeelistpage.getelistOfEmployees("emp");
	}
	
	@AfterTest
	public void teardown() {
		reports.flush();
		driver.close();
	}
}
