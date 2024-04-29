package Testcases;
import Testdata.LoginTestdata;
import Utilities.ReadExcelData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.LoginPage;
import junit.framework.Assert;

import java.io.IOException;

public class SignInWithValidCredential extends Base {
	@Test(dataProvider = "excelData")
	public void sign_in_with_valid_credential(String username, String password) throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.setUsername(username);
		obj.setPassword(password);
		obj.clickLogin();
		Assert.assertEquals("Dashboard",
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText());
	}

	@Test
	public void sign_in_with_invalid_credential() throws InterruptedException {
		LoginPage obj = new LoginPage(driver);
		obj.setUsername(LoginTestdata.Username);
		obj.setPassword(LoginTestdata.Password1);
		obj.clickLogin();
		Assert.assertEquals("Invalid credentials",
				driver.findElement(
						By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/p"))
						.getText());
	}

	@DataProvider(name = "excelData")
	public String[][] getData() throws IOException {
		String workbook = "C:\\Users\\aksha\\eclipse-workspace\\Selenium-Java-Automation-Framework\\src\\test\\java\\Testdata\\LoginTestdata.xlsx";
		String sheet = "Sheet1";
		return ReadExcelData.readExcelData(workbook, sheet);
	}
}
