package Extensions;

import org.openqa.selenium.WebElement;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Screen;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

import static org.testng.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class verify extends  commonOps
{
	public static void displayAccountPage(WebElement elem,String exeptedValue) throws ParserConfigurationException, SAXException, IOException
	{
		try

		{
			if(getData("AutommationType").equalsIgnoreCase("Desktop"))
				assertEquals(elem.getAttribute("Name"),exeptedValue);
			else
				assertEquals(elem.getText(),exeptedValue);
			test.log(LogStatus.PASS, "Text found in Element");
		}	
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Error with finding text,See details:"+ e+"see screenshot:"+test.addScreenCapture(takeSS()));
			fail("error with finding text");
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL, "Text Not found in Element,See details:"+ e+"see screenshot:"+test.addScreenCapture(takeSS()));
			fail("error with finding text");
		}
	}
	public static void images(String imagePath) throws  ParserConfigurationException, SAXException, IOException
	{

		try 
		{
			//screen.find(imagePath);
			test.log(LogStatus.PASS, "Image found in Successfully");

		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Failed to find Image,See details:"+ e+"see screenshot:"+test.addScreenCapture(takeSS()));
			fail("Failed to find Image");

		}
	}
	public static void contains(String response,String text)
	{
		try
		{
			assertTrue(response.contains(text));	
			test.log(LogStatus.PASS, "Contains Pass Successfully");

		} 
		catch(AssertionError e)
		{
			test.log(LogStatus.FAIL,text + "Failed to be contained,See details:"+ e);
			fail(text + "Failed to be contained,See details:"+ e);
		}

	}

}
