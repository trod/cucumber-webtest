package com.github.trod.webtest.support

import com.typesafe.config.ConfigFactory

/**
 * Created by boris.wainberg on 20/03/17.
 */
trait TestConfig {
  val config = ConfigFactory.load

  object CommonSettings {
    val baseUrl = config.getString("common.baseUrl")
    val port = config.getInt("common.port")
    val isHeadless = config.getBoolean("common.isHeadless")
  }

  object LoginSettings {
    val registeredEmail = config.getString("login.registeredEmail")
    val validPassword = config.getString("login.validPassword")
    val invalidPassword = config.getString("login.invalidPassword")
  }

}