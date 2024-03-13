package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class HomePage extends WebDriverUtil {

	//Identify Organization
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgname;
	
	//Identify Contact
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactname;
	
	//MouseHover on sign out image
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement img;
	
	//Click on sign out
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getContactname() {
		return contactname;
	}

	public WebElement getImg() {
		return img;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
	//Contructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Create a method
	public void home()
	{
		//Click on organization
		orgname.click();
	}
	
	public void home(WebDriver driver)
	{
		//Mouse hover on img
		mouseHover(driver,img);
		//click on signout btn
		signoutbtn.click();
	}
}
	