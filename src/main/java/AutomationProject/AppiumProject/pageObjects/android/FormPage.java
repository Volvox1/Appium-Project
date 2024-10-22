package AutomationProject.AppiumProject.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
	private WebElement nameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
	private WebElement femaleOption;
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")
	private WebElement maleOption;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
	private WebElement shopButton;

	public void CountryField() {
		countryField.click();
	}

	public void SelectCountry(String countryName) {
		driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"" + countryName + "\"]"))
				.click();
	}

	public void SetName(String name) {
		nameField.sendKeys(name);
	}

	public void SelectGender(String gender) {
		if (gender == "female")
			femaleOption.click();
		else
			maleOption.click();

	}

	public ProductPage ShopButton() {
		shopButton.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;
	}

}
