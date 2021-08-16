package TestSanity;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Extensions.verify;
import Utilities.commonOps;
import WorkFlows.ApiAction;
import io.restassured.response.Response;

public class students extends commonOps
{
	@Test
	public void test01_VerifyStudentCreated() throws ParserConfigurationException, SAXException, IOException
	{		
		ApiAction.PostNewStudent();
		//verify.contains(ApiAction.GetDetails().getBody().asString(),"Ariel");
		System.out.println(ApiAction.GetDetails().getBody().asString());
	
	}
}
