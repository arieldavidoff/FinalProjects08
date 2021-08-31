package WorkFlows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Extensions.RestAPI;
import Utilities.commonOps;
import io.restassured.response.Response;

public class ApiAction extends commonOps

{
	public static String[]details={ "Ariel","Davidoff","ariel_Dav@walla.co.il","spoftware"};
	public static List<String>subject= new ArrayList<String>();

	public static void PostNewStudent() throws ParserConfigurationException, SAXException, IOException
	{
		subject.add("Math");
		subject.add("sportTeacher");
		subject.add("English");
		RestAPI.post(details, subject);
	}
	public static Response GetDetails() throws ParserConfigurationException, SAXException, IOException
	{
		return RestAPI.get(getData("API_URL") + getData("API_Resource") + "/list");
	}

}


