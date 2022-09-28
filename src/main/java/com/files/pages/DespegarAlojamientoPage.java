package com.files.pages;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientoPage {
	@FindBy(xpath = "/html/body/nav/div[4]/div[1]/i")
	WebElement ventanaFace;
	
	@FindBy (xpath = "//*[@id=\"lgpd-banner\"]/div/a[2]/em")
	WebElement ventanaCookie;
	
	@FindBy (css = "input[placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
	WebElement inputDestino;
	
	@FindBy (xpath = "//*[@id=\\\"searchbox-sbox-box-hotels\\\"]/div/div/div/div/div[3]/div[1]/div/div/div/input")
	WebElement searchDestino;
	
	@FindBy (xpath = "//div[7]/div/div[1]/ul/li[1]/span")
	WebElement seleccionarCiudad;
	
	@FindBy (css = "input[placeholder='Entrada']")
	WebElement seleccionarInputEntrada;
	
	@FindBy (xpath = "//*[@id='component-modals']//div[30]/div[1]")
	WebElement seleccionarIda;
	
	@FindBy (xpath = "//*[@id='component-modals']//div[2]/div[3]/div[13]/div[1]")
	WebElement seleccionarVuelta;
	
	@FindBy (css = "button.sbox5-3-btn.-primary.-md")
	WebElement seleccionarAplicar;
	
	@FindBy (css = "input.sbox5-3-second-input")
	WebElement seleccionarHabitaciones;
	
	@FindBy (xpath = "//*[@id='component-modals']/div[2]//div[1]/div[2]/div[1]/div[2]//button[2]")
	WebElement seleccionarAdultos;
	
	@FindBy (xpath = "//*[@id='component-modals']//div[2]/div[2]//button[2]" )
	WebElement seleccionarMenores;
	
	@FindBy (css = "select.select")
	WebElement seleccionarLaEdadMenores;
	
	@FindBy (xpath = "//*[@id='component-modals']//div//select/option[6]")
	WebElement clickEdadMenores;
	
	@FindBy (xpath = "//*[@id='component-modals']/div[2]/div/div/div[2]/a[1]/em")
	WebElement clickAplicarBusqueda;
	
	@FindBy (xpath = "//*[@id='searchbox-sbox-box-hotels']/div/div/div/div/div[3]/button")
	WebElement clickAplicarBuscar;
	
	@FindBy (xpath = "//*[@id='vacation-rentals-coachmark']/div/div/i[2]")
	WebElement clickCierraModal;
	
	@FindBy (xpath = "//aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]/aloha-cluster-accommodation-info-container/div[1]/span")
	WebElement tituloDelResultado;
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public DespegarAlojamientoPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);		
	}
	
	public void cerrarVentanasEmergentes() {
		wait.until(ExpectedConditions.visibilityOf(ventanaFace));
		this.ventanaFace.click();
		wait.until(ExpectedConditions.visibilityOf(ventanaCookie));
		this.ventanaCookie.click();
	}
	public void clickInputDestino() {
		this.inputDestino.click();
	}
	public void buscarElDestino(String text) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(inputDestino));
		this.inputDestino.click();
		this.inputDestino.clear();
		this.inputDestino.click();
		Thread.sleep(2000);	
		this.inputDestino.sendKeys(text);
		//Thread.sleep(2000);	
		this.wait.until(ExpectedConditions.visibilityOf(inputDestino));
		this.inputDestino.sendKeys(Keys.CONTROL);
		this.inputDestino.sendKeys(Keys.ENTER);
		this.inputDestino.click();
		this.wait.until(ExpectedConditions.visibilityOf(seleccionarCiudad));
		this.seleccionarCiudad.click();
	}
	public void elegirFechas() {
		this.seleccionarInputEntrada.click();
		this.wait.until(ExpectedConditions.visibilityOf(seleccionarIda));
		this.seleccionarIda.click();
		this.seleccionarVuelta.click();
		this.wait.until(ExpectedConditions.visibilityOf(seleccionarAplicar));
		this.seleccionarAplicar.click();
		
	}
	public void elegirHabitaciones() {
		this.wait.until(ExpectedConditions.visibilityOf(seleccionarHabitaciones));
		this.seleccionarHabitaciones.click();
		this.wait.until(ExpectedConditions.visibilityOf(seleccionarAdultos));
		this.seleccionarAdultos.click();
		this.wait.until(ExpectedConditions.visibilityOf(seleccionarMenores));
		this.seleccionarMenores.click();
		this.wait.until(ExpectedConditions.visibilityOf(seleccionarLaEdadMenores));
		this.seleccionarLaEdadMenores.click();
		this.wait.until(ExpectedConditions.visibilityOf(clickEdadMenores));
		this.clickEdadMenores.click();
		this.wait.until(ExpectedConditions.visibilityOf(clickAplicarBusqueda));
		this.clickAplicarBusqueda.click();		
		
	}
	public DespegarResultsPage buscarAlojamiento() {
		this.wait.until(ExpectedConditions.visibilityOf(clickAplicarBuscar));
		this.clickAplicarBuscar.click();
		return new DespegarResultsPage(this.driver);
	}


}
