package page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoriteItem extends BasicPage {

	List<WebElement> items = this.driver.findElements(By.cssSelector(
			"div ul.responsive-listing-grid.wt-grid.wt-grid--block.justify-content-flex-start.pl-xs-0 li "));
	public By heart = By.xpath("//*[@id=\"listing-right-column\"]/div/div[1]/div[1]/div/div/div/button");

	public FavoriteItem(WebDriver driver) {
		super(driver);
	}

	public void getRandomItem() {
		Random rand = new Random();
		items.get(rand.nextInt(items.size())).click();

	}

	public void FavoriteItems() {
		this.driver.findElement(this.heart).click();
	}

	public void CheckFavorites() {
		WebElement f = this.driver.findElement(By.className("favorites"));
		f.click();
	}

	boolean found = false;

	public boolean checkFavoriteItem() {
		WebElement favIt = this.driver.findElement(By.id("tl-1_0"));
		if (favIt != null)
			found = true;
		return found;

	}
}
