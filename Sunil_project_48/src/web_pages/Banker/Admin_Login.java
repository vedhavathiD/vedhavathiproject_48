package web_pages.Banker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Login {
	WebDriver driver;
    private String url="http://122.175.8.158/Ranford2/";
    private String title="MINDQ RANFORD BANK";
    public String username="Admin";
	public String password="Admin";
	
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			driver.get(url);
			
		}
	   
		@FindBy(xpath="//a[@href='http://ravinderbasani.com']")
		public WebElement Home_btn;
		
		@FindBy(xpath = "//input[@id='txtuId']")
		public WebElement Admin_Banker_username;

		@FindBy(xpath="//input[@name='txtPword']")
		public WebElement Admin_Banker_password;
		
		@FindBy(xpath = "//input[@id='login']")
		public WebElement Login_btn;
		
		@FindBy(xpath="//a[@href='personal_banking.html']")
		public WebElement Personal_Banking_btn;
		
		@FindBy(xpath="//a[@ href=\"savings_account.html']")
		public WebElement savings_account;
		
		@FindBy(xpath="//a[@href=\"fixed_deposits.html']")
		public WebElement fixed_deposits;
		
		@FindBy(xpath="//a[@ href=\"moneytrans.html']")
		public WebElement moneytrans;
		 
		@FindBy(xpath="//a[@ href=\"cards.html']")
		public WebElement  cards;
		
		@FindBy(xpath="//a[@ href=\"loans.html']")
		public WebElement loans;
		
		@FindBy(xpath="//a[@ href=\"payments.html']")
		public WebElement payments;
		
		@FindBy(xpath="//a[@ href='Corporate Banking.html']")
		public WebElement Corporate_Banking_btn;
		
		@FindBy(xpath="//a[@href='International Banking.html']")
		public WebElement International_Banking_btn;
		
		@FindBy(xpath="//a[@href='aboutus.html']")
		public WebElement About_us_btn; 
		
		@FindBy(xpath = "//a[@href='customerServices.html']")
		public WebElement Customer_Service;
		
		@FindBy(xpath = "//a[@href='faqs.html']")
		public WebElement Internet_Banking;
		
		@FindBy(xpath = "//a[@href='privacy.html']")
		public WebElement Privacy;
		
		@FindBy(xpath = "//a[@href='terms&conditions.html']")
		public WebElement Terms_and_Conditions;
		
		@FindBy(xpath = "//a[@href='disclaimer.html']")
		public WebElement Disclaimer;
		
		@FindBy(xpath = "//a[@href='sitemap.html']")
		public WebElement sitemap;
		
	
		
		public boolean Is_Ranford_Homepage_Opened()
		{
			String Runtime_title=driver.getTitle();
			boolean flag=Runtime_title.contains(title);
			return flag;
		}
		public void Click_on_Home_btn()
		{
			Home_btn.click();
		}
		

		public void Click_login_btn()
		{
			Login_btn.click();
			
		}
		public void Type_Admin_Banker_username(String username)
		{
			Admin_Banker_username.clear();
			Admin_Banker_username.sendKeys(username);
		}

		public void Type_Admin_Banker_password(String password)
		{
			Admin_Banker_password.clear();
			Admin_Banker_password.sendKeys(password);
		}
	
		
		public void Click_on_Personal_banking_btn()
		{
			Personal_Banking_btn.click();
		}
		public void Click_on_savings_account()
		{
			savings_account.click();
		}
		public void Click_on_fixed_deposits()
		{
			fixed_deposits.click();
		}
		public void Click_on_moneytrans()
		{
			moneytrans.click();
		}
		public void Click_on_cards()
		{
			cards.click();
		}
		public void Click_on_loans()
		{
			loans.click();
		}
		public void Click_on_payments()
		{
			payments.click();
		}
		public void Click_on_Corporate_Banking_btn()
		{
			Corporate_Banking_btn.click();
		}
		public void Click_on_International_Banking_btn()
		{
			International_Banking_btn.click();
		}
		public void Click_on_About_us_btn()
		{
			About_us_btn.click();
		}
		public void Click_on_Customer_Service()
		{
			Customer_Service.click();
		}
		public void Click_on_Internet_Banking()
		{
			Internet_Banking.click();
		}
		public void Click_on_Privacy()
		{
			Privacy.click();
		}
		public void Click_on_Terms_and_Conditions()
		{
			Terms_and_Conditions.click();
		}
		public void Click_on_Disclaimer()
		{
			Disclaimer.click();
		}
		public void Click_on_Site_Map()
		{
			sitemap.click();
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

