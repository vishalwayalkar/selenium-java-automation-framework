package Testcases;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	WebDriver driver;
	String env = "opensource-demo.orangehrmlive";
	int max_timeout = 10;
	String baseURL = "https://" +env+ ".com/web/index.php/auth/login";
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(max_timeout));
	}
	
	@AfterTest
	public void tearDown() throws IOException, InterruptedException {
//		driver.close();
	}

}
