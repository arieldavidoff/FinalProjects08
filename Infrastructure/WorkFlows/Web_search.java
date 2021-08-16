package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.click;
import Extensions.update;
import Utilities.commonOps;

public class Web_search extends commonOps
{
	public static void go(String Web_search) throws ParserConfigurationException, SAXException, IOException
	{
		update.text(spotifyMain.userBox,Web_search); 
	}
	public static void password(String pass) throws ParserConfigurationException, SAXException, IOException
	{
		update.text(spotifyMain.passBox,pass);	
	}
	
	public static void cliked(String pass) throws ParserConfigurationException, SAXException, IOException
	{
		update.text(spotifyMain.passBox,pass);
		
	}

}
