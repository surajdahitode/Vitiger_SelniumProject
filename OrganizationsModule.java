package vitigercrm;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Commonutils.ExcelUtil;
import Commonutils.JavaUtil;
import Commonutils.PropertyFileUtil;
import Commonutils.WebDriverUtil;

public class OrganizationsModule {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		


		      
				//:Create the object of propertyFileUtil class,JavaUtil class.WebDriverUtil class,ExcelUtil class
				
			    PropertyFileUtil putil = new PropertyFileUtil();
				JavaUtil jutil  = new JavaUtil();
				
				
				
				//Read the data from PropertyFile
		         String BROWSER= putil.getDataFromPropertyFile("Browser");
		         String URL= putil.getDataFromPropertyFile("Url");
		         String USERNAME= putil.getDataFromPropertyFile("Username");
		         String PASSWORD= putil.getDataFromPropertyFile("Password");
		         
		         
		         //To launch the browser
		         if(BROWSER.equals("Chrome"))
		         {
		        	 driver = new ChromeDriver();
		         }
		         else if(BROWSER.equals("Edge"))
		         {
		        	 driver = new EdgeDriver();
		         }
		         else
		         {
		        	 driver = new FirefoxDriver();
		         }
				
		          //To maximize the window
		          //Create object of Webdriver util
		         WebDriverUtil wutil =  new WebDriverUtil();
		         
		         //To maximize the window
		          wutil.maximize(driver);
		      
		 		
		        //To apply implicit wait  
		          wutil.togetimlicitwait(driver);
		     	
                 //To launch the application
		         driver.get(URL);
		         
		         //To login in apllication (Read the data from propertyFile)
		         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		         
		         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		         
		         driver.findElement(By.id("submitButton")).click();
		         
		         
		         //Identify the webelement and click on Organizations.
		         driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		         
		         //Identify the webelement and click on it (Create Organization)
		         driver.findElement(By.cssSelector("img[alt ='Create Organization...']")).click();
		         
		         
		         //To Read the Data from Excel util 
		         //Create the object of ExcelUtil for Read the data from ExelSheet
		         ExcelUtil ex  = new ExcelUtil ();
		 		
		        
		         
		         //call a method call getDataFromExcelFile() for Read the data from excel sheet
		 		 String data= ex.getDataFromExcelFile("Organizations", 0, 1);
		 		
		 		
		         
		         //Identify the webelement and and send the keys in textfield & Call method call getrandomNumbefor genareting random number
		         driver.findElement(By.name("accountname")).sendKeys(data + jutil.getRandomNumber());
		         
		         //To click on radio button(Group)
		         driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		         
		         
		         //Go to dropdown and choose one option 
		         //Select suppoet group in the dropdown
		         WebElement opt=	driver.findElement(By.name("assigned_group_id"));
		     	
		         //Read the option from ExcelSheet
		         String data1=  ex.getDataFromExcelFile("Organizations", 1, 1);
		         
		         //TO handle dropdown call method tohandledropdown
		         wutil.tohandledropdown(opt, data1);
		     		
		     	
		     	
		     	//Identify the element and click on save button
		     	driver.findElement(By.name("button")).click();
		     	
		        Thread.sleep(2000);
		     	
		     	//WebElement for mouse over
                WebElement icon=driver.findElement(By.xpath("(//img[@style= 'padding: 0px;padding-left:5px'])[1]"));
				
				
                
                //To mouse over the element 
                wutil.Tomouseover(driver, icon);
             
				//To click on signout
    			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		         

	}

}
