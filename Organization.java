package vTigerCRM;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImplementation.class)
public class Organization {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
	
	@Test
	public void OrganizationTest() throws IOException, InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
	//To maximize the window
	wutil.maximize(driver);
	
	//To apply wait for findElement()
	wutil.implicitwait(driver);
	
	//To read data from Property File
	String URL = putil.getDataFromPropertyFile("Url");
	String USERNAME =putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	//To read data from Excel Sheet
	String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);

	//To launch the application
	driver.get(URL);
	
	//Login the application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Click on Organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//Click on create organization--(+)
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	
	//Enter Organization Name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	
	//In AssignsedTo Click on Group
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the drop down select support group
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	wutil.handleDropdown(dropdown, GROUP);
	
	//To fail the test script
	String actualurl = driver.getCurrentUrl();
	String expectedurl = "http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing";
	Assert.assertEquals(actualurl, expectedurl);
	
	//Click on save button
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	Thread.sleep(6000);
	//Mouse hover on image
	WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	wutil.mouseHover(driver, img);
	
	//click on sign out button
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
