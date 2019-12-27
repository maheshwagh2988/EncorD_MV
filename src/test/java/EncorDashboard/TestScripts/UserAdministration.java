package EncorDashboard.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;
import EncorDashboard.UserInterface.Administration;
import EncorDashboard.UserInterface.DashboardGearWheelMenu;

public class UserAdministration {
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		 GlobalFunction.BrowsersSettings();
		    GlobalVariables.oDriver.get(GlobalVariables.LoginURL);
		    GlobalVariables.oDriver.manage().window().maximize();
		    GlobalFunction.init();
		
	}
	
	
	@Test
	public void UserAdministration() throws Exception {
		try
		{
			
			
		   	  Administration adm = new Administration();
			 
			     adm.clickonAdministrationIcon();
			     
			     adm.clickUserAdministration();
			     
			     adm.SelectUserdropdown();
			     
			     adm.clickSaveAccess();
			     
			     System.out.println(GlobalVariables.oDriver.findElement(By.cssSelector("span#ui-dialog-title-accessUpdatedDialog")).getText());
			     
			     Assert.assertEquals(GlobalVariables.oDriver.findElement(By.cssSelector("span#ui-dialog-title-accessUpdatedDialog")).getText(),"User Updated");
					        
		//	    Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("UserInformation_UserFName")).getText(),"savan");
			    
			  //  Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("UserInformation_UserLName")).getText(),"vadalia");
			    
			  			
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
