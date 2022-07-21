import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// --- SEND KEYS ----
		/*
		 * driver.get("https://google.com");
		 * driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
		 */

		// --- KEY DOWN ---
		/*
		 * driver.get("https://google.com");
		 * driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
		 * 
		 * Actions actionProvider = new Actions(driver); 
		 * Action keyDownn = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		 * keyDownn.perform();
		 */

		// --- KEY UP ---
		driver.get("https://google.com");		
		
		Actions actions = new Actions(driver);
		WebElement searchBox = driver.findElement(By.name("q"));
		actions.keyDown(Keys.SHIFT).sendKeys(searchBox, "selenium")
		.keyUp(Keys.SHIFT).sendKeys(searchBox, " selenium").perform();
		
		//clear all the text
		Thread.sleep(2000);
		searchBox.clear();

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
