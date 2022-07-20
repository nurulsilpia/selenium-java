import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://trytestingthis.netlify.app/");
		//WebElement dropdown = driver.findElement(By.id("option"));
		//Select selectObject = new Select(dropdown);

		// bisa select berdasarkan
		/*
		 * selectObject.selectByIndex(1); Thread.sleep(1000);
		 * selectObject.selectByValue("option 2"); Thread.sleep(1000);
		 * selectObject.selectByVisibleText("Option 3");
		 */

		// --- GET ALL DROPDOWN IN LIST
		// List<WebElement> allAvailableOptions = selectObject.getOptions();
		// bisa juga pake cara di bawah 🔽
		/*
		 * List<WebElement> allOptions = driver.findElements(By.id("option"));
		 * 
		 * for (WebElement option : allOptions) { System.out.println(option.getText());
		 * 
		 * if (option.getText().equalsIgnoreCase("option 2")) { option.click();
		 * Thread.sleep(1000); }
		 * 
		 * }
		 */
		
		// --- DESELECT AN OPTION ---
		WebElement dropdown = driver.findElement(By.id("owc"));
		Select selectObject = new Select(dropdown);
		
		selectObject.selectByValue("option 2"); 
		Thread.sleep(1000);
		selectObject.selectByVisibleText("Option 3");
		
		Thread.sleep(1000);
		selectObject.deselectByVisibleText("Option 3");

		Thread.sleep(2000);
		driver.quit();
		System.out.println("Done");
	}

}
