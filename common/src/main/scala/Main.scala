import scala.util.Properties

object Main extends App {
  assert(
    Properties.envOrNone("MEANING_OF_LIFE").contains("42-common")
  )
}
