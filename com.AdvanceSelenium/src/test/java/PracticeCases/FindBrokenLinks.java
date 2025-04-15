package PracticeCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");

		List<WebElement> link = driver.findElements(By.tagName("a"));

		System.out.println("No of links are" + link.size());

		List<String> urList = new ArrayList<String>();

		for (WebElement e : link) {
			String url = e.getAttribute("href");
			checkBrokenLink(url);

		}
	}

	public static void checkBrokenLink(String linkUrl)
	{
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode()>=400)
			{
				System.out.println(linkUrl+"--->"+httpUrlConnection.getResponseMessage()+"is a broken link");
			}
			else
			{
				System.out.println(linkUrl+"--->"+httpUrlConnection.getResponseMessage());
			}
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}

}
}
