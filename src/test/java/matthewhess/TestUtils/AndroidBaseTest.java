package matthewhess.TestUtils;

import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import matthewhess.utils.AppiumUtils;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass(alwaysRun = true)
	public void ConfigureAppiumFuture() throws IOException {
		// Load Config Properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//matthewhess//resources//data.properties");

		// Get IpAddress
		String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress")
				: prop.getProperty("ipAddress");

		// Load properties
		prop.load(fis);

		// String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		// Start Appium Server with properties
		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		// Prepare driver options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName")); // emulator
		// options.setDeviceName("Android Device");// real device
		options.setApp(
				System.getProperty("user.dir") + "//src//test//java//matthewhess//resources//ApiDemos-debug.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

//	@BeforeClass(alwaysRun = true)
//	public void ConfigureAppium() throws IOException, URISyntaxException {
//		UiAutomator2Options options = new UiAutomator2Options();
//
//		// Emulator
//		options.setDeviceName("Pixel_3a_API_34_extension_level_7_arm64-v8a");
//		options.setApp("/Users/matthewhess/Dev/eclipse-workspace/Appium/src/test/java/matthewhess/resources/ApiDemos-debug.apk");
//		
//		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
//		driver.quit();
//	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (this.driver != null) {
			driver.quit();
		}

		if (this.service != null) {
			service.stop();
		}
	}

}
