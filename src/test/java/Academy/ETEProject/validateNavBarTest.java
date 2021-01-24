package Academy.ETEProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingPage;
import resources.base;

public class validateNavBarTest extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void BrowserLaunching() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		//driver.get(prop.getProperty("url"));
		driver.get("http://www.qaclickacademy.com");
	}
	@AfterTest
	public void closeWindow() {
		driver.close();	
	}
	@Test
	public void navBardisplay() throws IOException {
		
		landingPage lp =new landingPage(driver);
	boolean result = lp.navBardisplay().isDisplayed();
		Assert.assertTrue(result);
		log.info("Successfull execution of isDisplayed ");

	}

}
