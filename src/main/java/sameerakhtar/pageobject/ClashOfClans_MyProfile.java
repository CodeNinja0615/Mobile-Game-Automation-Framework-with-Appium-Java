package sameerakhtar.pageobject;

import java.awt.Point;

import org.openqa.selenium.Keys;

import io.appium.java_client.android.AndroidDriver;
import sameerakhtar.AbstractComponents.AbstractComponent;

public class ClashOfClans_MyProfile extends AbstractComponent{
	AndroidDriver driver;
	public ClashOfClans_MyProfile(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean verifyProfile() throws Exception {
		return VerifyScreenPattern("COC_MyProfile", 30);
	}

	public boolean gotoSocialSection() throws Exception {
		Point social = VerifyScreenPatternAndGetCoordinates("COC_SocialSection", 30);
		clickOnScreenWithCoordinates(social.x, social.y);
		return VerifyScreenPattern("COC_Social", 30);
	}
	
	public boolean searchPlayers() throws Exception {
		Point searchPlayers = VerifyScreenPatternAndGetCoordinates("COC_SearchPlayers", 30);
		clickOnScreenWithCoordinates(searchPlayers.x, searchPlayers.y);
		Point searchPlayerID = VerifyScreenPatternAndGetCoordinates("COC_SearchPlayerID", 30);
		clickOnScreenWithCoordinates(searchPlayerID.x, searchPlayerID.y);
		sendKeyboardInput("Y2QCPVGC8", Keys.ENTER);
		return VerifyScreenPattern("COC_SearchedProfle", 30);
	}
	
	public void quitGame(String packageName) {
		quitGameWithPackageName(packageName);
	}
}
