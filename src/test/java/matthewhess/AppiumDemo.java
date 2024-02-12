package matthewhess;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumDemo {

	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {

		UiAutomator2Options options = new UiAutomator2Options();

		// Emulator
		options.setDeviceName("Pixel_3a_API_34_extension_level_7_arm64-v8a");
		options.setApp("/Users/matthewhess/Dev/eclipse-workspace/Appium/src/test/java/Resources/ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		driver.quit();
	}
}
