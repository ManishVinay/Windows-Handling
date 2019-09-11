package org.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {
public static void main(String[] args) throws AWTException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\eclipse\\Manish\\WindowsHandling\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.snapdeal.com");
	WebElement search = driver.findElement(By.xpath("(//input[@name='keyword'])[1]"));
search.sendKeys("iphone 7");
Robot r=new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
WebElement iPhone = driver.findElement(By.xpath("(//p[@class='product-title '])[1]"));
iPhone.click();
String pWid = driver.getWindowHandle();
System.out.println(pWid);
Set<String> allWid = driver.getWindowHandles();
System.out.println(allWid);
for (String eachWid : allWid) {
	if (!pWid.equals(eachWid)) {
		driver.switchTo().window(eachWid);
	}
}

WebElement cart = driver.findElement(By.xpath("//div[@class='mmm col-xs-6 btn btn-xl btn-theme-secondary rippleWhite buyLink']"));

cart.click();

WebElement print = driver.findElement(By.xpath("//div[@class='you-pay']"));

String text = print.getText();
System.out.println(text);

driver.switchTo().window(pWid);
driver.close();





}
}
