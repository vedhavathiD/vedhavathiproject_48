package web_tests;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import admin_page.Admin_Branch;
import admin_page.Admin_home;
import admin_page.New_Branch_Creation;
import admin_page.RanfordHomePage;
import sun.reflect.generics.scope.MethodScope;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
public class Test_Branches 
{
	
	WebDriver driver;
	String Driver_Path="Drivers\\chromedriver.exe";
	String screen_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\screens\\";
	
	

	@Test(priority=7)
	public void Tc001_Admin_login_Invalid_Password()
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username(RHP.username);
		RHP.Type_Admin_Banker_password(RHP.password);
		RHP.Click_login_btn();
		
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.else_Alert();
		
	}


	@Test(priority=1)
	public void Tc002_Admin_login_Invalid_Username()
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("dfjfj");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		
		Assert.assertTrue(RHP.is_AlertPresent());
		RHP.else_Alert();


	}



	@Test(priority=2)
	public void Tc003_Admin_login_valid()
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		
		

	}
	 
	@Test(priority=3,dependsOnMethods="Tc003_Admin_login_valid")
	public void Tc004_Admin_Create_New_branch_Valid() throws InterruptedException
	{
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Branches();
		
		New_Branch_Creation NAB=new New_Branch_Creation(driver);
		Assert.assertTrue(NAB.Is_Ranford_New_Branchpage_Opened());
		NAB.Click_on_New_Branch();
		NAB.Type_Branch_Name("armoor");
		NAB.Type_Address1("Mig 1-20");
		NAB.Type_Address2("HB Colony");
		NAB.Type_Address3("Armoor");
		NAB.Type_Area_textbox("kshtriya marg");
		NAB.Type_Zip_Code("50322");
		Thread.sleep(2000);
		NAB.Select_Country_dropdown("INDIA");
		Thread.sleep(4000);
		NAB.Select_State_dropdown("Andhra Pradesh");
		Thread.sleep(4000);
		NAB.Select_City_dropdown("Hyderabad");
		Thread.sleep(4000);
		NAB.Click_on_Submit_btn();
		Assert.assertTrue(NAB.is_AlertPresent());
		NAB.else_Alert();


	}
	@Test(priority=6)
  public void Tc005_Admin_Create_New_branch_Invalid_BranchName()

  {
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Branches();
		
		New_Branch_Creation NAB=new New_Branch_Creation(driver);
		Assert.assertTrue(NAB.Is_Ranford_New_Branchpage_Opened());
		
		NAB.Click_on_New_Branch();
		NAB.Type_Branch_Name("xc");
		Assert.assertTrue(NAB.is_AlertPresent());
		NAB.else_Alert();
		NAB.Type_Address1("Mig 1-20");
		NAB.Type_Address2("HB Colony");
		NAB.Type_Address3("Armoor");
		NAB.Type_Area_textbox("kshtriya marg");
		NAB.Type_Zip_Code("50322");
		NAB.Select_Country_dropdown("INDIA");
		NAB.Select_State_dropdown("Andhra Pradesh");
		NAB.Select_City_dropdown("Hyderabad");
		NAB.Click_on_Submit_btn();
		Assert.assertTrue(NAB.is_AlertPresent());
		NAB.else_Alert();


	}
	@Test(priority=4)
	  public void Tc006_Admin_Create_New_branch_Blank()

	  {

		    Admin_home AB=new Admin_home(driver);
	       	AB.Click_on_Branches();
			New_Branch_Creation NAB=new New_Branch_Creation(driver);
			Assert.assertTrue(NAB.Is_Ranford_New_Branchpage_Opened());
			NAB.Click_on_New_Branch();
			NAB.Click_on_Submit_btn();
			Assert.assertTrue(NAB.is_AlertPresent());
			NAB.else_Alert();
			RanfordHomePage RHP=new RanfordHomePage(driver);
			RHP.Click_on_Home_btn();
		}
	@Test(priority=0)

		public void Tc0013_Branch_delete()
		{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Branches();
		
		Admin_Branch Ab=new Admin_Branch(driver);
		Ab.Click_on_Delete_btn();
		Assert.assertTrue(Ab.is_AlertPresent());
	    Ab.else_Alert();
	    Assert.assertTrue(Ab.is_AlertPresent());
	    Ab.else_Alert();
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