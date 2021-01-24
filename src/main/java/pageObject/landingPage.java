package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	public WebDriver driver ;
	public landingPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement LoginButton ;
	public WebElement LoginButton() {
		return LoginButton;

}
	@FindBy(xpath="//div[@class='text-center']/h2")
	WebElement textVerify;
	public WebElement textVerify() {
		return textVerify;
		}
	@FindBy(css=".nav.navbar-nav.navbar-right")
	WebElement navBar;
	public WebElement navBardisplay() {
		return navBar;
	}
	}
