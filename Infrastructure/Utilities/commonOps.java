package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
//import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.javascript.host.Screen;
import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;

public class commonOps extends base
{
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{          
		File fXmlFile = new File("./Configuration/FinalProject.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);		
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException
	{
		switch (browserType.toLowerCase())
		{

		case "chrome":
			driver=initChromeDriver();
			break;
		} 
		driver.manage().window().maximize();
		driver.get(getData("url"));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		screen =new Screen();
	}
	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.chrome.driver",getData("ChromeDriverPatch")); 
		WebDriver driver=new ChromeDriver();
		return driver;
	}

	public static void initMobile() throws ParserConfigurationException, SAXException, IOException
	{
		dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
		driver = new AndroidDriver(new URL(getData("Appium_Server_Address")), dc);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	public static void initAPI() throws ParserConfigurationException, SAXException, IOException
	{
		RestAssured.baseURI=getData("API_URL");
		httpRequest=RestAssured.given();
	}
	public static void initElectronDriver(String ElectronApp) throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.chrome.driver",getData("DriverPathElectron"));
		ChromeOptions opt= new ChromeOptions();
		opt.setBinary(getData("ElectronApp"));
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("chromeOptions", opt);
		capabilities.setBrowserName("chrome");
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	public void initDesktopDriver(String App) throws  ParserConfigurationException, SAXException, IOException, InterruptedException
	{
		DesktopOptions options = new DesktopOptions(); 
		options.setApplicationPath(App); 
		File drivePath = new File(getData("DesktopDriver")); 
		WiniumDriverService service = new WiniumDriverService.Builder().
				usingDriverExecutable(drivePath).
				usingPort(9999).
				withVerbose(true).
				withSilent(false).
				buildDesktopService();
		service.start(); 
		driver = new WiniumDriver(service, options);
		Thread.sleep(1000);
	}

	public static void InstantReport() throws ParserConfigurationException, SAXException, IOException
	{
		extent= new ExtentReports(getData("ReportFilePath")+ "execution_"+ timeStamp+ "/"+getData("ReportFileName")+ ".html");
	}

	public static void initReportTest(String testName,String testDescrition)
	{
		test= extent.startTest(testName,testDescrition);
	}
	public static void finilizeReportTest()
	{
		extent.endTest(test);
	}

	public static void finilizeExtentReport()
	{
		extent.flush();
		extent.close();
	}
	public static String takeSS()throws  ParserConfigurationException, SAXException, IOException
	{
		String SSPath=getData("ReportFilePath")+ "execution_"+ timeStamp+ "/"+"screenshot_"+getRandomNumber()+".png";
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(SSPath));
		return SSPath;
	}
	public static int getRandomNumber()
	{
		Random rand =new Random();
		return rand.nextInt(999999)+1;
	}

	@BeforeClass(groups={"HardCoded"})
	public void StartSession() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	{
		if (getData("AutommationType").toLowerCase().equals("Web"))
			initBrowser(getData("BrowserType"));
		else if (getData("AutommationType").toLowerCase().equals("mobile"))
			initMobile();
		else if (getData("AutommationType").toLowerCase().equals("api"))
			initAPI();

		else if (getData("AutommationType").toLowerCase().equals("electron"))
			initElectronDriver(getData("ElectronApp"));


		else if (getData("AutommationType").toLowerCase().equals("desktop"))
			initDesktopDriver(getData("DesktopApplication"));

		ManagePages.init();
		InstantReport();
	}

	@AfterClass(groups={"HardCoded"})
	public void closeSession() throws ParserConfigurationException, SAXException, IOException
	{
		if(!getData("AutommationType").equals("API"))
			driver.quit();
		finilizeExtentReport();
	}
	@BeforeMethod(groups={"HardCoded"})
	public void  doBeforeMethod(Method method)
	{
		initReportTest("Login","Account");
	}
	@AfterMethod(groups={"HardCoded"})
	public void doAfterTest() throws ParserConfigurationException, SAXException, IOException
	{
		if(getData("AutommationType").equalsIgnoreCase("Web"))
		driver.get(getData("URL"));
		finilizeReportTest();
	}
} 


