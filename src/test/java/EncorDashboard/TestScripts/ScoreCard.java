package EncorDashboard.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;
import EncorDashboard.UserInterface.DashboardGearWheelMenu;

public class ScoreCard {
	


	@BeforeMethod
	public void setUp() throws Exception {
		
		 GlobalFunction.BrowsersSettings();
	    GlobalVariables.oDriver.get(GlobalVariables.LoginURL);
	    GlobalVariables.oDriver.manage().window().maximize();
	    GlobalFunction.init();
		
	}
	
	
	@Test
	public void ScoreCardDashboard() throws Exception {
		try
		{
						
			DashboardGearWheelMenu dgwlm = new DashboardGearWheelMenu();
			
			 // dgwlm.clickonDashboardIcon();
			  
			 			  
			//  dgwlm.ClickonChangeDashbd();
			
			   dgwlm.HoveronGearWheel();
			    	    
			    dgwlm.ClickonMonthlyGraph();
			    
			   /* Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lblDashboardName")).getText(),"HAC(M) :: All Categories");
			    
			    dgwlm.HoveronGearWheel();
			    
			    dgwlm.ClickonQuarterlyScoreCard();
			    
			    Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lblDashboardName")).getText(),"HAC(Q) :: All Categories");
			    
			    dgwlm.HoveronGearWheel();
			    
			    dgwlm.ClickonQuarterlyGraph();
			    
			    Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lblDashboardName")).getText(),"HAC(Q) :: All Categories");
			    
			    dgwlm.HoveronGearWheel();
			    
			    dgwlm.ClickonYearlyGuage();
			    
			    Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lblDashboardName")).getText(),"HAC(Y) :: All Categories");
			    
			   dgwlm.ClickonHospitalScoreCard();
			   
			   Assert.assertEquals(GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lblDashboardName")).getText(),"HAC(H) :: All Categories"); */
			    
			 
			    
			  			
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
