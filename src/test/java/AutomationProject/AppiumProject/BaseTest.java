package AutomationProject.AppiumProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.google.common.collect.ImmutableMap;

import AutomationProject.AppiumProject.pageObjects.android.FormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService services;
	public AndroidDriver driver;
	public FormPage formPage;

	@BeforeClass(alwaysRun=true)
	public void Configure() throws URISyntaxException, IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\AutomationProject\\AppiumProject\\resources\\data.properties");
		prop.load(file);
		String ipAdress = prop.getProperty("ipAdress");
		String port = prop.getProperty("port");
		String AndroidDeviceName = prop.getProperty("AndroidDeviceName");
		services = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\UUR~1\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAdress).usingPort(Integer.parseInt(port)).build();
		services.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(AndroidDeviceName);
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\Store.apk");

		driver = new AndroidDriver(services.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
	}

	public void LongPressAction(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));

	}

	public void Scroll(String searchedText) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + searchedText + "\"));"));
	}
	
	public String GetScreenShotPath(String testCaseName,AndroidDriver driver) throws IOException {
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		File destination = new File(destinationFile);
		FileUtils.copyFile(source, destination);
		return destinationFile;
		
	}

	@AfterClass(alwaysRun=true)
	public void Close() {

		driver.quit();
		services.stop();
	}
}
