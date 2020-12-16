package Banker_tests;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import admin_page.RanfordHomePage;
import keywords.Repository;
import web_pages.Banker.Banker_Homepage;
import web_pages.Banker.Payments;
import web_pages.Banker.Receipts_and_Payments;


public class Banker_TestCase extends Repository
{

	public Banker_TestCase(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}



	public void banker_login(String BranchName,String username,String password)
	{
		
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Select_Dropdown(RHP.branch_Dropdown,BranchName);
		Type_text(RHP.Admin_Banker_username, username);
		Type_text(RHP.Admin_Banker_password, password);
		click_element(RHP.Login_btn);
		
	}
	
	

	public void Receipts_DD_Deposit_using_Valid_AccoutNumber(String AccoutNumber,String Customer_Company_name)
	{  Banker_Homepage BH=new Banker_Homepage(driver);
		click_element(BH.Receipts);
		Receipts_and_Payments RP=new Receipts_and_Payments(driver);
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, "dd deposite(+)");
		Assert.assertTrue(wait_and_verify_element_visible(RP.Customer_Company_name));
		Assert.assertTrue(Verify_input_Value(RP.Customer_Company_name, Customer_Company_name));
		
	}


	public void Receipts_DD_Deposit_using_InValid_AccoutNumber(String AccoutNumber1,String Transaction_Type)
	{
		Banker_Homepage BH=new Banker_Homepage(driver);
		click_element(BH.Receipts);
		Receipts_and_Payments RP=new Receipts_and_Payments(driver);
		Type_text(RP.Account_Number, AccoutNumber1);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type);
		Verify_Alert_message("Give correct Account number");
		is_AlertPresent();
		close_Alert();
		
	}
	
	
	
	public void Receipts_DD_Deposit_verify_creditcard_info_is_present(String AccoutNumber,String Transaction_Type)
	{
	 Banker_Homepage BH=new Banker_Homepage(driver);
	click_element(BH.Receipts);
	Receipts_and_Payments RP=new Receipts_and_Payments(driver);
	Type_text(RP.Account_Number, AccoutNumber);
	Select_Dropdown(RP.Transaction_Type, Transaction_Type);
	Assert.assertTrue(wait_and_verify_element_visible(RP.Cheque_DD_CreditCardNumber));

	}
	
	
	
	public void Receipts_Cheque_Deposite_verify_creditcard_info_is_present(String AccoutNumber,String Transaction_Type1)
	{
	 Banker_Homepage BH=new Banker_Homepage(driver);
	click_element(BH.Receipts);
	Receipts_and_Payments RP=new Receipts_and_Payments(driver);
	Type_text(RP.Account_Number, AccoutNumber);
	Select_Dropdown(RP.Transaction_Type, Transaction_Type1);
	Assert.assertTrue(wait_and_verify_element_visible(RP.Cheque_DD_CreditCardNumber));
	}
	

	
	public void Receipts_Cash_Deposite_verify_creditcard_info_is_Absent(String AccoutNumber,String Transaction_Type2)
	{
	 Banker_Homepage BH=new Banker_Homepage(driver);
	click_element(BH.Receipts);
	Receipts_and_Payments RP=new Receipts_and_Payments(driver);
	Type_text(RP.Account_Number, AccoutNumber);
	Select_Dropdown(RP.Transaction_Type, Transaction_Type2);
	Assert.assertFalse(wait_and_verify_element_visible(RP.Cheque_DD_CreditCardNumber));
	}
	
	
	public void Verify_DD_Deposit_Valid_Transaction(String Amount,String Cheque_DD_CreditCardNumber,String Customer_Company_name,String AccoutNumber,String Transaction_Type) throws Exception
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Select_Dropdown(RHP.branch_Dropdown,"HayathNagar");
		Type_text(RHP.Admin_Banker_username, "sriram123");
		Type_text(RHP.Admin_Banker_password, "sriram123");
		click_element(RHP.Login_btn);
		Banker_Homepage BH=new Banker_Homepage(driver);
		click_element(BH.Receipts);
		Receipts_and_Payments RP=new Receipts_and_Payments(driver);
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type);
	
		String Before_Bal=Get_editbox_input(RP.acc_bal);
		double initial_bal=Double.parseDouble(Before_Bal);
		System.out.println(initial_bal);
		Type_text(RP.Cheque_DD_CreditCardNumber,Cheque_DD_CreditCardNumber);
		Type_text(RP.Amount,Amount);
		click_element(RP.Submit_btn);
		//Assert.assertTrue(Verify_Alert_message("Transaction Has been posted"));
		driver.switchTo().alert().accept();
		Receipts_DD_Deposit_using_Valid_AccoutNumber(AccoutNumber,Customer_Company_name);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type);
		String After_Bal=Get_editbox_input(RP.acc_bal);
		double later_bal=Double.parseDouble(After_Bal); 
		System.out.println(later_bal);	
		double total=later_bal-initial_bal;
		double E_cash=Double.parseDouble(Amount);
		Assert.assertEquals(total,E_cash);
		System.out.println("Transaction completed");
		
	}

	

	public void Verify_Cheque_Deposit_Valid_Transaction(String Amount,String Cheque_DD_CreditCardNumber,String AccoutNumber,String Transaction_Type1) throws Exception
	{

		RanfordHomePage RHP=new RanfordHomePage(driver);
		Select_Dropdown(RHP.branch_Dropdown,"HayathNagar");
		Type_text(RHP.Admin_Banker_username, "sriram123");
		Type_text(RHP.Admin_Banker_password, "sriram123");
		click_element(RHP.Login_btn);
		Banker_Homepage BH=new Banker_Homepage(driver);
		click_element(BH.Receipts);
		Receipts_and_Payments RP=new Receipts_and_Payments(driver);
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type1);
		String Before_Bal=Get_editbox_input(RP.acc_bal);
		double initial_bal=Double.parseDouble(Before_Bal);
		System.out.println(initial_bal);
		Type_text(RP.Cheque_DD_CreditCardNumber,Cheque_DD_CreditCardNumber);
		Type_text(RP.Amount,Amount);
        click_element(RP.Submit_btn);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type1);
		String After_Bal=Get_editbox_input(RP.acc_bal);
		double later_bal=Double.parseDouble(After_Bal); 
		System.out.println(later_bal);	
		double total=later_bal-initial_bal;
		double E_cash=Double.parseDouble(Amount);
		Assert.assertEquals(total,Amount);
		System.out.println("Transaction completed");
		
	}
	
	
	public void Verify_Cash_Deposit_Valid_Transaction(String Amount,String AccoutNumber,String Transaction_Type2) throws Exception
	{RanfordHomePage RHP=new RanfordHomePage(driver);
	Select_Dropdown(RHP.branch_Dropdown,"HayathNagar");
	Type_text(RHP.Admin_Banker_username, "sriram123");
	Type_text(RHP.Admin_Banker_password, "sriram123");
	click_element(RHP.Login_btn);
		 Banker_Homepage BH=new Banker_Homepage(driver);
		 click_element(BH.Receipts);
		Receipts_and_Payments RP=new Receipts_and_Payments(driver);
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type2);
		String Before_Bal=Get_editbox_input(RP.acc_bal);
		double initial_bal=Double.parseDouble(Before_Bal);
		System.out.println(initial_bal);
	    Type_text(RP.Amount,Amount);
		click_element(RP.Submit_btn);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type2);
		String After_Bal=Get_editbox_input(RP.acc_bal);
		double later_bal=Double.parseDouble(After_Bal); 
		System.out.println(later_bal);	
		double total=later_bal-initial_bal;
		double E_cash=Double.parseDouble(Amount);
		Assert.assertEquals(total,E_cash);
		System.out.println("Transaction completed");
			
	}
	
	
	public void Verify_DD_withdrawl_Valid_Transaction(String Amount,String Customer_Company_name,String Cheque_DD_CreditCardNumber, String AccoutNumber,String Transaction_Type3) throws Exception
	{RanfordHomePage RHP=new RanfordHomePage(driver);
	Select_Dropdown(RHP.branch_Dropdown,"HayathNagar");
	Type_text(RHP.Admin_Banker_username, "sriram123");
	Type_text(RHP.Admin_Banker_password, "sriram123");
	click_element(RHP.Login_btn);
		 Banker_Homepage BH=new Banker_Homepage(driver);
		 click_element(BH.Payments);
		 Payments PY=new Payments(driver);
		 Type_text(PY.Account_Number, AccoutNumber);
		Select_Dropdown(PY.Transaction_Type, Transaction_Type3);
		String Before_Bal=Get_editbox_input(PY.acc_bal);
		double initial_bal=Double.parseDouble(Before_Bal);
		System.out.println(initial_bal);
		Type_text(PY.Cheque_DD_CreditCardNumber,Cheque_DD_CreditCardNumber);
		Type_text(PY.Amount,"100");	
		click_element(PY.Submit_btn);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Type_text(PY.Account_Number, AccoutNumber); 
		Select_Dropdown(PY.Transaction_Type, Transaction_Type3);
		String After_Bal=Get_editbox_input(PY.acc_bal);
		double later_bal=Double.parseDouble(After_Bal); 
		System.out.println(later_bal);	
		double total=initial_bal-later_bal;
		double E_cash=Double.parseDouble("100");
		Assert.assertEquals(total,E_cash);
		System.out.println("Transaction completed");
		
	}
	
	

	public void Verify_Cheque_withdrawl_Valid_Transaction(String Amount,String Cheque_DD_CreditCardNumber,String AccoutNumber,String Transaction_Type4) throws Exception
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Select_Dropdown(RHP.branch_Dropdown,"HayathNagar");
		Type_text(RHP.Admin_Banker_username, "sriram123");
		Type_text(RHP.Admin_Banker_password, "sriram123");
		click_element(RHP.Login_btn);
		 Banker_Homepage BH=new Banker_Homepage(driver);
		click_element(BH.Payments);
		Receipts_and_Payments RP=new Receipts_and_Payments(driver);
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type4);
		String Before_Bal=Get_editbox_input(RP.acc_bal);
		double initial_bal=Double.parseDouble(Before_Bal);
		System.out.println(initial_bal);
		Type_text(RP.Cheque_DD_CreditCardNumber,Cheque_DD_CreditCardNumber);
		Type_text(RP.Amount, Amount);
		click_element(RP.Submit_btn);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type4);
		String After_Bal=Get_editbox_input(RP.acc_bal);
		double later_bal=Double.parseDouble(After_Bal); 
		System.out.println(later_bal);	
		double total=initial_bal-later_bal;
		double E_cash=Double.parseDouble(Amount);
		Assert.assertEquals(total,E_cash);
		System.out.println("Transaction completed");
		
	}
	
	
	
	public void Verify_Cash_withdrawl_Valid_Transaction(String Amount,String AccoutNumber,String Transaction_Type5) throws Exception
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Select_Dropdown(RHP.branch_Dropdown,"HayathNagar");
		Type_text(RHP.Admin_Banker_username, "sriram123");
		Type_text(RHP.Admin_Banker_password, "sriram123");
		click_element(RHP.Login_btn);
		 Banker_Homepage BH=new Banker_Homepage(driver);
		click_element(BH.Payments);
		Receipts_and_Payments RP=new Receipts_and_Payments(driver);
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type5);
		String Before_Bal=Get_editbox_input(RP.acc_bal);
		double initial_bal=Double.parseDouble(Before_Bal);
		System.out.println(initial_bal);
		Type_text(RP.Amount, Amount);
		click_element(RP.Submit_btn);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Type_text(RP.Account_Number, AccoutNumber);
		Select_Dropdown(RP.Transaction_Type, Transaction_Type5);
		String After_Bal=Get_editbox_input(RP.acc_bal);
		double later_bal=Double.parseDouble(After_Bal); 
		System.out.println(later_bal);	
		double total=initial_bal-later_bal;
		double E_cash=Double.parseDouble(Amount);
		Assert.assertEquals(total,E_cash);
		System.out.println("Transaction completed");	
		
	}
}
