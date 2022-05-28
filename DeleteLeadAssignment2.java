package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadAssignment2 {

	public static void main(String[] args) throws InterruptedException {

		//setting up chromedriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//open leaftaps url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//login
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click on leads
		driver.findElement(By.linkText("Leads")).click();
		
		//access find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//click on phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//enter phone number
		
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
	
		//click find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		//printing lead ID of First Resulting lead
		String leadId= driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).getText();
		System.out.println("Captured Lead ID is " +leadId);
		
		Thread.sleep(5000);
		
		//clicking First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//delete the selected lead
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		Thread.sleep(5000);
		//access find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//enter captured lead
		driver.findElement(By.xpath("//label[contains(text(),'Lead ID')]/following-sibling::div/input")).sendKeys(leadId);
		
		//click find lead button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//verifying deletion message
		String message = driver.findElement(By.xpath("//div[contains(text(),'No records')]")).getText();
		
		 if ( message.equalsIgnoreCase ( "No records to display" ) )
	        {
	            System.out.println ( "Sucessfully Deleted the Lead with ID: " + leadId );
	        }
	        else
	        {
	            System.out.println ( "Lead not deleted" + message );
	        }
		//closing browser
		driver.close();		
		
	}

}
