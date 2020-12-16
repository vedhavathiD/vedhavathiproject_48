package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Role_Edit_Updation {
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/home.aspx";
	private String title="Admin_Roles_details";
	public Role_Edit_Updation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@id='txtrNameU']")
	public WebElement Enter_Role_Name;
	
	@FindBy(xpath = "//input[@id='txtrdescU']")
	public WebElement Enter_Role_Description;
	
	@FindBy(xpath = "//select[contains(@id,'lstRtype')]")
	public WebElement Role_Type;
	
	@FindBy(xpath = "//input[@id='btnupdate']")
	public WebElement Update_btn;
	
	@FindBy(xpath = "//input[@id='Btn_cancel']")
	public WebElement Cancel_btn;
			
	public boolean Is_UpdateRole_Page_Displayed()
	{

		String Runtime_title=driver.getTitle();
		boolean flag= Runtime_title.contains(title);
		return flag;
	}
	public void Type_Role_Name(String role_name)
	{
		Enter_Role_Name.clear();
		Enter_Role_Name.sendKeys(role_name);
	}
	
	public void Type_Enter_Role_Description(String role_desc)
	{
		Enter_Role_Description.clear();
		Enter_Role_Description.sendKeys(role_desc);
	}
	public void Select_Role_Type(String role_type)
	{
		new Select(driver.findElement(By.id("lstRtype"))).selectByVisibleText("C");
	}
	public void Click_On_Update_btn()
	{
		Update_btn.click();
	}
	public void Click_On_Cancel_btn()
	{
		Cancel_btn.click();
	}
	 public boolean is_AlertPresent()
		{
			try {
				driver.switchTo().alert();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public void close_Alert()
		{
			if(is_AlertPresent())
				driver.switchTo().alert().accept();
			else
				System.out.println("Alert not presented");
		}
		
		

}