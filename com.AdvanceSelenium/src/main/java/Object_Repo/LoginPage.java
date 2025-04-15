package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Element initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Element Decalaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;

	//Generate getter Method. getter and setter by right-click and then click on source->get getter and setter 
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business Login
	/**
	 * This method is used to login into application
	 * @param userName
	 * @param passWord
	 */
	
	public void loginIntoApp(String userName, String passWord)
	{
		UserTextField.sendKeys(userName);
		PasswordTextField.sendKeys(passWord);
		LoginButton.click();
	}
	
}
