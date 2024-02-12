package matthewhess;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

import matthewhess.TestUtils.AndroidBaseTest;

public class AppiumDemo extends AndroidBaseTest {

	@Test
	void AppiumTest() {
//		WebElement accessibilityButton = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
//		accessibilityButton.click();
	
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath(" (//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Matt's Wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		System.out.println("Test Ran");
		
	}
}
