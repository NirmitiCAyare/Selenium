package basicPOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
import pom.CreateNewOrgPage;
import pom.HomePage;
import pom.LoginPage;
import pom.OrganizationsPage;

public class BasePage 
{
	public static WebDriver driver;
	
public static void main(String[] args) throws IOException, InterruptedException 
{
	//Create the object of property file
	PropertyFileUtil putil=new PropertyFileUtil();
	
	//Create the obj of ExcelUtil file
	ExcelUtil eutil=new ExcelUtil();
	
	//Create the obj of WebUtil file
	WebDriverUtil wutil=new WebDriverUtil();
	
	//Create the obj of javautil file
	JavaUtil jutil=new JavaUtil();
		
	//To read data from property file
	String BROWSER = putil.getDataFromPropertyFile("Browser");
	String USERNAME = putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	String URL = putil.getDataFromPropertyFile("Url");
	
	//To read file from excel util
	String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	String GROUP=eutil.getDataFromExcel("Organizations", 1, 1);
	
	//TO launch the browser
	if(BROWSER.equals("Chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("Firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equals("Safari"))
	{
		driver=new SafariDriver();
	}
	else
	{
		driver=new EdgeDriver();
	}
	
	//Maximize the window
	driver.manage().window().maximize();
	
	//launch application
	driver.get(URL);
	
	//Create Object of LoginPage
	LoginPage l=new LoginPage(driver);
	l.login(USERNAME, PASSWORD);;
		
	//Create Object of HomePage
	HomePage h=new HomePage(driver);
	h.home();

	//Create Object of Organization page
	OrganizationsPage op=new  OrganizationsPage(driver);
	op.Organizations();
	
	//Create Object of CreateNewOrgPage
	CreateNewOrgPage nop=new CreateNewOrgPage(driver);
	nop.createNewOrgPage(ORGNAME+jutil.getRandomNumber(), GROUP);
	
	Thread.sleep(4000);
	h.home(driver);
	}
}
