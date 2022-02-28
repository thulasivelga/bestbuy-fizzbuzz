package com.thulasi.assignments.betsbuy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
		driver.findElement(By.id("textbox")).sendKeys(input); // Assuming input text box id is 'textbox'
		driver.findElement(By.id("button")).click(); // Assuming click button id is 'button'
	}

	@Then("verify {column1} ,{column2} are displayed in the table")
	public void verifyOutput(String column1, String column2) {
		String input = driver.findElement(By.xpath("//*[@name='table']/tbody/tr[1]/td[0]")).getText();
		String expectedOutput = driver.findElement(By.xpath("//*[@name='table']/tbody/tr[1]/td[0]")).getText();

		Assert.assertEquals(input, column1);
		Assert.assertEquals(expectedOutput, column2);

		// TODO below code is to traverse the complete tables.
		List<WebElement> rowElements = driver.findElements(By.xpath("//*[@name='table']/tbody/tr"));
		int rowsize = rowElements.size();
		List<WebElement> colElements = driver.findElements(By.xpath("//*[@name='table']/tbody/tr[1]/td"));
		int colsize = colElements.size();

		String[][] actualTableData = new String[rowsize][colsize];
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= colsize; j++) {
				actualTableData[i - 1][j - 1] = driver
						.findElement(By.xpath("//*[@name='table']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
			}
		}

		// TODO get this data from the selenium outline examples
		String[][] expectedTableData = new String[rowsize][colsize];

		// Comparing the 2 2-D arrays to be equal
		for (int i = 0; i < rowsize; i++) {
			for (int j = 0; j < colsize; j++) {
				Assert.assertEquals(actualTableData[i][j], expectedTableData[i][j]);
			}
		}

	}

}
