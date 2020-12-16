package web_pages.Personal_Banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Request_for_Check {
	WebDriver driver;
	public Request_for_Check(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='images/req_but.jpg']")
	public WebElement Requestfor_Check;
	
	@FindBy(xpath = "//select[@id='lst_booksize']")
	public WebElement Book_Size;
	
	@FindBy(xpath = "//input[@id='txt_date']")
	public WebElement Date_Of_Request;
	
	@FindBy(xpath = "//input[@id='Txt_tpwd']")
	public WebElement Transaction_Password;
	
	@FindBy(xpath = "//input[@id='btnsubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btncancel']")
	public WebElement Cancel_btn;
	
	public void Click_On_Requestfor_Check()
	{
		Requestfor_Check.click();
	}
	public void Select_Book_Size(int size)
	{
		new Select(driver.findElement(By.id("lst_booksize"))).selectByVisibleText("25");
	}
	public void Type_Transaction_Password(String password)
	{
		Transaction_Password.clear();
		Transaction_Password.sendKeys("abcdef");
	}
	public void Click_On_Submit_btn() {
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
