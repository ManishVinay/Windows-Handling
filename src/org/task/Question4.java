package org.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Question4 {
public static void main(String[] args) throws AWTException, InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\eclipse\\Manish\\WindowsHandling\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.greenstechnologys.com");
	WebElement cl = driver.findElement(By.xpath("//a[text()='CONTACT US']"));
Actions acc=new Actions(driver);
acc.contextClick(cl).perform();;
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	
	JavascriptExecutor jk=(JavascriptExecutor)driver;
	String pWid = driver.getWindowHandle();
	System.out.println(pWid);
	
	Set<String> all = driver.getWindowHandles();
	System.out.println(all);
	
	for (String each : all) {
		if (!pWid.equals(each)) {
			driver.switchTo().window(each);
		}
	}
	Thread.sleep(3000);
	
	WebElement add = driver.findElement(By.xpath("(//div[@class='address-block address-border'])[2]"));
	String text = add.getText();
	System.out.println(text);
	
	
	
	driver.close();
}
}
