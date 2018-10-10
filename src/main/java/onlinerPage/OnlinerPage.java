package onlinerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlinerPage {
    public WebDriver webDriver;

    @BeforeSuite
    public void startChrome() {
        System.out.println("Запускаем браузер");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\small dick boy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.onliner.by/");
    }

    @AfterSuite
    public void quit() {
        System.out.println("Закрываем браузер");
        webDriver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        WebElement clickKatalog=webDriver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/header/div[2]/div/nav/ul[1]/li[1]/a/span"));
        clickKatalog.click();
        WebElement clickElektronika=webDriver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/ul/li[2]"));
        clickElektronika.click();
        WebElement clickGajet=webDriver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/div[6]/div[1]"));
        clickGajet.click();
       Thread.sleep(3000);
        WebElement clickTovar=webDriver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/div[6]/div[2]/div/a[4]/span/span[2]"));
        clickTovar.click();
        Thread.sleep(3000);
        WebElement clickSonyTovar=webDriver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[1]/div[3]/div[2]/ul/li[1]/label/span[1]/span"));
        clickSonyTovar.click();
        Thread.sleep(3000);
        List<WebElement> actual = webDriver.findElements(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/h1"));
        ArrayList<String> expected = new ArrayList<String>(
                Arrays.asList("Очки виртуальной реальности"));
        List<String> errors = new ArrayList<String>();
        for (int i=0; i<actual.size(); i++){
            if (!actual.get(i).getText().equals(expected.get(i))){
                errors.add(expected.get(i));
            }
        }

        if (errors.size()>0) throw new RuntimeException();
    }

}
