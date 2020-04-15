package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowseSearch extends BasicPage {

	public By Search = By.cssSelector("[name='search_query']");

	public BrowseSearch(WebDriver driver) {
		super(driver);
	}

	public void InputItem(String item) {
		WebElement input = this.driver.findElement(this.Search);
		input.sendKeys(item);
		input.sendKeys(Keys.ENTER);

	}

	public String getTitle() {
		return this.driver.getTitle();
	}

	boolean found = false;

	public boolean CheckTitle(String term) {
		if (getTitle().toLowerCase().contains(term)) {
			found = true;
		}
		return found;
	}

}
