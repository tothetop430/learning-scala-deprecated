package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(2, 7))
  println(str.split(" ").toList)
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val numStr: String = "10"
  println(numStr.toInt)
  println('a' +: numStr :+ 'b')
  println('a' + numStr + 'b')

  println(str.take(4))
  println(str.reverse)
  println(str.startsWith("I"))


  // String Interpolators

  val name = "Sid"
  val age = 24
  val greeting = s"Hello, I am $name and I am ${age + 1} years old"
  println(greeting)

  val speed = 1.2f
  println(f"$name can eat $speed%2.2f burgers per minute")

  println(raw"My name is \n Sid")
  val something = "My name is \n Sid"
  println(raw"$something")
}
