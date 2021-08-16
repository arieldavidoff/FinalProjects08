package Extensions;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.base;
import Utilities.commonOps;

public class click extends commonOps
{
	public static void go(WebElement elem) throws ParserConfigurationException, SAXException, IOException
	{	
		try
		
		{
			elem.click();
			test.log(LogStatus.PASS, "Element clicked Successfully");
			
			
		}	
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to click on Element,See details"+ e+"see screenshot:"+takeSS());
		}
	}
	public static void account(WebElement elem) throws ParserConfigurationException, SAXException, IOException
	{	
		try
		{
			elem.click();
			test.log(LogStatus.PASS, "Element clicked Successfully");
		}	
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to click on Element,See details"+ e+"see screenshot:"+test.addScreenCapture(takeSS()));

		}
		
	}
}
