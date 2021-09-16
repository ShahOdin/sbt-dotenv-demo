import scala.util.Properties

class AcceptanceTest extends munit.FunSuite {
  test("common acceptance tests") {
    assertEquals(
      Properties.envOrNone("MEANING_OF_LIFE"), Some("42-common-at")
    )
  }
}
