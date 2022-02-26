package com.thulasi.assignments.betsbuy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FizzBuzzStepDef {

	WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("user in on the FizzBuzz application page")
	public void launch_Browser() {
		driver.get("URL");
	}

	@When("user enters {input}")
	public void getInput(String input) {
		driver.findElement(By.id("")).sendKeys(input);
	}

	@Then("verify {column1} ,{column2} are displayed in the table")
	public void verifyOutput(String column1, String column2) {
		List<WebElement> rowElements = driver.findElements(By.xpath("//*[@name='table']/tbody/tr"));
		int rowsize = rowElements.size();
		List<WebElement> colElements = driver.findElements(By.xpath("//*[@name='table']/tbody/tr[1]/td"));
		int colsize = colElements.size();
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= colsize; j++) {
				driver.findElement(By.xpath("//*[@name='table']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
			}
		}
	}

}
