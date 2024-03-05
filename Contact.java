package vTigerCRM;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Contact {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();

	@Test
	public void ContactTest() throws IOException, InterruptedException {
		
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
		String FIRSTNAME = eutil.getDataFromExcel("Contacts", 0, 1);
		String LASTNAME = eutil.getDataFromExcel("Contacts", 1, 1);
		String ORGNAME=eutil.getDataFromExcel("Contacts", 3, 1);
		String GROUP = eutil.getDataFromExcel("Contacts", 2, 1);
		
		//To launch the application
		driver.get(URL);
		
		//Login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Contacts 
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Create on Contacts--+
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//Enter First Name
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME+jutil.getRandomNumber());
		
		//Enter LAst Name
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME+jutil.getRandomNumber());
		
		//To fail the test script
		//WebElement notifyCheckbox = driver.findElement(By.name("notify_owner"));
		//Assert.assertTrue(notifyCheckbox.isSelected());
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "http://localhost:/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualurl, expectedurl);
		
		//In AssignsedTo Click on Group
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//In the drop down select support group
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.handleDropdown(dropdown, GROUP);	
		
		//click on Organization---+
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//Transfer the control from parent window to child window
		wutil.switchToWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");

		
		//To enter organization name in text field
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		
		//To click on search on search now button
		driver.findElement(By.name("search")).click();
		
		//Click on organization name
		driver.findElement(By.xpath("//a[text()='Qspiders4']")).click();
		
		//To transfer the control from child window to parent window
		wutil.switchToWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
				
		//Click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(6000);
		
		//To take screenshot of contact
		wutil.screenshot(driver, "Contact");
		
		Thread.sleep(6000);
		//Mouse hover on image
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mouseHover(driver, img);
		
		//click on sign out button
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

	}

