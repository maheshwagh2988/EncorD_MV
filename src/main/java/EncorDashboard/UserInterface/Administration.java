package EncorDashboard.UserInterface;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import EncorDashboard.GlobalLibrary.*;


public class Administration {
	
	
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_LnkUserAdmin") WebElement UserAdministration;
	
	@FindBy(xpath="//button[1]") WebElement clickUserDropDown;
	
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_LnkUserAccess") WebElement clickUserAccess;
	
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_IndigoGroupDropDown_GroupDropDownCtrl") WebElement selectUserGroup;
	
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_UsersNotInGroup") WebElement userNotInGroup;
	
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_SubmitBtn") WebElement clickSubmit;
	
	@FindBy(id="AddToGroup") WebElement AddToGroupButton;
	
	@FindBy(id="ctl00_ctl00_IndigoLiteMasterContent_AdminBody_UsersInGroup") WebElement userInGroup;
	
	@FindBy(xpath="//span[@class='ui-button-text']//following::span[4]") WebElement clickSaveAccess;
	
	
	public Administration()
	{
		PageFactory.initElements(GlobalVariables.oDriver, this);
	}
	
	
	
	
	public void clickonAdministrationIcon()
	{
		
	   GlobalFunction.ClickOnAdministration();
		
			
	}
	
	//User Administration
	public void clickUserAdministration()
	{
		try
		{
			
		Thread.sleep(1000);
		
		UserAdministration.click();
		
        Thread.sleep(1000);
		
		}
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//User Administration
	public void SelectUserdropdown()
	{
		try
		{
		    GlobalVariables.oDriver.switchTo().frame("ctl00_ctl00_IndigoLiteMasterContent_AdminBody_concert1");
			
		   
		   clickUserDropDown.click();
		   
		 //Scroll down browser then click on save button
		    
		    Actions action = new Actions(GlobalVariables.oDriver);
		    
		        Thread.sleep(1000);
		        
		        action.sendKeys(Keys.PAGE_DOWN).build().perform();
		    
		        action.sendKeys(Keys.PAGE_DOWN).build().perform();
		        
		        action.sendKeys(Keys.PAGE_DOWN).build().perform();
			
            GlobalVariables.oElement = GlobalVariables.oDriver.findElement(By.xpath("//html/body/ul[1]"));
		
		       Thread.sleep(1000);
		
		      System.out.println("Test Dropdown");
		        
		
	   		GlobalFunction.Selectdropdown("Savan Vadalia","li");
	   		
	   		Thread.sleep(1000);
		  
		
		}
		
		catch(Exception e)
		{
			
		}
		
	}
	
	public void clickSaveAccess()
	{
		try
		{
			
		Thread.sleep(1000);
		
        clickSaveAccess.click();
		
        Thread.sleep(1000);
		
		}
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		//User Access
		public void clickUserAccess()
		{
			try
			{
				
			Thread.sleep(1000);
			
	        clickUserAccess.click();
			
	        Thread.sleep(1000);
			
			}
			
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//User Access
				public void SelectGroups()
				{
					try
					{
						
					Thread.sleep(1000);
					
			       GlobalVariables.sel  = new Select(selectUserGroup);
			       
			       GlobalFunction.SelectBySelecttag("Administrator");
			 			      		 					
			        Thread.sleep(1000);
			        
			       				
					}
					
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
	}
				
				//User Access
				public void SelectNotINGroups()
				{
					try
					{
						//Scroll down browser then click on save button
					    
					    Actions action = new Actions(GlobalVariables.oDriver);
					    
					        Thread.sleep(1000);
					        
					        action.sendKeys(Keys.PAGE_DOWN).build().perform();
					        
					        						
					Thread.sleep(1000);
					
					GlobalVariables.oElement =	userNotInGroup;
					
					List<WebElement> options = GlobalVariables.oElement.findElements(By.tagName("option"));

				    for (WebElement option : options) {
				        if ("savan vadalia".equals(option.getText())) {
				        	 GlobalVariables.sel  = new Select(userNotInGroup);			 						       
						       GlobalFunction.SelectBySelecttag("savan vadalia");    		 					
					            Thread.sleep(1000);
				            break;
				        }
				    }
				    
				      Thread.sleep(1000);
					
				       AddToGroupButton.click();
				       
				       Thread.sleep(1000);
				      				       
				      
				
					
					}
					
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
	}
				
				//User Access
				public void SelectINGroups()
				{
					try
					{
						
					Thread.sleep(1000);
					
					GlobalVariables.oElement =	userInGroup;
					
					List<WebElement> options = GlobalVariables.oElement.findElements(By.tagName("option"));

				    for (WebElement option : options) {
				        if ("savan vadalia".equals(option.getText())) {
				        	Assert.assertEquals(option.getText(),"savan vadalia");   		 					
					            Thread.sleep(1000);
				            break;
				        }
				    }
					
				    clickSubmit.click();
				      
				      
				      //Click on Popup ok button
				      
				   Alert alert = GlobalVariables.oDriver.switchTo().alert();
				   
				      alert.accept();
				
				       	      
				    				
					}
					
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
	}
}
		
	

