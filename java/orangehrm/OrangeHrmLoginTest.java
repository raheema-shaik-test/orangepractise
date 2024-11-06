package orangehrm;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class OrangeHrmLoginTest {
	    
	    WebDriver driver;
	    
	    @BeforeMethod
	    public void setup() {
	        // Set up the ChromeDriver (ensure the path to chromedriver is correct)
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        // Navigate to the OrangeHRM demo site
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	    }
	    
	    @Test
	    public void testValidLogin() {
	        // Enter valid username and password
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	        driver.findElement(By.id("btnLogin")).click();
	        
	        // Assert that the Dashboard page is displayed
	        String expectedTitle = "OrangeHRM";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Login failed: Title does not match after valid login.");
	        
	        // Assert that the user is redirected to the dashboard
	        Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed(), "Login failed: Welcome message is not displayed.");
	    }
	    
	    @Test
	    public void testInvalidLoginWrongPassword() {
	        // Enter valid username and invalid password
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        driver.findElement(By.id("txtPassword")).sendKeys("wrongpassword");
	        driver.findElement(By.id("btnLogin")).click();
	        
	        // Assert that an error message is displayed
	        String errorMessage = driver.findElement(By.id("spanMessage")).getText();
	        Assert.assertEquals(errorMessage, "Invalid credentials", "Error message does not match for invalid login.");
	    }
	    
	    @Test
	    public void testBlankUsername() {
	        // Leave username blank and enter password
	        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	        driver.findElement(By.id("btnLogin")).click();
	        
	        // Assert that an error message is displayed
	        String errorMessage = driver.findElement(By.id("spanMessage")).getText();
	        Assert.assertEquals(errorMessage, "Username cannot be empty", "Error message does not match for blank username.");
	    }
	    
	    @Test
	    public void testBlankPassword() {
	        // Enter username and leave password blank
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        driver.findElement(By.id("txtPassword")).clear();
	        driver.findElement(By.id("btnLogin")).click();
	        
	        // Assert that an error message is displayed
	        String errorMessage = driver.findElement(By.id("spanMessage")).getText();
	        Assert.assertEquals(errorMessage, "Password cannot be empty", "Error message does not match for blank password.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}



