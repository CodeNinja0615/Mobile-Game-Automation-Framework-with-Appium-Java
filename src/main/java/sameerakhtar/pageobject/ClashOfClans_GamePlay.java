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
	
	public boolean GamePlay() throws Exception {
		return VerifyScreenPattern("COC_GamePlay", 30);
	}
	
	public ClashOfClans_MyProfile gotoProfile() throws Exception {
		Point profile = VerifyScreenPatternAndGetCoordinates("COC_ProfileIcon", 25);
		clickOnScreenWithCoordinates(profile.x, profile.y);
		return new ClashOfClans_MyProfile(driver);
	}
	
}
