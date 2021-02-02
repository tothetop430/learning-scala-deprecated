package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 36)
  println(jim.name)
  println(jim.toString)
  println(jim)

  val jim2 = new Person("Jim", 37)
  println(jim == jim2)

  val jim3 = jim.copy(age = 45)
  println(jim3)
  println(jim == jim3)

  val jim4 = Person
  val jim5 = Person("Jim", 40)
  println(jim4)
  println(jim5)

  case object AnotherPerson {
    def name: String = "Another Person"
  }
}
