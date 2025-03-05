package Test_script;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {

	public WebDriver driver;
	public WebDriver initializemethod(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
	
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("invalid brower name");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
}
