package EncorDashboard.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EncorDashboard.GlobalLibrary.GenericFunction;
import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;
import EncorDashboard.UserInterface.CreateDashboard;
import EncorDashboard.UserInterface.DashboardGearWheelMenu;
import EncorDashboard.UserInterface.DashboardList;

public class VerifyDashboardData {
	


	@BeforeMethod
	public void setUp() throws Exception {
		
    	 GlobalFunction.BrowsersSettings();
	     GlobalVariables.oDriver.get(GlobalVariables.LoginURL); 
	     GlobalVariables.oDriver.manage().window().maximize();
	     GlobalFunction.init();
	  
		
	}
	
	@Test (dataProvider="DashboardData", dataProviderClass=VerifyDashboardData.class)
	public void VerifyDashboardData(String Column1,String Column2,String Column3,String Column4,String Column5,String Column6,String Column7,String Column8,String Column9,String Column10,String Column11,String Column12,String Column13,String Column14,String Column15,String Column16)
	 throws Exception {
		try
		{
			
			System.out.println(Column1 +","+ Column2);
			
			DashboardGearWheelMenu dgwm = new DashboardGearWheelMenu();
		   	  
	   	       dgwm.clickonDashboardIcon();
	      	  
	      	    dgwm.HoveronGearWheel(); 
			    
			    dgwm.ClickonChangeDashbd();
			    
			    GenericFunction.SaveVariable(Column1,Column2,Column3,Column4,Column5,Column6,Column7,Column8,Column9,Column10,Column11,Column12,Column13,Column14,Column15,Column16);
			    
			    GenericFunction.dbConnect();
			    			    			    		   			 
	          Assert.assertEquals(GlobalVariables.oDriver.getTitle(),"Add/Edit Dashboard");			   
			 
		}
		catch (Exception e) {
			// TODO: handle exception
			GenericFunction.getScreenShot();
		}
	}
	
			//This data provider method will return 6 column's data one by one In every Iteration.
			@DataProvider
			public static Object[][] DashboardData(){
				//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
				//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
							
				return GlobalFunction.ReadXlData("DashboardData","DataStorage");
			}
	
	

	@AfterMethod
	public void tearDown() throws Exception {
		GlobalVariables.oDriver.quit();
    		}

}
