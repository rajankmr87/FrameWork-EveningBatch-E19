package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadiResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		
		String teamName = "Patna Pirates";
		
		String teamxPath = driver.findElement(By.xpath("//p[text()='"+teamName+"']")).getText();
		String teamwon = driver.findElement(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class=\"row-head\"]/descendant::div[@class='table-data matches-won']")).getText();
		String teamlost = driver.findElement(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class=\"row-head\"]/descendant::div[@class='table-data matches-lost']")).getText();
		String teamtie = driver.findElement(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class=\"row-head\"]/descendant::div[@class='table-data matches-draw']")).getText();
		String teampoint = driver.findElement(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class=\"row-head\"]/descendant::div[@class='table-data points']")).getText();
		
		System.out.println("The Team Name is "+teamxPath);
		System.out.println("Match won: "+teamwon);
		System.out.println("Match Lost: "+teamlost);
		System.out.println("Match Tie: "+teamtie);
		System.out.println("Team Total Point is: "+teampoint);
		
		driver.close();
	}

}
