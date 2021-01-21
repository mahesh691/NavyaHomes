package com.OrangeHRM; 

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.Page.Employeelistpage;
import com.Page.HomePage;
import com.Page.LoginPage;
import com.Page.addemployeepage;
import com.Testbase.Testing;
import com.Utility.Log;

public class HomePageTest extends Testing{
	HomePage HomePage;
	LoginPage LoginPage;
	addemployeepage addemployeepage;
	Employeelistpage Employeelistpage;
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		HomePage=new HomePage();
		LoginPage= new LoginPage();
		Log.info("orange hrm launched successfully");
		Test=reports.createTest("HOme page test");	
		LoginPage.loginPagevalid(prop.getProperty("username"), prop.getProperty("password"));

		}
	@Test(priority = 1)
	public void homepagevalidatioontest() {
		Assert.assertEquals(HomePage.homepagevalidation(), "Welcome Admin", "not matched welcome page");
		Test.pass("successfully opened homePage ");
		Log.info("successfully opened homePage ");

	}
	@Test(priority = 2)
	public void adminPAgeTest() {
		HomePage.clickonadmin();
		Test.pass("successfully opened  admin");
		Log.info("successfully opened  admin");

	}
	
	@Test(priority = 3)
	public void pimPageTest() {
		HomePage.clickonpim();
      	Test.pass("successfully opened pim");
		Log.info("successfully opened pim");

	}
	
	@Test(priority = 4)
	public void recruitementPageTest() {
		HomePage.clickonrecruitement();
		Test.pass("successfully opened recruitement");
		Log.info("successfully opened recruitement");

	}
	
	@Test(priority = 5)
	public void verifyaddemployeetest() throws InterruptedException {
		addemployeepage = HomePage.clickonaddemployee();
		Thread.sleep(10000);
		Test.pass("successfully opened add employee");
		Log.info("successfully opened add employee");

	}
	
	@Test(priority = 6)
	public void verifyemployeelistTest() throws InterruptedException {
		Employeelistpage = HomePage.clickonaddemployeelist();
		Test.pass("successfully opened employeelist");
		Log.info("successfully opened employeelist");

	}
	
	
	@AfterTest
	public void tearDown() {
		reports.flush();
		driver.quit();
	}
	
	
	
}
