package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	protected WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "userRegisterForm_email")
	private WebElement userEmail;
	@FindBy(id = "userRegisterForm_password_first_l")
	private WebElement userPassword;
	
	@FindBy(id = "remember_me")
	private WebElement rememberCheckBox;
	
	@FindBy(id = "loginForm")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(userEmail));
		userEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(userPassword));
		userPassword.sendKeys(password);
	}
	
	public void selectRememberCheckBox() {
		rememberCheckBox.click();
	}
	
	public void selectLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
	
	public void validateErrorMessageIsVisible(String errorMsg) {
		WebElement wb = driver.findElement(By.cssSelector(".statement span"));
		wait.until(ExpectedConditions.visibilityOfAllElements(wb));
		assertEquals(wb.getText(), errorMsg);
	}
}
