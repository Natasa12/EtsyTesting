package page;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FilteringItems extends BasicPage {

	public By category = By.cssSelector("span#catnav-primary-link-10923");

	public By radioButton = By.cssSelector(".mb-xs-3.filter-chrome fieldset a.radio-label");
	public List<WebElement> tag = this.driver.findElements(By.className("tag"));

	public FilteringItems(WebDriver driver) {
		super(driver);
	}

	public void ChooseCategory() {
		this.driver.findElement(category).click();

	}

	public void getRandomElement() {
		List<WebElement> cards = this.driver.findElements(By.cssSelector(
				"div ul.responsive-listing-grid.wt-grid.wt-grid--block.justify-content-flex-start.pl-xs-0 li "));
		Random rand = new Random();
		cards.get(rand.nextInt(cards.size())).click();
	}

	public void SelectAdd(String Add) {
		WebElement selectElement = driver.findElement(By.tagName("select"));
		Select select = new Select(selectElement);
		// List<WebElement> allOptions = select.getOptions();
		select.selectByVisibleText(Add);
	}
//	public void SelectSize(String text) {
//		WebElement selectElement = driver.findElement(By.cssSelector("select#inventory-variation-select-0"));
//		if(selectElement!=null) {
//		Select select = new Select(selectElement);
//		select.selectByVisibleText(text);
//		}

	public void SelectToAdd() {
		WebElement dropdown = driver.findElement(By.id("inventory-variation-select-1"));
		dropdown.click();

		List<WebElement> itemsInDropdown = driver
				.findElements(By.cssSelector("select#inventory-variation-select-0 option"));
		int randomNumber = ThreadLocalRandom.current().nextInt(0, itemsInDropdown.size());
		itemsInDropdown.get(randomNumber).click();
	}
}
