package lectures.part4pm

object AllThePatterns extends App {

  val x: Any = "Scala"
  val constants = x match {
    case 1 => "one"
    case "Scala" => "Scala"
    case true => "True"
    case AllThePatterns => "All The Patterns SingleTon Object"
  }

  val matchAnything = x match {
    case _ =>
  }

  val matchAnythin2 = x match {
    case something => s"It is $something"
  }

  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 2) => "Its a match"
    case _ => "no"
  }

  val matchATuple2 = aTuple match {
    case (something, 2) => "Its a match"
    case _ => "no"
  }

  println(matchATuple)
  println(matchATuple2)
}
