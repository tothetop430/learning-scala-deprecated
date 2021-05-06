package lectures.part3fp

object Options extends App {

  val someOption: Option[Int] = Some(1)
  val noOption: Option[Int] = None

  println(someOption)
  println(noOption)

  val unsafeMethod: String = null
  val safeMethod: String = "A Safe Method"

  val result1 = Option(unsafeMethod)
  val result2 = Option(safeMethod)

  println(result1)
  println(result2)

  println(Option(unsafeMethod).orElse(Option(safeMethod)))

  // Design APIs

  def betterUnSafeMethod(): Option[String] = None
  def betterSafeMethod(): Option[String] = Some("A Safe Method")

  println(betterUnSafeMethod() orElse betterSafeMethod())

  val option1 = Some()
  val option2 = None
  println(option1.isEmpty)
  println(option2.isEmpty)
}
