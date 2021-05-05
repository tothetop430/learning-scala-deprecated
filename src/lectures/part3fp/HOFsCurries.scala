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

  /*
  Exercises

  1. Expand MyList
    - foreach method A => Unit
      [1,2,3].foreach(x => println(x))

    - sort function ((A,A) => Int) => MyList
      [1,2,3].sort((x, y) => y - x) => [3,2,1]

    - zipWith(list, (A, A) => B) => MyList[B]
      [1,2,3].zipWith([4,5,6], x*y) => [4, 10, 18]

    - fold(start)(function) => a value
      [1,2,3].fold(0)(x + y) => 6

  2. toCurry(f: (Int => Int) => Int): Int => Int => Int
     fromCurry(f: Int => Int => Int): (Int => Int) => Int

  3. Composition of functions
     compose(f, g) => f(g(x))
     aCompose(f, g) => g(f(x))

   */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[T, A, B](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def aCompose[A, B, T](f: A => B, g: B => T): A => T =
    x => g(f(x))

  val valueAdder: Int => Int => Int = toCurry(_ + _)
  println(valueAdder(2)(3))

  val simpleAdder: (Int, Int) => Int = fromCurry(valueAdder)
  println(simpleAdder(2, 3))

  def add1(x: Int): Int = x + 2
  def mul1(x: Int): Int = x * 3

  println(compose(add1, mul1)(4))
  println(aCompose(add1, mul1)(4))
}
