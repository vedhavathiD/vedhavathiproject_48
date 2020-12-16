package admin_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Employee_Edit_Updation {
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/home.aspx";
	private String title="Employee Updation";
	public Employee_Edit_Updation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@id='txtBnameU']")
	public WebElement Employee_Name;
	
	@FindBy(xpath = "//input[@id='txtPwdU']")
	public WebElement Login_Password;
	
	@FindBy(xpath = "//select[@id='lstrolesU']")
	public WebElement Role;
	
	@FindBy(xpath = "//select[@id='lstBidU']")
	public WebElement Branch;
	
	@FindBy(xpath = "//input[@id='BtnUpdate']")
	public WebElement Update_btn;
	
	@FindBy(xpath = "//input[@id='btncancelU']")
	public WebElement Cancel_btn;
	
	public void Type_Employee_Name(String emp_name)
	{
		Employee_Name.clear();
		Employee_Name.sendKeys("abcdefghi");
	}
   public boolean Is_Employee_Updation_Page_Displayed()
   {
	   String Runtime_title=driver.getTitle();
		boolean flag= Runtime_title.contains(title);
		return flag;
	}
   
	public void Type_Login_Password(String password)
	{
		Login_Password.clear();
		Login_Password.sendKeys("shekarVarma");
	}
	public void Select_Role_Name(String rolename)
	{
		new Select(driver.findElement(By.id("lstrolesU"))).selectByVisibleText("Chandra");
	}
	public void Select_Branch(String branchname)
	{
		new Select(driver.findElement(By.id("lstBidU"))).selectByVisibleText("HayathNagar");
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
