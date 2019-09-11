package org.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Question5 {
public static void main(String[] args) throws AWTException, InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\eclipse\\Manish\\WindowsHandling\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
driver.get("http://www.greenstechnologys.com");
WebElement cl= driver.findElement(By.xpath("//a[text()='CONTACT US']"));
Actions acc=new Actions(driver);
acc.contextClick(cl).perform();;
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	Thread.sleep(3000);
	JavascriptExecutor 
	jk=(JavascriptExecutor)driver;
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
	
	WebElement course = driver.findElement(By.xpath("//a[@href='courses.html']"));
acc.moveToElement(course).perform();
WebElement train = driver.findElement(By.xpath("//a[@href='software-testing-course-content.html']"));
acc.moveToElement(train).perform();
WebElement sel = driver.findElement(By.xpath("//a[@href='selenium-course-content.html']"));
acc.click(sel).perform();
TakesScreenshot tk=(TakesScreenshot)driver;
File as = tk.getScreenshotAs(OutputType.FILE);
File dest=new File("F:\\Selenium Task\\namew.png");
FileUtils.copyFile(as, dest);
driver.close();












}
}