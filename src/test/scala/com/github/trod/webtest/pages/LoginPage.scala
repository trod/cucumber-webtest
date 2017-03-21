package com.github.trod.webtest.pages

import com.github.trod.webtest.support.{TestConfig, TestHelper}
import cucumber.api.scala.ScalaDsl
import org.openqa.selenium.By
import org.scalatest.Matchers

object LoginPage extends BasePage with TestConfig with ScalaDsl with Matchers {
  val driver = TestHelper.getWebDriver
  val emailFieldSelector = "input[id~=email]"
  // TODO Dev ticket required: Enter button needs proper automation id
  val enterBtnSelector = ".buttons-wrapper button[value~=submit]"
  val passwordFieldLocator = "input#password"

  def open: Unit = {
    driver.get(CommonSettings.baseUrl)
    driver.getCurrentUrl should startWith(CommonSettings.baseUrl)
  }

  def close: Unit = {
    driver.quit()
  }

  def isVisible: Boolean = {
    TestHelper.waitForByCSS(emailFieldSelector)
    driver.findElement(By.cssSelector(emailFieldSelector)).isDisplayed
  }

  def inputEmail(email: String): Unit = {
    TestHelper.waitForByCSS(emailFieldSelector)
    driver.findElement(By.cssSelector(emailFieldSelector)).sendKeys(email)
  }

  def clickRegisterWithEmail = {
    clickEnter
  }

  def clickEnter = {
    TestHelper.waitForByCSS(enterBtnSelector)
    driver.findElement(By.cssSelector(enterBtnSelector)).click()
  }

  def inputPassword(password: String): Unit = {
    TestHelper.waitForByCSS(passwordFieldLocator)
    driver.findElement(By.cssSelector(passwordFieldLocator)).sendKeys(password)
  }
}
