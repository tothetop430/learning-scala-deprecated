package lectures.part3fp

import scala.util.Random

object Options extends App {

  val someOption: Option[Int] = Some(1)
  val noOption: Option[Int] = None

  println(someOption)
  println(noOption)

  val unsafeMethod: String = null
  val safeMethod: String = "A Safe Method"

  val result1 = Option(unsafeMethod)
  val result2 = Option(safeMethod)

  println(result1)
  println(result2)

  println(Option(unsafeMethod).orElse(Option(safeMethod)))

  // Design APIs

  def betterUnSafeMethod(): Option[String] = None
  def betterSafeMethod(): Option[String] = Some("A Safe Method")

  println(betterUnSafeMethod() orElse betterSafeMethod())

  val option1 = Some(12)
  val option2 = None
  println(option1.isEmpty)
  println(option2.isEmpty)

  println(option1.get)
  println(option1.map(_ + 2))
  println(option1.filter(_ < 10))
  println(option1.flatMap(x => Option(x * 2)))

  /*
  Exercise
   */

  val config: Map[String, String] = Map(
    "host" -> "127.0.0.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  // try to establish a connection - if so call connect method
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  val connectionStatus = connection.map(x => x.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // 2 Method
  println("2nd method")
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port)))
    .map(connection => connection.connect)
    .foreach(println)

  // 3 Method
  println("3rd method")
  val aConnectStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  println(aConnectStatus)
}
