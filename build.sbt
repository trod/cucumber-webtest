import sbt.Keys._
name := "web-test"

version := "1.0"

val scalaV = "2.11.1"

organization := "com.github.trod"

val restAssuredV = "3.0.2"
val cucumberV = "1.2.4"
val scalatestV = "3.0.1"
val configV = "1.2.1"
val json4sV = "3.2.11"
val SeleniumV = "2.35.0"

def chromeDriver = if (System.getProperty("os.name").startsWith("Windows")) "chromedriver.exe" else "chromedriver"

TaskKey[Unit]("hello") := println("-Dwebdriver.chrome.driver=" + (baseDirectory.value / "src/test/resources" / chromeDriver).getAbsolutePath)



lazy val main = project.in(file("."))
  .settings(scalaVersion := scalaV)
  .settings(fork := true)
  .settings(javaOptions in Test += "-Dwebdriver.chrome.driver=" + (baseDirectory.value / "src/test/resources" / chromeDriver).getAbsolutePath)
  .settings(libraryDependencies ++= Seq(
    "info.cukes" % "cucumber-core" % cucumberV % "test",
    "info.cukes" %% "cucumber-scala" % cucumberV % "test",
    "info.cukes" % "cucumber-jvm" % cucumberV % "test",
    "info.cukes" % "cucumber-junit" % cucumberV % "test",
    "info.cukes" % "cucumber-core" % cucumberV % "test",
    "com.typesafe" % "config" % configV % "test",
    "org.scalatest" %% "scalatest" % scalatestV % "test",
    "org.scalactic" %% "scalactic" % scalatestV % "test",
    "org.seleniumhq.selenium" % "selenium-java" % SeleniumV % "test"
  ))



enablePlugins(CucumberPlugin)
CucumberPlugin.glue := "com/github/trod/webtest/"
