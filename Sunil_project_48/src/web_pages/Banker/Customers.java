package web_pages.Banker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customers {

	WebDriver driver;
	public Customers(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='images/Customer_but.jpg']")
	public WebElement Customers;
	
	@FindBy(xpath = "(//img[@src='images/b-edit.png'])[1]")
	public WebElement Edit_btn;
	
	@FindBy(xpath = "(//img[contains(@src,'delete.gif')])[1]")
	public WebElement Delete_btn;
	
	@FindBy(xpath = "//input[@id='btnNEW']")
	public WebElement New_Customer;
	
	@FindBy(xpath = "//img[contains(@id,'logout')]")
	public WebElement Logout_btn;
	
	public void Click_On_Customers()
	{
		Customers.click();
	}
	public void Click_On_Edit_btn()
	{
		Edit_btn.click();
	}
	public void Click_On_Delete_btn()
	{
		Delete_btn.click();
	}
	public void Click_On_New_Customer()
	{
		New_Customer.click();
	}
	public void Click_On_Logout_btn()
	{
		Logout_btn.click();
	}
}
