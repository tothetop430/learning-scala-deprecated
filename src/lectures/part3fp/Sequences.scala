package lectures.part3fp

import scala.util.Random

object Sequences extends App {
  val aSeq = Seq(1,2,3,4)
  println(aSeq)

  println(aSeq.reverse)
  println(aSeq(2))
  println(aSeq ++ Seq(5,6,7))
  println(Seq(7,2,8,1).sorted)

  val aRange: Range = 1 until 10
  aRange.foreach(println)
//  (1 to 100).foreach(x => println("Its a Range"))

  println(List.fill(10)(0))
  println(10 +: aSeq :+ 11)

  //Arrays
  val numbers = Array(1,2,3,4)
  val numbers3 = Array.ofDim[Int](3)
  println(numbers.mkString(" "))
  numbers3.foreach(println)
  numbers(2) = 0
  val arraySeq: Seq[Int] = numbers
  println(arraySeq)

  //Vector
  val aVec: Vector[Int] = Vector(1,2,3,4)
  println(aVec)

  // Perf Test

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      nt <- 1 to maxRuns
    } yield {
      val currTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currTime
    }

    times.sum * 1.0/maxRuns
  }

  val perfList: List[Int] = (1 to maxCapacity).toList
  val perfVector: Vector[Int] = (1 to maxCapacity).toVector

//  println(getWriteTime(perfList))
//  println(getWriteTime(perfVector))

  val a = List(1,2,3)
  println(a :+ a(1))
}
