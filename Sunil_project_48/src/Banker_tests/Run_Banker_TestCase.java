package Banker_tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Run_Banker_TestCase {
  

	  String Driver_Path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\DRIVERS\\chromedriver.exe";
	  String screen_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\Screens\\";
	  String property_file_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\src\\Banker_tests\\input.properties";
	  FileInputStream fi;
	  Properties properties;
	  WebDriver driver;
	  Banker_TestCase banker;
	  
  
@Test(priority=0)
public void banker_login()
{
	String BranchName=properties.getProperty("BranchName");
	String username=properties.getProperty("username");
	String password=properties.getProperty("password");
	driver.get(properties.getProperty("banker_url"));
	  banker=new Banker_TestCase(driver);
	  banker.banker_login(BranchName, username, password);
}


@Test(priority=1)
public void Receipts_DD_Deposit_using_Valid_AccoutNumber()
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
    String Customer_Company_name=properties.getProperty("Customer_Company_name");
    driver.get(properties.getProperty("Receipts_url"));
    banker=new Banker_TestCase(driver);
    banker.Receipts_DD_Deposit_using_Valid_AccoutNumber(AccoutNumber,Customer_Company_name);
	}



@Test(priority=2)
public void Receipts_DD_Deposit_using_InValid_AccoutNumber()
{
	String AccoutNumber1=properties.getProperty("AccoutNumber1");
	 String Transaction_Type=properties.getProperty("Transaction_Type");
	 driver.get(properties.getProperty("Receipts_url"));
	    banker=new Banker_TestCase(driver);
	    banker.Receipts_DD_Deposit_using_InValid_AccoutNumber(AccoutNumber1,Transaction_Type);
	}



@Test(priority=3)
public void Receipts_DD_Deposit_verify_creditcard_info_is_present()
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
    String Transaction_Type=properties.getProperty("Transaction_Type");
    driver.get(properties.getProperty("Receipts_url"));
    banker=new Banker_TestCase(driver);
    banker.Receipts_DD_Deposit_verify_creditcard_info_is_present(AccoutNumber,Transaction_Type);
}


@Test(priority=4)
public void Receipts_Cash_Deposite_verify_creditcard_info_is_Absent()
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
    String Transaction_Type2=properties.getProperty("Transaction_Type2");
    driver.get(properties.getProperty("Receipts_url"));
    banker=new Banker_TestCase(driver);
    banker.Receipts_Cash_Deposite_verify_creditcard_info_is_Absent(AccoutNumber,Transaction_Type2);
}


@Test(priority=5)
public void Receipts_Cheque_Deposit_verify_creditcard_info_is_present()
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
    String Transaction_Type1=properties.getProperty("Transaction_Type1");   
    driver.get(properties.getProperty("Receipts_url"));
    banker=new Banker_TestCase(driver);
    banker.Receipts_DD_Deposit_verify_creditcard_info_is_present(AccoutNumber,Transaction_Type1);
}

@Test(priority=6)
public void Verify_DD_Deposit_Valid_Transaction() throws Exception
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
	  String Transaction_Type=properties.getProperty("Transaction_Type");
	  String Cheque_DD_CreditCardNumber=properties.getProperty("Cheque_DD_CreditCardNumber");
	  String Customer_Company_name=properties.getProperty("Customer_Company_name");
	  String Amount=properties.getProperty("Amount");
    driver.get(properties.getProperty("banker_url"));
    banker=new Banker_TestCase(driver);
    banker.Verify_DD_Deposit_Valid_Transaction(Amount, Cheque_DD_CreditCardNumber, Customer_Company_name, AccoutNumber, Transaction_Type);
}


@Test(priority=7)
public void Verify_Cheque_Deposit_Valid_Transaction() throws Exception
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
	  String Transaction_Type1=properties.getProperty("Transaction_Type1");
	  String Cheque_DD_CreditCardNumber=properties.getProperty("Cheque_DD_CreditCardNumber");
	  String Amount=properties.getProperty("Amount");
    driver.get(properties.getProperty("banker_url"));
    banker=new Banker_TestCase(driver);
    banker.Verify_Cheque_Deposit_Valid_Transaction(Amount, Cheque_DD_CreditCardNumber, AccoutNumber, Transaction_Type1);
}


@Test(priority=8)
public void Verify_Cash_Deposit_Valid_Transaction() throws Exception
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
	  String Transaction_Type2=properties.getProperty("Transaction_Type2");
	  String Amount=properties.getProperty("Amount");
    driver.get(properties.getProperty("banker_url"));
    banker=new Banker_TestCase(driver);
    banker.Verify_Cash_Deposit_Valid_Transaction(Amount,AccoutNumber, Transaction_Type2);
}


@Test(priority=9)
public void Verify_DD_withdrawl_Valid_Transaction() throws Exception
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
	  String Transaction_Type3=properties.getProperty("Transaction_Type3");
	  String Cheque_DD_CreditCardNumber=properties.getProperty("Cheque_DD_CreditCardNumber");
	  String Customer_Company_name=properties.getProperty("Customer_Company_name");
	  String Amount=properties.getProperty("Amount");
    driver.get(properties.getProperty("banker_url"));
    banker=new Banker_TestCase(driver);
    banker.Verify_DD_withdrawl_Valid_Transaction(Amount, Customer_Company_name, Cheque_DD_CreditCardNumber, AccoutNumber, Transaction_Type3);
}


@Test(priority=10)
public void Verify_Cheque_withdrawl_Valid_Transaction() throws Exception
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
	String Transaction_Type4=properties.getProperty("Transaction_Type4");
	String Cheque_DD_CreditCardNumber=properties.getProperty("Cheque_DD_CreditCardNumber");
    String Amount=properties.getProperty("Amount");
    driver.get(properties.getProperty("banker_url"));
    banker=new Banker_TestCase(driver);
    banker.Verify_Cheque_withdrawl_Valid_Transaction(Amount, Cheque_DD_CreditCardNumber, AccoutNumber, Transaction_Type4);
}

 
@Test(priority=11)
public void Verify_Cash_withdrawl_Valid_Transaction() throws Exception
{
	String AccoutNumber=properties.getProperty("AccoutNumber");
	  String Transaction_Type5=properties.getProperty("Transaction_Type5"); 
	  String Amount=properties.getProperty("Amount");
    driver.get(properties.getProperty("banker_url"));
    banker=new Banker_TestCase(driver);
    banker.Verify_Cash_withdrawl_Valid_Transaction(Amount,  AccoutNumber, Transaction_Type5);
}


@AfterMethod//Invoke every @Test annotation after.
public void afterMethod(Method method) throws Exception 
{
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(src, new File(screen_path+method.getName()+".png"));
}

@BeforeClass//Invoke once before execution of all @Test annotations
public void beforeClass() throws IOException 
{
	  System.setProperty("webdriver.chrome.driver", Driver_Path);
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();  
	  
	  fi=new FileInputStream(property_file_path);
	  properties=new Properties();
	  properties.load(fi);
	 	 
}

@AfterClass //Invoke once after execution of all @Test annotations
public void afterClass() throws Exception 
{
	  Thread.sleep(10000);
	  driver.close();
}

}