package exercises

object OOBasicsEx extends App {

  val writer = new Writer("Sid", "Chan", 1997)
  val imposter = new Writer("Sid", "Chan", 1997)
  val writer2 = new Writer("Abhi", "Chan", 2000)
  println(writer.fullName())

  val novel1 = new Novel("Python", 2022, writer)
  println(novel1.authorAge())
  println(novel1.isWrittenBy(imposter))
  println(novel1.copy(2024).authorAge())

  val counter = new Counter
  counter.inc.getCurrCount
  counter.getCurrCount
  counter.inc(5).getCurrCount

}

class Writer(fname: String, lname: String, dob: Int) {

  def fullName(): String = s"$fname $lname"

  def getDOB(): Int = dob
}

class Novel(name: String, yor: Int, author: Writer) {

  def getAuthName(): String = author.fullName()

  def authorAge(): Int = yor - author.getDOB()

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def  copy(newYOR: Int): Novel = new Novel(name, newYOR, author)

}

class Counter(val someVal: Int = 0) {

  def inc = {
    println("Incrementing")
    new Counter(someVal + 1)
  }

  def dec = {
    println("Decrementing")
    new Counter(someVal - 1)
  }

  def inc(someOtherVal: Int): Counter = {
    if (someOtherVal <= 0) this
    else inc.inc(someOtherVal-1)
  }

  def dec(someOtherVal: Int): Counter = {
    if (someOtherVal <= 0) this
    else dec.dec(someOtherVal - 1)
  }

  def getCurrCount = println(someVal)
}