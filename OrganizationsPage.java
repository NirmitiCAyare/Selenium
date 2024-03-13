package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
		
		//Identify Create Organization....(+)
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement createorg;

		public WebElement getCreateorg() {
			return createorg;
		}
		
		public OrganizationsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Create a method
		public void Organizations()
		{
			createorg.click();
		}
}
