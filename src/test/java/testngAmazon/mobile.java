package testngAmazon;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;

public class mobile {
	
	
	
	static WebDriver driver ;
	
	
	
	
	@BeforeClass(groups = "check")
	
	public static void beforec () {
		WebDriverManager.chromedriver().setup();
		
		driver =new ChromeDriver();
	driver =new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterClass
	public void afterc (){
		
		System.out.println("afterclass");
	}
	
	@Test (priority = 0,groups = "check")
	public void launchUrl () {
	
	driver.get("https://www.amazon.in");
	}
	@Test (priority = 1,groups = "check")
	public void search () {

	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone 14");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	@Test (priority = 2,groups = "check")
	public void Selectmodel () {
  WebElement model = driver.findElement(By.xpath("//span[text()='Apple iPhone 14 (128 GB) - Blue']"));
  model.click();
	}
	
	@Test (priority = 3,groups = "check")
	public void switchwindow () {
		String pwind = driver.getWindowHandle();
		Set<String> cwind = driver.getWindowHandles();
		List<String> list = new ArrayList(cwind);
		driver.switchTo().window(list.get(1));
	}
	
	@Test (priority = 4,groups = "check")
	public void buy () {
	
		
		
		driver.findElement(By.xpath("//input[@title='Buy Now']")).click();
		
		
	}
	
	
	
	
	
	
	
	
	
}
