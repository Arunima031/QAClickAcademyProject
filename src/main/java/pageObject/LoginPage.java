package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='user_email']")
	WebElement loginBox;
	public WebElement loginBox() {
		return loginBox;
	}
	@FindBy(xpath="//input[@id='user_password']")
	WebElement passwordBox;
	public WebElement passworkBox() {
		return passwordBox;
		
	}
@FindBy(css="input[type='submit']")
WebElement LoginButton;
public WebElement LoginButton() {
	return  LoginButton;
}
}
