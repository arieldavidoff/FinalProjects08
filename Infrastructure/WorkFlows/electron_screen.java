package WorkFlows;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.click;
import Utilities.commonOps;

public class electron_screen extends commonOps
{
	public static void getinfo() throws ParserConfigurationException, SAXException, IOException
	{
		click.go(electronMain.MangeWindows);
		click.go(electronMain.HandWindows);
		click.go(electronMain.SystemInfo);
		click.go(electronMain.ScreenInfoo);
		click.go(electronMain.DemoButton);
	}
}
