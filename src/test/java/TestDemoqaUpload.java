import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.time.Duration;
import java.io.File;

public class TestDemoqaUpload {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options =new ChromeOptions();
//        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/upload-download");
        File uploadFile = new File("src/test/1.jpg");

        WebElement upLoadButton =driver.findElement(By.id("uploadFile"));
        upLoadButton.sendKeys(uploadFile.getAbsolutePath());

        WebElement uploadMes=driver.findElement(By.id("uploadedFilePath"));
        Assert.assertEquals(uploadMes.getText(),"C:\\fakepath\\1.jpg");
        System.out.println(uploadMes.getText());
        driver.close();
    }
}