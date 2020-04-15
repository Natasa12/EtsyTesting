package tests;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddToCart;
import page.BrowseSearch;
import page.FavoriteItem;
import page.SignInPage;
import page.FilteringItems;

public class EtsyTests extends BasicTest {

	private String baseUrl = "https://www.etsy.com/";
	private String BaseUrlAdd = "https://www.etsy.com/listing/542505771/ring-wood-wood-rings-for-men-5-year?ref=search_recently_viewed-2&pro=1&frs=1";

	private String BaseUrlFav = "https://www.etsy.com/c/clothing/womens-clothing";

	
	// Use Case - Login to Etsy website(valid email and password)
	@Test(priority = 1)
	public void goSigIn() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);

		SignInPage sign = new SignInPage(driver);
		Thread.sleep(3000);
		sign.ClickOnSingButt();
		Thread.sleep(3000);
		sign.InputEmail("njevtic73@gmail.com");
		Thread.sleep(2000);
		sign.InputPassword("Natasa1");
		Thread.sleep(2000);
		sign.ClickOnSignIn();
		Thread.sleep(3000);

		boolean found = sign.Iconlogg();
		Assert.assertTrue(found);
	}

	
	// Use Case-Browsing through categories and searching for items
	// (Browsing on Search)
	@Test(priority = 2)
	public void searchItems() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);

		Thread.sleep(3000);
		BrowseSearch s = new BrowseSearch(driver);
		Thread.sleep(2000);
		s.InputItem("shoes");
		Thread.sleep(3000);

		boolean title = s.CheckTitle("shoes");

		Assert.assertTrue(title);
	}

	// Use Case-Filtering and adding items to cart(Choose items and filtering)
	@Test(priority = 3)
	public void FilteringItems() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);

		FilteringItems filter = new FilteringItems(driver);
		Thread.sleep(3000);
		filter.ChooseCategory();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		filter.SelectAdd("Russia");
		Thread.sleep(2000);

	}

	// Use Case-Filtering and adding items to cart(Choose items and adding to cart)
	@Test(priority = 4)
	public void AddingToCart() throws InterruptedException {
		driver.get(BaseUrlAdd);
		Thread.sleep(2000);

		AddToCart add = new AddToCart(driver);
		Thread.sleep(3000);

		add.SelectRingSize("3 US");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		add.SelectRingStyle("1");
		Thread.sleep(2000);
		add.InputText("N");
		Thread.sleep(2000);
		add.AddToCard();
		Thread.sleep(3000);

		boolean found = add.CheckCards();

		Assert.assertTrue(found);
	}

	// Use Case - Managing favorite items (“hearted” items)
	// (Make favorite items)
	@Test(priority = 5)
	public void getfavoriteItem() throws InterruptedException {
		driver.get(BaseUrlFav);
		Thread.sleep(2000);

		FavoriteItem f = new FavoriteItem(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		f.getRandomItem();
		Thread.sleep(3000);

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		f.FavoriteItems();
		Thread.sleep(2000);
		f.CheckFavorites();
		Thread.sleep(2000);
		boolean found = f.checkFavoriteItem();

		Assert.assertTrue(found);

	}
}
