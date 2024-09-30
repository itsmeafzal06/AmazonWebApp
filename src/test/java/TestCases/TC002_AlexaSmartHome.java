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

public class TC002_AlexaSmartHome extends BaseClass{
	 @Test
	void AlexaSHTest() {
		
		HomePage hp = new HomePage(driver);
		
		hp.All();
		hp.alexa();
	}
	
		
	

}
