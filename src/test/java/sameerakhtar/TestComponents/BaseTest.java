package sameerakhtar.TestComponents;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import sameerakhtar.pageobject.LauchHillClimbRacing;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public LauchHillClimbRacing launchGame;

	public void configureAppium(String deviceName, boolean setNoReset)
			throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//HP//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setPlatformName("Android");
//		options.setApp("C:/Users/HP/Downloads/General-Store.apk");
//		adb shell dumpsys window | findstr "mCurrentFocus"
//		options.setAppPackage("com.instagram.barcelona");
//		options.setAppActivity("com.instagram.barcelona.mainactivity.BarcelonaActivity");
		options.setNoReset(setNoReset); // ----- set true else app will be reset on start
//		options.setAppWaitForLaunch(true);
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.unlockDevice();
	}

	@BeforeMethod
	public void setup() throws MalformedURLException, URISyntaxException {
		configureAppium("ZA222JVBYL", true);
		launchGame = new LauchHillClimbRacing(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.terminateApp("com.fingersoft.hillclimb");
		driver.quit();
		service.stop();
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {// ----Goes to extent report
		// in Listeners
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File filePath = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(src, filePath);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
}
