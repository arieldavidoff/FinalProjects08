package TestSanity;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Utilities.commonOps;
import WorkFlows.electron_screen;

public class ElectronDemo extends commonOps
{
	@Test
	public void test01_Info() throws ParserConfigurationException, SAXException, IOException
	{
		electron_screen.getinfo();
	}
}
