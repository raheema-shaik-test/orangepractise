package orangehrm;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Orangeclass {
	WebDriver driver;
  
  @BeforeMethod (description="sample login")
  public void setup() throws Exception {
	 // WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().clearResolutionCache().setup();
	  driver=new ChromeDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      System.out.println(driver.getTitle());
      Thread.sleep(3000);
  }
  @Test 
  public void validcredentials() throws Exception {
	  driver.findElement(By.name("username")).sendKeys("Admin");
      Thread.sleep(3000);
	  driver.findElement(By.name("password")).sendKeys("admin123");
      driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
      driver.getTitle();
   //   String Expected="Admin";
   //   String Actual="admin123";
    //  Assert.assertNotEquals(Actual, Expected);
   //   Assert.assertEquals(Actual, Expected); ----both expected and actual values should be given same
        
  }

  @AfterMethod 
  public void quit() {
      // Close the browser
      driver.quit();
  }
  
  
  

 


}
