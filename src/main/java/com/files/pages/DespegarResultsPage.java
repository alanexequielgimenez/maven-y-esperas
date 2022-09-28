package com.files.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarResultsPage {
	@FindBy (xpath = "//*[@id='vacation-rentals-coachmark']/div/div/i[2]")
	WebElement clickCierraModal;
	
	@FindBy (xpath = "//aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]/aloha-cluster-accommodation-info-container/div[1]/span")
	WebElement tituloDelResultado;
	
	public WebDriver driver = null;
	private WebDriverWait wait = null;
	
	public DespegarResultsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public void cerrarExperienciasModal() {
		this.wait.until(ExpectedConditions.visibilityOf(clickCierraModal));
		this.clickCierraModal.click();		
	}
	public void primerResultadoHotel() {
		this.wait.until(ExpectedConditions.visibilityOf(tituloDelResultado));

		
	}
	public boolean tituloVisible() {
		return this.tituloDelResultado.isDisplayed();
	}

}
