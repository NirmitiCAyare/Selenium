package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Identify User name tf
	@FindBy(name="user_name")
	private WebElement usernametf;
	
	//Identify Password tf
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	//Identify Login button
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Create a Constructor--to initialize the web element
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create a method
	public void login(String usernamedata,String passworddata)
	{
		usernametf.sendKeys(usernamedata);
		passwordtf.sendKeys(passworddata);
		loginbtn.click();
		
		
	}
}
