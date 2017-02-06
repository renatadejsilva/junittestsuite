package junitpack;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EditTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.firefox.marionette","driver/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "http://acesso.paripassu.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEditTestCase() throws Exception {
    driver.get(baseUrl);
	driver.findElement(By.id("usuario")).clear();
    driver.findElement(By.id("usuario")).sendKeys("redej.silva@gmail.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("q1w2e3r4");
    driver.findElement(By.id("submit-login")).click();
    driver.findElement(By.id("sistemaComAcesso_54")).click();
    driver.findElement(By.linkText("Aplicação de questionário")).click();
    driver.findElement(By.linkText("Listar aplicações de questionário")).click();
    driver.findElement(By.xpath("//body[@id='webBody']/div/div/div[3]/div/div/div/div[4]/div/table/tbody/tr/td[9]/button[2]")).click();
    driver.findElement(By.xpath("//textarea[@type='text']")).clear();
    driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Teste - editado");
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).sendKeys("editado@gmail.com");
    driver.findElement(By.xpath("//body[@id='webBody']/div/div/div[3]/div/div/div/div[2]/form/div[4]/div/div/a[2]/i")).click();
    driver.findElement(By.xpath("//textarea[@type='text']")).clear();
    driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Teste - editado");
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).sendKeys("Teste - editado");
    driver.findElement(By.xpath("(//textarea[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//textarea[@type='text'])[3]")).sendKeys("Teste - editado");
    driver.findElement(By.xpath("(//a[contains(text(),'Salvar')])[3]")).click();
    driver.findElement(By.xpath("//body[@id='webBody']/div/div/div[3]/div/div/div/div[4]/div/table/tbody/tr/td[9]/button[2]")).click();
    Assert.assertEquals("Teste - editado", driver.findElement(By.xpath("//textarea[@type='text']")).getAttribute("value"));    
    Assert.assertEquals("editado@gmail.com", driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).getAttribute("value"));
    driver.findElement(By.xpath("//body[@id='webBody']/div/div/div[3]/div/div/div/div[2]/form/div[4]/div/div/a[2]")).click();
    Assert.assertEquals("Teste - editado", driver.findElement(By.xpath("//textarea[@type='text']")).getAttribute("value"));
    Assert.assertEquals("Teste - editado", driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).getAttribute("value"));
    Assert.assertEquals("Teste - editado", driver.findElement(By.xpath("(//textarea[@type='text'])[3]")).getAttribute("value"));    
    driver.findElement(By.cssSelector("a.mb-sm.btn.btn-default.ng-binding")).click();
    driver.findElement(By.id("dropdownMenu2")).click();
    driver.findElement(By.linkText("Sair")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
