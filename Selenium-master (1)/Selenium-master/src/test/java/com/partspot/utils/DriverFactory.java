package com.partspot.utils;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverFactory {

    private static EventFiringWebDriver e_driver;
    private static EventListener eventListener;

    public static WebDriver createInstance ( String browserName ) {
        WebDriver driver = null;
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);

        switch (browserName.toLowerCase()) {
            case "chrome":

                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

            case "firefox":

                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "edge":

                break;

            case "ie":
            	
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;

            case "safari":

                break;


        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new EventListener();
        e_driver.register(eventListener);

        return e_driver;
    }
}
