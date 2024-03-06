package com.ohrm.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class OrangeHRMBase {

	public static WebDriver driver;
	public static Properties prop;

	public void initialization() {
		propertyFileConfiguration();
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	public void tearDown() {
		driver.quit();
	}

	public void propertyFileConfiguration() {
		String configFilePath = "./src/main/java/com/ohrm/config/config.properties";
		prop = new Properties();
		FileReader reader;
		try {
			reader = new FileReader(configFilePath);
			prop.load(reader);
		} catch (IOException e) {
			System.out.println("Unable to find the file");
		}
	}

	public static void captureScreenshot(String name) {
		String path = "./Screenshot/" + name + ".png";
		// to take screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scrnshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrnshot, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
