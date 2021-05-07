package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val desc = x match {
    case 1 => "It is one"
    case 2 => "It is two"
    case 3 => "It is three"
    case _ => "It is another value"
  }

  println(x)
  println(desc)

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if (a <= 20) => "I am underage"
    case Person(n, a) => s"Hi, I am $n and am $a years old."
    case _ => "I don't know who I am"
  }
  println(greeting)

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Cat(breed: String) extends Animal

  val animal: Animal = Dog("Nova")
  animal match {
    case Dog(somebreed) => s"Some $somebreed of Dog"
  }

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Product(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Product(e1, e2) => {
      def maybeParantheses(exp: Expr) = exp match {
        case Product(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeParantheses(e1) + " * " + maybeParantheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Product(Sum(Number(2), Number(3)), Number(4))))
  println(show(Product(Sum(Number(2), Number(3)), Sum(Number(4), Number(5)))))
  println(show(Sum(Product(Number(2), Number(3)), Number(4))))
}
