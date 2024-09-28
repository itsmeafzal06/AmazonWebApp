package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IphoneDescriptionPage extends BasePage {
	
	WebDriver driver;

	public IphoneDescriptionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@id='productTitle']") WebElement txt_title;
	
	public String itemTitle() {
		String title=txt_title.getText();
		return title;
	}

}
