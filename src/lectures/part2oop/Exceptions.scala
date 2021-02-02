package lectures.part2oop

object Exceptions extends App {

//  val something: String = throw new NullPointerException

  def catchExp(someExp: Boolean): Int = {
    if (someExp) throw new RuntimeException("No Int For You")
    else 42
  }

  val someVal = try {
    catchExp(false)
  } catch {
    case e: RuntimeException => {10}
    case a: NullPointerException => {println("null")}
  } finally {
    println("Moving out finally")
  }

  println(someVal)

  // Exercises

  // OutOfMemoryError

//  val array = Array.ofDim(Int.MaxValue)

  // SOError
//  def infinite: Int = 1 + infinite
//
//  val something = infinite

  class OverflowExceptions extends RuntimeException
  class UnderflowExceptions extends RuntimeException
  class MathCalculationException extends RuntimeException("Division By Zero")

  class PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowExceptions
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowExceptions
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowExceptions
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowExceptions
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowExceptions
      else if (x < 0 && y < 0 && result < 0) throw new OverflowExceptions
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowExceptions
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowExceptions
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }


}
