package lectures.part3fp

object HOFAndCurries extends App {

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n<=0) x
    else nTimes(f, n-1, f(x))
  }

  def someUtility(x: Int): Int = x * 2

  println(nTimes(someUtility, 10, 2))
}
