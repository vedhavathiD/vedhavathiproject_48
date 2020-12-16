package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class New_Role_Creation {
	
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/Admin_Roles_details.aspx";
    private String title="Admin_Roles_details";
	public New_Role_Creation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	@FindBy(xpath="//a[@href='http://ravinderbasani.com']")
	public WebElement Home_btn;
	
	@FindBy(xpath = "//input[@id='btnRoles']")
	public WebElement New_Role;
		
	
	@FindBy(xpath = "//input[@id='txtRname']")
	public WebElement Role_Name;
	
	@FindBy(xpath = "//input[@id='txtRDesc']")
	public WebElement Role_Description;
	
	@FindBy(xpath = "//select[@id='lstRtypeN']")
	public WebElement Select_Role_Type;
	
	@FindBy(xpath = "//input[@id='btninsert']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='Btn_Reset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='Btn_cancel']")
	public WebElement Cancel_btn;

	public boolean Is_Ranford_New_Rolepage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	public void Click_on_Home_btn()
	{
		Home_btn.click();
	}
	
	public void Click_on_new_Role()
	{
		New_Role.click();
	}
		
	public void Type_Role_Name(String name)
	{
		Role_Name.clear();
		Role_Name.sendKeys(name);
	}

	public void Type_Role_Description(String description)
	{
		Role_Description.clear();
		Role_Description.sendKeys(description);
	}
    public void Select_Role_Type(String Role_Type)
   
	{
		new Select(Select_Role_Type).selectByVisibleText(Role_Type);

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
	

