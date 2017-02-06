package junitpack;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaveAndFinishTestCase {
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
  public void testSaveAndFinishTestCase() throws Exception {
    driver.get(baseUrl);
	driver.findElement(By.id("usuario")).clear();
    driver.findElement(By.id("usuario")).sendKeys("redej.silva@gmail.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("q1w2e3r4");
    driver.findElement(By.id("submit-login")).click();
    driver.findElement(By.id("sistemaComAcesso_54")).click();
    driver.findElement(By.linkText("Aplicação de questionário")).click();
    driver.findElement(By.linkText("Nova aplicação de questionário")).click();
    driver.findElement(By.cssSelector("a.list-group-item")).click();
    driver.findElement(By.cssSelector("a.list-group-item.list-group-item-buttom")).click();
    driver.findElement(By.xpath("//textarea[@type='text']")).clear();
    driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Renata de Jesus Silva");
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).sendKeys("redej.silva@gmail.com");
    driver.findElement(By.xpath("//body[@id='webBody']/div/div/div[3]/div/div/div/div[2]/form/div[4]/div/div/a[2]")).click();
    driver.findElement(By.xpath("//textarea[@type='text']")).clear();
    driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("Gosto de estar sempre aprendendo coisas novas e trabalhar na Paripassu como QA vai exigir bastante isso de mim. \nCertamente a Paripassu me proporcionará novos desafios e, com a bagagem que tenho até aqui e meu esforço, serei capaz de atingir meus objetivos e contribuir no meu crescimento e no da empresa.");
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).sendKeys("Quero atuar nesta área pois acredito que o trabalho do QA na empresa é extramente importante e fundamental, não só na etapa da entrega do produto, mas também durante todo o processo de desenvolvimento. O sistema que será entregue ao cliente deve ser cuidadosamente testado e estar de acordo com os requisitos pré definidos. \nPara mim, a qualidade do sistema vai além do \"está  funcionando\". Gosto de seguir normas e rotinas a fim de garantir que o produto será entregue de forma consistente, intuitivo e padronizado.");
    driver.findElement(By.xpath("(//textarea[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//textarea[@type='text'])[3]")).sendKeys("Quando me deparo com um problema, primeiramente tento manter a calma. Depois, tento resolvê-lo com recursos que estão ao meu alcance. Entretanto, quando não consigo solucioná-lo, compartilho com meus colegas de trabalho.\nAlém disso, se estou com alguma dificuldade, tento analisar o motivo de isso ter ocorrido, para evitar que aconteça novamente. Tem ocasião que lido com a dificuldade como uma grande possibilidade de crescimento e desenvolvimento.");  
    driver.findElement(By.xpath("(//a[contains(text(),'Salvar e finalizar')])[2]")).click();
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
