package EncorDashboard.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EncorDashboard.GlobalLibrary.GenericFunction;
import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;
import EncorDashboard.UserInterface.Administration;
import EncorDashboard.UserInterface.DashboardGearWheelMenu;

public class SetDashboardData {
	
	
	

	@BeforeMethod
	public void setUp() throws Exception {
		
		 GlobalFunction.BrowsersSettings();
		    GlobalVariables.oDriver.get(GlobalVariables.LoginURL);
		    GlobalVariables.oDriver.manage().window().maximize();
		    GlobalFunction.init();
		
	}
	
	
	@Test
	public void UserAccess() throws Exception {
		try
		{
		
		      	  DashboardGearWheelMenu dgwm = new DashboardGearWheelMenu();
		   	  
		   	        dgwm.clickonDashboardIcon();
		      	  
		      	    dgwm.HoveronGearWheel(); 
				    
				   dgwm.ClickonChangeDashbd();
		   	      
		   	        dgwm.SetDashboardRate();
		   	      
		   	          
		   	          	      
		   	  			         
			  			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	

	@AfterMethod
	public void tearDown() throws Exception {
		
		GlobalVariables.oDriver.quit();
    		}
}
