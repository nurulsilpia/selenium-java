import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// JS ALERT
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		Thread.sleep(2000);
		alert1.accept();

		// verify js alert
		if (driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("You successfully clicked an alert");
			System.out.println("=============");
		}

		// JS CONFIRM
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		Thread.sleep(2000);
		alert2.dismiss();

		if (driver.getPageSource().contains("You clicked: Cancel")) {
			System.out.println("You clicked: Cancel");
			System.out.println("=============");
		} else {
			System.out.println("Alert doesn's exist");
		}

		// JS PROMPT
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("Input test alert");
		Thread.sleep(2000);
		alert3.accept();
		
		if (driver.getPageSource().contains("You entered: Input test alert")) {
			System.out.println("You entered: Input test alert");
			System.out.println("=============");
		}
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
