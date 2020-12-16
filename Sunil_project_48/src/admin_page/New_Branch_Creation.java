package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class New_Branch_Creation {
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/admin_banker_master.aspx";
    private String title="admin_banker_master";
	public New_Branch_Creation(WebDriver driver)
	{
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	@FindBy(xpath = "//input[@id='BtnNewBR']")
	public WebElement New_Branch;
	
	@FindBy(xpath = "//input[@id='txtbName']")
	public WebElement Branch_Name;
	
	@FindBy(xpath = "//input[@id='txtAdd1']")
	public WebElement Address1;
	
	@FindBy(xpath = "//input[@id='Txtadd2']")
	public WebElement Address2;
	
	@FindBy(xpath = "//input[@id='txtadd3']")
	public WebElement Address3;
	
	@FindBy(xpath = "//input[@id='txtArea']")
	public WebElement Area_textbox;
	
	@FindBy(xpath = "//input[@id='txtZip']")
	public WebElement Zip_Code;

	@FindBy(xpath = "//select[@name='lst_counrtyU']")
	public WebElement Select_Country_Name;
	
	@FindBy(xpath = "//select[@name='lst_stateI']")
	public WebElement Select_StateName;
	
	@FindBy(xpath = "//select[@name='lst_cityI']")
	public WebElement Select_City_Name;
	
	@FindBy(xpath = "//input[@id='BtnSubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btnCancel']")
	public WebElement Cancel_btn;
	
	public boolean Is_Ranford_New_Branchpage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	public void Click_on_New_Branch()
	{
		New_Branch.click();
		}
	public void Type_Branch_Name(String name)
	{
		Branch_Name.clear();
		Branch_Name.sendKeys(name);
	}

	public void Type_Address1(String address)
	{
		Address1.clear();
		Address1.sendKeys(address);
	}

	public void Type_Address2(String address)
	{
		Address2.clear();
		Address2.sendKeys(address);
	}

	public void Type_Address3(String address)
	{
		Address3.clear();
		Address3.sendKeys(address);
	}

	public void Type_Area_textbox(String area)
	{
		Area_textbox.clear();
		Area_textbox.sendKeys(area);
	}

	public void Type_Zip_Code(String code)
	{
		Zip_Code.clear();
		Zip_Code.sendKeys(code);
	}
	
	public void Select_Country_dropdown(String Country_Name)
	{
		new Select(Select_Country_Name).selectByVisibleText(Country_Name);
	}
	public void Select_State_dropdown(String State_Name)
	{
		new Select(Select_StateName).selectByVisibleText(State_Name);
	}
	public void Select_City_dropdown(String City_Name)
	{
		new Select(Select_City_Name).selectByVisibleText(City_Name);
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
		System.out.println("alert not presented");
	}
}
