package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		
		 prop =new Properties();
		FileInputStream fis = new FileInputStream("F:\\Udemy_Selenium\\ETEProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if( browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Udemy_Selenium\\ETEProject\\exe files\\chromedriver.exe");
		 driver=new ChromeDriver();
			
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Udemy_Selenium\\ETEProject\\exe files\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "F:\\Udemy_Selenium\\ETEProject\\exe files\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	return driver;
	}
	public void getScreenShotpath(String FailedMethodName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destFile= System.getProperty("user.dir")+"\\reports\\FailedMethodName"+".png";
	FileUtils.copyFile(src,new File(destFile));
	}
	
		
}
