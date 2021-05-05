package lectures.part3fp

object TuplesAndMaps extends App {

  val aTuple = (2, "Hello Scala")   // Tuple2(2, "Hello Scala") = (Int, String) = Tuple2[Int, String]

  println(aTuple._1)
  println(aTuple.copy(_2 = "Super Python"))
  println(aTuple.swap)

  val aMap: Map[String, Int] = Map()

  val phoneBook = Map("abc" -> 123, "def" -> 456).withDefaultValue(-1)
  println(phoneBook)

  println(phoneBook.contains("abc"))
  println(phoneBook("abc"))

  val newPair = "Hello" -> 789
  val newphoneBook = phoneBook + newPair
  println(newphoneBook)
  println(phoneBook + Tuple2("scala", 110))

  println(phoneBook.map( pair => pair._1.toUpperCase -> pair._2))

  println(phoneBook.view.filterKeys(x => x.startsWith("a")).toMap)

  println(phoneBook.view.mapValues(x => x * 10).toMap)

  //conversions

  println(phoneBook.toList)
  println(List(("abc", 123)).toMap)

  val someList = List("Abhishek", "Anmol", "Aayush", "Siddharth", "Shashank", "Yash")
  println(someList.groupBy(x => x.startsWith("A")))
}
