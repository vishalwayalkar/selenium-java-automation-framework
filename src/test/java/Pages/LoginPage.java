package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement USERNAME;
	
	@FindBy(name="password")
	private WebElement PASSWORD;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement LOGIN;
	
	public void setUsername(String username) {
		USERNAME.sendKeys(username);
	}
	
	public void setPassword(String password) {
		PASSWORD.sendKeys(password);
	}
	
	public void clickLogin() {
		LOGIN.click();
	}
	
}
