package ru.yandex;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    @Test
    public void firstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/Andrey/Desktop/chromedriver.exe"); //местоположение chromedriver
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//полноэкранный режим браузера Google Chrome
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://passport.yandex.ru/auth");//получение ссылки для ввода логина

        driver.findElement(By.id("passp-field-login")).sendKeys("koryakina.marina2018");//ввод логина
        driver.findElement(By.id("passp-field-login")).sendKeys(Keys.RETURN);//нажатие Enter(переход к вводу пароля)


        driver.findElement(By.id("passp-field-passwd")).sendKeys("qwerty1324");//ввод пароля
        driver.findElement(By.id("passp-field-passwd")).sendKeys(Keys.RETURN);//нажатие Enter(вход в Яндекс.Паспорт)


        driver.findElement(By.cssSelector("#root > div > div.dheader > div.dheader-user > div > div > a.user-account.user-account_has-accent-letter_yes.user-account_has-ticker_yes.user2__current-account")).click();
        //нажатие на e-mail

        driver.findElement(By.cssSelector("body > div.popup2.popup2_view_classic.popup2_theme_normal.popup2_direction_bottom-right.popup2_visible_yes.popup2_target_anchor.user2__popup > ul > ul > li:nth-child(1) > a")).click();
        //нажатие для перехода в Яндекс.Почту из Яндекс.Паспорта

        driver.findElement(By.className("mail-ComposeButton-Text")).click();
        //нажатие кнопки "Написать"

        driver.findElement(By.className("composeYabbles")).sendKeys("korjakin21@yandex.ru");
        //заполнения поля "Кому"

        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/div[3]/form/div/div/input")).sendKeys("QA");
        //заполнение поля "Тема"

        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/div/div")).sendKeys("Обеспечение качества");
        //Заполнение поля "Напишите что-нибудь"

        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div[1]/button")).click();//нажатие кнопки "Отправить"
        Thread.sleep(5000);
        //Сообщение отправлено

        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[6]/div/div[3]/div[2]/div[3]/div/div[1]/div[1]/a[2]/span")).click();//открытие вкладки "Отправленные"
        Thread.sleep(10000);
        //Просмотр отправленных сообщений

        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[6]/div/div[2]/div/div/header/div/div[5]/div[2]/a[1]/div/img")).click();
        //нажатие на e-mail

        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[6]/div/div[2]/div/div/header/div/div[5]/div[2]/div/ul/ul/li[5]/a/span")).click();
        //выход из аккаунта

        driver.quit();
    }
}
