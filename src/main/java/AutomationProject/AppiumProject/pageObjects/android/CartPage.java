package AutomationProject.AppiumProject.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {

	
	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	@AndroidFindBy(id = "android:id/button1")
	private WebElement termsCheckboxButton;
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement termsCheck;
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement GoPaymentButton;
	
	public void Verification(String name) {
		String product = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\""+name+"\"]"))
				.getText();
		Assert.assertEquals(product, name);
	}
	
	public WebElement termsButton() {
		WebElement element = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		return element;
	}
	public void CheckTermsButton() {
		termsCheckboxButton.click();
		termsCheck.click();
	}
	public void GoToPaymentPageButton() {
		GoPaymentButton.click();
	}
	

}
