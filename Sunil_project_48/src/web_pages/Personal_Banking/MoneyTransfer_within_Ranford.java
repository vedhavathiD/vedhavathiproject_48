package web_pages.Personal_Banking;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MoneyTransfer_within_Ranford {
	
	WebDriver driver;
	public MoneyTransfer_within_Ranford(WebDriver driver)
	{
		this.driver=driver;
		
}
	@FindBy(xpath = "//img[@src='images/money_but.jpg']")
	public WebElement Money_transfer;
	@FindBy(xpath = "//a[contains(@id,'samebr')][contains(.,'Transfering Funds with in Ranford')]")
	public WebElement moneyTransfer_within_Ranford;
    @FindBy(xpath = "//input[@name='txtaCCNO']")
    public WebElement Account_num;
    @FindBy(xpath = "//input[contains(@id,'txtTPWD')]")
     public WebElement transaction_pswd;
    @FindBy(xpath = "//select[contains(@id,'lst_branchname')]")
     public WebElement branch_name;
    @FindBy(xpath = "//input[contains(@id,'btnsubmit')]")
     public WebElement submit_btn;
     @FindBy(xpath = "//input[contains(@id,'btncancel')]")
     public WebElement cancel_btn;
     public void Click_On_Money_transfer()
 	{
 		Money_transfer.click();
 	}
 	
 	public void Click_On_Transfer_Bank_to_Ranford()
 	{
 		moneyTransfer_within_Ranford.click();
 	}
 	public void Type_Account_num(int account_num)
	{
		Account_num.clear();
		Account_num.sendKeys("873498327429");
	}
public void Type_Transaction_Pwd(String transaction_password)
	
	{
		transaction_pswd.clear();
		transaction_pswd.sendKeys("abcdef");
	}
 	public void Select_Branch_Name()
 	
 		{
 	 		Money_transfer.click();
 	 	}
 	
 	public void Click_On_submit_btn()
 		{
 		submit_btn.click();
 	}
 	public void Click_On_cancel_btn()
	{
 		cancel_btn.click();
 	}
}
 	