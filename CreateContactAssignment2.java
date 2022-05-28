package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAssignment2 {

	public static void main(String[] args) {
		
		//setting up chromedriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//open leaftaps url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//create contact with mandatory fields
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Kavin");
		driver.findElement(By.id("lastNameField")).sendKeys("Amuthan");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Chinnu");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Pappu");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("NB");
		driver.findElement(By.id("createContactForm_description")).sendKeys("First Cry");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("KA@test.com");
		Select option= new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		option.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		
		//edit contact
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_description")).sendKeys("New Born");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		// print title of the page
		System.out.println(driver.getTitle());

	}

}
