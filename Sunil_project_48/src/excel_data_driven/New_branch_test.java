package excel_data_driven;


import org.openqa.selenium.WebDriver;

import admin_page.Admin_Branch;
import admin_page.Admin_home;
import admin_page.New_Branch_Creation;
import admin_page.RanfordHomePage;
import keywords.Excel_Keywords;
import keywords.Repository;


public class New_branch_test extends Repository
{
	public New_branch_test(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}


 public void New_Brnch_Creation()
 {
	
		RanfordHomePage RHP=new RanfordHomePage(driver);
		RHP.Type_Admin_Banker_username("Admin");
		RHP.Type_Admin_Banker_password("M1ndq");
		RHP.Click_login_btn();
		Admin_home AH=new Admin_home(driver);
		AH.Click_on_Branches();
		Admin_Branch AB=new Admin_Branch(driver);
		AB.Click_on_New_Branch();
		 New_Branch_Creation NB=new  New_Branch_Creation(driver);
		 Excel_Keywords.get_workbook("InputData", "Sheet3");
		 Type_text(NB.Branch_Name,Excel_Keywords.get_cell_Data(1, 0));
		 Type_text(NB.Address1,Excel_Keywords.get_cell_Data(1, 1));
		 Type_text(NB.Zip_Code,Excel_Keywords.get_cell_Data(1, 2));
		 Select_Dropdown(NB.Select_Country_Name,Excel_Keywords.get_cell_Data(1, 3));
		 Select_Dropdown(NB.Select_StateName,Excel_Keywords.get_cell_Data(1, 4));
		 Select_Dropdown(NB.Select_City_Name,Excel_Keywords.get_cell_Data(1, 5));
		
		 
		 
}
}


