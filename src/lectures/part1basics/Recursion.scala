package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def aFactorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - first we need to compute factorial of " + (n-1))
      val result: Int = n * aFactorial(n-1)
      println("Computed factorial of " + n)

      result
    }

  println(aFactorial(4))

  def anotherFact(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if (x <= 1) acc
      else factHelper(x-1, x*acc)
    }
    factHelper(n, 1)
  }

  println(anotherFact(20000))
}
