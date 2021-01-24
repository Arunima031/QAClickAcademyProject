package Academy.ETEProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.landingPage;
import resources.base;

public class HomePageTest extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void BrowserLaunching() throws IOException {
		driver=initializeDriver();
		log.info("initialized driver");
	}
	@AfterTest
	public void closeWindow() {
		driver.close();	
	}
	@Test(dataProvider="getData")
	public void HomePageLaunch(String Username,String Password,String usertype)   {
		//driver.get(prop.getProperty("url"));
		driver.get("http://www.qaclickacademy.com");
		landingPage lp =new landingPage(driver);
		lp.LoginButton().click();
		LoginPage loginp= new LoginPage(driver);
		loginp.loginBox().sendKeys( Username);
		loginp.passworkBox().sendKeys(Password);
		log.info(usertype);
		loginp.LoginButton().click();
		
		}
	@DataProvider
	public Object[][] getData() {
		Object[][] data =new Object[2][3];
		data[0][0]="abc@gmail.com";
		data[0][1]="1234567";
		data[0][2]="restricted";
		data[1][0]="def@gmail.com";
		data[1][1]="dg34567";
		data[1][2]="unrestricted";
		return data;
	}
	

	}
	

