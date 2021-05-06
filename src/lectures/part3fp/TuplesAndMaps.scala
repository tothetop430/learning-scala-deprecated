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

  val uniqueBook = Map("Jim" -> 123, "JIM" -> 456)
  println(uniqueBook.map(pair => pair._1.toLowerCase -> pair._2))

  // Social Network

  val socialNetwork: Map[String, Set[String]] = Map()

  def addPerson(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val aFriends = network(a)
    val bFriends = network(b)
    network + (a -> (aFriends + b)) + (b -> (bFriends + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val aFriends = network(a)
    val bFriends = network(b)

    network + (a -> (aFriends - b)) + (b -> (bFriends - a))
  }

  def removePerson(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def unfriendAux(friends: Set[String], auxNetwork: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) auxNetwork
      else unfriendAux(friends.tail, unfriend(auxNetwork, person, friends.head))
    }
    val friends = network(person)
    val unfriendedNetwork = unfriendAux(friends, network)

    unfriendedNetwork - person
  }

  val updatedsocialNetwork = addPerson(addPerson(socialNetwork, "Bob"), "Mary")
  println(updatedsocialNetwork)
  println(friend(updatedsocialNetwork, "Bob", "Mary"))
  println(unfriend(friend(updatedsocialNetwork, "Bob", "Mary"), "Bob", "Mary"))
  println(removePerson(friend(updatedsocialNetwork, "Bob", "Mary"), "Bob"))

  val network = addPerson(addPerson(addPerson(socialNetwork, "Bob"), "Jim"), "Mary")
  val jimBob = friend(network, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def totalFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  println(totalFriends(testNet, "Bob"))
  println(mostFriends(testNet))

  def noFriends(network: Map[String, Set[String]]): Int = {
    network.view.filterKeys(key => network(key).isEmpty).size
    // network.count(pair => pair._2.isEmpty)
  }

  println(noFriends(jimBob))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPersons: Set[String], discoveredPersons: Set[String]): Boolean = {
      if (discoveredPersons.isEmpty) false
      else {
        val newPerson = discoveredPersons.head
        if (newPerson == target) true
        else if (consideredPersons.contains(newPerson)) bfs(target, consideredPersons, discoveredPersons.tail)
        else bfs(target, consideredPersons + newPerson, discoveredPersons.tail ++ network(newPerson))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(jimBob, "Mary", "Jim"))
}
