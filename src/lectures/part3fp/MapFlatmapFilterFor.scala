package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + " Hello"))

  println(list.filter(_ % 2 == 0))
  println(list.filter(_ % 2 != 0))

  val flat = (x: Int) => List(x, x+1)
  println(list.flatMap(flat))

  // print all combinations
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  // List("a1", "a2", ..., "d4")
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)
  val reverseCombinations = chars.flatMap(c => numbers.map(n => "" + c + n))
  println(reverseCombinations)

  list.foreach(println)

  // for comprehension

  val forCombinations = for {
    n <- numbers
    c <- chars
  } yield "" + c + n

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  list.map {
    x => x + 2
  }
}
