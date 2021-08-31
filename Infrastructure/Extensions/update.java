package Extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.commonOps;

public class update extends commonOps
{
	public static void text(WebElement elem,String value) throws ParserConfigurationException, SAXException, IOException
	{
		try

		{
			elem.sendKeys(value);
			test.log(LogStatus.PASS, "Text Field updated Successfully");
		}	
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Failed to update text Field,See details:"+ e+"see screenshot:"+test.addScreenCapture(takeSS()));
			fail("Failed to update text Field,See details");
		}
	}

}

