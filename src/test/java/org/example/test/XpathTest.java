package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // ChromeDriver yolunu ayarlayın
        System.setProperty("webdriver.chrome.driver", "src/main/java/org/example/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        // options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        // Page Load Timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 0)

    public void ClickTest(){
        driver.get("https://demoqa.com/elements");

        WebElement buttons = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttons.click();
    }

    @Test(priority = 1)

    public void ClickMebutton(){

        WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
        click.click();

        WebElement message = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        Assert.assertEquals(message.getText(),"You have done a dynamic click");


}
    @Test(priority = 2)
    public void AddButton(){
        driver.get("https://demoqa.com/webtables");
        WebElement add = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        add.click();

    }
    @Test(priority = 3)

    public void FormTitleShown(){
        WebElement formTitle = driver.findElement(By.xpath("//div[@id='registration-form-modal']"));

        Assert.assertTrue(formTitle.isDisplayed());
        Assert.assertEquals(formTitle.getText(), "Registration Form");
    }
    @Test(priority = 4)

    public void FillForm(){

        WebElement firstname = driver.findElement((By.xpath("//input[@id='firstName']")));
        firstname.click();
        firstname.sendKeys("Beyza");

        WebElement Lastname = driver.findElement((By.xpath("//input[@id='lastName']")));
        Lastname.click();
        Lastname.sendKeys("Test");

        WebElement Email = driver.findElement((By.xpath("//input[@id='userEmail']")));
        Email.click();
        Email.sendKeys("test@gmail.com");

        WebElement Age = driver.findElement(By.xpath(("//input[@id='age']")));
        Age.click();
        Age.sendKeys("30");

        WebElement Salary = driver.findElement(By.xpath(("//input[@id='salary']")));
        Salary.click();
        Salary.sendKeys("25000");

        WebElement Department = driver.findElement((By.xpath("//input[@id='department']")));
        Department.click();
        Department.sendKeys("Yazılım");
    }

    @Test(priority = 5)
    public void SubmitForm(){
        WebElement Submit = driver.findElement((By.xpath("//button[@id='submit']")));
        Submit.click();
}
    @Test(priority = 6)
    public void EditRecord(){
        WebElement Edit = driver.findElement((By.xpath("//span[@title='Edit']")));
        Edit.click();
}
    @Test(priority = 7)
    public void EditEmail(){
        WebElement Email = driver.findElement((By.xpath("//input[@id='userEmail']")));
        Email.clear();
        Email.sendKeys("beyza@mail.com");

        WebElement Submit = driver.findElement((By.xpath("//button[@id='submit']")));
        Submit.click();

}
    @Test(priority = 8)
    public void CheckEmail(){
        WebElement controlemail = driver.findElement(By.xpath("//div[@class='rt-td'][text()='beyza@mail.com']"));
        Assert.assertEquals("beyza@mail.com", controlemail.getText());
    }

}


