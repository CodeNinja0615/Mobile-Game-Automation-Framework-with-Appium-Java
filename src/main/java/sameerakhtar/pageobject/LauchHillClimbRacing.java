package sameerakhtar.pageobject;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import sameerakhtar.AbstractComponents.AbstractComponent;

public class LauchHillClimbRacing extends AbstractComponent {

	AndroidDriver driver;
	public LauchHillClimbRacing(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public MainMenu launchGame() {
		driver.activateApp("com.fingersoft.hillclimb");
		return new MainMenu(driver);
	}
	
}
