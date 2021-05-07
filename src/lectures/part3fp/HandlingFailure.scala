package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  val aSuccess = Success(10)
  val aFailure = Failure(new RuntimeException("Failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String")
  val tryError = Try(unsafeMethod())
  println(tryError)

  def anotherPotentialError: Try[String] = Try {
    //throw new RuntimeException("Syntax Sugar")
    "Syntax Sugar"
  }
  println(anotherPotentialError)

  def safeMethod = "A Valid result"
  println(Try(unsafeMethod()).orElse(Try(safeMethod)))

  def betterUnsafeMethod: Try[String] = Failure(new RuntimeException("Failure String"))
  def betterSafeMethod: Try[String] = Success("A Valid Result")

  println(betterUnsafeMethod orElse betterSafeMethod)

  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 3)))
  println(aSuccess.filter(_ > 11))

  val host = "localhost"
  val port = "8080"
  def renderHtml(page: String) = println(page)

  class Connection {
    val random = new Random(System.nanoTime())
    def get(url: String): String = {
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection Interrupted")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Http Service Not Responded")
    }
  }

  // if you get html page from connection print it to the console
  println("Http Exercise")
  Try(HttpService.getConnection(host, port))
    .flatMap(connection => Try(connection.get("someurl")))
      .foreach(renderHtml)

  println("For Http Exercise")

  val connect = for {
    connection <- Try(HttpService.getConnection(host, port))
    html <- Try(connection.get("someurl"))
  } renderHtml(html)
}
