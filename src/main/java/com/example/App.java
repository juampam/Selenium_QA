package com.example;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import java.time.Month;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.github.cdimascio.dotenv.Dotenv;


public class App {
    public static void main( String[] args ){
		Dotenv dotenv = Dotenv.load();

        // DOTENV variables
		String webTablesName = dotenv.get("WEB_TABLES_NAME");
		String webTablesLastName = dotenv.get("WEB_TABLES_LAST_NAME");
        String envName = dotenv.get("NAME");
        String envLastName = dotenv.get("LAST_NAME");
        String envEmail = dotenv.get("EMAIL");
        String envAge = dotenv.get("AGE");
        String envSalary = dotenv.get("SALARY");
        String envCountry = dotenv.get("COUNTRY");
        String envPhone = dotenv.get("PHONE");
        String envYear = dotenv.get("YEAR");
        String envMonth = dotenv.get("MONTH");
        String envDay = dotenv.get("DAY");
        String envAddress = dotenv.get("ADDRESS");



        String direccion = dotenv.get("DIRECCION");
    	WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	try{
		driver.get("https://demoqa.com/elements");
		WebElement checkBoxSection = driver.findElement(By.xpath("//span[text()='Check Box']"));
		checkBoxSection.click();
		WebElement addButton = driver.findElement(By.xpath("//button[@title='Expand all']"));
		addButton.click();

		WebElement wordFileCheckbox = driver.findElement(By.xpath("//label[@for='tree-node-wordFile']//span[@class='rct-checkbox']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wordFileCheckbox);
		wordFileCheckbox.click();

		WebElement excelFileCheckbox = driver.findElement(By.xpath("//label[@for='tree-node-excelFile']//span[@class='rct-checkbox']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", excelFileCheckbox);
		excelFileCheckbox.click();
		
		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		// Remove the first line
		WebElement dynamicProperties = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicProperties);
		dynamicProperties.click();
		WebElement DynamicButton = driver.findElement(By.xpath("//button[@id='enableAfter']"));
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(DynamicButton)).click();

		WebElement webTable = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webTable);
		webTable.click();

		WebElement removeFirstRow = driver.findElement(By.xpath("//span[@id='delete-record-1']//*[name()='svg']//*[name()='path' and contains(@d,'M864 256H7')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", removeFirstRow);
		removeFirstRow.click();

		WebElement addRow = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addRow);
		addRow.click();
		//add a new "user"
		WebElement nameField = driver.findElement(By.id("firstName"));
		WebElement lastname = driver.findElement(By.id("lastName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement age = driver.findElement(By.id("age"));
		WebElement salary = driver.findElement(By.id("salary"));
		WebElement department = driver.findElement(By.id("department"));
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));

		nameField.sendKeys(webTablesName);
		lastname.sendKeys(webTablesLastName);
		email.sendKeys(envEmail);
		age.sendKeys(envAge);
		salary.sendKeys(envSalary);
		department.sendKeys(envCountry);
		submitButton.click();

		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		//fill form

	driver.get("https://demoqa.com/forms");
	WebElement practiceForm = driver.findElement(By.xpath("//span[normalize-space()='Practice Form']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", practiceForm);
	practiceForm.click();
	WebElement nameForm = driver.findElement(By.id("firstName"));
	WebElement lastnameForm = driver.findElement(By.id("lastName"));
	WebElement emailForm = driver.findElement(By.id("userEmail"));
	WebElement buttonGender = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
	WebElement phoneForm = driver.findElement(By.id("userNumber"));
	WebElement birthday = driver.findElement(By.id("dateOfBirthInput"));
	
	WebElement subjects = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
	WebElement hobbiesMusic = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
	WebElement fileForm = driver.findElement(By.id("uploadPicture"));
	WebElement addressForm = driver.findElement(By.id("currentAddress"));
	//WebElement cityForm = driver.findElement(By.xpath("//div[@id='city']"));
	//WebElement stateForm = driver.findElement(By.xpath("//*[@id='state']"));
	nameForm.sendKeys(envName);
	lastnameForm.sendKeys(envLastName);
	emailForm.sendKeys(envEmail);
	buttonGender.click();
	phoneForm.sendKeys(envPhone);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", birthday);
	birthday.click();
	WebElement selYear = driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
	selYear.click();	
	String y = Integer.toString(2000);
	selYear.sendKeys(y);
	selYear.click();
		
	WebElement selMonth = driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
	selMonth.click();
	String m = Month.of(6).toString();
	selMonth.sendKeys(m);
	selMonth.click();	
	String d = Integer.toString(25);
	String xp = "//*[@class='react-datepicker__week']//*[text()='" + d + "']";
	WebElement selDate = driver.findElement(By.xpath(xp));
	selDate.click();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement subjectsInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("subjectsInput")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjectsInput);
	subjectsInput.sendKeys("m");
	WebElement elusiveEl = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subjects-auto-complete__menu")));
	WebElement mathsOption = elusiveEl.findElement(By.xpath("//div[text()='Maths']"));
	mathsOption.click();


	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbiesMusic);
	hobbiesMusic.click();
   
	File uploadFile = new File("testfile.txt");
	WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
    fileInput.sendKeys(uploadFile.getAbsolutePath());
    //driver.findElement(By.id("uploadPicture")).click();


	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addressForm);
	addressForm.sendKeys(envAddress);
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityForm);
	WebElement state = driver.findElement(By.id("state"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state);
	state.click();
	 WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-3-option-0']")));
	 optionToSelect.click();
	WebElement city = driver.findElement(By.id("city"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", city);
	city.click();
	 WebElement CityToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-4-option-0']")));
	 CityToSelect.click();
	  Actions actions = new Actions(driver);
        actions.sendKeys(phoneForm, Keys.RETURN).build().perform();
		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	WebElement close = driver.findElement(By.id("closeLargeModal"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", close);
	close.click();
	

	driver.get("https://demoqa.com/books");
	WebElement books = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", books);
	books.click();
	WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Understanding ECMAScript 6']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
	link.click();

	WebElement otherLink = driver.findElement(By.id("userName-value"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", otherLink);
	otherLink.click();

	WebElement labelElement = driver.findElement(By.id("userName-value"));
	String url = labelElement.getText();
	((JavascriptExecutor) driver).executeScript("window.open();");

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
		driver.get("https://leanpub.com/understandinges6/read");
		 driver.close();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
		WebElement buttonGoBack = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonGoBack);
		buttonGoBack.click();
		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}finally{
        	driver.quit();		
	}
   }
}
