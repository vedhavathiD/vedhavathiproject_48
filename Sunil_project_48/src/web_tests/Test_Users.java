package web_tests;

import org.testng.annotations.Test;

import com.sun.jmx.mbeanserver.Repository;

import org.testng.annotations.BeforeMethod;


import admin_page.Admin_Branch;
import admin_page.Admin_Users;
import admin_page.Admin_home;
import admin_page.New_Branch_Creation;
import admin_page.New_Role_Creation;
import admin_page.New_User_Creation;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
public class Test_Users {
	WebDriver driver;
	String Driver_Path="Drivers\\chromedriver.exe";
	String screen_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\screens\\";
	@Test(priority=1)
	public void Tc0017_Admin_Create_New_User_Valid() throws InterruptedException 
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		Admin_home AB=new Admin_home(driver);
		AB.Click_on_Users();
		 
		Admin_Users AU=new Admin_Users(driver);
	    AU.Click_on_New_User();
	    New_User_Creation NAC=new New_User_Creation(driver);
	    NAC.Select_Select_Role("icustomer");
	    NAC.Select_Select_Branch("HayathNagar");
	    NAC.Select_Customer_ID("35");
	    NAC.Type_Enter_Customer_Name("naveengolla");
	    NAC.Type_Enter_UserName("vedha");
	    NAC.Type_Enter_Password("naveengolla");
	    NAC.Type_Enter_Transaction_Password("naveengolla");
	   NAC.Click_On_Submit_btn();
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
