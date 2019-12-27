package EncorDashboard.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import EncorDashboard.GlobalLibrary.GenericFunction;
import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;
import EncorDashboard.UserInterface.CreateDashboard;
import EncorDashboard.UserInterface.DashboardList;
import org.apache.log4j.Logger;


public class AddDashboard

{
	//testfile
    
	

	@BeforeMethod
	public void setUp() throws Exception {
		
    	 GlobalFunction.BrowsersSettings();
	     GlobalVariables.oDriver.get(GlobalVariables.LoginURL); 
	     GlobalVariables.oDriver.manage().window().maximize();
	    GlobalFunction.init();
	     DashboardList dl = new DashboardList();
	     dl.clickonAddDashboard();
		
	}
	
	
	
	@Test (dataProvider="IndicatorDashboard", dataProviderClass=AddDashboard.class)
	public void AddDashboard(String Column1,String Column2,String Column3,String Column4,String Column5,String Column6,String Column7) throws Exception {
		try
		{
			
			//savan add dashboard 
			//Changes for mahesh
			//changes for branch
		
			     System.out.println(Column1 +","+ Column2);
			
		     	 CreateDashboard cd = new CreateDashboard();
			
			      cd.createdashboard(Column1,Column2,Column3,Column4,Column5); 
			      
			      cd.SearchIndicatorGrid(Column6);
			      
			      cd.clickSavebutton(Column7);
			   			 
	     Assert.assertEquals(GlobalVariables.oDriver.getTitle(),"Manage Dashboard");			   
			 
		}
		catch (Exception e) {
			// TODO: handle exception
			GenericFunction.getScreenShot();
		}
	}
	
			//This data provider method will return 6 column's data one by one In every Iteration.
			@DataProvider
			public static Object[][] IndicatorDashboard(){
				//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
				//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
							
				return GlobalFunction.ReadXlData("IndicatorDashboard","Dashboard");
			}
	
	

	@AfterMethod
	public void tearDown() throws Exception {
		GlobalVariables.oDriver.quit();
		
		
	}

}
