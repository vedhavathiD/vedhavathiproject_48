package web_pages.Banker;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Payments {
	WebDriver driver= new ChromeDriver();
	public Payments(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='TxtaccNO']")
	public WebElement Account_Number;
	
	@FindBy(xpath = "//input[@id='txttransDate']")
	public WebElement Transaction_Date;
	
	@FindBy(xpath = "//select[@id='lstTransType']")
	public WebElement Transaction_Type;
	
	@FindBy(xpath = "//input[@id='TxtCname']")
	public WebElement Customer_Name;
	
	@FindBy(xpath = "//input[@id='txtCity']")
	public WebElement City;
	
	@FindBy(xpath = "//input[@id='txtphNO']")
	public WebElement Phone_num;
	
	@FindBy(xpath = "//input[@id='txtBalans']")
	public WebElement acc_bal;
	
	
	
	@FindBy(xpath = "//input[@id='txtCqueNO']")
	public WebElement Cheque_DD_CreditCardNumber;
	
	@FindBy(xpath = "//input[@id='txtnaration']")
	public WebElement Narration;
	
	@FindBy(xpath = "//input[@id='txtamount']")
	public WebElement Amount;
	
	@FindBy(xpath = "//input[@id='btnSubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btncancel']")
	public WebElement Cancel_btn;
	
		public void Type_Account_Number(int accountno)
	{
		Account_Number.clear();
		Account_Number.sendKeys("3001776101372");
	}
	public void Type_Transaction_Date(int transactiondate)
	{
		
		Transaction_Date.clear();
		Transaction_Date.sendKeys("23/4/2025");
	}
	public void Select_Transaction_Type()
	{
		new Select(driver.findElement(By.id("lstTransType"))).selectByVisibleText("cash deposite(+)");
	}
	public void Customer_Name(String customername)
	{
		
	}
	public void City(String city)
	{
		
	}
	public void Phone_Number()
	{
		
	}
	public void Available_Balance()
	{
		
	}
	public void Type_Cheque_DD_CreditCardNumber(int number)
	{
		Cheque_DD_CreditCardNumber.clear();
		Cheque_DD_CreditCardNumber.sendKeys("567890");
	}
	public void Type_Narration(int narration)
	{
		Narration.clear();
		Narration.sendKeys("2000");
	}
	public void Type_Amount(int amount)
	{
		Amount.clear();
		Amount.sendKeys("1000");
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

