package AutomationProject.AppiumProject;

import org.testng.annotations.Test;



import AutomationProject.AppiumProject.pageObjects.android.CartPage;

import AutomationProject.AppiumProject.pageObjects.android.ProductPage;

public class AppiumTest extends BaseTest {

	@Test(groups = { "Smoke" })
	public void AppiumTest() throws InterruptedException {

		formPage.CountryField();
		Scroll("Armenia");
		formPage.SelectCountry("Armenia");

		formPage.SetName("Ayşe");
		formPage.SelectGender("female");
		ProductPage productPage = formPage.ShopButton();

		Scroll("Converse All Star");
		productPage.SelectProduct("Converse All Star");
		Scroll("Jordan 6 Rings");
		productPage.SelectProduct("Jordan 6 Rings");
		CartPage cartPage = productPage.GoToCart();

		cartPage.Verification("Converse All Star");
		cartPage.Verification("Jordan 6 Rings");

		LongPressAction(cartPage.termsButton());
		cartPage.CheckTermsButton();

		cartPage.GoToPaymentPageButton();

	}
}
