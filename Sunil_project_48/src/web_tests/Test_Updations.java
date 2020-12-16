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

import admin_page.Admin_Branch;
import admin_page.Admin_Employee;
import admin_page.Admin_Role;
import admin_page.Admin_Users;
import admin_page.Admin_home;
import admin_page.Branch_Edit_Updation;
import admin_page.Employee_Edit_Updation;
import admin_page.RanfordHomePage;
import admin_page.Role_Edit_Updation;
import admin_page.User_Edit_Updation;


public class Test_Updations {

	WebDriver driver;
	String Driver_Path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\DRIVERS\\chromedriver.exe";
	String screen_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\Screens\\";
	
	
	@Test(priority=0)
	public void Branch_Edit() throws InterruptedException
	{
		RanfordHomePage RHP=new RanfordHomePage(driver);
		Assert.assertTrue(RHP.Is_Ranford_Homepage_Opened());
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		Thread.sleep(2000);
		RHP.Click_login_btn();    
		Thread.sleep(3000);
		Admin_home AH= new Admin_home(driver);
		AH.Click_on_Branches();
		Admin_Branch branches= new Admin_Branch (driver);
		branches.Click_on_Edit_btn();

		Branch_Edit_Updation BE=new Branch_Edit_Updation(driver);
		BE.Type_Branch_Name("HayathNagar");
		BE.Type_Address1("Delhi");
		BE.Type_Address2("Mumbai");
		BE.Type_Address3("asdfkjjr");
		BE.Type_Area("SaiNagar");
		BE.Type_Zipcode("67890");
		 Thread.sleep(5000);
		BE.Click_On_Update_btn();
		 Assert.assertTrue(BE.is_AlertPresent());
		 BE.close_Alert();
	     
	}
	@Test(priority=1)
	public void Roles_Edit() throws InterruptedException
	{
		Admin_home AH= new Admin_home(driver);
		AH.Click_on_Roles();
		Admin_Role AR= new Admin_Role(driver);
		AR.Click_on_Edit_btn();
		
		Role_Edit_Updation RE=new Role_Edit_Updation(driver);
		RE.Type_Role_Name("tester");
		RE.Click_On_Update_btn();
		Assert.assertTrue(RE.is_AlertPresent());
	    RE.close_Alert();
	}

@Test(priority=2)
	public void Users_Edit() throws InterruptedException
	{
	
	Admin_home AH= new Admin_home(driver);
		AH.Click_on_Users();
		Admin_Users AU= new Admin_Users(driver);
		AU.Click_on_Edit_btn();
		User_Edit_Updation UEU= new User_Edit_Updation(driver);
		UEU.Click_On_Update_btn();
		Assert.assertTrue(UEU.is_AlertPresent());
		UEU.close_Alert();
	
	}



@Test(priority=3)
	public void Employee_Edit() throws InterruptedException
	{

	Admin_home AH= new Admin_home(driver);
		
	    AH.Click_on_Employee();
	    Admin_Employee AE= new Admin_Employee(driver);
	    AE.Click_on_Edit_btn();
	    Employee_Edit_Updation EEU=new Employee_Edit_Updation(driver);
	    EEU.Type_Login_Password("varshu");
	    Thread.sleep(2000);
	    EEU.Click_On_Update_btn();
	    Assert.assertTrue(EEU.is_AlertPresent());
	    EEU.close_Alert();
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
public void afterClass() throws InterruptedException 
{
	  Thread.sleep(10000);
	  driver.close();
}

}