package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int) = {
    a + " " + b
  }
  println(aFunction("Hello", 3))

  def aParameterLessFunction(): Boolean = {
    true
  }
  println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatedFunction(a: String, b: Int): String = {
    if(b==1) a
    else a + " " + b + " " + aRepeatedFunction(a, b-1)
  }

  println(aRepeatedFunction("Hi", 3))

  def aFunctionWithSideEffects(): Unit= println("Hello Side Effect")

  println(aFunctionWithSideEffects())

  def aOuterFunction(a: Int): String = {
    def aInnerFunction(b: Int): String = {
      "Inner" + b
    }

    println(aInnerFunction(a))

    "Outer" + a
  }

  println(aOuterFunction(10))

  // Tasks, Exercises

  // Greeting function
  def aGreetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and i am " + age + " years old."
  }

  // Fibonacci function
  def aFibonacciFunction(n: Int): Int = {
    if (n<=1) 1
    else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)
  }

  // Factorial function
  def aFactorialFunction(n: Int): Int = {
    if (n<=0) 1
    else n * aFactorialFunction(n-1)
  }

  println(aGreetingFunction("Siddharth", 24))
  println(aFibonacciFunction(4))
  println(aFactorialFunction(5))

  // Prime function
  def aPrimeFunction(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t<=1) true
      else (n % t)!=0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n/2)
  }

  println(aPrimeFunction(4))

}
