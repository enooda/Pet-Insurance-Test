package base;

import helpers.ExcelReader;
import models.Cat;
import models.Dog;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class TestBase {
    public WebDriver driver;
    private static final String TEST_DATA_PATH = "src/test/resources/Pet_Owners.xlsx";
    private static final String SHEET = "PetOwners";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        getDriver().get("https://www.quotezone.co.uk/pet-insurance");
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {return driver;}

    public void fillCatInfo(Cat cat) {
        getDriver().findElement(By.id(cat.getPetType())).click();
        getDriver().findElement(By.xpath("//input[@name='pet_name']")).sendKeys(cat.getPetName());
        getDriver().findElement(By.id("pet_gender" + cat.getPetGender())).click();

        Select petAgeDay = new Select(getDriver().findElement(By.xpath("//select[@name='pet_date_of_birth_dd']")));
        petAgeDay.selectByValue(cat.getPetAgeDay());
        Select petAgeMonth = new Select(getDriver().findElement(By.xpath("//select[@name='pet_date_of_birth_mm']")));
        petAgeMonth.selectByValue(cat.getPetAgeMonth());
        Select petAgeYear = new Select(getDriver().findElement(By.xpath("//select[@name='pet_date_of_birth_yyyy']")));
        petAgeYear.selectByValue(cat.getPetAgeYear());

        getDriver().findElement(By.xpath("//input[@name='pet_purchase_price']")).sendKeys(cat.getPetPrice());
        getDriver().findElement(By.xpath("//input[@name='chipped_tagged' and @value='" + cat.getPetChipped() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='pet_vaccination_up_to_date' and @value='" + cat.getPetVaccine() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='neutered' and @value='" + cat.getPetNeutered() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='pet_health' and @value='" + cat.getPetIllness() + "']")).click();

        Select coverDate = new Select(getDriver().findElement(By.xpath("//select[@name='pet_cover_start_date']")));
        coverDate.selectByIndex(3);

        Select breedType = new Select(getDriver().findElement(By.id("catPedigreeSelect")));
        breedType.selectByValue(cat.getPetBreed());

        getDriver().findElement(By.id("nextButton")).click();
    }

    public void fillDogInfo(Dog dog) {
        getDriver().findElement(By.id(dog.getPetType())).click();
        getDriver().findElement(By.xpath("//input[@name='pet_name']")).sendKeys(dog.getPetName());
        getDriver().findElement(By.id("pet_gender" + dog.getPetGender())).click();

        Select petAgeDay = new Select(getDriver().findElement(By.xpath("//select[@name='pet_date_of_birth_dd']")));
        petAgeDay.selectByValue(dog.getPetAgeDay());
        Select petAgeMonth = new Select(getDriver().findElement(By.xpath("//select[@name='pet_date_of_birth_mm']")));
        petAgeMonth.selectByValue(dog.getPetAgeMonth());
        Select petAgeYear = new Select(getDriver().findElement(By.xpath("//select[@name='pet_date_of_birth_yyyy']")));
        petAgeYear.selectByValue(dog.getPetAgeYear());

        getDriver().findElement(By.xpath("//input[@name='pet_purchase_price']")).sendKeys(dog.getPetPrice());
        getDriver().findElement(By.xpath("//input[@name='chipped_tagged' and @value='" + dog.getPetChipped() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='pet_vaccination_up_to_date' and @value='" + dog.getPetVaccine() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='neutered' and @value='" + dog.getPetNeutered() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='pet_health' and @value='" + dog.getPetIllness() + "']")).click();

        Select coverDate = new Select(getDriver().findElement(By.xpath("//select[@name='pet_cover_start_date']")));
        coverDate.selectByIndex(3);

        Select breedType = new Select(getDriver().findElement(By.id("pet_breed_type")));
        breedType.selectByValue(dog.getBreedType());

        Select petBreed = new Select(getDriver().findElement(By.id("dogPedigreeSelect")));
        petBreed.selectByValue(dog.getPetBreed());

        getDriver().findElement(By.xpath("//input[@name='professional_use' and @value='" + dog.getProfessionalUse() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='aggressivity' and @value='" + dog.getAggressive() + "']")).click();
        getDriver().findElement(By.xpath("//input[@name='aggressiv_attack' and @value='" + dog.getAttack() + "']")).click();

        getDriver().findElement(By.id("nextButton")).click();
    }


    public void contactAmelia() throws IOException {
        ExcelReader petExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = petExcelReader.getSheetbyName(SHEET);

        int Amelia = 1;
        for (int cell = 0; cell < 10; cell++) {

            String title = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            Select titleSelect = new Select(getDriver().findElement(By.xpath("//select[@name='title']")));
            titleSelect.selectByValue(title);

            String name = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='first_name']")).sendKeys(name);

            String surName = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='surname']")).sendKeys(surName);

            String maritalStatus = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            Select maritalStatusSelect = new Select(getDriver().findElement(By.xpath("//select[@name='marital_status']")));
            maritalStatusSelect.selectByVisibleText(maritalStatus);

            int birthDay = (int) sheet.getRow(Amelia).getCell(cell++).getNumericCellValue();
            Select birthDaySelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_dd']")));
            birthDaySelect.selectByValue(String.valueOf(birthDay));

            String birthMonth = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            Select birthMonthSelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_mm']")));
            birthMonthSelect.selectByValue(birthMonth);

            String birthYear = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            Select birthYearSelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_yyyy']")));
            birthYearSelect.selectByValue(birthYear);

            String email = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='email_address']")).sendKeys(email);

            String phoneNumber = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='home_telephone_single_input']")).sendKeys(phoneNumber);

            String postCode = sheet.getRow(Amelia).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.id("postcodeID")).sendKeys(postCode);
        }

        getDriver().findElement(By.xpath("//a[@onkeypress='PostcodeSubmitOnEnterKeyPet(event);']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='found_address_id']/option[2]"))).click();

        getQuote();
    }

    public void contactCharlie() throws IOException {
        ExcelReader petExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = petExcelReader.getSheetbyName(SHEET);

        int Charlie = 2;
        for (int cell = 0; cell < 10; cell++) {

            String title = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            Select titleSelect = new Select(getDriver().findElement(By.xpath("//select[@name='title']")));
            titleSelect.selectByValue(title);

            String name = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='first_name']")).sendKeys(name);

            String surName = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='surname']")).sendKeys(surName);

            String maritalStatus = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            Select maritalStatusSelect = new Select(getDriver().findElement(By.xpath("//select[@name='marital_status']")));
            maritalStatusSelect.selectByVisibleText(maritalStatus);

            String birthDay = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            Select birthDaySelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_dd']")));
            birthDaySelect.selectByValue(String.valueOf(birthDay));

            String birthMonth = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            Select birthMonthSelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_mm']")));
            birthMonthSelect.selectByValue(birthMonth);

            String birthYear = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            Select birthYearSelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_yyyy']")));
            birthYearSelect.selectByValue(birthYear);

            String email = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='email_address']")).sendKeys(email);

            String phoneNumber = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='home_telephone_single_input']")).sendKeys(phoneNumber);

            String postCode = sheet.getRow(Charlie).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.id("postcodeID")).sendKeys(postCode);
        }

        getDriver().findElement(By.xpath("//a[@onkeypress='PostcodeSubmitOnEnterKeyPet(event);']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='found_address_id']/option[2]"))).click();

        getQuote();
    }

    public void contactShaggy() throws IOException {
        ExcelReader petExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = petExcelReader.getSheetbyName(SHEET);

        int Shaggy = 3;
        for (int cell = 0; cell < 10; cell++) {

            String title = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            Select titleSelect = new Select(getDriver().findElement(By.xpath("//select[@name='title']")));
            titleSelect.selectByValue(title);

            String name = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='first_name']")).sendKeys(name);

            String surName = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='surname']")).sendKeys(surName);

            String maritalStatus = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            Select maritalStatusSelect = new Select(getDriver().findElement(By.xpath("//select[@name='marital_status']")));
            maritalStatusSelect.selectByVisibleText(maritalStatus);

            String birthDay = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            Select birthDaySelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_dd']")));
            birthDaySelect.selectByValue(String.valueOf(birthDay));

            String birthMonth = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            Select birthMonthSelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_mm']")));
            birthMonthSelect.selectByValue(birthMonth);

            String birthYear = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            Select birthYearSelect = new Select(getDriver().findElement(By.xpath("//select[@name='date_of_birth_yyyy']")));
            birthYearSelect.selectByValue(birthYear);

            String email = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='email_address']")).sendKeys(email);

            String phoneNumber = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.xpath("//input[@name='home_telephone_single_input']")).sendKeys(phoneNumber);

            String postCode = sheet.getRow(Shaggy).getCell(cell++).getStringCellValue();
            getDriver().findElement(By.id("postcodeID")).sendKeys(postCode);
        }

        getDriver().findElement(By.xpath("//a[@onkeypress='PostcodeSubmitOnEnterKeyPet(event);']")).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='found_address_id']/option[2]"))).click();

        getQuote();
    }

    public void fillLegalForm() {
        getDriver().findElement(By.xpath("//span[@class='floatLeft4px' and text()='No']")).click();
        getDriver().findElement(By.xpath("//span[@class='floatLeft4px' and text()='Email']")).click();
        getDriver().findElement(By.id("nextButton")).click();
    }

    private void getQuote() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("nextButton")));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", getDriver().findElement(By.id("nextButton")));
    }
}
