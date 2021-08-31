package Test_No_Xml;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestElctron {

	public WebDriver driver;
	public ChromeOptions opt;
	public DesiredCapabilities capabilities;

	@BeforeClass
	public void startSession()
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/USER/Desktop/Jar/electrondriver.exe");
		opt = new ChromeOptions();
		opt.setBinary("C:/Users/USER/Desktop/Jar/ElectronAPI/Electron API Demos.exe");
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("chromeOptions", opt);
		capabilities.setBrowserName("chrome");
		driver = new ChromeDriver(capabilities);
	} 

	@Test()
	public void Test01()
	{

	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
	}
}
