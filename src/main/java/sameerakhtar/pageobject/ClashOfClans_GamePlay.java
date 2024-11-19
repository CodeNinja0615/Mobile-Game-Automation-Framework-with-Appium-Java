package sameerakhtar.pageobject;

import java.awt.Point;

import io.appium.java_client.android.AndroidDriver;
import sameerakhtar.AbstractComponents.AbstractComponent;

public class ClashOfClans_GamePlay extends AbstractComponent{
	AndroidDriver driver;
	public ClashOfClans_GamePlay(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean gamePlay() throws Exception {
		return VerifyScreenPattern("COC_GamePlay", 30);
	}
	
	public ClashOfClans_MyProfile gotoProfile() throws Exception {
		Point profile = VerifyScreenPatternAndGetCoordinates("COC_ProfileIcon", 25);
		clickOnScreenWithCoordinates(profile.x, profile.y);
		return new ClashOfClans_MyProfile(driver);
	}
	
	public ClashOfClans_Settings gotoSettings() throws Exception {
		Point settings = VerifyScreenPatternAndGetCoordinates("COC_Settings", 25);
		clickOnScreenWithCoordinates(settings.x, settings.y);
		return new ClashOfClans_Settings(driver);
	}
	
}
