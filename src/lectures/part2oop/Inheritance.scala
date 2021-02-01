package lectures.part2oop

object Inheritance extends App {

  class Animal {

    def eat = println("nomnom")
  }

  class Cat extends Animal {

    def crunch = {
      eat
      println("munch munch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: Int) extends Person(name, age) // or Person(name) if age is fixed, use this method then.

  // overriding
  class Dog extends Animal {
    override def eat: Unit = println("Dog Eat")
    def supereat: Unit = println(super.eat)
  }

  val dog = new Dog
  println(dog.eat)
  println(dog.supereat)

  // type substitution -> polymorphism

  val someAnimal: Animal = new Dog
  someAnimal.eat
}
