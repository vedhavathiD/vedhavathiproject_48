package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class New_User_Creation {
	
	WebDriver driver;
	private String url="22.175.8.158/Ranford21/userdetails.aspx";
    private String title="AdminUserCreation";
	public New_User_Creation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	@FindBy(xpath = "//select[@id='lst_Roles']")
	public WebElement Role;
	
	@FindBy(xpath = "//select[@id='lst_Branch']")
	public WebElement Branch;
	
	@FindBy(xpath = "//select[@id='DrCName']")
	public WebElement Customer_ID;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	public WebElement Customer_Name;
	
	@FindBy(xpath = "//input[@id='txtUname']")
	public WebElement UserName;
	
	@FindBy(xpath = "//input[@id='txtLpwd']")
	public WebElement Password;
	
	@FindBy(xpath = "//input[@id='txtTpwd']")
	public WebElement Transaction_Password;
	
	@FindBy(xpath = "//input[@id='BtnSubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement Cancel_btn;
	
	public boolean Is_Ranford_New_Userpage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	 public void Select_Role_dropdown(String Role_Name)

		{
			new Select(driver.findElement(By.id("Role"))).selectByVisibleText("Role_Name");
		}
	 public void Select_Branch_dropdown(String Branch_Name)
		{
			new Select(driver.findElement(By.id("Branch"))).selectByVisibleText(Branch_Name);
		}
	 public void Select_Customer_ID_dropdown(String Customer_ID )
		{
			new Select(driver.findElement(By.id("Cusomer_ID"))).selectByVisibleText(Customer_ID );
		}
	
		public void Type_Customer_Name(String name)
		{
			Customer_Name.clear();
			Customer_Name.sendKeys(name);
		}
		public void Type_UserName(String username)
		{
			UserName.clear();
			UserName.sendKeys(username);
		}

		public void Type_Password(String password)
		{
			Password.clear();
			Password.sendKeys(password);
		}


		public void Type_Transaction_Password(String password)
		{
			Transaction_Password.clear();
			Transaction_Password.sendKeys(password);
		}

	 public void Click_on_Submit_btn()
		{
			 Submit_btn.click();
		}
		public void Click_on_Reset_btn()
		{
			 Reset_btn.click();
		}

		public void Click_on_Cancel_btn()
		{
			Cancel_btn.click();
		}
}