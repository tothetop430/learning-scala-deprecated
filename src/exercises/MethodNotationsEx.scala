package exercises

object MethodNotationsEx extends App {

  class Person(val name: String, favMovie: String, val age: Int = 10) {

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favMovie)

    def unary_+ : Person = new Person(name, favMovie, age+1)

    def learns(something: String): String = s"$name learns $something"

    def learnsScala: String = this learns "Scala"

    def apply(n: Int): String = s"$name watched $favMovie $n times"
  }

  val sid = new Person("Sid", "Kimi no Nawa", 24)

  val nsid = sid + "Paaji"
  val msid = +sid
  println(nsid.name)
  println(msid.age)
  println(sid.learnsScala)
  println(sid(4))
  println(sid.name)
  println(sid.age)

}
