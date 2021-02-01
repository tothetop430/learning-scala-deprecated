package lectures.part2oop

object Objects extends App {
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(moth: Person, fath: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    def getName: String = name
  }


  println(Person.N_EYES)
  println(Person.canFly)

  val mary = Person
  val joe = Person

  println(mary == joe)

  val a = new Person("a")
  val b = new Person("b")

  println(a == b)

  val bob = Person(a, b)

  println(bob.getName)
}

// Below code is same as above, but without extends App statement hence needed def main
/*
object SomeObject {
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(moth: Person, fath: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    def getName: String = name
  }
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    val mary = Person
    val joe = Person

    println(mary == joe)

    val a = new Person("a")
    val b = new Person("b")

    println(a == b)

    val bob = Person(a, b)

    println(bob.getName)

  }
}

*/