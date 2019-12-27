package EncorDashboard.UserInterface;
import EncorDashboard.GlobalLibrary.GenericFunction;
import EncorDashboard.GlobalLibrary.GlobalFunction;
import EncorDashboard.GlobalLibrary.GlobalVariables;
import EncorDashboard.UserInterface.CreateDashboard;
import EncorDashboard.UserInterface.DashboardList;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class DashboardGearWheelMenu {
	
	
	String mainWindowHandle;
	Actions acns;
	
	@FindBy (xpath="//a[@id='show-dashboard-popup']") WebElement clickPopup;
	
	@FindBy (name="ctl00$IndigoLiteMasterContent$dashboardNavigation$txtSearchCriteria") WebElement EnterDashboardName;
	
	@FindBy (className="DashboardName") WebElement clickDashboard;
	
	
	
	public DashboardGearWheelMenu() {
		PageFactory.initElements(GlobalVariables.oDriver,this);
	}
	
	public void clickonDashboardIcon()
	{
		try
		{			
			GlobalFunction.ClickOnDashboard();
			
			GlobalVariables.oDriver.navigate().refresh();
			
			
			Thread.sleep(8000);
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
	}
		
				
	public void HoveronGearWheel()
	{
		try
		
		{
			
			 String mainWindowHandle=GlobalVariables.oDriver.getWindowHandle();
			 
			 GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_DivGearWheelMenu")).click();
			
			/*GlobalVariables.oElement = GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_DivGearWheelMenu"));
				
			 acns = new Actions(GlobalVariables.oDriver);
					
			acns.moveToElement(GlobalVariables.oElement).build().perform();*/
			
			Thread.sleep(10000);
			
					   
		}
		
		catch(Exception e)
		
		{
			
			System.out.println(e);
		
	    }
	
	}
		
		public void ClickonChangeDashbd()
		
		{
			try
			{
				
				acns = new Actions(GlobalVariables.oDriver);
			
				acns.moveToElement(clickPopup).click().build().perform();
				
				Thread.sleep(20000);
				
				EnterDashboardName.sendKeys("HAC");
				      
		        Thread.sleep(20000);
		                
		        clickDashboard.click();
		        
		        Thread.sleep(20000);
		              				
			}
			
			catch(Exception e)
			
			{
			}
		}
		
       public void ClickonExportFile()
       {
			try
			{
			
				GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lnkExport")).click();
				      
		        Thread.sleep(20000);
		                
		        GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_exportPopup_imgExportToPdf")).click();
		        
		        Thread.sleep(20000);       
				
			}
			
			catch(Exception e)
			
			{
			}
		}
       
       public void VerifyExportedFile()
       {
    	 File getLatestFile = getLatestFilefromDir("C:\\Users\\Savan\\Downloads");
   	    
    	 String fileName = getLatestFile.getName();
   	    
   	     System.out.println(fileName);
   	    
   	     Assert.assertTrue(fileName.equals("mailmerge.xls"), "Downloaded file name is not matching with expected file name");
   	}
       
       /* Get the latest file from a specific directory*/
   	private File getLatestFilefromDir(String dirPath){
   	    File dir = new File(dirPath);
   	    File[] files = dir.listFiles();
   	    if (files == null || files.length == 0) {
   	        return null;
   	    }
   	
   	    File lastModifiedFile = files[0];
   	    for (int i = 1; i < files.length; i++) {
   	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
   	           lastModifiedFile = files[i];
   	       }
   	    }
   	    return lastModifiedFile;
   	}
   	
   	
   	public void SettoDefault()
   	{
   		try
   		{
   		 GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_defaultDashboard_lnkMarkAsDefault")).click();
   		
   		 Thread.sleep(20000);
   		}
   		
   		catch(Exception e)
		
		{
   			
		}
   		
   		
   	}
   	
   	public void SaveCurrentView()
   	{
   		
   		GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_saveView_imgSaveView")).click();
   		
   		GlobalVariables.oDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
   		
   		GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_saveView_txtViewName"))
   		.sendKeys(GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_lblDashboardName")).getText()+123);
   		
   		GlobalVariables.oDriver.manage().timeouts().implicitlyWait(40, TimeUnit.MINUTES);
   		
   		GlobalVariables.oDriver.findElement(By.id("ctl00_IndigoLiteMasterContent_saveView_imgCreateView")).click();
   		
   	}
   	
   	
   	public void ClickonQuarterlyScoreCard() throws InterruptedException
	
	{ 	
         Thread.sleep(20000);
		
		GlobalVariables.oElement  =   GlobalVariables.oDriver.findElement(By.className("dropdown-menu"));
	        List<WebElement> anchors = GlobalVariables.oElement.findElements(By.tagName("a"));
	        Iterator<WebElement> i = anchors.iterator();
	 
	        while(i.hasNext()) {
	            WebElement anchor = i.next();
	            if(anchor.getAttribute("href").contains("http://ms-qa-c/encord-sh-qa-x-02/Dashboard/Dashboard.aspx?ViewName=MonthlyGraphs&CategoryKey=0&SubCategoryKey=0")) 
	            {
	            	
	            	System.out.println("Quartely Graph");
	                anchor.click();			              
	                break;
	            }        
              				
     	}
		
	}
   	
    public void ClickonMonthlyGraph() throws InterruptedException
	
	{ 
    	acns.moveToElement(GlobalVariables.oDriver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td/div[1]/div/table/tbody/tr[1]/td/div/ul/li[3]/a/img"))).click().build().perform();
		
		Thread.sleep(20000);
    
		
		GlobalVariables.oElement  =   GlobalVariables.oDriver.findElement(By.className("dropdown-menu"));
	        List<WebElement> anchors = GlobalVariables.oElement.findElements(By.tagName("a"));
	        Iterator<WebElement> i = anchors.iterator();
	 
	        while(i.hasNext()) {
	            WebElement anchor = i.next();
	            if(anchor.getAttribute("href").contains("Dashboard.aspx?ViewName=MonthlyGraphs&CategoryKey=0&SubCategoryKey=0")) 
	            {
	            	
	            	System.out.println("Quartely Graph");
	            
	            	System.out.println(anchor.getAttribute("href"));
	                anchor.click();	
	                anchor.click();	
	                anchor.click();	
	                break;
	            }        
              				
     	}
	}
    	
  
		
	
    
    public void ClickonQuarterlyGraph() throws InterruptedException
	
   	{ 	
         Thread.sleep(20000);
		
		GlobalVariables.oElement  =   GlobalVariables.oDriver.findElement(By.className("dropdown-menu"));
	        List<WebElement> anchors = GlobalVariables.oElement.findElements(By.tagName("a"));
	        Iterator<WebElement> i = anchors.iterator();
	 
	        while(i.hasNext()) {
	            WebElement anchor = i.next();
	            if(anchor.getAttribute("href").contains("Dashboard.aspx?ViewName=QuarterlyGraphs&CategoryKey=0&SubCategoryKey=0")) 
	            {
	            	
	            	System.out.println("Quartely Graph");
	                anchor.click();			              
	                break;
	            }        
              				
     	}
      	   		
   	}
    
  public void ClickonYearlyGuage() throws InterruptedException
	
   	{ 
	        this.HoveronGearWheel();
      		GlobalFunction.GearWheelMenuOptions("Dashboard.aspx?ViewName=YearlyGauge&CategoryKey=0&SubCategoryKey=0");
      		
      		Thread.sleep(20000);
   		
   	}
  
  public void ClickonHospitalScoreCard() throws InterruptedException
	
 	{ 		
    		GlobalFunction.GearWheelMenuOptions("Dashboard.aspx?ViewName=HospitalScorecard&CategoryKey=0&SubCategoryKey=0");
    		
    		Thread.sleep(20000);
 		
 	}
  
  
  public void SetDashboardRate() throws IOException
  {
	     int columnCount = 0;
	     
	  	 GenericFunction gfn = new  GenericFunction(); 
	  	 
	  	gfn.Read_XLS("E:\\workspace\\EncorDDashboard\\bin\\EncorDashboard\\ExcelFile\\DashboardData.xls");
	  	 
	 GlobalVariables.oElement= GlobalVariables.oDriver.findElement(By.className("DashboardmainTable"));
	 
	 GlobalVariables.oElement= GlobalVariables.oElement.findElement(By.tagName("tbody"));
	  
	 List<WebElement> row_table= GlobalVariables.oElement.findElements(By.tagName("tr"));
	 
	  int row_count =  row_table.size();
	  
	     for (int row =0; row<row_count; row++)
	     {
	 
	           List<WebElement> Columns_row= row_table.get(row).findElements(By.tagName("td"));
	           
	                int column_count =Columns_row.size();
	                
	              //  System.out.println("Number of cells In Row " + row + " are " + column_count);	
	                	 
	                for (WebElement value : Columns_row) 
	             {
	                	//System.out.println("Value is " + row + " are " + value.getText());
	                	        	
	                	                        	                	
	                	if ("Blood Incompatibility (HAC 3)".equals(value.getText())) 
	                		                		 
	              {       		                		
	                		for(WebElement data : Columns_row)
	                		{
	                			System.out.println("Data is " + row + " are " + data.getText());
	                				                			
	                			gfn.SimpleExcelWrite(data.getText(),columnCount);
	                			
	                			++columnCount;
	                			
	                			                			
	                		}   
	                		gfn.WriteFile();	    
	              }
	           }
	                
                  
	     
	    }
  }
}
     

		
		
	
	

	


