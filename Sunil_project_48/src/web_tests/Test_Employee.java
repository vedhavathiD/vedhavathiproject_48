package web_tests;

import java.io.File;
import java.lang.reflect.Method;

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

import admin_page.Admin_Employee;
import admin_page.Admin_Role;
import admin_page.Admin_home;
import admin_page.New_Employee_Creation;
import admin_page.New_Role_Creation;
import admin_page.RanfordHomePage;

public class Test_Employee {
	WebDriver driver;
	String Driver_Path="Drivers\\chromedriver.exe";
	String screen_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\screens\\";
	
	@Test(priority=2)
	public void Tc010_Admin_Create_New_Employee_Valid() throws InterruptedException
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		Thread.sleep(2000);
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		Thread.sleep(2000);
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Employee();
		
		New_Employee_Creation NAE=new New_Employee_Creation(driver);
		NAE.Click_on_new_Employee();
		Thread.sleep(2000);
        NAE.Type_Employee_Username("VEDHA");
		NAE.Type_Employee_Password("12345");
		NAE.Select_Role_dropdown("ASDFGF");
		NAE.Select_Branch_dropdown("armoor");
		NAE.Click_on_Submit_btn();
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.else_Alert();
	}@Test(priority=1)
	public void Tc011_Admin_Create_New_Employee_InValid() throws InterruptedException
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		Thread.sleep(2000);
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		Thread.sleep(2000);
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Employee();
		
		New_Employee_Creation NAE=new New_Employee_Creation(driver);
		NAE.Click_on_new_Employee();
		Thread.sleep(2000);
        NAE.Type_Employee_Username("VEDHAVATHI");
		NAE.Type_Employee_Password("12345");
		NAE.Select_Role_dropdown("ASDFGF");
		NAE.Select_Branch_dropdown("armoor");
		NAE.Click_on_Submit_btn();
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.else_Alert();
		
	}
	@Test(priority=3)
	public void Tc012_Admin_Create_New_Employee_Blank() throws InterruptedException
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		Thread.sleep(2000);
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		Thread.sleep(2000);
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Employee();
		
		New_Employee_Creation NAE=new New_Employee_Creation(driver);
		NAE.Click_on_new_Employee();
		Thread.sleep(2000);
		NAE.Click_on_Submit_btn();
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.else_Alert();
	}
	@Test(priority=0)

	public void Tc0015_Employee_delete()
	{
	RanfordHomePage RHP=new RanfordHomePage(driver);
	Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
	RHP.Type_Admin_Banker_username("Admin");
	RHP.Type_Admin_Banker_password("M1ndq");
	RHP.Click_login_btn();
	
	Admin_home AB=new Admin_home(driver);
	AB.Click_on_Employee();
	
	Admin_Employee AE=new Admin_Employee(driver);
	AE.Click_on_Delete_btn();
	Assert.assertTrue(AE.is_AlertPresent());
    AE.else_Alert();
    Assert.assertTrue(AE.is_AlertPresent());
    AE.else_Alert();
    
	}
	  @AfterMethod//Invoke every @Test annotation after.
	  public void afterMethod(Method method) throws Exception 
	  {
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src, new File(screen_path+method.getName()+".png"));
	  }
	  @BeforeClass//Invoke once before execution of all @Test annotations
	  public void beforeClass() 
	  {
		  System.setProperty("webdriver.chrome.driver", Driver_Path);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();  
	  }
	  @AfterClass //Invoke once after execution of all @Test annotations
	  public void afterClass() throws Exception 
	  {
		  Thread.sleep(10000);
		  driver.close(); 
	  }
	
}