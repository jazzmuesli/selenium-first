
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class HelloSelenium {

	public static void run(WebDriver driver) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			System.setProperty("webdriver.chrome.logfile", "/tmp/chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			driver.get("https://github.com/jazzmuesli/selenium-first");
//			googleCheese(driver, wait);
		} finally {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println(scrFile);
			File dstDir = new File("screenshots");
			dstDir.mkdirs();
			File dstFile = new File(dstDir,
					driver.getClass().getSimpleName() + "_" + System.currentTimeMillis() + ".png");
			Files.copy(scrFile, dstFile);
			System.out.println(dstFile);
			driver.quit();
		}
	}

	protected static void googleCheese(WebDriver driver, WebDriverWait wait) {
		driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
		WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
		System.out.println(firstResult.getAttribute("textContent"));
	}
}
