import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSeleniumTest {

	@Test
	public void testFirefox() throws Exception {
		HelloSelenium.run(new FirefoxDriver());
	}

	@Test
	public void testChrome() throws Exception {
		HelloSelenium.run(new ChromeDriver());
	}
}
