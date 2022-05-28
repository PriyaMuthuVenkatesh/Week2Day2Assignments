package week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadAssignment2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

//		* 1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		* 2	Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

//		* 3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

//		* 4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

//		* 5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

//		* 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

//		* 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		 Thread.sleep(2000);

//		* 8	Enter first name
		driver.findElement(By.xpath("//input[@name='firstName' and @id='ext-gen248']")).sendKeys("Priya");
		 Thread.sleep(2000);

//		* 9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(2000);

//		* 10 Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		 Thread.sleep(2000);

//		* 11 Verify title of the page
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("View Lead | opentaps CRM"))
			System.out.println("Title verified as " + title);
		else
			System.out.println("Incorrect title");

//		* 12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

//		* 13 Change the company name
		WebElement cmpName = driver.findElement(By.id("updateLeadForm_companyName"));
		cmpName.clear();
		cmpName.sendKeys("PMV");

//		* 14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

//		* 15 Confirm the changed name appears
		String changedName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if (changedName.contains("PMV")) {
			System.out.println("Changed name is " + changedName);
		}

		else
			System.out.println("Incorrect name");

//		* 16 Close the browser (Do not log out)
		driver.close();

	}

}
