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
import EncorDashboard.UserInterface.CreateDashboard;
import EncorDashboard.UserInterface.DashboardGearWheelMenu;
import EncorDashboard.UserInterface.DashboardList;
import org.apache.log4j.Logger;

public class ChangeDashboard {
	

	@BeforeMethod
	public void setUp() throws Exception {
		
		 GlobalFunction.BrowsersSettings();
	    GlobalVariables.oDriver.get(GlobalVariables.LoginURL);
	    GlobalVariables.oDriver.manage().window().maximize();
	    GlobalFunction.init();
		
	}
	
	//This is test commit
	@Test
	public void ChangeDashboard() throws Exception {
		try
		{
						
			DashboardGearWheelMenu dgwlm = new DashboardGearWheelMenu();
			
			  dgwlm.clickonDashboardIcon();
				    
			    dgwlm.HoveronGearWheel(); 
			    
			    dgwlm.ClickonChangeDashbd();
			    
			    Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lblDashboardName")).getText(),"HAC(M) :: All Categories"); 
			    
			  			
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
