package Academy.ETEProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import junit.framework.Assert;
import pageObject.landingPage;
import resources.base;

public class validateTitleTest extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void BrowserLaunching() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		//driver.get(prop.getProperty("url"));
		driver.get("http://www.qaclickacademy.com");
		log.info("Navigated to site");
	}
	@AfterTest
	public void closeWindow() {
		driver.close();	
		log.info("closed window");
	}
	
	@Test
	public void ValidateTitle() throws IOException  {
	
	landingPage lp =new landingPage(driver);
	String actualText = lp.textVerify().getText();
	log.info("got text field");
	String Expected ="FEATURED COURSES";
	Assert.assertEquals(Expected,actualText);
	log.info("successfully validated");

}
}