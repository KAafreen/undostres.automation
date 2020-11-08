package com.page.home;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.page.AbstractPage;

/**
 * POM for recharge cellular
 * 
 * @author Aafreen Khan
 */
public class RechargaCellular extends AbstractPage {
	private By rechargaCellularIconLocator = By.xpath("//*[contains(@src,'newLook_recarga.png')]");
	private By operatorLocator = By.xpath("//*[@suggest='mobile-operator' and @name='operator']");
	private By operatorListLocator = By.xpath("//*[@class='suggestion']//li");
	private By cellPhoneNumberLocator = By.xpath("//*[@name='mobile' and @oninput='checkMob(this)']");
	private By rechargeAmountLocator = By.xpath("//*[@name='amount' and @suggest='mobile-operator_amount']");
	private By nextButtonLocator = By
			.xpath("//*[contains(text(),'Recarga Celular')]//following::button[@class='button buttonRecharge'][1]");
	private By rechargeCategoryList = By.xpath("//*[@class='category-list  cat1']//li");

	@Override
	public boolean confirm() {
		waitForPageLoad();
		return isRechargeCellularIconDisplayed();
	}

	@Override
	public void waitForPageLoad() {
		fluentwaitForElementClickable(rechargaCellularIconLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
	}

	/**
	 * Verify if recharge cellular icon is displayed.
	 * 
	 */
	public boolean isRechargeCellularIconDisplayed() {
		return isDisplayed(rechargaCellularIconLocator);
	}

	/**
	 * Click recharge cellular.
	 * 
	 */
	public void clickRechargeCellular() {
		click(rechargaCellularIconLocator);
	}

	/**
	 * Click operator field.
	 * 
	 */
	public void clickOperator() {
		click(operatorLocator);
	}

	/**
	 * Select operator from list.
	 * 
	 */
	public void selectOperator(String operatorValue) {
		List<WebElement> operators = new ArrayList();
		operators = findElements(operatorListLocator);
		for (WebElement li : operators) {
			if (li.getAttribute("data-show").equalsIgnoreCase(operatorValue)) {
				li.click();
				break;
			}
		}
	}

	/**
	 * Type mobile number.
	 * 
	 * @param number
	 */
	public void typeMobileNumber(String number) {
		type(cellPhoneNumberLocator, number);
	}

	/**
	 * Select to recharge amount.
	 * 
	 */
	public void selectRecharge() {
		click(rechargeAmountLocator);
	}

	/**
	 * Select recharge amount value.
	 * 
	 * @param rechargeValue
	 */
	public void selectRechargeValue(String rechargeValue) {
		List<WebElement> operators = new ArrayList();
		operators = findElements(rechargeCategoryList);
		for (WebElement li : operators) {
			if (li.getAttribute("data-show").equalsIgnoreCase(rechargeValue)) {
				li.click();
				break;
			}
		}
	}

	/**
	 * Click next button.
	 * 
	 */
	public void clickNext() {
		click(nextButtonLocator);
	}
}
