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
import org.openqa.selenium.support.ui.Select;

import Commonutils.ExcelUtil;
import Commonutils.JavaUtil;
import Commonutils.PropertyFileUtil;
import Commonutils.WebDriverUtil;

public class ContactsModule {
public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		//Object creation
		 PropertyFileUtil putil = new PropertyFileUtil();
		 WebDriverUtil wutil =  new WebDriverUtil();
		 ExcelUtil Eutil = new  ExcelUtil();
		
		
		//To read data from Property File
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
	
		//To Launch the browser
				if(BROWSER.equals("Chrome")) {
					 driver = new ChromeDriver();
					 
				}else if(BROWSER.equals("Edge")) {
					 driver = new EdgeDriver();
				}else {
					 driver = new FirefoxDriver();
				}
			
				//To maximize window
				wutil.maximize(driver);
				
			    //To apply implicit wait  
		         wutil.togetimlicitwait(driver);
		         
		       //To launch the application
		         driver.get(URL);
		         
		         //To login in apllication
		         driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		         
		         driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		         
		         driver.findElement(By.id("submitButton")).click();
		         
		         
		         //Identify the webelement and click on Organizations.
		         driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		         
		         //Identify the webelement and click on it 
		         driver.findElement(By.cssSelector("img[alt ='Create Contact...']")).click();
		         
		         //identify the webElement and click on it for dropdown
		        WebElement  pre= driver.findElement(By.name("salutationtype"));
		        
		        //choose option
		       WebElement opt = driver.findElement(By.cssSelector("option[value='Mr.']"));
		         
		         
		         
		       //To handle dropdown Create the object of the Select class
		       Select s = new Select(pre);
		       
		       s.selectByVisibleText("Mr.");
		       
		       //identify the searchfield and send the value By read the data 
		       
		       
		     String FIRSTNAME = Eutil.getDataFromExcelFile("Contacts", 0, 1);
		     
		     String LASTNAME  = Eutil.getDataFromExcelFile("Contacts", 1, 1);
		     
		     //identify the Firstname and send the data 
		     driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		     
		     //Identify the Lastname and send the data 
		     driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		     
		     
		     
		     
		     //To click on radio button(Group)
	         driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	         
	         
	         
	         
	         //Go to dropdown and choose one option 
	         //Select Team Selling in the dropdown
	         WebElement dropdown=	driver.findElement(By.name("assigned_group_id"));
	     	
	     	//STEP 1:- Create object of select class
	     	//STEP 2:- In select construtor pass webelement as argumenet .
	         
	         String Options=  Eutil.getDataFromExcelFile("Contacts", 2, 1);
	         
	         wutil.tohandledropdown(dropdown, Options);
	         
	         
	         //Click on save button 
	         driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	         
	         Thread.sleep(2000);
		     	
		     //To mouse over on image  to element 
             WebElement icon=driver.findElement(By.xpath("(//img[@style= 'padding: 0px;padding-left:5px'])[1]"));
				
				
             //Call methopd call To Mouseover
             wutil.Tomouseover(driver, icon);
             
            //To click on signout
 			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
 			
 			//LOG OUT FROM THE APPLICATION
		         
		     
		     
		       
		       
		         
		         
		         
		         
	}

}
