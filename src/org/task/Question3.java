package org.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {
	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\eclipse\\Manish\\WindowsHandling\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.homedepot.com/c/Appliance_Savings");
	WebElement search = driver.findElement(By.xpath("//input[@class='SearchBox__input']"));
	search.sendKeys("ceiling fan");
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	WebElement fan = driver.findElement(By.xpath("(//a[@data-request-type='sr'])[1]"));
	fan.click();
	WebElement cart = driver.findElement(By.xpath("(//span[@class='bttn__content'])[5]"));
	cart.click();
	String pWid = driver.getWindowHandle();
	Set<String> allWid = driver.getWindowHandles();
	for (String wid : allWid) {
		if (!pWid.equals(wid)){
			driver.switchTo().window(wid);
		}
	}
	WebElement gng = driver.findElement(By.xpath("//div[@data-automation-id='cartTotalPrice']"));
	String text = gng.getText();
	System.out.println(text);
	
	
	
	
	}

}
