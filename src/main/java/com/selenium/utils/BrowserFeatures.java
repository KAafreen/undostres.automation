package com.selenium.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Class to initalize browser and perform other browser operations like get url,
 * close, quit, window handling etc.
 * 
 * @author Aafreen Khan
 */
public class BrowserFeatures extends WebDriverClass {

	/**
	 * Initalize browser as chrome, firefox or ie.
	 * 
	 * @param browser
	 */
	public static void initalizeBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resource/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/resource/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/src/main/resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}

	/**
	 * Launch url.
	 * 
	 * @param url
	 */
	public void getUrl(String url) {
		driver.get(url);
	}

	/**
	 * Close browser.
	 * 
	 */
	public void closeBrowser() {
		driver.close();
	}

	/**
	 * Quit browser.
	 * 
	 */
	public void quitBrowser() {
		driver.quit();
	}
}
