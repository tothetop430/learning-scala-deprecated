package lectures.part3fp

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  def nTimes(f: Int => Int, n: Int): (Int => Int) = {
    if (n<=0) (x: Int) => x
    else (x: Int) => nTimes(f, n-1)(f(x))
  }

  val plus1: Int => Int = (x: Int) => x+1
  val plus10 = nTimes(plus1, 10)

  println(plus10(2))

  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => (x + y)
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: Double => String = curriedFormatter("%4.2f")
  val preciseFormat: Double => String = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

}
