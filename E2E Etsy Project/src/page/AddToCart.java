package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddToCart extends BasicPage {

	
	public List<WebElement> cards = this.driver.findElements(By.cssSelector(
			"div ul.responsive-listing-grid.wt-grid.wt-grid--block.justify-content-flex-start.pl-xs-0 li "));
    public By add= By.cssSelector("button.wt-btn.wt-btn--filled.wt-width-full");
    public List<WebElement> liste= this.driver.findElements(By.className("cart-list-col col-xs-12 col-sm-12 col-md-7 col-lg-8 p-xs-0 pr-md-3  full-height list-unstyled"));
    
    
	public AddToCart(WebDriver driver) {
		super(driver);
	}



	public void goToCard(int num) {
		cards.get(num).click();
			}
		
	

	public void SelectRingSize(String text) {
		WebElement selectElement = driver.findElement(By.cssSelector("select#inventory-variation-select-0"));
		Select select = new Select(selectElement);
		select.selectByVisibleText(text);
	}
	public void SelectRingStyle(String text) {
		WebElement selectElement = driver.findElement(By.id("inventory-variation-select-1"));
		Select select = new Select(selectElement);
		select.selectByVisibleText(text);
	}
	public void InputText(String text) {
		WebElement t=this.driver.findElement(By.id("personalization-input"));
		t.sendKeys(text);
	}

	public void AddToCard()
	{
		this.driver.findElement(this.add).click();
	}
	
	public WebElement getFoundItems() {
		return this.driver.findElement(By.id("page-title"));
		
	}

	boolean found = false;

	public boolean CheckCards() {
		if(getFoundItems().getText()!=null) {
			found = true;
		}
		return found;
	}
	
		
	}
	

