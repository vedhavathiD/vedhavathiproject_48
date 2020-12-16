package web_pages.Banker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class New_User {
	
	WebDriver driver;
	public New_User(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@id='Btnuser']")
	public WebElement NewUser;
	
	@FindBy(xpath = "//select[@id='lst_Roles']")
	public WebElement Role_Name;
	
	@FindBy(xpath = "//select[@id='lst_Branch']")
	public WebElement Branch_Name;
	
	@FindBy(xpath = "//select[@id='DrCName']")
	public WebElement Customer_ID;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	public WebElement Customer_Name;
	
	@FindBy(xpath = "//input[@id='txtUname']")
	public WebElement UserName;
	
	@FindBy(xpath = "//input[@id='txtLpwd']")
	public WebElement Login_Password;
	
	@FindBy(xpath = "//input[@id='txtTpwd']")
	public WebElement Transaction_Password;
	
	@FindBy(xpath = "//input[@id='BtnSubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement Cancel_btn;
	
	public void Click_On_NewUser()
	{
		NewUser.click();
	}
	public void Select_Role_Name(String role_name)
	{
		new Select(driver.findElement(By.id("lst_Roles"))).selectByVisibleText("icustomer");
	}
	public void Select_Branch_Name(String branch)
	{
		new Select(driver.findElement(By.id("lst_Branch"))).selectByVisibleText("Hayathnagar");

	}
	public void Select_Customer_ID(int cust_ID)
	{
		new Select(driver.findElement(By.id("DrCName"))).selectByVisibleText("32");
	}
	public void Type_Customer_Name(String cust_name)
	{
		Customer_Name.clear();
		Customer_Name.sendKeys(cust_name);
	}
	public void Type_UserName(String username)
	{
		UserName.clear();
		UserName.sendKeys(username);
	}
	public void Type_Login_Password(String pwd)
	{
		Login_Password.clear();
		Login_Password.sendKeys(pwd);
	}
	public void Type_Transaction_Password(String transaction_pwd)
	{
		Transaction_Password.clear();
		Transaction_Password.sendKeys(transaction_pwd);
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