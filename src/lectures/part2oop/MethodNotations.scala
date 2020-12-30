package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favMovie: String) {
    def likes(anotherMovie: String): Boolean = anotherMovie == favMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isActive: Boolean = true
    def apply(): String = s"Hi, i am $name and i like $favMovie"
  }

  val sid = new Person("Sid", "Your Name")
  val abhi = new Person("Abhi", "Inception")
  println(sid.likes("Your Name"))
  println(sid likes "Your Name") // infix notation
  println(sid.hangOutWith(abhi))
  println(sid hangOutWith abhi)

  println(1 + 2)
  println(1.+(2))

  val x = -1
  val y = 1.unary_-
  println(x == y)

  println(!sid)
  println(sid.unary_!)

  println(sid.isActive)

  println(sid.apply())
  println(sid())

}
