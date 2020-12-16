package admin_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Employee {
    WebDriver driver;
	private String url="http://122.175.8.158/Ranford2/adminflow.aspx";
    private String title="RANFORD BANK";
    
	public Admin_Employee(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get(url);
	}	
	
    @FindBy(xpath="//a[@href='adminflow.aspx']")
	public WebElement new_Employee;
	
    @FindBy(xpath = "(//img[@src='images/b-edit.png'])[1]")
	public WebElement Edit_button;
	
    @FindBy(xpath = "(//img[@border='0'])[8]")
	public WebElement Delete_btn;
	
	public boolean Is_Ranford_Employeepage_Opened()
	{
		String Runtime_title=driver.getTitle();
		boolean flag=Runtime_title.contains(title);
		return flag;
	}
	public void Click_on_new_Employee()
	{
		new_Employee.click();
	}
		
		public void Click_on_Edit_btn()
		{
			 Edit_button.click();
		}
		public void Click_on_Delete_btn()
		{
			 Delete_btn.click();
		}
		public boolean is_AlertPresent() {
			try {
				driver.switchTo().alert();
				return true;
			}
			catch(Exception e) {
			return false;
		}
		
		}
		public void else_Alert() {

			if(is_AlertPresent())
				driver.switchTo().alert().accept();
			else
				System.out.println("Alert not presented");
				}
			
}
