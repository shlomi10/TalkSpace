package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CalculatorMain;
import utilities.ExtentListener;

@SuppressWarnings("javadoc")
public class BaseTest {

	WebDriver driver;
	CalculatorMain mainCalcPage;
	ExtentListener extentListener;
	
	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true)
	public void setup(String browser) {
		WebDriverManager.chromedriver().setup();
		try {
			WebDriverManager.chromedriver().setup();
			if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
		}catch (Exception e) {
			System.out.println("You enter wrong browser");
		}
		
		// maximize the browser window
		driver.manage().window().maximize();
		mainCalcPage = new CalculatorMain(driver);
	}

	@AfterTest(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}
