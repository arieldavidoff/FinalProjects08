package PageObjects_ExperiBnak;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultPage 
{
	@FindBy(how =How.CLASS_NAME,using="android.widget.ImageView")   
	public WebElement eribank;
	
}
