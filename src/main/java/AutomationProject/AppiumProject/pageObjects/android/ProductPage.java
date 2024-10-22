package AutomationProject.AppiumProject.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {

	AndroidDriver driver;

	public ProductPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> productsName;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addCartButton;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;

	public void SelectProduct(String name) {

		int productCount = productsName.size();

		for (int i = 0; i < productCount; i++) {
			String productName = productsName.get(i).getText();
			if (productName.equalsIgnoreCase(name)) {
				addCartButton.get(i).click();
			}
		}
	}

	public CartPage GoToCart() {
		cartButton.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
}
