package admin_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Edit_Updation {
	
		WebDriver driver;
		private String url="http://122.175.8.158/Ranford2/home.aspx";
		private String title="UserDetails";
		public User_Edit_Updation(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(xpath = "(//input[contains(@maxlength,'16')])[1]")
		public WebElement Enter_Username;
		
		@FindBy(xpath = "//input[@id='txtLPwd']")
		public WebElement Enter_Password;
		
		@FindBy(xpath = "//input[@id='txtTPwd']")
		public WebElement Enter_Transaction_Password;
		
		@FindBy(xpath = "//input[@id='btn_edit']")
		public WebElement Update_btn;
		
		@FindBy(xpath = "//input[@id='btnCancel']")
		public WebElement Cancel_btn;
		public boolean Is_User_UpdationPage_Displayed()
		{

			String Runtime_title=driver.getTitle();
			boolean flag= Runtime_title.contains(title);
			return flag;
		}

		public void Type_Enter_UserName(String username)
		{
			Enter_Username.clear();
			Enter_Username.sendKeys(username);
		}
		public void Type_Enter_Password(String pwd)
		{
			Enter_Password.clear();
			Enter_Password.sendKeys(pwd);
		}
		public void Type_Enter_Transaction_Password(String transaction_pwd)
		{
			Enter_Transaction_Password.clear();
			Enter_Transaction_Password.sendKeys(transaction_pwd);
		}
		
		public void Click_On_Update_btn()
		{
			Update_btn.click();
		}
		public void Click_On_Cancel_btn()
		{
			Cancel_btn.click();
		}
		public boolean is_AlertPresent()
		{
			try {
				driver.switchTo().alert();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		
		public void close_Alert()
		{
			if(is_AlertPresent())
				driver.switchTo().alert().accept();
			else
				System.out.println("Alert not presented");
		}
		
		

}

