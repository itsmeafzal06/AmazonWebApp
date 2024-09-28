package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement txt_search;
	@FindBy(xpath="//input[@id='nav-search-submit-button']") WebElement btn_search;
	
	public void searchBar(String st) {
		txt_search.sendKeys(st);
	}
	
	public void searchButton() {
		btn_search.click();
	}
}
