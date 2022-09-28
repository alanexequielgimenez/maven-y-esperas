package com.files.tests;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.files.driver.DriverFactory;

public class DespegarTestMaven {
	WebDriver driver;
	WebDriverWait wait;
	
	//Locators
	By cerrarface = By.xpath("/html/body/nav/div[4]/div[1]/i");
	By closeCookie = By.xpath("//*[@id=\"lgpd-banner\"]/div/a[2]/em");
	By clickDestino = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[1]/div/div");
	By buscarDestino = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[1]/div/div/div/input");
	By inputCiudad = By.xpath("//div[7]/div/div[1]/ul/li[1]/span");
	By inputEntrada = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div/div/input");
	By selectIda = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[26]/div");
	By selectVuelta = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[30]/div");
	By botonAplicar = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button/em");
	By habitaciones = By.xpath("//*[@id=\"svg-bed-378XaOe\"]");
	By seleccionarAdulto = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]");
	By seleccionarMenor = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]");
	By seleccionarEdadMenor = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select");
	By clickEdadMenor = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select/option[4]");
	By aplicarBusqueda = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a[1]/em");
	By aplicarBuscar = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/button");
	By cierraModal = By.xpath("//*[@id=\"vacation-rentals-coachmark\"]/div/div/i[2]");
	By tituloResultado = By.xpath("//aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]/aloha-cluster-accommodation-info-container/div[1]/span");
	

	@BeforeMethod(alwaysRun = true)
	public void initTest() {
		//String navegadorSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador ="chrome";
		String url = "https://www.despegar.com.ar/hoteles/";
		this.driver = DriverFactory.LevantarBrowser(navegador, url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	}
  @Test(description = "validar que la reserva funcione")
  public void reservarViaje() throws Exception{
	  
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(cerrarface));
	  	driver.findElement(cerrarface).click();		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(closeCookie));
		driver.findElement(closeCookie).click();
		
		driver.findElement(clickDestino).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(buscarDestino));
		//Buscar Destino. Ej: Cordoba 
		wait.until(ExpectedConditions.visibilityOfElementLocated(buscarDestino));
		driver.findElement(buscarDestino).sendKeys("Cordoba");
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(buscarDestino));
		driver.findElement(buscarDestino).sendKeys(Keys.CONTROL);
		driver.findElement(buscarDestino).sendKeys(Keys.ENTER);
		driver.findElement(buscarDestino).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputCiudad));
		driver.findElement(inputCiudad).click();
			
		driver.findElement(inputEntrada).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectIda));
		//Seleccionar Ida y Vuelta
		driver.findElement(selectIda).click();
		driver.findElement(selectVuelta).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(botonAplicar));	
		driver.findElement(botonAplicar).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(habitaciones));
		//Seleccionar cuantas personas
		driver.findElement(habitaciones).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(seleccionarAdulto));
		driver.findElement(seleccionarAdulto).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(seleccionarMenor));
		driver.findElement(seleccionarMenor).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(seleccionarEdadMenor));
		driver.findElement(seleccionarEdadMenor).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickEdadMenor));
		driver.findElement(clickEdadMenor).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(aplicarBusqueda));
		driver.findElement(aplicarBusqueda).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(aplicarBuscar));
		driver.findElement(aplicarBuscar).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(cierraModal));
		driver.findElement(cierraModal).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(tituloResultado));
		driver.findElement(tituloResultado);
		driver.findElement(tituloResultado).isDisplayed();
		System.out.println("Texto encontrado "+ driver.findElement(tituloResultado).getText());
		Assert.assertTrue(driver.findElement(tituloResultado).isDisplayed());
		driver.close();
		
  }
}
