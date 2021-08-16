package PageObjects_Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage 
{
	@FindBy(how =How.ID,using="login-username")   
	public WebElement userBox;
	
	@FindBy(how =How.ID,using="login-password")
	public WebElement passBox;
	
	@FindBy(how =How.ID,using="login-button")
	public WebElement loginbutton;
	
	@FindBy(how =How.ID,using="account-settings-link")   
	public WebElement accountClick;
}
