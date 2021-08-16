package PageObjects_ExperiBnak;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage 
{

	@FindBy(how =How.ID,using="usernameTextField")   
	public WebElement userName;
	
	@FindBy(how =How.ID,using="passwordTextField")
	public WebElement password;
	
	@FindBy(how =How.ID,using="loginButton")
	public WebElement loginEri;
}
