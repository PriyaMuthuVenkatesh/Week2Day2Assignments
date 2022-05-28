package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundRadio {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/radio.html");

		// print title of the page
		System.out.println("Page title is: " + driver.getTitle());

		// print current URL
		System.out.println("Current URL is: " + driver.getCurrentUrl());

		// yes or no radio button- clicking yes
		driver.findElement(By.xpath("//input[@class='myradio' and @id='yes']")).click();

		// Find default selected radio button
		WebElement uncheckedButton = driver.findElement(By.xpath("//input[@value='0' and @name='news']"));
		WebElement checkedButton = driver.findElement(By.xpath("//input[@value='1' and @name='news']"));
		if (uncheckedButton.isSelected()) {
			System.out.println("Unchecked is selected");
		} else if (checkedButton.isSelected()) {
			System.out.println("Checked is selected");
		} else
			System.out.println("No default selection");

		// Select your age group (Only if choice wasn't selected)

		WebElement option1 = driver.findElement(By.xpath("//input[@value='0' and @name='age']"));
		WebElement option2 = driver.findElement(By.xpath("//input[@value='1' and @name='age']"));
		WebElement option3 = driver.findElement(By.xpath("//input[@value='2' and @name='age']"));

		if (option1.isSelected()) {
			System.out.println("1 to 20 years is selected");
		} else if (option2.isSelected()) {
			System.out.println("21-40 years is selected");
		} else if (option3.isSelected()) {
			System.out.println("Above 40 is selected");
		} else
			System.out.println("Please select age group");

	}

}
