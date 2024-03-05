package vTigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Lead {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();
	
	@Test
	public void LeadTest() throws IOException, InterruptedException {
		
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
		String FIRSTNAME = eutil.getDataFromExcel("Leads", 0, 1);
		String LASTNAME = eutil.getDataFromExcel("Leads", 1, 1);
		String COMPANY=eutil.getDataFromExcel("Leads", 2, 1);
		String GROUP = eutil.getDataFromExcel("Leads", 3, 1);
		
		//To launch the application
		driver.get(URL);
		
		//Login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Leads 
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
			
		//Click on Create on Leads--+
		driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
				
		//Enter First Name
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME+jutil.getRandomNumber());
				
		//Enter Last Name
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME+jutil.getRandomNumber());
				
		//Enter Company Name
		driver.findElement(By.name("company")).sendKeys(COMPANY+jutil.getRandomNumber());
		
//		//To fail the test script
//		String actualurl = driver.getCurrentUrl();
//		String expectedurl = "http://localhost:/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
//		Assert.assertEquals(actualurl, expectedurl);
				
		//In AssignsedTo Click on Group
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
				
		//In the drop down select support group
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.handleDropdown(dropdown, GROUP);	
				
		//Click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				
		Thread.sleep(6000);
				
		//To take screenshot of leads
		wutil.screenshot(driver, "Leads");
				
		Thread.sleep(6000);
		
		//Mouse hover on image
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mouseHover(driver, img);
				
		//click on sign out button
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}