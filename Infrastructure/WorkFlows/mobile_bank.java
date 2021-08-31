package WorkFlows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.click;
import Extensions.update;
import Utilities.commonOps;

public class mobile_bank extends commonOps
{
	public static void bank(String user,String pass) throws ParserConfigurationException, SAXException, IOException 
	{
		update.text(bankMain.userName, user);
		update.text(bankMain.password, pass);
		click.go(bankMain.loginEri);
	}

}
