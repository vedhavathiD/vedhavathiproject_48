package web_pages.Banker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Banker_Homepage {

	WebDriver driver;
	public Banker_Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='images/Customer_but.jpg']")
	public WebElement Customers;
	
	@FindBy(xpath = "//img[@src='images/Receipts_but.jpg']")
	public WebElement Receipts;
	
	@FindBy(xpath = "//img[@src='images/Pay_but.jpg']")
	public WebElement Payments;
	
	public void Click_On_Customers()
	{
		Customers.click();
	}
	public void Click_On_Receipts()
	{
		Receipts.click();
	}
	public void Click_On_Payments()
	{
		Payments.click();
	}
	
}
