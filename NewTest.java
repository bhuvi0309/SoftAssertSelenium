package co.edurekatraining;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	public WebDriver driver = new ChromeDriver();
  
  @Test  
  public void methodOne() {
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("abcd@gmail.com");
	  
	  SoftAssert softAssert = new SoftAssert(); 
	  //softAssert.assertEquals(actualRersult,expectedResult,"Title is not Matching"); 
	  WebElement passWord=driver.findElement(By.xpath("//input[@name='pass']"));
	  //Boolean val=passWord.isDisplayed();
	  //Boolean val1=passWord.isEnabled();
	  softAssert.assertFalse(passWord.isDisplayed());
	  softAssert.assertFalse(passWord.isEnabled());
   
  }
   
  
  @BeforeMethod
  public void beforeMethod() {
				
	//Open Facebook
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	
	String CurrentTitle=driver.getTitle();
	System.out.println("Title of the page is = "+ CurrentTitle );
	
	if (CurrentTitle.equalsIgnoreCase("Facebook - log in or sign up" ))
	{ 	System.out.println ("Facebook page is displayed") ;}
	else 
	{	System.out.println ("Facebook page is not displayed");}
		
  }
   
  @AfterMethod
  public void afterMethod() {	  
	  driver.close();
  }

}
