package sameerakhtar.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sameerakhtar.TestComponents.BaseTest;
import sameerakhtar.pageobject.GamePlay;
import sameerakhtar.pageobject.MainMenu;

public class HillClimbRacingTest extends BaseTest {
 
	@Test
	public void HillClimbRacing_LauchGameplay() throws Exception {
		MainMenu mainMenu = launchGame.launchGame();
		Boolean verifyMainMenu = mainMenu.verifyManiMenu();
		Assert.assertTrue(verifyMainMenu);
		Boolean verifySettings = mainMenu.naviagteToGameSettings();
		Assert.assertTrue(verifySettings);
		Boolean verifyMainMenuAgain = mainMenu.gotoMainMenu();
		Assert.assertTrue(verifyMainMenuAgain);
		
		GamePlay gamePlay = mainMenu.navigateToGamePLay();
		Boolean verifyGamePlay = gamePlay.verifyGamePlay();
		Assert.assertTrue(verifyGamePlay);
		Boolean gamePlayPaused = gamePlay.pauseGamePlay();
		Assert.assertTrue(gamePlayPaused);
		Boolean verifyGamePlayQuit = gamePlay.quitGamePlay();
		Assert.assertTrue(verifyGamePlayQuit);
	}
}
