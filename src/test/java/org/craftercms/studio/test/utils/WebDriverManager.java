package org.craftercms.studio.test.utils;

import junit.framework.TestFailure;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.TestException;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
	WebDriver driver;
	ConstantsPropertiesManager constantsPropertiesManager;

	public void openConnection() {
		final Properties runtimeProperties = new Properties();
		try {
			runtimeProperties.load(WebDriverManager.class.getResourceAsStream("/runtime.properties"));
			String enviromentPropertiesPath = runtimeProperties.getProperty("crafter.test.location");
			final Properties envProperties = new Properties();
			try{
				envProperties.load(new FileInputStream(enviromentPropertiesPath));
				String webBrowserProperty = envProperties.getProperty("webBrowser");
				DesiredCapabilities capabilities;
				switch (webBrowserProperty.toLowerCase()){
					case "phantomjs":
						capabilities = DesiredCapabilities.phantomjs();
						System.setProperty("phantomjs.binary.path",
								envProperties.getProperty("phantomjs.binary.path"));
						driver = new PhantomJSDriver(capabilities);
						break;
					case "firefox":
						capabilities = DesiredCapabilities.firefox();
						System.setProperty("webdriver.gecko.driver",
								envProperties.getProperty("firefox.driver.path"));
						driver = new FirefoxDriver(capabilities);
						break;
					case "edge":
						capabilities = DesiredCapabilities.edge();
						System.setProperty("webdriver.edge.driver",
								envProperties.getProperty("edge.driver.path"));
						driver = new EdgeDriver(capabilities);
						break;
					case "ie":
						capabilities = DesiredCapabilities.internetExplorer();
						capabilities.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
						System.setProperty("webdriver.ie.driver",
								envProperties.getProperty("ie.driver.path"));
						driver = new InternetExplorerDriver(capabilities);
						break;
					case "chrome":
						capabilities = DesiredCapabilities.chrome();
						System.setProperty("webdriver.chrome.driver",
								envProperties.getProperty("chrome.driver.path"));
						driver = new ChromeDriver(capabilities);
						break;
					default:
						throw new IllegalArgumentException("webBrowser property is needed, valid values are:" +
								"chrome,edge,ie,firefox,phantomjs");
				}
				driver.get(envProperties.getProperty("baseUrl"));
			}catch (IOException ex){
				throw new FileNotFoundException("Unable to read runtime properties file");
			}
		}catch (IOException ex){
			throw new  TestException("Require Files are not found.");
		}
		this.maximizeWindow();
	}


	public void closeConnection() {
		this.driver.close();
		this.driver.quit();
	}

	public void maximizeWindow() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int) toolkit.getScreenSize().getWidth();
		int height = (int) toolkit.getScreenSize().getHeight();

		this.driver.manage().window().setPosition(new Point(0, 0));
		this.driver.manage().window().maximize();
		this.driver.manage().window().setSize(new Dimension(width, height));
		this.driverWait();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void driverWait() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}
	}

	public void dragAndDropElement(WebElement fromWebElement, WebElement toWebElement) {
		// Creating an actions builder
		Actions builder = new Actions(this.getDriver());

		// Creating the action for click and hold from the origin web element
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement)
				.build();

		// commit the actions above
		dragAndDrop.perform();

		// wait for a couple of secs
		this.driverWait();
	}

	public boolean isElementPresentByXpath(String xpathOfTheElement) {
		boolean isElementPresent = true;

		try {

			this.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			@SuppressWarnings("unused")

			WebElement webElement = this.getDriver().findElement(By.xpath(xpathOfTheElement));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public void setImplicitlyWaitTimeForFindElements() {
		this.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	public void contextClick(WebDriver driver, WebElement element) {
		if (driver instanceof PhantomJSDriver) {
			String script = "var element = arguments[0];" + "var event = document.createEvent('HTMLEvents');"
					+ "event.initEvent('contextmenu', true, false);" + "element.dispatchEvent(event);";
			((JavascriptExecutor) driver).executeScript(script, new Object[] { element });
		} else {
			(new Actions(driver)).contextClick(element).build().perform();
		}
	}

	
}
