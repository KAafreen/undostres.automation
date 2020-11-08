package com.page.home;

import org.openqa.selenium.By;

import com.page.AbstractPage;

/**
 * POM for success page
 * 
 * @author Aafreen Khan
 */
public class SuccessPage extends AbstractPage {
	private By successMessageLocator = By.xpath("//*[@class='recharge-status success-msg']");
	private By rechargeSummaryMessageLocator = By.xpath("//*[@class='recharge-summary']");
	private By rechargeAmountLocaotor = By.xpath("//*[@class='recharge-amount']");
	private By loaderMessageLocator = By
			.xpath("//*[contains(text(),'No cierres tu navegador ni regreses a la página anterior')]");

	@Override
	public boolean confirm() {
		waitForPageLoad();
		return isSuccessMessageDisplayed();
	}

	@Override
	public void waitForPageLoad() {
		explicitWaitForInvisibilityElement(loaderMessageLocator, 30);
	}

	/**
	 * Verify if success message is displayed.
	 * 
	 */
	public boolean isSuccessMessageDisplayed() {
		return isDisplayed(successMessageLocator);
	}

	/**
	 * Get success message.
	 * 
	 */
	public String getSuccessMessage() {
		return getText(successMessageLocator);
	}

	/**
	 * Get recharge amount.
	 * 
	 */
	public String getRechargeAmount() {
		return getText(rechargeAmountLocaotor);
	}

	/**
	 * Get recharge success message.
	 * 
	 */
	public String getRechargeSummaryMessage() {
		return getText(rechargeSummaryMessageLocator);
	}
}
