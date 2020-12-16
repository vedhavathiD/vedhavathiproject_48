package admin_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class New_Employee_Creation {
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/Admin_Emp_details.aspx";
    private String title="Admin_Emp_details";
    
	public New_Employee_Creation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
    }
	@FindBy(xpath = "//input[@id='BtnNew']")
		public WebElement new_Employee;
	 
	 @FindBy(xpath = "//input[@name='txtUname']")
	public WebElement Employee_Username;
	
	@FindBy(xpath = "//input[@id='txtLpwd']")
	public WebElement Employee_Password;
	
	@FindBy(xpath = "//select[@id='lst_Roles']")
	public WebElement Select_Role;
	
	@FindBy(xpath = "//select[@id='lst_Branch']")
	public WebElement Select_Branch;
	
	@FindBy(xpath = "//input[@id='BtnSubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement Cancel_btn;
	
		public boolean Is_Ranford_NewEmployeepage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	
		public void Click_on_new_Employee()
		{
			new_Employee.click();
		}
			
		public void Type_Employee_Username(String username)
		{
			Employee_Username.clear();
			Employee_Username.sendKeys(username);
		}

		public void Type_Employee_Password(String password)
		{
			Employee_Password.clear();
			Employee_Password.sendKeys(password);
		}
		public void Select_Role_dropdown(String role_name)
		{
		new Select(Select_Role).selectByVisibleText(role_name);
		}
		public void Select_Branch_dropdown(String Branch_Name)
		{
		new Select(Select_Branch).selectByVisibleText(Branch_Name);
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


