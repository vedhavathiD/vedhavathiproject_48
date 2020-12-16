package admin_page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class New_User_Creation {
	
	WebDriver driver;
	public New_User_Creation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//select[@id='lst_Roles']")
	public WebElement Select_Role;
	
	@FindBy(xpath = "//select[@id='lst_Branch']")
	public WebElement Select_Branch;
	
	@FindBy(xpath = "//select[@id='DrCName']")
	public WebElement Customer_ID;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	public WebElement Enter_Customer_Name;
	
	@FindBy(xpath = "//input[@id='txtUname']")
	public WebElement Enter_UserName;
	
	@FindBy(xpath = "//input[@id='txtLpwd']")
	public WebElement Enter_Password;
	
	@FindBy(xpath = "//input[@id='txtTpwd']")
	public WebElement Enter_Transaction_Password;
	
	@FindBy(xpath = "//input[@id='BtnSubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement Cancel_btn;
	
	public void Select_Select_Role(String role_name)
	{
		new Select(driver.findElement(By.id("lst_Roles"))).selectByVisibleText(role_name);
	}
	public void Select_Select_Branch(String branch)
	{
		new Select(driver.findElement(By.id("lst_Branch"))).selectByVisibleText(branch);

	}
	public void Select_Customer_ID(String cust_ID)
	{
		new Select(driver.findElement(By.id("DrCName"))).selectByVisibleText(cust_ID);
	}
	public void Type_Enter_Customer_Name(String cust_name)
	{
		Enter_Customer_Name.clear();
		Enter_Customer_Name.sendKeys(cust_name);
	}
	public void Type_Enter_UserName(String username)
	{
		Enter_UserName.clear();
		Enter_UserName.sendKeys(username);
	}
	public void Type_Enter_Password(String pwd)
	{
		Enter_Password.clear();
		Enter_Password.sendKeys(pwd);
	}
	public void Type_Enter_Transaction_Password(String transaction_pwd)
	{
		Enter_Transaction_Password.clear();
		Enter_Transaction_Password.sendKeys(transaction_pwd);
	}
	
	public void Click_On_Submit_btn()
	{
		Submit_btn.click();
	}
	public void Click_On_Reset_btn()
	{
		Reset_btn.click();
	}
	public void Click_On_Cancel_btn()
	{
		Cancel_btn.click();
	}
	
	
	
	
	
	
	
	
	
}
