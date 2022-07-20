import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//Waits and Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://google.com");
		String originalWindow = driver.getWindowHandle();

		//---browser action---
		/*
		driver.navigate().to("https://automationstepbystep.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());


		//---navigate---
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();


		//---new window or new tab---
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demoqa.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		//String originalWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().window(originalWindow);


		//---FRAME---
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		//driver.findElement(By.linkText("Alert")).click(); //-> ini ga akan ketemu soalnya ada di dlm tag frame. jadi harus beralih ke frame dulu
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.className("interfaceName")).click();
		driver.switchTo().defaultContent();


		//---MANAGE WINDOW---
		//dimension size
		driver.manage().window().getSize().getWidth();
		driver.manage().window().getSize().getHeight();

		Dimension size = driver.manage().window().getSize();
		System.out.println(size.getWidth());
		System.out.println(size.getHeight());

		driver.manage().window().setSize(new Dimension(800, 600));
		Thread.sleep(2000);

		//point position
		driver.manage().window().getPosition().getX();
		driver.manage().window().getPosition().getY();

		Point position = driver.manage().window().getPosition();
		System.out.println(position.getX());
		System.out.println(position.getY());

		driver.manage().window().setPosition(new Point(500, 100));

		//minimize, maximize, fullscreen window
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();


		//--- SCREENSHOT ---
		//full screen
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./image1.png"));
			//ini lokasi file nya keluar satu folder di default folder file

		//ss spesifik element
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		File srcFile1 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("./image-specific.png"));
		 */


		//--- JAVASCRIPT EXECUTOR ---
		JavascriptExecutor js = (JavascriptExecutor)driver;

		WebElement button = driver.findElement(By.name("btnI"));
		js.executeScript("arguments[0].click();", button);
		//js.executeScript("console.log('This console made by automation')");

		Thread.sleep(3000);
		driver.close(); 
		//hanya menutup tab/window
		driver.quit(); 
		//mengakhiri sesi browser
	}
}
