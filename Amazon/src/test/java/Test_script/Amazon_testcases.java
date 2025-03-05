package Test_script;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import PageClasses.AmazonHomePage;
import PageClasses.AmazonProductDetailPage;
import PageClasses.AmazonProductListingPage;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon_testcases extends Base_Class 
{
	public WebDriver driver;
	AmazonHomePage homepage; //object named homepage of AmzonHomePage class is declared here
	AmazonProductListingPage listingpage;
	AmazonProductDetailPage detailspage;
	@BeforeMethod
	@Parameters({"browser"})
	public void browserInitialization(String browsername) throws Exception
	{
	System.out.println("BeforeMethod");
	driver = initializemethod(browsername);
	driver.get("https://selenium.qabible.in/");
	homepage=new AmazonHomePage(driver);
	listingpage=new AmazonProductListingPage(driver);
	detailspage=new AmazonProductDetailPage(driver);
	}
	//@Test(priority = 5)
	public void TC01()
	{
		//id
		driver.findElement(By.name("q")).sendKeys("IPhone");
		driver.findElement(By.xpath("//div[@class='flex flex-auto items-center relative']//child::button")).click();
		
		//to clear the field
		driver.findElement(By.name("q")).clear();
		
		//name
		driver.findElement(By.name("q")).sendKeys("Smart TV");
		driver.findElement(By.xpath("//div[@class='flex flex-auto items-center relative']//child::button")).click();
		
		//class
		//driver.findElement(By.className("a-button-input")).click();
		
		//tagname
		//driver.findElement(By.tagName("input")).click();
		
		//link test
		driver.findElement(By.linkText("Conditions of Use")).click();
		
		//partial link test
		driver.findElement(By.partialLinkText("Privacy")).click();
		
		//css selector - fastest locator-check note
		
		//xpath
	}
		//To learn navigate commands:
	@Test(priority = 4)
		public void TC02() throws InterruptedException
		{
			driver.navigate().to("https://www.amazon.in/");
			//driver.navigate().back();
			//Thread.sleep(4000); //to add time break in btw the flows
			//driver.navigate().forward();
			//Thread.sleep(4000);
			//driver.navigate().refresh();
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
			driver.findElement(By.id("nav-search-submit-button")).click();
			WebElement dropdown=driver.findElement(By.id("s-result-sort-select"));
			Select obj=new Select(dropdown);
			//obj.selectByValue("price-asc-rank");
			//obj.selectByVisibleText("Best Sellers");
			//obj.selectByIndex(0);
			List<WebElement> products= driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']//child::span"));
			System.out.println(products.size());
			driver.quit();
		}
	@Test(priority = 3)
	public void TC03()
	{
		String s=driver.findElement(By.xpath("//div[@class='container']//p")).getText();
		System.out.println(s);
		String t=driver.findElement(By.xpath("//div[@class='top-logo']//img")).getAttribute("src");
		System.out.println(t);
		String u=driver.findElement(By.xpath("//div[@class='top-logo']//img")).getTagName();
		System.out.println(u);
		driver.close();
				
	}
	
	@Test(priority = 1)
	public void TC04() throws InterruptedException
	{
		//SoftAssert softassert = new SoftAssert(); //create object named softassert
		driver.navigate().to("https://selenium.qabible.in/javascript-alert.php");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		// or Thread.sleep(2000);
		driver.switchTo().alert().accept();//accept is used to click on Yes/Ok
		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		driver.switchTo().alert().sendKeys("Amala");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='btn btn-warning']"))));
		//boolean status=driver.findElement(By.xpath("//button[@class='btn btn-warning']")).isDisplayed();
		//softassert.assertEquals(status, true);
		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		String a=driver.switchTo().alert().getText();
		System.out.println(a);
		//softassert.assertAll();
		
	}
	@Test(priority = 2)
	public void TC05()
	{
		driver.navigate().to("https://selenium.qabible.in/drag-drop.php");
		Actions action=new Actions(driver); //creating object named action
		WebElement source= driver.findElement(By.xpath("(//div[@id='todrag']//parent::span)[1]"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		//action.dragAndDrop(source, destination).build().perform(); //for drag & drop
		//action.moveToElement(driver.findElement(By.id("others"))).build().perform();//to hover the mouse/mouse over
		//action.contextClick().build().perform(); //for right click action
		//action.doubleClick(driver.findElement(By.id("others"))).build().perform();//for double click
		/*
		 * action.keyDown(Keys.ENTER).build(); action.keyUp(Keys.ENTER).build();
		 * action.perform();
		 */ //if multiple actions are done in one go then .perform can be given at last than each actions as above
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone");
		boolean buttonstatus = driver.findElement(By.id("nav-search-submit-button")).isDisplayed();
		//System.out.println(buttonstatus);
		Assert.assertEquals(buttonstatus, true);
		boolean status = driver.findElement(By.id("nav-search-submit-button")).isEnabled();
		//System.out.println(status);
		Assert.assertEquals(status, true);
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']")).click();
		String parent=driver.getWindowHandle();
		Set<String> tabs=driver.getWindowHandles();
		for(String actual:tabs)
		{
			if(!actual.equalsIgnoreCase(parent))
			{
				driver.switchTo().window(actual);//if the value of the string actual is no equal to parent
				//driver.findElement(By.xpath("(//div[@class='a-accordion-row-a11y a-accordion-row a-declarative a-accordion-sr accordion-header mobb-header-css']//i)[1]")).click();
				WebElement element=driver.findElement(By.xpath("(//input[@name='submit.add-to-cart'])[2]"));
				JavascriptExecutor js=(JavascriptExecutor)driver;//object creation for javascript - javascript is used bcz there is no scroll in selenium
				js.executeScript("arguments[0].scrollIntoView();", element); //to scroll using javascript
				//element.click();
				js.executeScript("arguments[0].click();", element);//to click on a hidden element using javascript
			}
			driver.switchTo().window(parent);
		}
		
	}
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("AfterSuite");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("BeforeTestMethod");
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("AfterTestMethod");
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("AfterMethod");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("BeforeClass");
	} 
	@AfterClass
	public void afterclass()
	{
		System.out.println("AfterClass");
	}
	@BeforeGroups
	public void beforgroups()
	{
		System.out.println("BeforGroups");
	}
	
	public void aftergroups()
	{
		System.out.println("AfterGroups");
	}
	@Test
	public void TC06() throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert(); //create object named softassert
		driver.navigate().to("https://selenium.qabible.in/javascript-alert.php");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		// or Thread.sleep(2000);
		driver.switchTo().alert().accept();//accept is used to click on Yes/Ok
		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		driver.switchTo().alert().sendKeys("Amala");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='btn btn-warning']"))));
		boolean status=driver.findElement(By.xpath("//button[@class='btn btn-warning']")).isDisplayed();
		softassert.assertEquals(status, true);
		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		String a=driver.switchTo().alert().getText();
		System.out.println(a);
		softassert.assertAll();
	}
	@Test
	public void TC07() throws InterruptedException
	{
		SoftAssert softassert = new SoftAssert();
		driver.navigate().to("https://selenium.qabible.in/");
		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='single-input-field']")).sendKeys("test");
		//Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='single-input-field']"))));
		
		String status=driver.findElement(By.xpath("//input[@id='single-input-field']")).getText();
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@type='button'])[2]"))));
		
		driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys("4");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='value-b']"))));
		driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys("6");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//button[@id='button-two']")).click();
		//softassert.assertEquals(status, true);
		String total=driver.findElement(By.id("message-two")).getText();
		softassert.assertEquals(total,"Total A + B : 10");
		softassert.assertAll();
		
	}
	@Test
	public void TC08()
	{
		//to write test case to open amazon, search iphone, list items, select one particular phone & add to cart
		
		driver.navigate().to("https://www.amazon.in/");
		homepage.searchProduct("IPhone");
		listingpage.firstProduct().click();
	
		String parent=driver.getWindowHandle();
		Set<String> tabs=driver.getWindowHandles();
		for(String actual:tabs)
		{
			if(!actual.equalsIgnoreCase(parent))
			{
				driver.switchTo().window(actual);//if the value of the string actual is no equal to parent
				WebElement element=detailspage.addToCartButton();
				JavascriptExecutor js=(JavascriptExecutor)driver;//object creation for javascript - javascript is used bcz there is no scroll in selenium
				js.executeScript("arguments[0].scrollIntoView();", element); //to scroll using javascript
				//element.click();
				js.executeScript("arguments[0].click();", element);//to click on a hidden element using javascript
			}
			driver.switchTo().window(parent);
		}
		
	}
	@Test(dataProvider = "testDatas")
	public void TC09(String A, String B)
	{
		driver.navigate().to("https://selenium.qabible.in/");
		driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='single-input-field']")).sendKeys("test");
		//Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='single-input-field']"))));
		
		String status=driver.findElement(By.xpath("//input[@id='single-input-field']")).getText();
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@type='button'])[2]"))));
		
		driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys(A);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='value-b']"))));
		driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys(B);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//button[@id='button-two']")).click();
		
	}
	@DataProvider(name="testDatas")//name of data provider
	public Object[][] testDataFeed()
	{
		Object [][] testdata=new Object[2][2];
		testdata[0][0]="10";
		testdata[0][1]="5";
		testdata[1][0]="15";
		testdata[1][1]="20";
		return testdata;
	}

}
