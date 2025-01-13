package sameerakhtar.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import sameerakhtar.TestComponents.BaseTest;
import sameerakhtar.data.DataReader;

public class StandAloneTest extends BaseTest{
	@Test(enabled=false)
	public void appiumTest() throws MalformedURLException, URISyntaxException {
		driver.activateApp("com.instagram.barcelona");
		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"barcelona_tab_profile\"]/android.view.View[2]")).click();
		driver.terminateApp("com.instagram.barcelona");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = DataReader.getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//sameerakhtar//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } }; //--Set of parameters
	}
}
