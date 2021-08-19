package TestSanity;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.click;
import Extensions.verify;
import Utilities.ManagePages;
import Utilities.commonOps;
import WorkFlows.Web_search;

public class spotify extends commonOps

{

	@BeforeClass
	public void StartSession() throws ParserConfigurationException, SAXException, IOException
	{
		initBrowser(getData("BrowserType"));
		ManagePages.init(); 
		InstantReport();
	}

	@AfterClass
	public void closeSession()
	{
		driver.quit();
		finilizeExtentReport();
	}
	@BeforeMethod
	public void  doBeforeMethod()
	{
		initReportTest("Login","Account");
	}

	@AfterMethod
	public void doAfterTest()
	{
		finilizeReportTest();
	}

	@Test(groups={"HardCoded"})

	public void Test01_login() throws ParserConfigurationException, SAXException, IOException 
	{
		Web_search.go("arielqa123@gmail.com");
		Web_search.password("Ad123654!");
		click.go(spotifyMain.loginbutton);
		click.account(spotifyMain.accountClick);
		//verify.displayAccountPage(spotifyResults.Account, "Account overview");
		//	verify.images("./ImageRepository/spoty.png");
	}
}
