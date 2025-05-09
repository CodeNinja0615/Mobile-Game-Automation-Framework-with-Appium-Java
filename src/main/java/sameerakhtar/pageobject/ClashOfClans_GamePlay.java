package sameerakhtar.pageobject;

import java.awt.Point;

import io.appium.java_client.android.AndroidDriver;
import sameerakhtar.utils.AbstractComponent;

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
		zoomInAreaWithCoordinates(500, 200, 300, 200, 1.0);
		swipeInDirectionInAreaWithCoordinates(500, 200, 300, 200, "left", 0.50);
		zoomOutAreaWithCoordinates(500, 200, 300, 200, 0.50);
		clickOnScreenIcon("COC_ProfileIcon", 20);
		return new ClashOfClans_MyProfile(driver);
	}
	
	public ClashOfClans_Settings gotoSettings() throws Exception {
		clickOnScreenIcon("COC_Settings", 20);
		return new ClashOfClans_Settings(driver);
	}
	
}
