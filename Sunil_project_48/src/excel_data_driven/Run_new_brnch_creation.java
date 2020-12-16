package excel_data_driven;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Run_new_brnch_creation {
	 String Driver_Path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\DRIVERS\\chromedriver.exe";
	  String screen_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\Screens\\";
	  String InputData_file_path="C:\\Users\\Lenovo\\git\\vedhavathiproject_48\\Sunil_project_48\\resource\\InputData.xlsx";
	  FileInputStream fi;
	  Properties properties;
	  WebDriver driver;
	  New_branch_test banker;
	  
	  @Test(priority=0)
	  public void  New_Brnch_Creation()
	  
	  {
	 
		  banker=new New_branch_test(driver);
		  banker.New_Brnch_Creation();
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
	  
	  fi=new FileInputStream(InputData_file_path);
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
