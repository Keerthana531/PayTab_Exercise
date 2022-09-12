package orangeHRM_TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public String userName = "Admin";
	public String password = "admin123";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}

