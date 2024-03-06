package com.ohrm.pages;

import org.openqa.selenium.By;

import com.ohrm.base.OrangeHRMBase;

public class LoginPage extends OrangeHRMBase {

	public String getTitle() {
		return driver.getTitle();
	}

	public DashboardPage login() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new DashboardPage();
	}
	
	public DashboardPage login(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new DashboardPage();
	}

}
