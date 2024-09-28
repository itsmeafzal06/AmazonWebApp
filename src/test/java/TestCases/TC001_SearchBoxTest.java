package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.IphoneDescriptionPage;
import PageObjects.SearchPage;
import TestBase.BaseClass;

public class TC001_SearchBoxTest extends BaseClass{
	
	@Test
	void SearchTest()  throws IOException{
		try {
			HomePage hp= new HomePage(driver);
			
			String item = p.getProperty("item");
			hp.searchBar(item);
			hp.searchButton();
			
			SearchPage sp = new SearchPage(driver);
			
			sp.iphone();
			
			Set<String> wids=driver.getWindowHandles();
			List<String> wid=new ArrayList<String>(wids);
			
			driver.switchTo().window(wid.get(1));
			
			IphoneDescriptionPage idp= new IphoneDescriptionPage(driver);
			System.out.println(idp.itemTitle());
			if(p.getProperty("itemName").equalsIgnoreCase(idp.itemTitle())) {
				Assert.assertTrue(true);
							}
			else {
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			Assert.fail();
		}
		
	}

}
