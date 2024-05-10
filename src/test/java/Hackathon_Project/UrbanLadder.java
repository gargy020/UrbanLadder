package Hackathon_Project;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UrbanLadder {
	public WebDriver driver;
	//constructor
	public UrbanLadder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Boookshleves locator
	@FindBy(xpath = "//a[@href='/bookshelf?src=explore_categories']//*[name()='svg']")
	WebElement Bookshelves;

	// Action methods for clicking on bookshelves
	public void Book() {
		Bookshelves.click();
	}

	// popUp locator
	@FindBy(xpath = "//a[contains(text(),'Close')]")
	WebElement pop;

	// Action methods for clicking on bookshelves
	public void Pop() {
		pop.click();
	}

	// Storage Dropdown type locator
	@FindBy(xpath = "//li[@data-group='storage type']")
	WebElement drop;

	// Action Methods for storage Dropdown
	public void Dropdown() {
		drop.click();
	}

	// Open type locator
	@FindBy(xpath = "//input[@id='filters_storage_type_Open']")
	WebElement open;

	// Action methods for Open Type
	public void Open() {
		open.click();
	}
	
	//Exclude_Out_of_stock locator
	@FindBy(xpath="//div[@class='option']//input[@id='filters_availability_In_Stock_Only']") WebElement exclude;
	
	//Action methods for excluding out of stock
	public void Exclude() {
		exclude.click();
	}
	// Display the name & price of first 3 Bookshelves below Rs. 15000, with Storage
	@FindBy(xpath="//li[contains(@class, 'product')]") List<WebElement> shelves;
	@FindBy(xpath=".//div[contains(@class, 'product-title')]//span") List<WebElement> title;
	@FindBy(xpath=".//div[contains(@class, 'price-number')]//span") List<WebElement> price;
	
	//Action method for displaying names
	public void Display() {
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

		
	}
	
	public void TakeScreenshot(String photo) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\2317747\\eclipse-workspace\\Hackathon\\Screenshot\\"+photo+".png");
		FileUtils.copyFile(sc, target);
	}
}
