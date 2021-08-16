package PageObjects_Electron;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
	@FindBy(how =How.ID,using="button-windows")   
	public WebElement MangeWindows;
	
	@FindBy(how =How.ID,using="button-crash-hang")   
	public WebElement HandWindows;
	
	@FindBy(how =How.ID,using="button-app-sys-information")
	public WebElement SystemInfo;
	
	@FindBy(how =How.ID,using="screen-info-demo-toggle")
	public WebElement ScreenInfoo;
	
	@FindBy(how =How.ID,using="screen-info")
	public WebElement DemoButton;
	
}