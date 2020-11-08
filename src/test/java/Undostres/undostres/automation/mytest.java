package Undostres.undostres.automation;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.page.home.LoginForm;
import com.page.home.RechargaCellular;
import com.page.home.SuccessPage;
import com.page.payment.CardPayment;

public class mytest {
	private RechargaCellular rechargaCellular;
	private CardPayment cardPayment;
	private LoginForm loginModal;
	private SuccessPage successPage;
	private static final String PAGE_URL = "http://prueba.undostres.com.mx";
	private static final String TELCEL_OPERATOR = "Telcel";
	private static final String MOBILE_NUMBER = "5523261151";
	private static final String RECHARGE_VALUE = "$10 (Recarga Saldo)";
	private static final String CARD_NAME = "Test";
	private static final String CARD_NUMBER = "4111111111111111";
	private static final String CARD_MONTH = "11";
	private static final String CARD_YEAR = "2025";
	private static final String CARD_CVV = "111";
	private static final String CARD_EMAIL = "test@test.com";
	private static final String USERNAME = "automationexcersise@test.com";
	private static final String PASSWORD = "123456";
	private static final String SUCCESS_SUMMARY_MESSAGE = "Recarga Saldo de Telcel al número 5523261151";
	private static final String RECHARGE_AMOUNT = "$10";
	private static final String SUCCESS_MESSAGE = "¡Exitosa!";

	@BeforeTest
	@Parameters({ "browser" })
	public void suitSetUp(String browser) {
		// Initalize browser.
		rechargaCellular.initalizeBrowser(browser);
		rechargaCellular = new RechargaCellular();
		// Launch url.
		rechargaCellular.getUrl(PAGE_URL);
	}

	@Test
	public void testq() {
		// Verify if home page is displayed.
		Assert.assertTrue(rechargaCellular.confirm(), "Home page is not displayed.");

		// Click recharge cellular operator.
		rechargaCellular.clickOperator();

		// Select operator from dropdown.
		rechargaCellular.selectOperator(TELCEL_OPERATOR);

		// Type phone number.
		rechargaCellular.typeMobileNumber(MOBILE_NUMBER);

		// Select recharge.
		rechargaCellular.selectRecharge();

		// Select recharge amount.
		rechargaCellular.selectRechargeValue(RECHARGE_VALUE);

		// Click next button.
		rechargaCellular.clickNext();
		cardPayment = new CardPayment();

		// Verify card payment page is displayed.
		Assert.assertTrue(cardPayment.confirm(), "Card payment page is not displayed");

		// Verify if summary header is displayed
		Assert.assertTrue(cardPayment.isSummaryHeaderDisplayed(), "Summary header is not displayed");

		// Enter all card details.
		cardPayment.typeCardName(CARD_NAME);
		cardPayment.typeCardNumber(CARD_NUMBER);
		cardPayment.typeExpiryMonth(CARD_MONTH);
		cardPayment.typeExpiryYear(CARD_YEAR);
		cardPayment.typeCvv(CARD_CVV);
		Assert.assertTrue(cardPayment.isSaveCardSelected(), "Save card is not selected.");
		cardPayment.typeEmail(CARD_EMAIL);

		// Click payment button.
		cardPayment.clickPaymentButton();
		loginModal = new LoginForm();

		// Enter username.
		loginModal.enterUsername(USERNAME);

		// Enter password.
		loginModal.enterPassword(PASSWORD);

		// Select captcha checkbox.
		loginModal.selectCaptchaCheckbox();

		// Click login button.
		loginModal.clickLoginButton();
		successPage = new SuccessPage();

		// Verify success page is displayed.
		Assert.assertTrue(successPage.confirm(), "Success page is not displayed");

		// Verify success message details.
		Assert.assertEquals(successPage.getRechargeSummaryMessage(), SUCCESS_SUMMARY_MESSAGE);
		Assert.assertEquals(successPage.getRechargeAmount(), RECHARGE_AMOUNT);
		Assert.assertEquals(successPage.getSuccessMessage(), SUCCESS_MESSAGE);
	}

	@AfterTest
	public void tearDown() {
		// Quit browser.
		successPage.quitBrowser();
	}
}
