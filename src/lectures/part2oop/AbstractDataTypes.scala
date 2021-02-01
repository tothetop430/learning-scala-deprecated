package lectures.part2oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

//  val animal = new Animal

  class Dog extends Animal {
    val creatureType: String = "Doge"
    def eat: Unit = println("crunch crunch")
  }

  val doge = new Dog

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class anotherAnimal extends Animal with Carnivore {
    val creatureType: String = "Carni"
    def eat: Unit = println("Trying to eat something")
    def eat(animal: Animal): Unit = println(s"I'm a carnivore and I am eating ${animal.creatureType}")
  }

  val lion = new anotherAnimal
  lion.eat
  lion.eat(doge)

}
