package EncorDashboard.UserInterface;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;


public class CreateDashboard {
	
	
	@FindBy(name="ctl00$ctl00$IndigoLiteMasterContent$AdminBody$dashboardGrid$Title$AddButton") WebElement AddDashboard;
	
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_NewDashboardRoundPanel_newDashboardName") WebElement DashboardName;
	
	@FindBy(name="ctl00$ctl00$IndigoLiteMasterContent$AdminBody$NewDashboardRoundPanel$ddlDashboardType") WebElement DashboardType;
	
	@FindBy(name="ctl00$ctl00$IndigoLiteMasterContent$AdminBody$NewDashboardRoundPanel$newDashboardView") WebElement DashboardView;
	
	@FindBy(id="ddlCalOrFiscal") WebElement Calendar;
	
	@FindBy(name="ctl00$ctl00$IndigoLiteMasterContent$AdminBody$NewDashboardRoundPanel$addIndicatorsGridView$DXFREditorcol0") WebElement IndicatorName;
		
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_NewDashboardRoundPanel_addIndicatorsGridView_header8_SelectAllCheckBox") WebElement SelectIndicator;
			
	@FindBy(xpath="//input[@id ='ctl00_ctl00_IndigoLiteMasterContent_AdminBody_NewDashboardRoundPanel_newDashboardButton']") WebElement SaveButton;
	
	public CreateDashboard() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(GlobalVariables.oDriver, this);
	}
	
	

	public void createdashboard(String column1, String column2, String column3,	String column4, String column5) throws InterruptedException 
	
	{
		// TODO Auto-generated method stub
		
		if(column5.contentEquals("Y"))
			
	 {
		   GlobalVariables.oDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		   AddDashboard.click();
				
	      GlobalVariables.oDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	      DashboardName.sendKeys(column1);
		
	      Select dt1= new Select(DashboardType);
		  
	       dt1.selectByVisibleText(column2);
	       
	       GlobalFunction.Add_Log.info("DashboardType is selected");
	       
	       GlobalVariables.oDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				       	       		       
	       Select dt2= new Select(DashboardView);
			  
	       dt2.selectByVisibleText(column3);
	       
	       GlobalFunction.Add_Log.info("View is selected");
	       
	       GlobalVariables.oDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			       
	       Select dt3= new Select(Calendar);
			  
	       dt3.selectByVisibleText(column4);
	       
	       GlobalFunction.Add_Log.info("Calender/Fiscal is selected");
	       
		}
	}
		
		public void SearchIndicatorGrid(String column6) throws InterruptedException
		{
			
	       
        GlobalVariables.oDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		IndicatorName.clear();
		
		GlobalVariables.oDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
				
		IndicatorName.sendKeys(column6);
					
	   	GlobalVariables.oDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	   	     
	  // 	Thread.sleep(10000);
	   		   		   	
	   //	GlobalVariables.oDriver.findElement(By.id("ctl00_ctl00_IndigoLiteMasterContent_AdminBody_NewDashboardRoundPanel_addIndicatorsGridView_Title_headerGridText")).click();
	   	
	    GlobalFunction.Add_Log.info("Search indicator in grid");
		 
		 Thread.sleep(10000);
		 
		 GlobalVariables.oDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		 
		 String IndicatorName =   GlobalVariables.oDriver.findElement(By.xpath("//tr[@id='ctl00_ctl00_IndigoLiteMasterContent_AdminBody_NewDashboardRoundPanel_addIndicatorsGridView_DXDataRow0']/td[1]")).getText();		    
		   		       
		 if(column6.contentEquals(IndicatorName));
		    
		 {
		   		 		
	     SelectIndicator.click();
	 
	     GlobalVariables.oDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
         GlobalFunction.Add_Log.info("click on checkbox");
            
         GlobalVariables.oDriver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
         
         GlobalVariables.oDriver.findElement(By.name("ctl00$ctl00$IndigoLiteMasterContent$AdminBody$NewDashboardRoundPanel$addIndicatorsGridView$DXFREditorcol0")).clear();
                                                       
         Thread.sleep(10000);
       
		
		}
	}
		
		public void clickSavebutton(String flag) throws InterruptedException
		
		{ 
                                               
           if(flag.contentEquals("N"))
         {	
        	   
        	   //Scroll down browser then click on save button
   		    
   		    Actions action = new Actions(GlobalVariables.oDriver);
   		    
   		        Thread.sleep(1000);
   		        
   		        action.sendKeys(Keys.PAGE_DOWN).build().perform();
   		    
   		        action.sendKeys(Keys.PAGE_DOWN).build().perform();
   		        
   		     Thread.sleep(2000);
	    	
   		        SaveButton.click();
   		        
   		     Thread.sleep(6000);
	    		    	
	         EncorDashboard.GlobalLibrary.GlobalFunction.Add_Log.info("Dashboard is saved");
		 		
	   }
		
    }
}




