import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// --- MOVE ELEMENT ---
		/*
		 * driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		 * WebElement boxA = driver.findElement(By.xpath("//li[text()='A']"));
		 * WebElement boxD = driver.findElement(By.xpath("//li[text()='D']"));
		 * 
		 * Actions moveBox = new Actions(driver);
		 * 
		 * moveBox.moveToElement(boxA); moveBox.clickAndHold();
		 * moveBox.moveToElement(boxD);
		 * 
		 * moveBox.release().perform();
		 * 
		 * 
		 * //--- MOUSE ACTION --- // klik kanan pada mouse //
		 * moveBox.contextClick(boxD);
		 * 
		 * // double click // moveBox.doubleClick(boxD);
		 * 
		 * moveBox.build().perform(); //moveBox.release().perform();
		 */
		
		// --- DRAG AND DROP ---
		driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html?m=1");
		WebElement elm1 = driver.findElement(By.id("draggable"));
		WebElement elm2 = driver.findElement(By.id("droppable"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(elm1, elm2);
		actions.build().perform();
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Done");
	}

}
