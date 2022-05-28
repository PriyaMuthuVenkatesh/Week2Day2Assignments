package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeAssignment3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
//		1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
		
//		2. Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		
//		3. Enter Password as "leaf@12"
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
//		4. Click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
//		5. Get the title of the page and print
		String title = driver.getTitle();
		System.out.println(title);
		
//		6. Click on Log Out
		driver.findElement(By.linkText("Log Out")).click();
		
//		7. Close the browser (use -driver.close())
		driver.close();
	}

}
