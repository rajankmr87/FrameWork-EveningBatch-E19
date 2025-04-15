package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhonePriceGreaterThan60K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);
		List<WebElement> phoneName = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> phonePrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		
		for(int i=0;i<phoneName.size();i++)
		{
			String product = phoneName.get(i).getText();
			String price = phonePrice.get(i).getText().replace("₹", "").replace(",", "").trim();
			double fprice = Double.parseDouble(price);
			if(fprice>60000)
			{
				 System.out.println("Product Name: " + product);
                 System.out.println("Price: ₹" + price);
                 System.out.println("------------------------------------");
			}

/*     //Below code is also correct in case to use of try and catch
            try {
                double fprice = Double.parseDouble(price);
                if (price > 60000) {
                    System.out.println("Product Name: " + product);
                    System.out.println("Price: ₹" + price);
                    System.out.println("------------------------------------");
                }
            } catch (NumberFormatException e) {
                // If there's a problem parsing the price, skip this item
                continue;
 */
		}
	}

}
