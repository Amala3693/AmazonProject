package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductDetailPage {//using page object model
	WebDriver driver;
	By addtocartbtn = By.xpath("(//input[@name='submit.add-to-cart'])[2]");
			
			
			
			
			
			
			
			
	public AmazonProductDetailPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}








	public WebElement addToCartButton()
	{
		return(driver.findElement(addtocartbtn));
	}
}

