package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;




public class BasicTest {

protected WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drive-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().refresh();
	}
	
	
	@AfterTest
	public void quit() {
//		driver.close();
	}

// Try to write a test for Cross browser Testing// but unfortunately didnt work
//@BeforeTest
//@Parameters("browsers")
//public  void setup(String browser) throws Exception {
//	if(browser.equalsIgnoreCase("firefox")) {
//		System.setProperty("webdriver.gecko.driver","C:\\Users\\owner\\Downloads\\geckodriver-v0.26.0-win32");
//		driver=new FirefoxDriver();
//	}
//	else if (browser.equalsIgnoreCase("chrome")) {
//		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
//		driver = new ChromeDriver();
//	}
//		
	}


