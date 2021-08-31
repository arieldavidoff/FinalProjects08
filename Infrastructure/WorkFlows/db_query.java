package WorkFlows;

import Extensions.SQLQueries;

public class db_query
{
	public static String getMessage(String expectedResult ,String value)
	{
		return SQLQueries.queries("Select"+  expectedResult + "from test;");
	}

}
