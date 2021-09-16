sbtVersion := "1.5.5"

scalaVersion := "2.13.6"

lazy val IntegrationTest = config("it") extend Test
lazy val AcceptanceTest = config("at") extend Test

val dependencies = Seq(
  "org.scalameta" %% "munit" % "0.7.29" % Test
)

lazy val common = project
  .in(file("common"))
  .configs(IntegrationTest)
  .settings(inConfig(IntegrationTest)(Defaults.testSettings): _*)
  .configs(AcceptanceTest)
  .settings(inConfig(AcceptanceTest)(Defaults.testSettings): _*)
  .settings(
    libraryDependencies ++= dependencies
  )
  .settings(
    inConfig(Test)(
      inThisBuild(envFileName := "meta/common.env")
    )
  )
  .settings(
    inConfig(IntegrationTest)(
      inThisBuild(
        envFileName := "meta/common.it.env"
      )
    )
  )
  .settings(
    inConfig(AcceptanceTest)(
      Seq(
        envFileName := "meta/common.at.env"
      )
    )
  )

lazy val foo = project
  .in(file("foo"))
  .dependsOn(common)

lazy val bar = project
  .in(file("bar"))
  .dependsOn(common)

lazy val root = project
  .in(file("foobar"))
  .aggregate(common, foo, bar)
