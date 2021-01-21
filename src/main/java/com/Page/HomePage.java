package com.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Testbase.Testing;

public class HomePage extends Testing{
@FindBy(id = "welcome")
WebElement wc;
@FindBy(id = "menu_admin_viewAdminModule")
WebElement admin;

@FindBy(id = "menu_pim_viewPimModule")
WebElement pim;

@FindBy(id = "menu_pim_addEmployee")
WebElement adde;

@FindBy(id = "menu_pim_viewEmployeeList")
WebElement addelist;
@FindBy(id = "menu_recruitment_viewRecruitmentModule")
WebElement rec;
	
public HomePage() {
	PageFactory.initElements(driver, this);
}

public String homepagevalidation() {
	return wc.getText();
}
	
	public adminPage clickonadmin() {
		admin.click();
return new adminPage();
}
		
	public pimPage clickonpim() {
		pim.click();
return new pimPage();
}
	
	public addemployeepage clickonaddemployee() throws InterruptedException {
		Actions act1=new Actions(driver);
		Thread.sleep(10000);
		act1.moveToElement(pim).perform();
//		Thread.sleep(10000);
		adde.click();
		Thread.sleep(10000);

return new addemployeepage();
}
	

	public Employeelistpage clickonaddemployeelist() throws InterruptedException {
		Actions act2=new Actions(driver);
		act2.moveToElement(pim).perform();
		Thread.sleep(10000);
		addelist.click();
return new Employeelistpage();
}
	public recruitementPage clickonrecruitement() {
		rec.click();
return new recruitementPage();
}
}
