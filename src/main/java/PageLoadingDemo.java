import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);

		/*
		 * options.setPageLoadStrategy(PageLoadStrategy.NONE);
		 * options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		 * options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");

		driver.close();
		driver.quit();
	}

}
