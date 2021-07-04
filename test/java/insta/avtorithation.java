package insta;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class avtorithation {
    private static WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/java/resouce/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to( "https://www.instagram.com/");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
    }

    @Test
    public void test02(){
        inputLogin("testacsabina");
        inputPassword("alfabank");


        List<String> myfriends = Arrays.asList("/html/body/div[1]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/a/div/div[2]","/html/body/div[1]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[2]/a/div","/html/body/div[1]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[3]");

        for (int i = 0; i < myfriends.size(); i++) {
            System.out.println(myfriends.get(i));
        }
        for (String temp : myfriends) {
            WebElement findFriend = driver.findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[2]/input"));
            findFriend.sendKeys(Keys.BACK_SPACE);
            findFriend.sendKeys("b");
            WebElement friend1 = driver.findElement(By.xpath(temp));
            friend1.click();
            WebElement picture1 = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div[3]/article/div[1]/div/div[1]/div[1]"));
            picture1.click();
            WebElement like= driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/article/div[3]/section[1]/span[1]/button/div/span"));
            like.click();
            WebElement x = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));
            x.click();
            WebElement podp = driver.findElement(By.xpath("/html/body/div[1]/section/main/div/header/section/div[1]/div[2]/div/div/div/span/span[1]/button"));
            podp.click();

        }
    }

    @AfterTest
    public void tearDown(){
        //driver.close();
        //driver.quit();
    }
    //@FindBy(xpath = "/html/body/div[1]/div/div/section/main/div/div[1]/div/div[1]/div[2]")
    //private WebElement InstaLogin;

    public void inputLogin(String login){
        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys(login);
    }
    public void inputPassword(String pass_word){
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys(pass_word);
        password.sendKeys(Keys.ENTER);
    }



}