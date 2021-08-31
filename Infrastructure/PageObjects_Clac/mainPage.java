package PageObjects_Clac;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage 
{

	@FindBy(how =How.NAME,using="One")   
	public WebElement btn_One;
	
	@FindBy(how =How.NAME,using="Two")
	public WebElement btn_two;
	
	@FindBy(how =How.NAME,using="Plus")
	public WebElement btn_Plus;
	
	@FindBy(how =How.NAME,using="Equals")
	public WebElement btn_equals;
	
	@FindBy(how =How.NAME,using="Display is 3")
	public WebElement feild_result;
}
