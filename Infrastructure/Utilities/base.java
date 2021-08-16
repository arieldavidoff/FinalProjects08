package Utilities;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.sikuli.script.Screen;
import com.gargoylesoftware.htmlunit.javascript.host.Screen;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class base
{
	public static WebDriver driver;
	public static Screen screen;

	public static DesiredCapabilities dc = new DesiredCapabilities();

	public static PageObjects_Spotify.MainPage spotifyMain;
	public static PageObjects_Spotify.ResultsPage spotifyResults;

	public static PageObjects_ExperiBnak.MainPage bankMain;
	public static PageObjects_ExperiBnak.ResultPage bankResult;
	public static PageObjects_Electron.mainPage electronMain ;
	public static PageObjects_Clac.mainPage ClacMain ;
	
	
	public static  ExtentReports extent;
	public static ExtentTest test;

	public static RequestSpecification httpRequest;
	public static JSONObject requestParams=new JSONObject();
	public static Response resp;
	public static String timeStamp=new SimpleDateFormat("yyyy-MM-ddd_HH-mm-ss").format(Calendar.getInstance().getTime());


}

//משתנים
//PAGE OBJECTS
//WORKS FLOWS
//TEST CASE