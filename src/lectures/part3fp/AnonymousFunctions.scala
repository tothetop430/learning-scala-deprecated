package lectures.part3fp

object AnonymousFunctions extends App {

  val someFunc: Int => Int = x => x*2

  val adder: (Int, Int) => Int = (a, b) => a+b

  println(adder(1, 2))

  val noArgsFunc: () => Int = () => 3
  println(noArgsFunc)
  println(noArgsFunc())

  val curlyFunc = {
    (str: String) =>
      "Hello " + str
  }

  println(curlyFunc("Scala"))

  // MOAR Syntactic Sugar
  val otherFunc: Int => Int = _ + 1 // x => x + 1
  val otherAdded: (Int, Int) => Int = _ + _ // (a, b) => a + b



}
