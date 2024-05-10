package Hackathon_Project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
	WebDriver driver;
	UrbanLadder ul;
	CollectionsType ct;
	@BeforeClass
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
	}
	
	@Test(priority=1)
	void bookshelf() throws InterruptedException, IOException {
		ul=new UrbanLadder(driver);
		Thread.sleep(2000);
		ul.Book();
		ul.TakeScreenshot("Bookshelf");
	}
	@Test(priority=2)
	void PopUp() throws InterruptedException, IOException {
		Thread.sleep(3000);
		ul.Pop();
		ul.TakeScreenshot("PopUp");
	}
	@Test(priority=3)
	void storageDropown() throws InterruptedException, IOException {
		Thread.sleep(2000);
		ul.Dropdown();
		ul.TakeScreenshot("storageDropown");
	}
	@Test(priority=4)
	void OpenType() throws InterruptedException, IOException {
		Thread.sleep(2000);
		ul.Open();
		ul.TakeScreenshot("OpenType");
	}
	@Test(priority=5)
	void Exclude_out_of_stock() throws InterruptedException, IOException {
		Thread.sleep(2000);
		ul.Exclude();
		ul.TakeScreenshot("Exclude_out_of_stock");
	}
	@Test(priority=6)
	void Details() throws InterruptedException, IOException {
		Thread.sleep(2000);
		ul.Display();
		ul.TakeScreenshot("Details");
	}
	
	@Test(priority=7)
	void collections() throws InterruptedException, IOException
	{
		ct=new CollectionsType(driver);
		ct.navigateToCollections();
		Thread.sleep(2000);
		ct.TakeScreenshot("collections");
	}
	
	@Test(priority=8)
	void SubMenu() throws InterruptedException, IOException {
		ct.subMenu();
		Thread.sleep(3000);
		ct.TakeScreenshot("SubMenu");
	}
	
	@Test(priority=9)
	void giftcards() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		ct.giftCard();
		Thread.sleep(3000);
		ct.TakeScreenshot("giftcards");
	}
	
	@Test(priority=10)
	void birthAnniversary() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		ct.birthday();
		Thread.sleep(3000);
		ct.TakeScreenshot("birthAnniversary");
	}
	
	@Test(priority=11)
	void amountButton() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		ct.selectAmount();
		ct.TakeScreenshot("amountButton");
	}
	
	@Test(priority=12)
	void selectedDate() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		ct.selectDate();
		ct.TakeScreenshot("selectedDate");
	}
	@Test(priority=13)
	void clickNext() throws InterruptedException, IOException {
		Thread.sleep(4000);
		ct.nextButton();
		ct.TakeScreenshot("clickNext");
		
	}
	
	@Test(priority=14)
	void form() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		ct.fillForm();
		ct.TakeScreenshot("form");
	}
	
	@AfterClass
	void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
