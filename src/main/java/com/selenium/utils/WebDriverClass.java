package com.selenium.utils;

import org.openqa.selenium.WebDriver;

/**
 * Initalize WebDriver object.
 * 
 * @author Aafreen Khan
 */
public class WebDriverClass {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		WebDriverClass.driver = driver;
	}
}
