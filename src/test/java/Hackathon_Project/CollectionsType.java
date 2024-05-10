package Hackathon_Project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CollectionsType {

	public WebDriver driver;
	//constructor
	public CollectionsType(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToCollections() throws InterruptedException
	{	Thread.sleep(3000);
		driver.navigate().to("https://www.urbanladder.com/collections-new?src=breadcrumb");
	}
	
	//submenu locators
	@FindBy(xpath=".//div[@class='row no-padding']") List <WebElement> sub;
	
	//action method for submenu
	public void subMenu() throws InterruptedException {
		System.out.println("\nSub-menu items from collections:");
		Thread.sleep(2000);
		for (WebElement item : sub) {
			System.out.println(item.getText());
		}
	}
	
	//Giftcard locators
	@FindBy(xpath="//a[@class='featuredLinksBar__link'][normalize-space()='Gift Cards']") WebElement gift;
	
	//action methods for gift card
	public void giftCard()
	{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", gift);
	gift.click();

	}
	
	//birthday/anniversary locator
	@FindBy(xpath="//ul[@class='_2sedU']//li[3]//div") WebElement birth;
	
	//actionmethod for birthday
	public void birthday() throws InterruptedException
	{	Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", birth);
		birth.click();
		
	}

	//Locator for amount button
	@FindBy(xpath="//div[@class='_3jn98 _23tqD _3k9Vm']//button[2]") WebElement amount;
	
	//action method for amount
	public void selectAmount()
	{
		amount.click();
	}
	
	//locator for month and day
	@FindBy(xpath="//select[@class='Upz18 _1hLiD UJU2v'][1]") WebElement month;
	@FindBy(xpath="//select[@class='Upz18 _1hLiD UJU2v'][2]") WebElement day;
	
	//action method to select date
	public void selectDate() {
		Select selMonth=new Select(month);
		selMonth.selectByValue("5/2024");
		
		Select selDay=new Select(day);
		selDay.selectByValue("9");
	}
	
	//locator for next button
	@FindBy(xpath="//button[normalize-space()='Next']") WebElement next;
	
	//action method for next button
	public void nextButton() {
		next.click();
	}
	
	//locators for form fields
	@FindBy(xpath="//input[@id='ip_4036288348']") WebElement toName;
	@FindBy(xpath="//input[@id='ip_137656023']") WebElement toEmail;
	@FindBy(xpath="//input[@id='ip_3177473671']") WebElement toMobile;
	@FindBy(xpath="//input[@id='ip_1082986083']") WebElement name;
	@FindBy(xpath="//input[@id='ip_4081352456']") WebElement email;
	@FindBy(xpath="//input[@id='ip_2121573464']") WebElement mobile;
	@FindBy(xpath="//input[@id='ip_2194351474']") WebElement address;
	@FindBy(xpath="//input[@id='ip_567727260']") WebElement pincode;

	@FindBy(xpath="//textarea[@id='ip_582840596']") WebElement message;
	@FindBy(xpath="//button[@class='_3Hxyv _1fVSi action-button _1gIUf _1XfDi']") WebElement submit;
	@FindBy(xpath="//input[@id='ip_137656023']") WebElement errmsg;

	//action method for form
	public void fillForm() throws InterruptedException
	{
		toName.sendKeys("Yash");
		toEmail.sendKeys("Hoodgmail.com");
		toMobile.sendKeys("8456732145");
		name.sendKeys("Hemanth");
		email.sendKeys("hemanth@gmail.com");
		mobile.sendKeys("9834563083");
		address.sendKeys("chennai");
		pincode.sendKeys("500078");
		Thread.sleep(1000);
		message.sendKeys("Happy birthday Yash!");
		submit.click();
		String err=errmsg.getAttribute("validationMessage");
		System.out.println();
		System.out.println("Error message after entering the invalid input :" + err);
		System.out.println("==================================");
	}
	
	public void TakeScreenshot(String photo) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\2317747\\eclipse-workspace\\Hackathon\\Screenshot\\"+photo+".png");
		FileUtils.copyFile(sc, target);
	}
}
