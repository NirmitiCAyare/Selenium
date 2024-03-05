package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	WebDriver driver=new ChromeDriver();
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();

	@BeforeSuite
	public void BS()
	{
		System.out.println("Connect to Data base");
		
	}
	
	@BeforeClass
	public void BC() throws IOException
	{
		String URL = putil.getDataFromPropertyFile("URL");
		
		//To maximize the window
		wutil.maximize(driver);
		
		//To apply wait for findElement()
		wutil.implicitwait(driver);
		
		System.out.println("Connect to the database");
		
		driver.get(URL);
		
	}
	
	@BeforeMethod
	public void BM() throws IOException
	//@before annotation is used to log in the application
	{
		String USERNAME =putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//Login the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("Disconnect from the database");
	}
	
	@AfterClass
	public void AC()
	//@After class is used to close the browser
	{
		driver.quit();
	}
	
	@AfterMethod
	public void AM() throws InterruptedException
	//@After method is used to sign out from the application
	{
		Thread.sleep(6000);
		//Mouse hover on image
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mouseHover(driver, img);
		
		//click on sign out button
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
