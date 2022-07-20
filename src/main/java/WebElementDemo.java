import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// --- FIND ELEMENT ---
		/*
		 * driver.get("https://google.com"); WebElement searchBox =
		 * driver.findElement(By.name("q")); searchBox.sendKeys("selenium" +
		 * Keys.ENTER); // driver.findElement(By.name("btnK")).click();
		 */

		// --- FIND ELEMENTS ---
		/*
		 * driver.get("https://trytestingthis.netlify.app/"); List<WebElement> elements
		 * = driver.findElements(By.tagName("select"));
		 * 
		 * for (WebElement element : elements) { System.out.println(element.getText());
		 * }
		 */

		// --- FIND ELEMENT WITHIN ELEMENT ---
		/*
		 * driver.get("https://google.com"); WebElement form =
		 * driver.findElement(By.tagName("form"));
		 * form.findElement(By.name("q")).sendKeys("ABCD" + Keys.ENTER);;
		 */

		// --- GET ACTIVE ELEMENT ---
		/*
		 * driver.get("https://google.com");
		 * driver.findElement(By.name("q")).sendKeys("selenium"); String title =
		 * driver.switchTo().activeElement().getAttribute("title");
		 * System.out.println(title);
		 */

		// --- GET TAG NAME, TEXT, CSS, ETC ---
		/*
		 * driver.get("https://google.com"); WebElement searchBox =
		 * driver.findElement(By.name("q")); String tagName = searchBox.getTagName();
		 * String text = searchBox.getText(); String cssValue =
		 * searchBox.getCssValue("font");
		 * 
		 * System.out.println(tagName + " | " + text + " | " + cssValue);
		 */
		
		// --- CHECK ELEMENT IS ENEBLED, IS SELECTED ---
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
