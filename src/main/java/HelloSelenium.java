
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * brew install geckodriver
 *
 */
public class HelloSelenium {

	public static void run() throws IOException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://google.com/ncr");
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
            System.out.println(firstResult.getAttribute("textContent"));
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         // Now you can do whatever you need to do with it, for example copy somewhere
            System.out.println(scrFile);
            Files.copy(scrFile, new File("1.png"));
        } finally {
            driver.quit();
        }
    }
}
