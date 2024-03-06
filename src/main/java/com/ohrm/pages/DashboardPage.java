package com.ohrm.pages;

import org.openqa.selenium.By;

import com.ohrm.base.OrangeHRMBase;

public class DashboardPage extends OrangeHRMBase{
	
	public boolean getDashboardLabel() {
		return driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	}
	
	public boolean getTimeWorkSection() {
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
	}
	
	public boolean getMyActionSection() {
		return driver.findElement(By.xpath("//p[text()='My Actions']")).isDisplayed();
	}
	
	
	
	
}
