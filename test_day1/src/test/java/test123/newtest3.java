package test123;

import com.pages.mecury_toolswelcome;
import com.pages.mercregister;
import com.utility.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class newtest3 {
	
	 WebDriver driver;
	 
	 mecury_toolswelcome mtwp;
	 mercregister mtrp;
	 
	 
	 
	  @Test(priority=1)
	  public void testMercuryToursWelcome()
	  {
		  driver.get("http://newtours.demoaut.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  }
		
	  @Test(priority=3)
	  public void testMercuryToursLogin() {
		  
		String title= mtwp.clickLogin();
		Assert.assertTrue(title.contains("Find a Flight"));
		  
	  }
	  @Test(priority=2)
	  public void testMercuryToursRegister() {
		  
		  String url=mtwp.clickRegister();
		  Assert.assertTrue(url.contains("register"));
		  mtrp.clickUserInfo();
		  mtrp.clickSignOFF();
		  
	  }
	  @BeforeTest
	  @Parameters("browser")
	  public void beforeTest(String browser) {
		
		  driver=utility.getDriver(browser);
		  mtwp=PageFactory.initElements(driver,mecury_toolswelcome.class);
		  mtrp=PageFactory.initElements(driver,mercregister.class);
		  
		  
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
		  mtwp=null;
		  mtrp=null;
	  }



}
