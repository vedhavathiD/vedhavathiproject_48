package admin_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Role {
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/Admin_Roles_details.aspx";
    private String title="Admin_Roles_details";
	public Admin_Role(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
    }	
	@FindBy(xpath = "//input[@id='btnRoles']")
	public WebElement New_Role;
		
	@FindBy(xpath = "(//td[contains(.,'Edit')])[2]")
	public WebElement Edit_btn;
	
	@FindBy(xpath = "(//td[contains(.,'Delete')])[2]")
	public WebElement Delete_btn;
	
	public boolean Is_Ranford_Rolepage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	public void Click_on_new_Role()
	{
		New_Role.click();
	}
		
		public void Click_on_Edit_btn()
		{
			 Edit_btn.click();
		}
		public void Click_on_Delete_btn()
		{
			 Delete_btn.click();
		}
	

}