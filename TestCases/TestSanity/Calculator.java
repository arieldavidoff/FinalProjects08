package TestSanity;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.verify;
import Utilities.commonOps;
import WorkFlows.desktop_calc;

public class Calculator extends commonOps
{
	@Test
	public void test01_Verify1Plus2() throws ParserConfigurationException, SAXException, IOException
	{
		desktop_calc.add1(ClacMain.btn_One,ClacMain.btn_two);
		verify.displayAccountPage(ClacMain.feild_result, "3");
	}
}
 