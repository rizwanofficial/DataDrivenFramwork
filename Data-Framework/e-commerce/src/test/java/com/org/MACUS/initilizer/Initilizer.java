package com.org.MACUS.initilizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initilizer {
	// Initializing environment properties
	public static FileInputStream envFis = null;
	public static Properties envProp = null;

	// Initializing Locator properties
	public static FileInputStream locatorFis = null;
	public static Properties locatorProp = null;

	
	public static WebDriver wd= null;
	public static void initilizer() throws IOException 
	{
		envFis = new FileInputStream(new File(
				"D:\\Data-Framework\\e-commerce\\src\\test\\resources\\com\\org\\MACUS\\config\\env.properties"));
		envProp = new Properties();
		envProp.load(envFis);

		locatorFis = new FileInputStream(new File(
				"D:\\Data-Framework\\e-commerce\\src\\test\\resources\\com\\org\\MACUS\\config\\locator.properties"));
		locatorProp = new Properties();
		locatorProp.load(locatorFis);

		if (envProp.getProperty("BROWSER").equals("FIREFOX")) 
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Data-Framework\\e-commerce\\lib\\drivers\\geckodriver.exe");
			wd = new FirefoxDriver();
			
		}
		else if (envProp.getProperty("BROWSER").equals("CHROME")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Data-Framework\\e-commerce\\lib\\drivers\\chromedriver.exe");
			wd = new ChromeDriver();
		}

	}
}
