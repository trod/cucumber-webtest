package com.github.trod.webtest.pages

import com.github.trod.webtest.support.{TestConfig, TestHelper}
import cucumber.api.scala.ScalaDsl
import org.openqa.selenium.By
import org.scalatest.Matchers

object HomePage extends BasePage with TestConfig with ScalaDsl with Matchers {
  val driver = TestHelper.getWebDriver
  val mainContainerSelector = "div.container.container-main"

  def isVisible = {
    TestHelper.waitForByCSS(mainContainerSelector)
    driver.findElement(By.cssSelector(mainContainerSelector)).isDisplayed
  }
}
