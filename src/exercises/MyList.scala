package exercises

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString(): String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  // foreach
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](l: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, EmptyList)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = EmptyList
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = EmptyList
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = EmptyList

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = EmptyList
  def zipWith[B, C](l: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if(!l.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else EmptyList
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons(h, t ++ list)
  }

  // transformer for this [n, n+1]
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, EmptyList)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](l: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (l.isEmpty) throw new RuntimeException("Empty List can not be zipped with List with elements")
    else new Cons(zip(h, l.head), t.zipWith(l.tail, zip))
  }

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

object Run extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, EmptyList)))
  val clonelist = new Cons(1, new Cons(2, new Cons(3, EmptyList)))
  val listStr = new Cons("Hello", new Cons("Scala", EmptyList))

  println(list.toString())
  println(listStr.toString())


  println(list.map({
    x => x * 2
  }).toString())

  println(list.filter({
    x => x % 2 == 0}).toString())

  println(list.++(new Cons(4, EmptyList)).toString())

  println(list.flatMap({
    x => new Cons(x, new Cons(x+1, EmptyList))
  }).toString())

  println(clonelist == list)

  list.foreach(x => println(x))   // == list.foreach(println)
  println(list.sort((x, y) => y - x))
  println(list.zipWith[Int, Int](clonelist, (x, y) => x*y))
  println(list.fold(0)((x, y) => x + y))
}
