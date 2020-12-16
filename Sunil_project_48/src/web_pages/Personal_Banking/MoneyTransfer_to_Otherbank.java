package web_pages.Personal_Banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MoneyTransfer_to_Otherbank {
	
	WebDriver driver;
	public MoneyTransfer_to_Otherbank(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='images/money_but.jpg']")
	public WebElement Money_transfer;
	
	@FindBy(xpath = "//a[@id='lnk_diffbr']")
	public WebElement Transfer_Bank_to_NonRanford;
	
	@FindBy(xpath = "//select[@id='lst_BankNameD']")
	public WebElement Bank_Name;
	
	@FindBy(xpath = "//select[@id='lst_branchd']")
	public WebElement Branch_Name;
	
	@FindBy(xpath = "//input[@id='TxtACCnoD']")
	public WebElement Account_Num_of_Receiver;
	
	@FindBy(xpath = "//input[@id='txtRnameD']")
	public WebElement Receiver_Name;
	
	@FindBy(xpath = "//input[@id='txtamountD']")
	public WebElement Amount_To_Pay;
	
	@FindBy(xpath = "//input[@id='txttpwdD']")
	public WebElement Transaction_Pwd;
	
	@FindBy(xpath = "//input[@id='Btn_payD']")
	public WebElement Pay_btn;
	
	@FindBy(xpath = "//input[@id='btnresetD']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = "//input[@id='Btn_cancelD']")
	public WebElement Cancel_btn;
	
	public void Click_On_Money_transfer()
	{
		Money_transfer.click();
	}
	
	public void Click_On_Transfer_Bank_to_NonRanford()
	{
		Transfer_Bank_to_NonRanford.click();
	}
	public void Select_Bank_Name()
	{
		new Select(driver.findElement(By.name("lst_BankNameD"))).selectByVisibleText("ICICI");
	}
	public void Select_Branch_Name()
	{
		new Select(driver.findElement(By.id("lst_branchd"))).selectByVisibleText("SRnagar");
	}
	public void Type_Account_Num_of_Receiver(int account_num)
	{
		Account_Num_of_Receiver.clear();
		Account_Num_of_Receiver.sendKeys("873498327429");
	}
	
	public void Type_Receiver_Name(String name)
	{
		Receiver_Name.clear();
		Receiver_Name.sendKeys("abc123");
	}
	public void Type_Amount_To_Pay(int amount)
	{
		Amount_To_Pay.clear();
		Amount_To_Pay.sendKeys("1000");
	}
	public void Type_Transaction_Pwd(String transaction_password)
	
	{
		Transaction_Pwd.clear();
		Transaction_Pwd.sendKeys("abc123");
	}
	
	public void Click_On_Pay_btn()
	{
		Pay_btn.click();
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
