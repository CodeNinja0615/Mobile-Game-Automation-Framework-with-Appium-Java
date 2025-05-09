package sameerakhtar.pageobject;

import java.awt.Point;
import java.util.Random;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import sameerakhtar.utils.AbstractComponent;

public class HillClimbRacing_GamePlay extends AbstractComponent {

	AndroidDriver driver;

	public HillClimbRacing_GamePlay(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyGamePlay() throws Exception {
		return VerifyScreenPattern("HCR_GamePlay", 25);
	}

	public void playTheGame(int timeInSeconds) throws Exception {
		long endTime = System.currentTimeMillis() + (timeInSeconds * 1000L);
		Random random = new Random();
		while (System.currentTimeMillis() < endTime) {
			boolean isGas = random.nextBoolean();
			if (isGas) {
				Point gasPedal = VerifyScreenPatternAndGetCoordinates("HCR_Gas", 10);
				clickAndHoldOnScreenWithCoordinates(gasPedal.x, gasPedal.y, random.nextInt(3) + 3); // Random hold between 3-5 seconds
				System.out.println("Clicked Gas pedal");
			} else {
				Point brakePedal = VerifyScreenPatternAndGetCoordinates("HCR_Brake", 10);
				clickAndHoldOnScreenWithCoordinates(brakePedal.x, brakePedal.y, random.nextInt(3) + 3); // Random hold between 3-5 seconds
				System.out.println("Clicked Brake pedal");
			}

		}
		// Random pause between actions
		Thread.sleep(random.nextInt(2000) + 1000); // Pause between 1-3 seconds
	}

	public boolean pauseGamePlay() throws Exception {
		clickOnScreenIcon("HCR_PauseBtn", 20);
		return VerifyScreenPattern("HCR_GamePlayPaused", 25);
	}

	public boolean quitGamePlay() throws Exception {
		clickOnScreenIcon("HCR_ExitBtn", 20);
		clickOnScreenIcon("HCR_ExitOKBtn", 20);
		return VerifyScreenPattern("HCR_MainMenu", 35);
	}

	public void quitGame(String packageName) {
		quitGameWithPackageName(packageName);
	}
}