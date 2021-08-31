package TestSanity;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class temp
{
	 protected AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = new DesiredCapabilities();
	    
	    @BeforeMethod
	    public void setUp() throws MalformedURLException {
	      
	        dc.setCapability(MobileCapabilityType.UDID, "7EX7N17613001347");
	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
	        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);
	    }

	    @Test
	    public void testUntitled() 
	    {
	    	driver.findElement(By.id("usernameTextField")).sendKeys("company");
	    	driver.findElement(By.id("passwordTextField")).sendKeys("company");
	    	driver.findElement(By.id("loginButton")).click();

	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

}
