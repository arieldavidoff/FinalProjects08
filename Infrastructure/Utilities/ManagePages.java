package Utilities;

import org.openqa.selenium.support.PageFactory;


public class ManagePages extends base
{
	public static void init()
	{ 
		spotifyMain = PageFactory.initElements(driver,PageObjects_Spotify.MainPage.class);
		spotifyResults = PageFactory.initElements(driver,PageObjects_Spotify.ResultsPage.class); 
		
		bankMain=PageFactory.initElements(driver,PageObjects_ExperiBnak.MainPage.class);
		bankResult=PageFactory.initElements(driver,PageObjects_ExperiBnak.ResultPage.class); 
		
		electronMain =PageFactory.initElements(driver,PageObjects_Electron.mainPage.class); 
		
		ClacMain=PageFactory.initElements(driver,PageObjects_Clac.mainPage.class);
	}
}

