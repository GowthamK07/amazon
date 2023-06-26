package testngAmazon;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class macbook {
	
static WebDriver driver ;
	

	
	
	
	
	
	@BeforeClass (groups = "check")
	
	public static void beforec () {
		WebDriverManager.chromedriver().setup();
		
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
	@Parameters({"product"})
	@Test (priority = 1,groups = "check")
	public void search (String prod) {

	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys(prod);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	@Test (priority = 2,groups = "check")
	public void Selectmodel () {
  WebElement model = driver.findElement(By.xpath("//span[contains(text(),'Apple 2020 MacBook Air Laptop M1 chip, 13.3-inch/33.74 cm Retina Display, 8GB RAM, 256GB SSD Storage, Backlit Keyboard, FaceTime HD Camera, Touch ID. Works with iPhone/iPad; Space Grey')]"));
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
