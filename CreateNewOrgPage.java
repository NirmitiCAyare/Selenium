package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class CreateNewOrgPage /*extends WebDriverUtil*/ {

	WebDriverUtil wutil=new WebDriverUtil();
	//Identify Organization text field
	@FindBy(name="accountname")
	private WebElement orgnametf;

	public WebElement getOrgnametf() {
		return orgnametf;
	}
	
	//Click on radio btn of Assign To
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement radiobtn;

	public WebElement getRadiobtn() {
		return radiobtn;
	}
	
	//Identify the drop down
	@FindBy(name="assigned_group_id")
	private WebElement assignedto;

	public WebElement getAssignedto() {
		return assignedto;
	}

	//Identify the save button
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement saveto;
	
	public WebElement getSaveto() {
		return saveto;
	}
	
	//Click on sign out option
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;

	public WebElement getSignout() {
		return signout;
	}
	
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Create a method
	public void createNewOrgPage(String Orgnamedata,String Groupdata) {
		
		//Enter org name
		orgnametf.sendKeys(Orgnamedata);
		//Click on radio btn
		radiobtn.click();
		//Click on Dropdown
		wutil.handleDropdown(assignedto, Groupdata);
		//click on save button
		saveto.click();
	}
	
	
	
	
	
	

}
