package com.github.trod.webtest.support

import scala.util.Random

object LoginTestHelper extends TestConfig {
  def getRandomValidEmail = Random.alphanumeric.take(10).mkString + "@" +
    Random.alphanumeric.take(5).mkString + "." + Random.alphanumeric.take(2).mkString

  def getValidPassword = LoginSettings.validPassword

  def getInvalidPassword = LoginSettings.invalidPassword
}
