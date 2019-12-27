package EncorDashboard.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;
import EncorDashboard.UserInterface.Administration;

public class UserAccess {
	


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
		
		   	  Administration adm = new Administration();
			 
			     adm.clickonAdministrationIcon();
			     
			     adm.clickUserAccess();
			     
			     adm.SelectGroups();
			     
			     adm.SelectNotINGroups();
			     
			     adm.SelectINGroups();
					        
			    
			  			
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
