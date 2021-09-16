import scala.util.Properties

class UnitTest extends munit.FunSuite {
  test("common unit tests") {
    assertEquals(
      Properties.envOrNone("MEANING_OF_LIFE"), Some("42-common")
    )
  }
}

