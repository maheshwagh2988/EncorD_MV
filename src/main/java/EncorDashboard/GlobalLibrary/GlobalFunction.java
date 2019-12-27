package EncorDashboard.GlobalLibrary;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import EncorDashboard.Logging.WebEventListener;




public class GlobalFunction {
	
	public static Logger Add_Log = null;
	
	public static void BrowsersSettings()
	{
		//office
		File file = new File("C:/Users/Savan/git/EncorD_MV/chromedriver.exe");
		//home
		//File file = new File("C:/Users/leomahesh/git/EncorD-Dashboard/Library/chromedriver.exe"); 
		
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
 		GlobalVariables.oDriver =  new ChromeDriver();
 		GlobalVariables.e_driver = new EventFiringWebDriver(GlobalVariables.oDriver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		GlobalVariables.eventListener = new WebEventListener();
		GlobalVariables.e_driver.register(GlobalVariables.eventListener);
        GlobalVariables.oDriver = GlobalVariables.e_driver;
 		
	}
	
	  public static void init()
	     {
		  
	 		Add_Log = Logger.getLogger("rootLogger");	
	 		
	 		Add_Log.debug("View applog file for logs");
	 		
	     }

	public static Object[][] ReadXlData(String ExcelfileName,String SheetTabName) {
		
		GenericFunction gfn = new GenericFunction();
			
 		gfn.Read_XLS(System.getProperty("user.dir")+"\\src\\main\\java\\EncorDashboard\\ExcelFile\\"+ExcelfileName+".xls");
 		
 		gfn.retrieveNoOfRows(SheetTabName);
 	
 	       gfn.retrieveNoOfCols(SheetTabName);
 	
 	      Object obj[][]=  gfn.retrieveTestData(SheetTabName);
 	
 	return obj;
		
	}

	public static void ClickOnAdministration() {
		
		// TODO Auto-generated method stub
		
		try
		{
		
		GlobalVariables.oDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		GlobalVariables.oDriver.findElement(By.xpath("//a[@id='ctl00_lnkTextAdministration']")).click();
								
		Thread.sleep(1000);
		
    	GlobalFunction.Add_Log.info("Clicked on Administration tab");
		}
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void ClickOnDashboard() {
		// TODO Auto-generated method stub
		
try {
			
			Thread.sleep(2000);
			
	      GlobalVariables.oDriver.findElement(By.xpath("//a[@id='ctl00_HyperLink1']")).click();
	      
	      Thread.sleep(2000);
					
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	  public static void Selectdropdown(String value, String tagname)
		
		{
			List<WebElement> options = GlobalVariables.oElement.findElements(By.tagName(tagname));

		    for (WebElement option : options) 
		    {
		    	System.out.println(option.getText());
		    		    	
		        if (value.equals(option.getText())) {
		            option.click();
		            break;
		        }
		    }
		}
	  
	  public static void SelectBySelecttag(String Txt)
	  {
		  
		  GlobalVariables.sel.selectByVisibleText(Txt);
	  }
	  
	  public static void GearWheelMenuOptions(String href)
	  {
		  try
			{
			  
			     Thread.sleep(20000);
		
				GlobalVariables.oElement  =   GlobalVariables.oDriver.findElement(By.className("dropdown-menu"));
			        List<WebElement> anchors = GlobalVariables.oElement.findElements(By.tagName("a"));
			        Iterator<WebElement> i = anchors.iterator();
			 
			        while(i.hasNext()) {
			            WebElement anchor = i.next();
			            if(anchor.getAttribute("href").contains(href)) 
			            {
			            	
			            	System.out.println("Quartely Graph");
			                anchor.click();			              
			                break;
			            }        
		              				
		     	}
			}
			
			catch(Exception e)
			
			{
			}
	  }



	}


