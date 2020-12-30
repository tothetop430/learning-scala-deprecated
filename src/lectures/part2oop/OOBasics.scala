package lectures.part2oop

object OOBasics extends App{

  val person = new Person("Sid", 24)
  println(person.age)
  person.greet("Abhi")
  person.greet()

  val person2 = new Person("Abhi")
  println(person2.age)
}

class Person(name: String, val age: Int = 10) {

  val somea = 4

  println(somea + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, $name")
}