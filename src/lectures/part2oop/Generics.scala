package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???

    /*
    A = Cat
    B = Dog == Animal; so B = Animal

     */
  }
  class MyMap[Key, Value]

  val IntMyList = new MyList[Int]
  val StringMyList = new MyList[String]
  val IntMyMap = new MyMap[Int, String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInt = MyList.empty[Int]

  // Variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Covariant List
  class CovList[+A]

  val animal: Animal = new Cat
  val animalList: CovList[Animal] = new CovList[Cat]

  // animalList.add(new Dog) ??? can be done using bounded type syntax, returning list of Animal

  // Invariant List

  class InvariantList[A]

  val animalList2: InvariantList[Animal] = new InvariantList[Animal]

  // Contravariant List
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)

  val cage: Cage[Dog] = new Cage(new Dog)

//  class newCar
//  val newCage = new Cage(new newCar)



}
