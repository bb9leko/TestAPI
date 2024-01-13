package br.com.example.testapi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class HelloSelenium {

    @Test
    public void hello() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\leano\\Projetos\\java\\TestAPI\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.g1.com.br");
        driver.navigate().to("https://www.g1.com.br");
        driver.quit();
    }

}
