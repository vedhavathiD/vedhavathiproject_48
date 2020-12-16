package web_pages.Personal_Banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Smart_Money_Order {

	WebDriver driver;
	public Smart_Money_Order(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='images/smart_but.jpg']")
	public WebElement SmartMoneyOrder;
	
	@FindBy(xpath = "//input[@id='txtRname']")
	public WebElement Name_Of_The_Receiver;
	
	@FindBy(xpath = "//input[@id='txtAdd1']")
	public WebElement Add1;
	
	@FindBy(xpath = "//input[@id='txtadd2']")
	public WebElement Add2;
	
	@FindBy(xpath = "//input[@id='txtcity']")
	public WebElement City;
	
	@FindBy(xpath = "//input[@id='txtstate']")
	public WebElement State;
	
	@FindBy(xpath = "//input[@id='txtcountry']")
	public WebElement Country;
	
	@FindBy(xpath = "//input[@id='txtpincode']")
	public WebElement Zipcode;
	
	@FindBy(xpath = "//input[@id='txtamount']")
	public WebElement Amount;
	
	@FindBy(xpath = "//input[@id='txtpwd']")
	public WebElement Transaction_Password;
	
	@FindBy(xpath = "//input[@id='btnsubmit']")
	public WebElement Submit_btn;
	
	@FindBy(xpath = "//input[@id='btnreset']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='btncancel']")
	public WebElement Cancel_btn;

	public void Click_On_SmartMoneyOrder()
	{
		SmartMoneyOrder.click();
	}
   public void Type_Name_Of_The_Receiver(String name)
   {
	   Name_Of_The_Receiver.clear();
	   Name_Of_The_Receiver.sendKeys("abcdef");
   }
   public void Type_Add1(String add1)
   {
	   Add1.clear();
	   Add1.sendKeys("123,hyd");
   }
   public void Type_Add2(String add2)
   {
	   Add2.clear();
	   Add2.sendKeys("456, mum");
   }
  public  void Type_City(String city)
  {
	  City.clear();
	  City.sendKeys("Hyderabad");
	  
  }
  public void Type_State(String state)
  {
	  State.clear();
	  State.sendKeys("Andra Pradesh");
  }
  public void Type_Country(String country)
  {
	  Country.clear();
	  Country.sendKeys("INDIA");
  }
  public void Type_Zipcode(int zipcode)
  {
	  Zipcode.clear();
	  Zipcode.sendKeys("45678");
  }
  public void Type_Amount()
  {
	  Amount.clear();
	  Amount.sendKeys("2000");
  }
  
  public void Type_Transaction_Password(String password)
  {
	  Transaction_Password.clear();
	  Transaction_Password.sendKeys("erty");
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
