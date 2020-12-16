package web_tests;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.Keys;
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

import admin_page.Admin_Branch;
import admin_page.Admin_Role;
import admin_page.Admin_home;
import admin_page.New_Branch_Creation;
import admin_page.New_Role_Creation;
import admin_page.RanfordHomePage;

public class Test_Roles {
	WebDriver driver;
	String Driver_Path="Drivers\\chromedriver.exe";
	String screen_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\screens\\";
	
	@Test(priority=1)
	public void Tc007_Admin_Create_New_Role_Valid() throws InterruptedException
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		Thread.sleep(2000);
		RHP.Click_login_btn();
		Thread.sleep(2000);
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Roles();
		
		New_Role_Creation NAR=new New_Role_Creation(driver);
		NAR.Click_on_new_Role();
		Thread.sleep(2000);
		NAR.Type_Role_Name("ASDFGF");
		NAR.Type_Role_Description("LKJHJ");
		NAR.Select_Role_Type("E");
		NAR.Click_on_Submit_btn();
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.else_Alert();
		
	}
	@Test(priority=3)
		public void Tc008_Admin_Create_New_Role_InValid() throws InterruptedException
		{
	    

	      
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		Thread.sleep(2000);
		RHP.Click_login_btn();
		Thread.sleep(2000);
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Roles();
		
		New_Role_Creation NAR=new New_Role_Creation(driver);
		NAR.Click_on_new_Role();
		Thread.sleep(2000);
		NAR.Type_Role_Description("LKJHJ");
		NAR.Select_Role_Type("E");
		NAR.Type_Role_Name("DEV");
	
		NAR.Click_on_Submit_btn();
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.else_Alert();
		
	}
		
	@Test(priority=2)
		public void Tc009_Admin_Create_New_Role_Blank() throws InterruptedException
		{
			RanfordHomePage RHP=new RanfordHomePage(driver);
			Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
			RHP.Type_Admin_Banker_username("Admin");
			RHP.Type_Admin_Banker_password("M1ndq");
			Thread.sleep(2000);
			RHP.Click_login_btn();
			Thread.sleep(2000);
			Admin_home AB=new Admin_home(driver);
			AB.Click_on_Roles();
			
			New_Role_Creation NAR=new New_Role_Creation(driver);
			NAR.Click_on_new_Role();
			NAR.Click_on_Submit_btn();
			Assert.assertTrue(NAR.is_AlertPresent());
			NAR.else_Alert();
			
	}
	@Test(priority=0)

	public void Tc0014_Role_delete()
	{
	RanfordHomePage RHP=new RanfordHomePage(driver);
	Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
	RHP.Type_Admin_Banker_username("Admin");
	RHP.Type_Admin_Banker_password("M1ndq");
	RHP.Click_login_btn();
	
	Admin_home AB=new Admin_home(driver);
	AB.Click_on_Roles();
	
	Admin_Role AR=new Admin_Role(driver);
	AR.Click_on_Delete_btn();
	Assert.assertTrue(AR.is_AlertPresent());
    AR.else_Alert();
    Assert.assertTrue(AR.is_AlertPresent());
    AR.else_Alert();
    
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