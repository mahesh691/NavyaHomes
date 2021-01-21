package com.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Testbase.Testing;

public class LoginPage extends Testing {
	
	@FindBy(id = "txtUsername")
	WebElement un;
	@FindBy(id = "txtPassword")
	WebElement pwd;
	@FindBy(id = "btnLogin")
	WebElement login;
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/img")
	WebElement logo;
	@FindBy(id = "welcome")
	WebElement welcome;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/ul/li[3]/a")
	WebElement logout;
	public  LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public  boolean logoValid() {
		return logo.isDisplayed();
	}
	
	public String loginPagetitle() {
		return driver.getTitle();
	}
	
	public  HomePage loginPagevalid(String username,String password) throws InterruptedException {
		Thread.sleep(2000);
		un.sendKeys(username);
		pwd.sendKeys(password);
		Thread.sleep(2000);
		login.click();
		
		return new HomePage();
	}
	
	public void logout() throws InterruptedException {
		welcome.click();
		Thread.sleep(1000);
		logout.click();
	}
	
	
}
