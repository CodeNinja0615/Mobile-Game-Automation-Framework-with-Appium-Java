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
		clickOnScreenIcon("COC_SocialSection", 20);
		return VerifyScreenPattern("COC_Social", 30);
	}
	
	public boolean searchPlayers() throws Exception {
		clickOnScreenIcon("COC_SearchPlayers", 20);
		clickOnScreenIcon("COC_SearchPlayerID", 20);
		sendKeyboardInput("Y2QCPVGC8", Keys.ENTER);
//		return verifyOnScreenText("Y2QCPVGC8", 376, 214, 117, 22, 30);
		return VerifyScreenPattern("COC_SearchedProfle", 30);
	}
	
	public boolean cutProfileWindow() throws Exception {
		clickOnScreenIcon("COC_Cross", 20);
		return VerifyScreenPattern("COC_GamePlay", 30);
	}
	
	public void quitGame(String packageName) {
		quitGameWithPackageName(packageName);
	}
}
