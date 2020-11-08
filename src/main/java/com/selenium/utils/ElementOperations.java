package com.selenium.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.glass.events.KeyEvent;

/**
 * Class contains all webdriver element methods like click, wait, sendkeys etc.
 * 
 * @author Aafreen Khan
 */

public class ElementOperations extends BrowserFeatures {
	private Select select;
	public static final int DEFAULT_TIMEOUT = 20000;
	public static final int DEFAULT_POLLING = 5000;

	/**
	 * Find element.
	 * 
	 * @param by
	 */
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	/**
	 * Find elements.
	 * 
	 * @param by
	 */
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	/**
	 * Click element.
	 * 
	 * @param by
	 */
	public void click(By by) {
		findElement(by).click();
	}

	/**
	 * Clear field and type in.
	 * 
	 * @param by
	 * @param type
	 */
	public void type(By by, String type) {
		findElement(by).clear();
		findElement(by).sendKeys(type);
	}

	/**
	 * Get attribute of element.
	 * 
	 * @param by
	 * @param name
	 */
	public String getAttribute(By by, String name) {
		return findElement(by).getAttribute(name);
	}

	/**
	 * Get text of element element.
	 * 
	 * @param by
	 */
	public String getText(By by) {
		return findElement(by).getText();
	}

	/**
	 * Verify if element is displayed.
	 * 
	 * @param by
	 */
	public boolean isDisplayed(By by) {
		return findElement(by).isDisplayed();
	}

	/**
	 * Verify if element is not displayed.
	 * 
	 * @param by
	 */
	public boolean isNotDisplayed(By by) {
		return !findElement(by).isDisplayed();
	}

	/**
	 * Verify if element is enabled.
	 * 
	 * @param by
	 */
	public boolean isEnabled(By by) {
		return findElement(by).isEnabled();
	}

	/**
	 * Verify if element is not enabled.
	 * 
	 * @param by
	 */
	public boolean isNotEnabled(By by) {
		return !findElement(by).isEnabled();
	}

	/**
	 * Verify if element is selected.
	 * 
	 * @param by
	 */
	public boolean isSelected(By by) {
		return findElement(by).isSelected();
	}

	/**
	 * Verify if element is not selected.
	 * 
	 * @param by
	 */
	public boolean isNotSelected(By by) {
		return !findElement(by).isSelected();
	}

	/**
	 * Select value from dropdown
	 * 
	 * @param by
	 * @param type
	 * @param value
	 */
	public void selectDropdown(By by, String type, String value) {
		select = new Select(findElement(by));
		if (type.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.valueOf(value));
		} else if (type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		} else if (type.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		}
	}

	/**
	 * Add implicit wait.
	 * 
	 * @param timeout
	 */
	public void implicitWait(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	/**
	 * Add explicit wait for presence of element
	 * 
	 * @param by
	 * @param timeout
	 */
	public void explicitWaitForPresenceOfElementLocated(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Add explicit wait for click of element
	 * 
	 * @param by
	 * @param timeout
	 */
	public void explicitWaitForElementClickable(By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Add explicit wait for invisibility of element
	 * 
	 * @param by
	 * @param timeout
	 */
	public void explicitWaitForInvisibilityElement(By by, int timeout) {
		WebElement ele = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	/**
	 * Add fluent wait for presence of element
	 * 
	 * @param by
	 * @param timeout
	 * @param polling
	 */
	public void fluentwaitForPresenceOfElementLocated(By by, int timeout, int polling) {
		FluentWait<WebDriver> flu = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(polling)).ignoring(NoSuchElementException.class);
		flu.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Add fluent wait for click of element
	 * 
	 * @param by
	 * @param timeout
	 * @param polling
	 */
	public void fluentwaitForElementClickable(By by, int timeout, int polling) {

		FluentWait<WebDriver> flu = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(polling)).ignoring(StaleElementReferenceException.class);
		flu.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Click element using java script.
	 * 
	 * @param element
	 */
	public void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
