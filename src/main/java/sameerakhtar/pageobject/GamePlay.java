package sameerakhtar.pageobject;

import java.awt.Point;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import sameerakhtar.AbstractComponents.AbstractComponent;

public class GamePlay extends AbstractComponent {

	AndroidDriver driver;
	public GamePlay(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyGamePlay() throws Exception {
		return VerifyScreenPattern("HCR_GamePlay", 25);
	}
	
	public boolean pauseGamePlay() throws Exception {
		Point startBtn = VerifyScreenPatternAndGetCoordinates("HCR_PauseBtn", 10);
		clickOnScreenWithCoordinates(startBtn.x, startBtn.y);
		return VerifyScreenPattern("HCR_GamePlayPaused", 25);
	}
	
	public boolean quitGamePlay() throws Exception {
		Point exitBtn = VerifyScreenPatternAndGetCoordinates("HCR_ExitBtn", 10);
		clickOnScreenWithCoordinates(exitBtn.x, exitBtn.y);
		Point okBtn = VerifyScreenPatternAndGetCoordinates("HCR_ExitOKBtn", 10);
		clickOnScreenWithCoordinates(okBtn.x, okBtn.y);
		return VerifyScreenPattern("HCR_MainMenu", 35);
	}
}