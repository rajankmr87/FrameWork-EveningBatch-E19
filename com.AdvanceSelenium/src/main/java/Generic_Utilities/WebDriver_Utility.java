package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
 
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is use to implement wait time
	 * @param driver
	 * @author Rajan
	 */
	public void waitElementToLoad(WebDriver driver)
	{ 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method is use to Switch Window
	 * @param driver
	 * @param partial_Title
	 * @author Rajan
	 */
	public void windowSwitching(WebDriver driver, String partial_Title)
	{
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> it = allWins.iterator();

		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partial_Title)) {
				break;
			}
		}
		
	}
	/**
	 * This method is used to handle the drop down elelment.
	 * @param ele
	 * @param value
	 */
	
	public void dropDown(WebElement ele, String value)
	{
		Select select = new Select (ele);
		select.selectByValue(value);	
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseHoverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
}
