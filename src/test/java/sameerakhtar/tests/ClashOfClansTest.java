package sameerakhtar.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sameerakhtar.TestComponents.BaseTest;
import sameerakhtar.pageobject.ClashOfClans_GamePlay;
import sameerakhtar.pageobject.ClashOfClans_MyProfile;

public class ClashOfClansTest extends BaseTest{

	@Test
	public void ClashOfClans_LauchGameplay() throws Exception {
		ClashOfClans_GamePlay gamePlay = launchGameWithPackageName.launchClashOfClans("com.supercell.clashofclans");
		Boolean verifyGamePlay = gamePlay.GamePlay();
		Assert.assertTrue(verifyGamePlay);
		ClashOfClans_MyProfile myProfile = gamePlay.gotoProfile();
		Boolean verifyMyProfile = myProfile.verifyProfile();
		Assert.assertTrue(verifyMyProfile);
		Boolean verifySocial = myProfile.gotoSocialSection();
		Assert.assertTrue(verifySocial);
		Boolean verifySarchedProfile = myProfile.searchPlayers();
		Assert.assertTrue(verifySarchedProfile);
		myProfile.quitGame("com.supercell.clashofclans");
	}
}
