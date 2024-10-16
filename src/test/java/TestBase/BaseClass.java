package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties p;
	@BeforeClass
	@Parameters({"browser","os"})
	public void setup(String br,String os) throws IOException {
		
	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//confi.configration");
	p=new Properties();
	p.load(file);
	
	if(p.getProperty("environment").equalsIgnoreCase("remote")) {
		
		DesiredCapabilities dc = new DesiredCapabilities();
	
		switch (os.toLowerCase()) {
		case "linux":dc.setPlatform(Platform.LINUX);break;
		case "max":dc.setPlatform(Platform.MAC);break;
		
		default:System.out.println("invalid Operating System");
			break;
		}
	
		
		switch (br.toLowerCase()) {
		case "chrome":dc.setBrowserName("chrome");break;
		case "edge":dc.setBrowserName("MicrosoftEdge");;break;
		case "firefox":dc.setBrowserName("firefox");break;
		default : System.out.println("invalid browser entry");break;
		}
	
		driver= new RemoteWebDriver(new URL("http://192.168.1.60:4444/wd/hub"),dc);
	
	}
	
	if(p.getProperty("environment").equalsIgnoreCase("local")) {
		
		switch (br) {
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default : System.out.println("invalid browser entry");break;
		}
		
	}
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();
	 
	 driver.get(p.getProperty("url"));
		
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png";
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}
