import scala.util.Properties

class IntegrationTest extends munit.FunSuite {
  test("common integration tests") {
    assertEquals(
      Properties.envOrNone("MEANING_OF_LIFE"), Some("42-common-it")
    )
  }
}
