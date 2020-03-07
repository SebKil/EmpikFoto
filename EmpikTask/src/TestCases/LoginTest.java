package TestCases;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginTest {
	WebDriver driver;
	
	String chromeDriverPath = "C:\\Users\\User\\Desktop\\JAVA\\EmpikTask\\chromedriver.exe";
	String pageURL = "https://www.empikfoto.pl/";
	
	MainPage mainPage;
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(pageURL);  
		driver.manage().window().maximize();
		
		mainPage = new MainPage(driver);
		loginPage = new LoginPage(driver);
	}

	@Test
	public void correctLogin() throws InterruptedException {
	
		//Test Data
		String email = "sebastiankilanski@gmail.com";
		String pass = "Test1234";
		String userName = "Sebastian";
		
		try {
			//Click login page
			mainPage.selectLoginButton();
			
			//Set Correct data to form
			loginPage.setEmail(email);
			loginPage.setPassword(pass);
			
			//Uncheck remember me checkbox
			loginPage.selectRememberCheckBox();
			
			//Click login button
			loginPage.selectLoginButton();
			
			//Validate Login Link
			mainPage.validateLinkNameChanged(userName);

		}
		catch (Exception e) {
			driver.quit();
			throw(e);
		}
	}
	
	@Test
	public void incorrectLogin() throws InterruptedException {
	
		//Test Data
		String email = "sebastiankilanski@gmailcom";
		String pass = "Test1234";
		String errMessage = "B��dny u�ytkownik lub has�o.";
		
		try {
			//Click login page
			mainPage.selectLoginButton();
			
			//Set Correct data to form
			loginPage.setEmail(email);
			loginPage.setPassword(pass);
			
			//Uncheck remember me checkbox
			loginPage.selectRememberCheckBox();
			
			//Click login button
			loginPage.selectLoginButton();
			
			//Validate error message
			loginPage.validateErrorMessageIsVisible(errMessage);
			
		}
		catch (Exception e) {
			driver.quit();
			throw(e);
		}
	}

	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
}
