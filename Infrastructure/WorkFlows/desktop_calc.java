package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import Extensions.click;
import Utilities.commonOps;

public class desktop_calc extends commonOps
{
	public static void add1(WebElement first,WebElement second) throws ParserConfigurationException, SAXException, IOException
	{
		click.go(first);
		click.go(ClacMain.btn_Plus);
		click.go(second);
		click.go(ClacMain.btn_equals);
	}
}
