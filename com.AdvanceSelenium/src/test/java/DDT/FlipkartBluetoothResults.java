package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartBluetoothResults {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("bluetooth",Keys.ENTER);
		List<WebElement> itemlist = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		List<WebElement> itemprice = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
		System.out.println("Products Name and price are: ");
		for(int i=0;i<itemlist.size();i++)
		{
			String product = itemlist.get(i).getText();
			String price = itemprice.get(i).getText();
			
			System.out.println(product+"--->"+price);
		}
	}

}
