package com.files.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.files.driver.DriverFactory;
import com.files.pages.DespegarAlojamientoPage;
import com.files.pages.DespegarResultsPage;
import org.testng.Assert;


public class DespegarTest2 extends DriverFactory {
	WebDriver driver = null;
	private DespegarAlojamientoPage alojamientoPage;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setUp(ITestContext context) throws Exception {
		String navegadorTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		String navegador = navegadorTestSuite != null ? navegadorTestSuite : "chrome";
		driver = DriverFactory.LevantarBrowser(navegador, "https://www.despegar.com.ar/hoteles/" );
		alojamientoPage = new DespegarAlojamientoPage(driver);
	}
	
	@DataProvider (name = "Data Provider Despegar")
	public Object [][] dpMetodo(){
		return new Object [][] {{"Miami"}, {"Misiones"}, {"Bariloche"}};
	}
	
	@Test(groups = {"grupo1"}, dataProvider = "Data Provider Despegar", description = "Validar el resultado de la busqueda de alojamiento")
		public void validarReservaViaje(String text) throws Exception{
		alojamientoPage.cerrarVentanasEmergentes();
		alojamientoPage.clickInputDestino();
		
		alojamientoPage.buscarElDestino(text);
		alojamientoPage.elegirFechas();
		alojamientoPage.elegirHabitaciones();
		
		DespegarResultsPage resultsAlojamientoPage = alojamientoPage.buscarAlojamiento();
		
		resultsAlojamientoPage.cerrarExperienciasModal();
		
		resultsAlojamientoPage.primerResultadoHotel();
		Assert.assertTrue(resultsAlojamientoPage.tituloVisible(), "El elemento no se encuentra");
		
			
		}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		DriverFactory.CloseBrowser(driver); 
	}
	}

