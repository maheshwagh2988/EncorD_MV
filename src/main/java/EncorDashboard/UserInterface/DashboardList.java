package EncorDashboard.UserInterface;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;



public class DashboardList {
	
	
	@FindBy(xpath="//a[@id='ctl00_ctl00_IndigoLiteMasterContent_AdminBody_LnkDashboardMgmt']") WebElement Managedashboard;
	
	
	public DashboardList() {
		
		PageFactory.initElements(GlobalVariables.oDriver,this);
	}
	
	

	public void clickonAddDashboard() {
		// TODO Auto-generated method stub
		
						 
		
		try
		{	
			
		    GlobalFunction.ClickOnAdministration();
		    			
			GlobalVariables.oDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				
										           
			Managedashboard.click();		
		
			GlobalVariables.oDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	

}
