package com.page.home;

import org.openqa.selenium.By;

import com.page.AbstractPage;

/**
 * POM for login form
 * 
 * @author Aafreen Khan
 */
public class LoginForm extends AbstractPage {

	private By usernameLocator = By.xpath("//*[@id='usrname']");
	private By passwordLocator = By.xpath("//*[@id='psw']");
	private By captchaCheckboxLocator = By.xpath("//*[@id='recaptcha-anchor-label']");
	private By loginButtonLocator = By.id("loginBtn");
	private By checkMarkLocator = By.xpath("//*[@class='recaptcha-checkbox-checkmark']");

	@Override
	public boolean confirm() {
		waitForPageLoad();
		return isDisplayed(usernameLocator);
	}

	@Override
	public void waitForPageLoad() {
		fluentwaitForPresenceOfElementLocated(usernameLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
	}

	/**
	 * Enter email
	 * 
	 * @param email
	 */
	public void enterUsername(String email) {
	//	waitForElement(10, usernameLocator);
		jsClick(findElement(usernameLocator));
		type(usernameLocator, email);
	}

	/**
	 * Enter password
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		jsClick(findElement(passwordLocator));
		type(passwordLocator, password);
	}

	/**
	 * Select captcha checkbox.
	 * 
	 */
	public void selectCaptchaCheckbox() {
		driver.switchTo().frame(0);
		jsClick(findElement(captchaCheckboxLocator));
		fluentwaitForPresenceOfElementLocated(checkMarkLocator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
		driver.switchTo().parentFrame();
	}

	/**
	 * Click login button
	 * 
	 */
	public void clickLoginButton() {
		click(loginButtonLocator);
	}
}
