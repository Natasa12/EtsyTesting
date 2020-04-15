package tests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import page.FilteringItems;

// Filtering and adding items to cart
// opening item in a new tab
@Test
public class FilteringTest extends BasicTest {
	private String baseUrl = "https://www.etsy.com/";

	public void GetFiltering() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		FilteringItems item = new FilteringItems(driver);
		item.ChooseCategory();
		Thread.sleep(3000);
		item.SelectAdd("Senegal");
		Thread.sleep(3000);
		item.getRandomElement();
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		item.SelectToAdd();
		Thread.sleep(3000);
	}

}
