package sameerakhtar.AbstractComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class AbstractComponent {

	AndroidDriver driver;
	public AbstractComponent(AndroidDriver driver) {
		this.driver = driver;
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
}
