package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin_Branch {
	
	WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/admin_banker_master.aspx";
    private String title="admin_banker_master";
	public Admin_Branch(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}
	@FindBy(xpath = "//input[@id='BtnNewBR']")
	public WebElement New_Branch;
	
	@FindBy(xpath = "//select[@id='lst_countryS']")
	public WebElement Select_Country_Name;
	
	@FindBy(xpath = "//select[@id='lst_stateS']")
	public WebElement Select_StateName;
	
	@FindBy(xpath = "//select[@id='lst_cityS']")
	public WebElement Select_City_Name;
	
	@FindBy(xpath = "//input[@id='btn_search']")
	public WebElement Search_btn;
	
	@FindBy(xpath = "//input[@id='btn_clsearch']")
	public WebElement Clear_btn;
		
	@FindBy(xpath = "(//td[contains(.,'Edit')])[2]")
	public WebElement Edit;
	
	@FindBy(xpath = "(//td[contains(.,'Delete')])[2]")
	public WebElement Delete;
	public boolean Is_Ranford_Employeepage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	public void Click_on_New_Branch()
	{
		New_Branch.click();
	}
	public void Select_Country_dropdown()
	{
		new Select(driver.findElement(By.id("Country"))).selectByVisibleText("All");
	}
	public void Select_State_dropdown()
	{
		new Select(driver.findElement(By.id("State"))).selectByVisibleText("All");
	}
	public void Select_City_dropdown()
	{
		new Select(driver.findElement(By.id("City"))).selectByVisibleText("All");
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
