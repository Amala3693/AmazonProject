package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
WebDriver driver;
@FindBy(id = "twotabsearchtextbox")
WebElement amazonhomepagesearchbox;
@FindBy(id ="nav-search-submit-button")
WebElement amazonsearchbutton;

public AmazonHomePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void searchProduct(String productname)
{
	amazonhomepagesearchbox.sendKeys(productname);
	amazonsearchbutton.click();
	}
}
