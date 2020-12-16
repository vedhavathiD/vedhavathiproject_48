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
	@FindBy(xpath = "(//input[contains(@border,'0')])[1]")
	public WebElement New_User;
	
	@FindBy(xpath = "//select[@id='lst_branchS']")
	public WebElement Select_Branch_Name;
	
	@FindBy(xpath = "//select[@id='lst_rolesS']")
	public WebElement Select_Roles;
	
	@FindBy(xpath = "//input[@id='btn_search']")
	public WebElement Search_btn;
	
	@FindBy(xpath = "//input[@id='btn_clear']")
	public WebElement Clear_btn;
	
	@FindBy(xpath = "(//img[@border='0'])[8]")
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
		new Select(Select_Branch_Name).selectByVisibleText("All");
	}
	public void Select_Role_dropdown()
	{
		new Select(Select_Roles).selectByVisibleText("All");
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
	
	
	
	public boolean is_AlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
		return false;
	}
	
	}
	public void else_Alert() {

		if(is_AlertPresent())
			driver.switchTo().alert().accept();
		else
			System.out.println("Alert not presented");
		}
	
	}
	
	
	

