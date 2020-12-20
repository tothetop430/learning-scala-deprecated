package lectures.part1basics

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name : " + x)
  }

  println(calledByValue(System.nanoTime()))
  println(calledByName(System.nanoTime()))

  def infinite(): Int = 1 + infinite()
  def anotherCallByName(x: Int, y: => Int): Unit = println(x)

//  anotherCallByName(infinite(), 34)
  anotherCallByName(34, infinite())
}