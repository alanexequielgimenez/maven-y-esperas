package com.files.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

public class DriverFactory {
	 private enum browsers{
		 chrome, edge
	 }
	 public static WebDriver LevantarBrowser (String browserName, String url) {
		 WebDriver driver = null;
		 switch(browsers.valueOf(browserName)) {
		 case chrome:
		 {
			 System.setProperty("webdriver.chrome.driver", "/Users/pijui/drivers/chromedriver/chromedriver.exe");
			 Reporter.log("Abrir Navegador Chrome");
			 driver = new ChromeDriver();
			 break;
		 	}
		 case edge:
		 {
			 System.setProperty("webdriver.edge.driver", "/Users/pijui/drivers/edgedriver.exe");
			 Reporter.log("Abrir Navegador Edge");
			 driver = new EdgeDriver();
			 break;			 
		 }
		 default:
		 {
			 Reporter.log("No se selecciono un navegador correcto, se abre Chrome por defecto");
			 System.setProperty("webdriver.chrome.driver", "/Users/pijui/drivers/chromedriver/chromedriver.exe");
			 Reporter.log("Abrir Navegador Chrome");
			 driver = new ChromeDriver();
			 break;
		 }
		 }
		 //maximizar el navegador
		 driver.manage().window().maximize();
		 //navegamos hacia la pagina
		 driver.get(url);
		 
		 return driver;
	 }
	// public static void CloseBrowser(WebDriver driver) {
		// driver.quit();
	// }
	
}

















