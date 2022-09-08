package com.telus.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RegisterUserDemo {

	public WebDriver driver;

	String url = "https://nxtgenaiacademy.com/";

	String registrationFormURL = "https://nxtgenaiacademy.com/demo-site/";

	String inputFirstName = "Lakshya";
	String inputLastName = "Shandilya";

	String streetAddress = "Zeta";
	String adressDetails = "Avj main";

	String pinCode = "834569";
	String cityAddress = "Delhi";

	String stateAddress = "Delhi";
	String country = "India";

	String enterEmailAddress = "lakshyashandilya6@gmail.com";
	String currentDate = "28/07/2022";

	String hourData = "18";
	String minsData = "30";

	String mobileNumber = "6230976184";
	String enterQuery = "Query is entered";

	String confirmationMsg= "Registration form is submitted";

	@Test(priority=1)
	public void launchApplication() {
		// Set the system property for chrome browser
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");

		// Creating Instance of Chrome driver
		driver = new ChromeDriver();
		
		
		//page load wait is updated by lakshya
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		//implicit wait increased by lakshya 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// launch the url
		driver.get(url);

		//printing confirmation message
		System.out.println("URL of application is :" +url);

		System.out.println(confirmationMsg);
		System.out.println("application launched successfully");

		// maximize the window
		driver.manage().window().maximize();


		
		System.out.println("Application is launched");
	}

	@Test(priority=2)
	public void navigateToRegistrationForm() {

		Actions action = new Actions(driver);

		//Creating the webelement object.
		WebElement qaAutomation = driver.findElement(By.linkText("QA AUTOMATION"));
		action.moveToElement(qaAutomation).perform();

		// Go to Practice Automation.
		WebElement practiceAutomation = driver.findElement(By.xpath("//*[@id=\"menu-item-4157\"]/a/span"));
		action.moveToElement(practiceAutomation).perform();
		// Click on Demo site which is Registration form

		WebElement registrationForm = driver.findElement(By.xpath("//*[@id=\"menu-item-4134\"]/a/span"));
		registrationForm.click();

		System.out.println("Registration Form Page is displayed");
	}

	@Test(priority=3)
	public void registerForDemo() {

		String currentURL = driver.getCurrentUrl()
				;
		if(registrationFormURL.equals(currentURL)) {
			System.out.println("Registration form page is displayed successfully");
			System.out.println("The current url of the page is:" +currentURL);
			System.out.println("Expected url of the page is:" +registrationFormURL);
		}
		//validating the register form

		WebElement header = driver.findElement(By.xpath("//*[@id='item-vfb-1']/div/h3"));

		if(header.isDisplayed()) {
			System.out.println("Register For Demo is Displayed");
		}
		else
		{
			System.out.println("Register For Demo is not displayed");
		}

		String actualText = header.getText();
		String expectedText = "Register For Demo";

		if(actualText.equals(expectedText))
		{
			System.out.println("Actual title and expected title is same");
		}
		else
		{
			System.out.println("Actual title and expected are not same");
		}


		//First Name validation

		WebElement firstName = driver.findElement(By.id("vfb-5"));

		if(firstName.isEnabled()) {
			System.out.println("First name is enabled");
			firstName.sendKeys(inputFirstName);
			System.out.println("First name is" + inputFirstName);
		}
		else
		{
			System.out.println("First name is not enabled");
		}

		// Verifying last name

		WebElement lastname = driver.findElement(By.id("vfb-7"));

		if(lastname.isEnabled()) {

			System.out.println("Last name is enabled");
			lastname.sendKeys(inputLastName);
			System.out.println("Last name is " + inputLastName);
		}
		else
		{
			System.out.println("Last name is not enabled");
		}

		//gender
		WebElement radioMaleBtn = driver.findElement(By.id("vfb-8-1"));
		radioMaleBtn.click();

		if(radioMaleBtn.isSelected()) {
			System.out.println("male Radio button is selected");
		}
		else
		{
			System.out.println("Male radio button is not selected");
		}
		//Address validation

		// adress 1

		WebElement address = driver.findElement(By.id("vfb-13-address"));

		if(address.isEnabled()) {
			System.out.println("Address 1 is enabled");

			address.sendKeys(streetAddress);
			System.out.println("Street " + streetAddress);
		}
		else
		{
			System.out.println("Address 1 is not enabled");
		}

		//adress 2

		WebElement adressTwo = driver.findElement(By.id("vfb-13-address-2"));

		if(adressTwo.isEnabled()) {
			System.out.println("Adress 2 is enabled");
			adressTwo.sendKeys(adressDetails);
		}
		else
		{
			System.out.println("Adress 2 is not enabled");
		}

		//verifying city 
		WebElement cityName = driver.findElement(By.id("vfb-13-city"));

		if(cityName.isEnabled()) {
			System.out.println("City address is enabled");

			cityName.sendKeys(cityAddress);
			System.out.println("City is" + cityAddress);
		}
		else
		{
			System.out.println("City address is not enabled");
		}

		// State name validation

		WebElement stateName = driver.findElement(By.id("vfb-13-state"));

		if(stateName.isEnabled()) {
			System.out.println("State address is enabled");
			stateName.sendKeys(stateAddress);
			System.out.println("State" + stateAddress);
		}
		else
		{
			System.out.println("State address is not enabled");
		}

		// Pin code Validation

		WebElement postCode = driver.findElement(By.id("vfb-13-zip"));

		if(postCode.isEnabled()) {
			System.out.println("Pin code is enabled");
			postCode.sendKeys(pinCode);
			System.out.println("pinCode is " + pinCode);
		}
		else
		{
			System.out.println("Pin code is not enabled");
		}

		//Drop down validation

		WebElement dDownCountry = driver.findElement(By.xpath("//*[@id=\"vfb-13-country\"]"));

		if(dDownCountry.isEnabled()) {
			System.out.println("Country Name Drop down is enabled");

			Select CountryName = new Select(dDownCountry);

			CountryName.selectByValue(country);

			System.out.println("Country is " + country);
		}
		else
		{
			System.out.println("Country name drop down is not enabled");
		}
		// Validating email.

		WebElement emailAddress = driver.findElement(By.id("vfb-14"));

		if(emailAddress.isEnabled()) {
			System.out.println("Email id is enabled");
			emailAddress.sendKeys(enterEmailAddress);
			System.out.println("Email id is" + enterEmailAddress);
		}
		else
		{
			System.out.println("Email id is not enabled");
		}

		// Time validation

		WebElement hourValue = driver.findElement(By.id("vfb-16-hour"));

		if(hourValue.isEnabled()) {
			System.out.println("Time in hours is enabled");
			Select hour = new Select(hourValue);

			hour.selectByValue(hourData);
		}
		else
		{
			System.out.println("Time in hours is not enabled");
		}

		WebElement minValue = driver.findElement(By.id("vfb-16-min"));

		if(minValue.isEnabled()) {
			System.out.println("Time in minutes is enabled");
			Select min = new Select(minValue);

			min.selectByValue(minsData);
		}
		else
		{
			System.out.println("Time in minutes is not enabled");
		}

		// Mobile number validation

		WebElement mobNumber = driver.findElement(By.id("vfb-19"));

		if(mobNumber.isEnabled()) {
			System.out.println("Mobile number is enabled");
			mobNumber.sendKeys(mobileNumber);

			System.out.println("Mobile Number" + mobileNumber);
		}
		else
		{
			System.out.println("Mobile number is ");
		}

		// Date validation

		WebElement date = driver.findElement(By.id("vfb-18"));

		if(date.isEnabled()) {
			System.out.println("Date is enabled");

			date.sendKeys(currentDate);
		}
		else
		{
			System.out.println("Date is not enabled");
		}



		// Course validation
		WebElement courseUFT = driver.findElement(By.id("vfb-20-1"));
		if(courseUFT.isDisplayed())
		{
			System.out.println("UFT course is displayed");
			if(courseUFT.isEnabled())
			{
				System.out.println("UFT course is enabled");
				if(courseUFT.isSelected())
				{
					System.out.println("Course UFT is selected");
				}
				else
				{
					//Using click method
					courseUFT.click();
					WebElement selectCourse = driver.findElement(By.xpath("//*[@id=\"vfb-20-1\"]"));
					String inputCourse = selectCourse.getText();
					System.out.println("Course checkbox selected" +inputCourse);
				}
			}
			else
			{
				System.out.println("Other checkbox are disabled");
			}
		}
		else
		{
			System.out.println("Other checkbox are not displayed");
		}
		//Query validation

		WebElement query = driver.findElement(By.id("vfb-23"));

		if(query.isEnabled()) {
			System.out.println("Enter your query");
			query.sendKeys(enterQuery);
			System.out.println("Your query" + enterQuery);
		}
		else
		{
			System.out.println("Enter your query is not enabled");
		}

		WebElement twoDigit = driver.findElement(By.xpath("//*[@id=\"item-vfb-2\"]/ul/li[1]/span/label"));

		//validate two digits values

		String verificationValue = twoDigit.getText();
		String exampleValue = verificationValue.split(":")[1].trim();

		//verify value
		WebElement inputTwoDigit = driver.findElement(By.id("vfb-3"));

		if(inputTwoDigit.isEnabled()) {
			System.out.println("Input two digits display is enabled");

			inputTwoDigit.sendKeys(exampleValue);
		}
		else
		{
			System.out.println("Input two Digits is disabled");
		}

		WebElement submitBTN = driver.findElement(By.id("vfb-4"));
		if(submitBTN.isDisplayed())
		{
			System.out.println("submit button is displayed");
			if(submitBTN.isEnabled())
			{
				System.out.println("submit button is enabled");
				submitBTN.click();
				System.out.println("submit button is clicked");
			}
			else
			{
				System.out.println("submit button is disabled");
			}
		}
		else
		{
			System.out.println("submit button is not displayed");
		}
	}

	@Test(priority=4)
	public void validateSuccessfullMsg() {
		// Success message validation

				WebElement transId = driver.findElement(By.xpath("//*[@id=\"content\"]/article/div/div/div/div/section[1]/div/div/div[1]/div/div/div/div/div"));

				if(transId.isDisplayed()) {
					System.out.println("Success message is displayed");

					//Display Message
					String successMSG = transId.getText();
					String successMsg = successMSG.split(":")[1].trim();
					System.out.println("User Successfully registered");
					System.out.println(successMSG);
					System.out.println("TransactionId is:" +successMsg);			
				}
				else
				{
					System.out.println("Success message not displayed");


					System.out.println("Transaction is not successful");
				}
	}
	@Test(priority=5)
	public void closeApplication() {
		driver.close();
		System.out.println("Application closed");
		

	}
}
