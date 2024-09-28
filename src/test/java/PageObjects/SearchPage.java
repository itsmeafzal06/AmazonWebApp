package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Apple iPhone 16 (128 GB) - Pink']") WebElement btn_iphone16;
	
	public void iphone() {
		btn_iphone16.click();
	}
}
