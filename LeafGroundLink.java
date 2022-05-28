package week2day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Link.html");
		
		// Go to Home Page
		WebElement link = driver.findElement(By.linkText("Go to Home Page"));
		System.out.println("Home page link is: "+link.getAttribute("href"));
		System.out.println("Color of the text is "+link.getCssValue("color"));
		
		// Find where am supposed to go without clicking me?
		WebElement link1 = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
		System.out.println("Hidden link is :" +link1.getAttribute("href"));
		System.out.println("Color of the text is "+link1.getCssValue("color"));
		
		//Verify am I broken?
		WebElement link2 = driver.findElement(By.linkText("Verify am I broken?"));
		System.out.println("Broken link is :" +link2.getAttribute("href"));
		System.out.println("Color of the text is "+link2.getCssValue("color"));
				
		//Go to Home Page (Interact with same link name)
		WebElement link3 = driver.findElement(By.xpath("//label/preceding-sibling::a"));
		System.out.println("Home page link is" +link3.getAttribute("href"));
		System.out.println("color is" +link3.getCssValue("color"));
		
		//How many links are available in this page?
		
		WebElement link4 = driver.findElement(By.linkText("How many links are available in this page?"));
		System.out.println("color is" +link4.getCssValue("color"));
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links in this page is " +links.size());
		
		driver.close();
	}

}
