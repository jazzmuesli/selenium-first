import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSeleniumTest {

	@Test
	public void testFirefox() throws Exception {
		HelloSelenium.run(new FirefoxDriver());
	}

	@Test
	public void testChrome() throws Exception {
		ChromeOptions options = new ChromeOptions();
		
		System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver");
        options.addArguments("start-maximized"); // open Browser in maximized mode
//        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); //
        options.addArguments("--headless"); //
		ChromeDriverService service = ChromeDriverService.createDefaultService();
		ChromeDriver driver = new ChromeDriver(service, options);
		HelloSelenium.run(driver);
	}
}
