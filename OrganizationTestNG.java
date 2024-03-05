package vTigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class OrganizationTestNG extends BaseClass {
	
	public WebDriver driver;

	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
	
	@Test
	public void OrganizationTest() throws IOException, InterruptedException {
		
//	//To maximize the window
//	wutil.maximize(driver);
//	
//	//To apply wait for findElement()
//	wutil.implicitwait(driver);
	
	//To read data from Property File
	//String URL = putil.getDataFromPropertyFile("Url");
//	String USERNAME =putil.getDataFromPropertyFile("Username");
//	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	//To read data from Excel Sheet
	String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);

	//To launch the application
//	driver.get(URL);
	
	//Login the application
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
	
	//Click on Organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//Click on create organization--(+)
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	
	//Enter Organization Name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	
	//In AssignsedTo Click on Group
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the dropdown select support group
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	wutil.handleDropdown(dropdown, GROUP);
	
	//Click on save button
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	Thread.sleep(6000);
	//Mouse hover on image
//	WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//	wutil.mouseHover(driver, img);
	
	//click on sign out button
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
