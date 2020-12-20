package playground

import scala.annotation.tailrec

object ScalaPlayground extends App {
  println("Hello, Scala Playground")

  // Tail recursive string concatenation
  def concatenateStrings(text: String, n: Int): String = {
    @tailrec
    def csHelper(temp: String, x: Int, acc: String): String = {
      if (x <= 0) acc
      else csHelper(temp, x-1, acc+temp)
    }
    csHelper(text, n, "")
  }
  println("concatenateStrings tail recursive")
  println(concatenateStrings("Hello", 3000))

  // IsPrime tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def ipHelper(x: Int, isPrimeUntil: Boolean): Boolean = {
      if (!isPrimeUntil) false
      else if (x <= 1) true
      else ipHelper(x - 1, n % x != 0 && isPrimeUntil)
    }
    ipHelper(n/2, true)
  }

  println("isPrime tail recursive")
  println(isPrime(97643317))

  // Fibonacci Tail Recursive
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboHelper(x: Int, f: Int, s: Int): Int = {
      if (x<=2) s
      else fiboHelper(x-1, s, f+s)
    }

    fiboHelper(n, 1, 1)
  }

  println("fibonacci tail recursive")
  println(fibonacci(3))

}
