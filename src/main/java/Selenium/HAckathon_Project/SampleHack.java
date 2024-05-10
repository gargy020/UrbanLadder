package Selenium.HAckathon_Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleHack {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.urbanladder.com/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='/bookshelf?src=explore_categories']//*[name()='svg']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		// WebElement
		// drpelement=driver.findElement(By.xpath("//div[normalize-space()='Storage
		// Type']"));
		WebElement drpelement = driver.findElement(By.xpath("//li[@data-group='storage type']"));
		drpelement.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='filters_storage_type_Open']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='option']//input[@id='filters_availability_In_Stock_Only']")).click();
		Thread.sleep(5000);
		// Display the name & price of first 3 Bookshelves below Rs. 15000, with Storage
		// type as open & exclude out of stock
		List<WebElement> shelves = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));
		System.out.println("Name & Price of first 3 Bookshelves below Rs. 15000 with open storage type:");
		int count = 0;
		for (WebElement shelf : shelves) {
			String name = shelf.findElement(By.xpath(".//div[contains(@class, 'product-title')]//span")).getText()
					.trim();
			
			String price = shelf.findElement(By.xpath(".//div[contains(@class, 'price-number')]//span")).getText()
					.trim();
			int priceValue = Integer.parseInt(price.replaceAll("[^0-9]", ""));
			if (priceValue < 15000) {
				System.out.println((count + 1) + ". " + name + " - " + price);
				count++;
			}
			if (count >= 3) {
				break;
			}
		}
		// From Collections, retrieve all sub-menu items under Being-At-home and store
		// in a List; Display the same
		driver.navigate().to("https://www.urbanladder.com/collections-new?src=breadcrumb");
		Thread.sleep(4000);
		// List<WebElement> subMenuItems =
		// driver.findElements(By.xpath(".//div[@class='row
		// no-padding']//div[@class='text-center']"));
		List<WebElement> subMenuItems = driver.findElements(By.xpath(".//div[@class='row no-padding']"));
		System.out.println("\nSub-menu items from collections:");
		for (WebElement item : subMenuItems) {
			System.out.println(item.getText().trim());
		}
		Thread.sleep(4000);
		WebElement giftcards = driver
				.findElement(By.xpath("//a[@class='featuredLinksBar__link'][normalize-space()='Gift Cards']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", giftcards);
		giftcards.click();
		Thread.sleep(4000);
		WebElement ba = driver.findElement(By.xpath("//ul[@class='_2sedU']//li[3]//div"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ba);
		ba.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='_3jn98 _23tqD _3k9Vm']//button[2]")).click();
		WebElement month = driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v'][1]"));
		Select drpdown = new Select(month);
		drpdown.selectByValue("5/2024");
		WebElement date = driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v'][2]"));
		drpdown = new Select(date);
		drpdown.selectByValue("3");
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//input[@id='ip_4036288348']")).sendKeys("Shaily");
		driver.findElement(By.xpath("//input[@id='ip_137656023']")).sendKeys("shailygmail.com");
		driver.findElement(By.xpath("//input[@id='ip_3177473671']")).sendKeys("7207636520");
		driver.findElement(By.xpath("//input[@id='ip_1082986083']")).sendKeys("Hemanth");
		driver.findElement(By.xpath("//input[@id='ip_4081352456']")).sendKeys("kanithihemanth@gmail.com");
		driver.findElement(By.xpath("//input[@id='ip_2121573464']")).sendKeys("6309406520");
		driver.findElement(By.xpath("//input[@id='ip_2194351474']")).sendKeys("GC CRPF Campus,Hakimpet");
		driver.findElement(By.xpath("//input[@id='ip_567727260']")).sendKeys("500078");
		driver.findElement(By.xpath("//textarea[@id='ip_582840596']")).sendKeys("Happy birthday bhai");
		driver.findElement(By.xpath("//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']")).click();
		String err_msg = driver.findElement(By.xpath("//input[@id='ip_137656023']")).getAttribute("validationMessage");
		System.out.println();
		System.out.println("Error message after entering the invalid input :" + err_msg);
		driver.close();
	}

}
