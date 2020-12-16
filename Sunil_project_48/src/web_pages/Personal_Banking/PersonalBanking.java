package web_pages.Personal_Banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalBanking {

	WebDriver driver;
	public PersonalBanking(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='personal']")
	public WebElement Personal_Banking;
	
	@FindBy(xpath = "//input[@id='idtxt']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@id='idtxt']")
	public WebElement Password;
	
	@FindBy(xpath = "//input[@id='btnGO']")
	public WebElement Login_btn;
	
	public void Click_On_personal_Banking()
	{
		Personal_Banking.click();
	}
	public void Type_Username()
	{
		Username.clear();
		Username.sendKeys("shekarVarma");
	}
	public void Type_Password()
	{
		Password.clear();
		Password.sendKeys("shekarVarma");
	}
	public void Login_btn()
	{
		Login_btn.click();
	}
}
