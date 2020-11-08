package com.page.payment;

import org.openqa.selenium.By;

import com.page.AbstractPage;

/**
 * POM for card payment
 * 
 * @author Aafreen Khan
 */
public class CardPayment extends AbstractPage {

	private By summaryHeaderMessageLocator = By.xpath("//*[@class='summary-message messageShowTop']");
	private By cardNameLocator = By.xpath("//*[@class='field form-group']//*[@name='cardname']");
	private By cardNumberLocator = By.id("cardnumberunique");
	private By expirMonthLocator = By.xpath("//*[@class='form-group']//*[@class='form-control expmonth']");
	private By expirYearLocator = By.xpath("//*[@class='form-group']//*[@class='form-control expyear']");
	private By cvvNoLocator = By.xpath("//*[@class='field form-group']//*[@name='cvvno']");
	private By saveCardLocator = By.id("card_save_checkbox");
	private By enterEmailLocator = By.xpath("//*[@name='txtEmail' and @class='form-control email']");
	private By paymentButtonLocator = By.id("paylimit");
	private By spinLoader = By.xpath("//*[@class='spinLoader']");

	@Override
	public boolean confirm() {
		waitForPageLoad();
		return isSummaryHeaderDisplayed();
	}

	@Override
	public void waitForPageLoad() {
		implicitWait(1000);
		explicitWaitForInvisibilityElement(spinLoader, DEFAULT_TIMEOUT);
	}

	/**
	 * Verify if summary header is displayed
	 * 
	 */
	public boolean isSummaryHeaderDisplayed() {
		return isDisplayed(summaryHeaderMessageLocator);
	}

	/**
	 * Enter card name
	 * 
	 * @param cardName
	 */
	public void typeCardName(String cardName) {
		type(cardNameLocator, cardName);
	}

	/**
	 * Enter card number
	 * 
	 * @param cardNumber
	 */
	public void typeCardNumber(String cardNumber) {
		type(cardNumberLocator, cardNumber);
	}

	/**
	 * Enter month
	 * 
	 * @param month
	 */
	public void typeExpiryMonth(String month) {
		type(expirMonthLocator, month);
	}

	/**
	 * Enter year
	 * 
	 * @param year
	 */
	public void typeExpiryYear(String year) {
		type(expirYearLocator, year);
	}

	/**
	 * Enter cvv
	 * 
	 * @param cvv
	 */
	public void typeCvv(String cvv) {
		type(cvvNoLocator, cvv);
	}

	/**
	 * Verify if save card is selected
	 * 
	 */
	public boolean isSaveCardSelected() {
		return isSelected(saveCardLocator);
	}

	/**
	 * Enter email
	 * 
	 * @param email
	 */
	public void typeEmail(String email) {
		type(enterEmailLocator, email);
	}

	/**
	 * Click payment button
	 * 
	 */
	public void clickPaymentButton() {
		click(paymentButtonLocator);
	}
}
