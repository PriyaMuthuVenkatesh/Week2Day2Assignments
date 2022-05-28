package week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		// open url
		String imageURL = "http://leafground.com/pages/Image.html";
		driver.get(imageURL);

		// verify if the click is working on image
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img"))
				.click();
		String navigatedURL = driver.getCurrentUrl();

		if (navigatedURL.matches(imageURL))
			System.out.println("Home page navigation is not successful");
		else
			System.out.println("Home page navigation is successful");

		// Am I Broken Image?
		driver.get(imageURL);
		WebElement brokenElement = driver
				.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
		brokenElement.click();
		String brokenUrl = driver.getCurrentUrl();
		if (brokenUrl.matches(imageURL))
			System.out.println("Broken link");
		else
			System.out.println("Navigation is successful");

		// Click me using Keyboard or Mouse
		driver.get(imageURL);
		WebElement keyLink = driver
				.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"));
		keyLink.click();
		String currentURL = driver.getCurrentUrl();
		if (currentURL.matches(imageURL))
			System.out.println("Click not working");
		else
			System.out.println("Click using keyboard or mouse is working");

	}

}
