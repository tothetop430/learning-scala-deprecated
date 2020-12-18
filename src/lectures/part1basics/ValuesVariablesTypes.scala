package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x = 42
  println(x)

  val aString: String = "Hello"
  val anotherString = "World"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 12344
  val aLong: Long = 123449863498L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  var aVar: Int = 4
  println(aVar)
  aVar = 5
  println(aVar)

}
