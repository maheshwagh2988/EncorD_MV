package EncorDashboard.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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
import EncorDashboard.UserInterface.DashboardGearWheelMenu;

public class ExportFile {
	

	
	@BeforeMethod
	public void setUp() throws Exception {
		
		 GlobalFunction.BrowsersSettings();
		    GlobalVariables.oDriver.get(GlobalVariables.LoginURL);
		    GlobalVariables.oDriver.manage().window().maximize();
		    GlobalFunction.init();
		
	}
	
	
	@Test
	public void ExportDashboard() throws Exception {
		try
		{
						
			DashboardGearWheelMenu dgwlm = new DashboardGearWheelMenu();
			
			   dgwlm.clickonDashboardIcon();
				    
			    dgwlm.HoveronGearWheel(); 
			    
			    dgwlm.ClickonExportFile();
			    
			 //   dgwlm.VerifyExportedFile();
			    
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
