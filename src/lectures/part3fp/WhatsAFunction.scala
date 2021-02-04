package lectures.part3fp

object WhatsAFunction extends App {
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val someFunction = new (String => Int) {
    override def apply(v1: String): Int = v1.toInt
  }

  println(someFunction("3") + 4)

  val someOtherFunction = new ((Int, Int) => Int) {
    override def apply(v1: Int, v2: Int): Int = v1 + v2 + 1
  }

  println(someOtherFunction(1, 2))

  // a function that takes 2 strings and concatenate them
  val concatStr = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatStr("Hello", "Scala"))

  // a function that takes int and returns a function that takes int and returns an int

  val someWeirdFunction: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  println(someWeirdFunction(3)(4))
  val x = someWeirdFunction(3)
  println(x(5))

  val otherCurryFunc: Int => Int => Int = {
    x => {
      y => x + y
    }
  }

  println(otherCurryFunc(5)(5))
  val y = otherCurryFunc(5)
  println(y(5))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}