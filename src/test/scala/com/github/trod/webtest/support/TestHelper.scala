package com.github.trod.webtest.support

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest.selenium.{Chrome, HtmlUnit}

object TestHelper extends TestConfig {
  // TODO this stuff would be nice to move to build.sbt
  def chromeDriver = if (System.getProperty("os.name").startsWith("Windows")) "drivers/chromedriver.exe" else "drivers/chromedriver"

  System.setProperty("webdriver.chrome.driver", s"src/test/resources/${chromeDriver}")
  private implicit val driver = if (CommonSettings.isHeadless) new HeadlessDriver else new ChromeDriver

  def getWebDriver = driver.webDriver

  //TODO: need to implement generic isDisplayed
  def isDisplayedByCSS(locator: String): Boolean = {
    getWebDriver.findElement(By.cssSelector(locator)).isDisplayed
  }

  //TODO: need to implement generic waitFor
  def waitForByCSS(locator: String): Unit = {
    val wait: WebDriverWait = new WebDriverWait(getWebDriver, 30)
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)))
  }
}

class HeadlessDriver extends HtmlUnit {}

class ChromeDriver extends Chrome {}
