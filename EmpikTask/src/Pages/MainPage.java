package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(linkText = "Zaloguj")
	private WebElement loginBtn;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}
	
	public void selectLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
	
	public void validateLinkNameChanged(String name) {
		WebElement wb = driver.findElement(By.linkText("Witaj, " + name));
		wait.until(ExpectedConditions.elementToBeClickable(wb));
		assertEquals(wb.getText(), "Witaj, " + name);
	}
}
