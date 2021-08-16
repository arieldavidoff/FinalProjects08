package PageObjects_Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsPage 
{
	@FindBy(how =How.XPATH,using="//*[@id='account-csr-container']/div/div[2]/h1")   
	public WebElement Account;
	
	
}
