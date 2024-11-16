package sameerakhtar.AbstractComponents;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.android.AndroidDriver;

public class AbstractComponent {
	// ANSI escape code constants
	public static final String RESET = "\u001B[0m"; // Resets to default color
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	AndroidDriver driver;

	public AbstractComponent(AndroidDriver driver) {
		this.driver = driver;
	}

	public Point VerifyScreenPatternAndGetCoordinates(String imageName, int timeInSeconds) throws Exception {
		long endTime = System.currentTimeMillis() + (timeInSeconds * 1000L);

		while (System.currentTimeMillis() < endTime) {
			captureScreenshot(imageName, driver);
			Point coordinates = ImageVerification.getCoordinatesOfItemOnScreen(imageName);
			if (coordinates != null) {
				return coordinates;
			}
			Thread.sleep(500);
		}
		return null;
	}

	public boolean VerifyScreenPattern(String imageName, int timeInSeconds) throws Exception {
		long endTime = System.currentTimeMillis() + (timeInSeconds * 1000L);

		while (System.currentTimeMillis() < endTime) {
			captureScreenshot(imageName, driver);
			boolean status = ImageVerification.verifyItemOnScreen(imageName);
			if (status) {
				return true;
			}
			Thread.sleep(500);
		}
		return false;
	}

	public String captureScreenshot(String imageName, WebDriver driver) throws IOException {
		// in Listeners
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File filePath = new File(System.getProperty("user.dir") + "/images/capturedImages/" + imageName + ".bmp");
		FileUtils.copyFile(src, filePath);
		return System.getProperty("user.dir") + "//reports//" + imageName + ".bmp";
	}

	public void clickOnScreenWithCoordinates(int x, int y) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(tap));

		System.out.println(GREEN + "Clicked at x:" + x + ", y:" + y + RESET);
	}
}
