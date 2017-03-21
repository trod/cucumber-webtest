package com.github.trod.webtest.stepdefinitions

import com.github.trod.webtest.pages.{HomePage, LoginPage}
import com.github.trod.webtest.support.LoginTestHelper
import cucumber.api.Scenario
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

class LoginSteps extends ScalaDsl with EN with Matchers {
  After("@login") { scenario: Scenario =>
    LoginPage.close
  }

  Given( """^Web site is opened""") { () =>
    LoginPage.open
    LoginPage.isVisible shouldBe true
  }

  When( """User types (valid|invalid) email""") { (isValidEmail: String) =>
    isValidEmail match {
      case "valid" => LoginPage.inputEmail(LoginTestHelper.getRandomValidEmail)
    }
  }

  When( """^Click (Enter|RegisterWithEmail) button""") { (button: String) =>
    button match {
      case "Enter" | "enter" => LoginPage.clickEnter
      case "RegisterWithEmail" => LoginPage.clickRegisterWithEmail
    }
  }

  When( """User types (valid|invalid) password""") { (isValidPassword: String) =>
    isValidPassword match {
      case "valid" => LoginPage.inputPassword(LoginTestHelper.getValidPassword)
      case "invalid" => LoginPage.inputPassword(LoginTestHelper.getInvalidPassword)
    }
  }

  Then( """^User gets home page""") { () =>
    HomePage.isVisible shouldBe true
  }
}
