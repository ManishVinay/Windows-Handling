package org.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\eclipse\\Manish\\WindowsHandling\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	search.sendKeys("iphone 7");
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
WebElement iPhone = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	iPhone.click();
	String pWid = driver.getWindowHandle();
	System.out.println(pWid);
	Set<String> allWid = driver.getWindowHandles();
	System.out.println(allWid);
	for (String eachwid : allWid) {
		if (!pWid.equals(eachwid)) {
			driver.switchTo().window(eachwid);
			
		}
	}
	
	
	WebElement btn = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
	btn.click();
	
	WebElement print = driver.findElement(By.xpath("//div[@id='huc-v2-order-row-with-divider']"));
	String text = print.getText();
	System.out.println(text);
	
	
	
	
	}

}
