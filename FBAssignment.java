package week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBAssignment {

	public static void main(String[] args) {
		
		//setup chromedriver
		WebDriverManager.chromedriver().setup();
		
		//open the browser
		ChromeDriver driver= new ChromeDriver();
		
		//load the url
		driver.get("https://en-gb.facebook.com/");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//adding implicit wait of 20 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//entering  new fb account
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Pri");
		driver.findElement(By.name("lastname")).sendKeys("MV");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8056277280");
		driver.findElement(By.id("password_step_input")).sendKeys("primu123");
		// using select method for selecting birthdate
		Select dayOption = new Select(driver.findElement(By.id("day")));
		dayOption.selectByVisibleText("27");
		Select monthOption = new Select(driver.findElement(By.id("month")));
		monthOption.selectByVisibleText("Oct");
		Select yearOption = new Select(driver.findElement(By.id("year")));
		yearOption.selectByVisibleText("1990");
		//selecting female radio button
		driver.findElement(By.xpath("//input[@type='radio' and @value='1']")).click();		

	}

}
