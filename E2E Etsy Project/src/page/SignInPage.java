package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasicPage {

	public By SingButt = By.cssSelector("li button");
	public By Email = By.id("join_neu_email_field");
	public By Password = By.id("join_neu_password_field");
	public By SignIn = By.cssSelector(".has-validation  button");

	public By loggIcon = By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/ul/li[4]/a");

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	public void ClickOnSingButt() {
		this.driver.findElement(this.SingButt).click();
	}

	public void InputEmail(String email) {
		this.driver.findElement(this.Email).sendKeys(email);
	}

	public void InputPassword(String password) {
		this.driver.findElement(this.Password).sendKeys(password);
	}

	public void ClickOnSignIn() {
		this.driver.findElement(this.SignIn).click();
	}

	boolean found = false;

	public boolean Iconlogg() {
		WebElement Icon = this.driver.findElement(this.loggIcon);
		if (Icon != null) {
			found = true;
		}
		return found;
	}

}
