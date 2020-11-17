package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin_Users {
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/userdetails.aspx";
    private String title="UserDetails";
	public Admin_Users(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	@FindBy(xpath = "//input[@id='Btnuser']")
	public WebElement New_User;
	
	@FindBy(xpath = "//select[@id='lst_branchS']")
	public WebElement Branch_Name;
	
	@FindBy(xpath = "//select[@id='lst_rolesS']")
	public WebElement Roles;
	
	@FindBy(xpath = "//input[@id='btn_search']")
	public WebElement Search_btn;
	
	@FindBy(xpath = "//input[@id='btn_clear']")
	public WebElement Clear_btn;
	
	@FindBy(xpath = "(//td[contains(.,'Edit')])[2]")
	public WebElement Edit;
	
	@FindBy(xpath = "(//td[contains(.,'Delete')])[2]")
	public WebElement Delete;
	
	public boolean Is_Ranford_Userpage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	public void Click_on_New_User()
	{
		New_User.click();
	}
	public void Select_Branch_dropdown()
	{
		new Select(driver.findElement(By.id("Branch"))).selectByVisibleText("All");
	}
	public void Select_Role_dropdown()
	{
		new Select(driver.findElement(By.id("Role"))).selectByVisibleText("All");
	}

	public void Click_on_Search_btn()
	{
		Search_btn.click();
	}
	public void Click_on_Clear_btn()
	{
		Clear_btn.click();
	}

	public void Click_on_Edit_btn()
	{
		 Edit.click();
	}
	public void Click_on_Delete_btn()
	{
		 Delete.click();
	}
	
	
	
	
	
	
	

}