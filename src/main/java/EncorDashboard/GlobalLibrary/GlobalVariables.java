package EncorDashboard.GlobalLibrary;

import java.sql.Connection;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import EncorDashboard.Logging.WebEventListener;

public  class GlobalVariables {
	
	public static WebDriver oDriver = null;
	public static String LoginURL = "http://msv-qa-web/encord-sh-qa-x-02";
	public static WebElement oElement = null; 
	public static int IncrementByone = 0;
	public static Hashtable<String,String> testData=new Hashtable<String,String>();
    public static Connection conn;
    public static Select sel;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

}
