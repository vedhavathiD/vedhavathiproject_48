package admin_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_home {
	WebDriver driver;

public Admin_home(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//img[@src='images/Branches_but.jpg']")
public WebElement Branches;
@FindBy(xpath = "//img[@src='images/Roles_but.jpg']")
public WebElement Roles;
@FindBy(xpath = "(//img[@border='0'])[6]")
public WebElement Users;
@FindBy(xpath = "//img[@src='images/emp_btn.jpg']")
public WebElement Employee;


public void Click_on_Branches()
{
	Branches.click();
}
public void Click_on_Roles()
{
	Roles.click();
}
public void Click_on_Users()
{
	Users.click();
}
public void Click_on_Employee()
{
	Employee.click();
}
}