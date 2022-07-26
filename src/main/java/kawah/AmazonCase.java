package kawah;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Waits and Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		//explicit wait for btn dont save
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btnDontSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")));
		btnDontSave.click();
		
		//--CHANGE CURRENCY SETTING--
		WebElement humbergerMenu = driver.findElement(By.id("nav-hamburger-menu"));
		humbergerMenu.click();
		WebElement preferences = driver.findElement(By.xpath("//*[@id=\"hmenu-icp-language\"]"));
		//scroll down
		js.executeScript("arguments[0].scrollIntoView();",preferences );
		Thread.sleep(500);
		preferences.click();
		
		//select dropdown
		js.executeScript("window.scrollBy(0,500)");
		WebElement dropdown = driver.findElement(By.className("a-dropdown-container"));
		dropdown.click();
		WebElement idr = driver.findElement(By.partialLinkText("IDR"));
		idr.click();
		WebElement saveBtnCrn = driver.findElement(By.id("icp-save-button"));
		saveBtnCrn.click();
		Thread.sleep(2000);
		
		//--TODAY'S DEALS COUPON--
		WebElement todayDeals = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
		todayDeals.click();
		
		//explicit wait sub nav coupon
		WebDriverWait waitCoupon = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement subNav = waitCoupon.until(ExpectedConditions.elementToBeClickable(By.id("nav-subnav")));

		WebElement coupon = subNav.findElement(By.linkText("Coupons"));
		coupon.click();
		
		WebElement sidebar = driver.findElement(By.className("apb-browse-left-nav"));
		WebElement electronic = sidebar.findElement(By.linkText("Electronics"));
		js.executeScript("window.scrollBy(0,500)");
		electronic.click();
		
		WebElement product = driver.findElement(By.partialLinkText("TOZO T6 True Wireless Earbuds Bluetooth Headphones"));
		product.click();
		js.executeScript("window.scrollBy(0,500)");
		
		/*
		 * WebElement addToCart = driver.findElement(By.className("addToCartBtn"));
		 * WebElement addToCartBtn = addToCart.findElement(By.tagName("input"));
		 * addToCartBtn.click();
		 * 
		 * WebElement addToCartBtn =
		 * driver.findElement(By.xpath("//*[@id=\"a-autoid-5\"]/span/input"));
		 * addToCartBtn.click();
		 */
		
		//js executor to handle btn add to cart
		WebElement addToCartBtn = driver.findElement(By.xpath("//*[@id=\"a-autoid-5\"]/span/input"));
		js.executeScript("arguments[0].click();", addToCartBtn);
		
		//cek in the cart
		WebElement cart = driver.findElement(By.id("nav-cart"));
		cart.click();
		
		// verify coupon success add to cart
		if (driver.getPageSource().contains("TOZO T6 True Wireless Earbuds Bluetooth Headphones")) {
			System.out.println("Coupon successfully add to cart");
		} else {
			System.out.println("Coupon failed add to cart");
		}
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
