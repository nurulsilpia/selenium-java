import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementLocator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Waits and Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(2000);
		// WebElement searchBox = driver.findElement(By.name("q"));
		// searchBox.sendKeys("Shin Ryujin", Keys.ENTER);
		// searchBox.sendKeys("Shin Ryujin", Keys.BACK_SPACE);

		// --- locating multiple elements ---
		/*
		driver.navigate().to("https://trytestingthis.netlify.app/");
		List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));

		for (WebElement element : options) {
			System.out.println(element.getText());
		}
		
		driver.findElement(By.cssSelector("#fname")).sendKeys("Shin");
		*/
		
		// --- RELARIVE LOCATOR ---
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));  
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton)).sendKeys("abcd");
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
