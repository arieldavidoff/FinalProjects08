package Extensions;

import static org.testng.Assert.fail;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.JDBC;

public class SQLQueries extends JDBC

{
	public static String queries(String query)
	
	{
		
		
		String value=null;
		try
		{
			initJDBC();
			retriveInfo(query);
			value=parseData();
			 closeDBcob();
			 test.log(LogStatus.PASS, "Query Succefully Created");
		}
		catch (Exception e)
		{
			 test.log(LogStatus.FAIL, "Query to DB Failed, See Details: "+ e);
			 fail("Query to DB Failed, See Details: "+ e);
		}
		return value;
	}
}
