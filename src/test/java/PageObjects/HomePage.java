package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(xpath="//div[@id='nav-main']/div[1]//a") WebElement btn_All;
	@FindBy(xpath="//div[@id='hmenu-content']/ul[1]//li[8]/a//i") WebElement btn_EchoAlexa;
	
	public void searchBar(String st) {
		txt_search.sendKeys(st);
	}
	
	public void searchButton() {
		btn_search.click();
	}
	
	public void All() {
		btn_All.click();
	}
	
	public void alexa() {
		btn_EchoAlexa.click();
	}
}
