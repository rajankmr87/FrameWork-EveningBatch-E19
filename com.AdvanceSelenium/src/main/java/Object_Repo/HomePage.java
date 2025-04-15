package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class HomePage {

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//a[text()=\"More\"]")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	
	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement admLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	//@FindBy(linkText = "Products")
//	private WebElement 
	
	//Getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}
	
	/**
	 * This method is used to click campaign link
	 */
	public void clickCampLink() 
	{
		moreLink.click();
		campLink.click();
	}
	
	public void logOut(WebDriver driver)
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseHoverOnElement(driver, admLink);
		signOut.click();
	}
	
	public void signOut()
	{
		admLink.click();
		signOut.click();
	}
	
	
	
}
