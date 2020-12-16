package keywords;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Repository 
{
	protected WebDriver driver;
	Robot robot;
	String Screen_filepath="C:\\Users\\SUNIL\\git\\Sunil_Project_48\\Sunil_Project_48\\screens\\";
	WebDriverWait wait;
	
	

	
	public Repository(WebDriver driver) 
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	/*
	 * keyword:==> Method verify alert presented at webpage and return boolean
	 * 				value true/false.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean is_AlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/*
	 * keyword:==> Method Close alert after verifying alert presented at webpage
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public void close_Alert()
	{
		if(is_AlertPresent())
			driver.switchTo().alert().accept();
		else
			System.out.println("Alert not presented");
	}
	
	/*
	 * keyword:==> Method verify expected alert message presented
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	
	public boolean Verify_Alert_message(String Exp_message)
	{
		try {
			return driver.switchTo().alert().getText().contains(Exp_message);
		} catch (Exception e) {
			return false;
		}
	
	}
	
	/*
	 * keyword:==> Capture screen on alert presented
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 * Note:--> Make sure Applicatio visible while capture screen..
	 */
	public void Capture_Screen_At_Alert(String filename) throws Exception
	{
		Dimension scree_size=Toolkit.getDefaultToolkit().getScreenSize();
		robot=new Robot();
		BufferedImage Bimage=robot.createScreenCapture(new Rectangle(scree_size));
		ImageIO.write(Bimage, "PNG", new File(Screen_filepath+filename+".png"));
	}
	
	
	/*
	 * keyword:==> Screen Capture at webpage.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public void Caputure_Screen_At_WeBpage(String Filename)
	{
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(Screen_filepath+Filename+".PNG"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/*
	 * keyword:==> Wait for element to visible at webapge
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public WebElement wait_element_to_visible(WebElement element)
	{
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	/*
	 * keyword:==> Wait for until element hide at webpage
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean wait_element_to_Hide(WebElement element)
	{
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	
	/*
	 * keyword:==> Wait for until element hide at webpage
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean wait_for_alert()
	{
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	
	/*
	 * keyword:==> Type text into editbox.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public void Type_text(WebElement element,String input)
	{
		element.clear();
		element.sendKeys(input);
	}
	

	/*
	 * keyword:==> Select dropdown using visible text
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public void Select_Dropdown(WebElement element,String OptinName)
	{
		new Select(element).selectByVisibleText(OptinName);
		
	}
	
	
	/*
	 * keyword:==> Element click on any location..
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public void click_element(WebElement element)
	{
		element.click();
		
	}
	
	/*
	 * keyword:==> Verify title presented at current window.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean Is_title_presented(String exp_title)
	{
		return driver.getTitle().contains(exp_title);
	}
	
	
	/*
	 * keyword:==> Verify url  presented at current window.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean Is_url_presented(String exp_url)
	{
		return driver.getCurrentUrl().contains(exp_url);
	}
	
	
	/*
	 * keyword:==> Method verify expected inptu value available at editbox and return boolean value
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean Verify_input_Value(WebElement Element,String Expected_input)
	{
		String Return_Value=Element.getAttribute("value");
		return Return_Value.equals(Expected_input);
	}
	
	
	/*
	 * keyword:==> Method get Input value from editbox.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public String Get_editbox_input(WebElement Element)
	{
		String Return_Value=Element.getAttribute("value");
		return Return_Value;
	}
	
	
	
	
	/*
	 * keyword:==> Method wait for element to visible and boolea value.
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean wait_and_verify_element_visible(WebElement Element)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(Element)).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}
	
	
	/*
	 * keyword:==> Verify Location Text
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public String get_location_text(WebElement element)
	{
		return element.getText();
		
	}
	
	
	/*
	 * keyword:==> Verify Location Text
	 * Author:-->
	 * Created-on:-->
	 * ReviewedBy:-->
	 * Parameters used:-->
	 * Last updated date:-->
	 */
	public boolean Verify_location_Text(WebElement element,String Exp_text)
	{
		wait_element_to_visible(element);
		return get_location_text(element).contains(Exp_text);
		
	}
}