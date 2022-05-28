package week2day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		// open URL
		driver.get("http://leafground.com/pages/checkbox.html");

		// Select the languages that you know?
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[1]"))
				.click();
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[3]"))
				.click();
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[5]"))
				.click();

		// Confirm Selenium is checked
		WebElement seleniumCheckBox = driver
				.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input"));
		if (seleniumCheckBox.isSelected()) {
			System.out.println("Selenium checkbox is selected");
		} else
			System.out.println("Selenium checkbox not selected");

		// DeSelect only checked
		WebElement option1 = driver
				.findElement(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[1]"));
		WebElement option2 = driver
				.findElement(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[2]"));

		if (option1.isSelected()) {
			option1.click();
			System.out.println("Deselected the already checked option- Not Selected");
		} else {
			option2.click();
			System.out.println("Deselected the already checked option- I am Selected");

		}

//					Select all below checkboxes
		List<WebElement> findElements = driver
				.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
		for (int i = 0; i < findElements.size(); i++) {
			findElements.get(i).click();
		}
		System.out.println("All the checkboxes are selected");

	}

}
