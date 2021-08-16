package TestSanity;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.click;
import Extensions.verify;
import Utilities.commonOps;
import WorkFlows.Web_search;
import WorkFlows.mobile_bank;

public class EriBank extends commonOps
{
	@Test
	public void Test01_loginEriBank() throws ParserConfigurationException, SAXException, IOException
	{
		mobile_bank.bank("company","company");
		verify.displayAccountPage(bankMain.loginEri,"//*[@text='Your balance is: -23.00$']");
	}

}
