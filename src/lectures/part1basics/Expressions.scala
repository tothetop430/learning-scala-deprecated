package lectures.part1basics

object Expressions extends App {
  val x = 1+2
  println(x)

  println(1+2*3)

  // + - * / & | ^ << >> >>>

  println(1 == 2)

  var y = 1
  y += 1
  println(y)
  y -= 1
  println(y)
  y *= 1
  println(y)
  y /= 1
  println(y)

  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3) // similar to println(5) or println(1+2), just evaluates an expression

  // For loops, discourage its use in functional programming

  var i = 0
  val aWhile = while (i<10) {
    println(i)
    i += 1
  }
  println(aWhile)
  //UNIT
  var aVar = 1
  val aWeirdValue = (aVar = 2)
  println(aWeirdValue)
  println(aVar)

  val aCodeBlock = {
    val z = 2
    val y = z+1

    if(y>z) "Hello" else "Scala"
  }

  println(aCodeBlock)

  val aCodeB = {
     println(3)
  }
  println(aCodeB)
}
