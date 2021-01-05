package lectures.part2oop

object AbstractDataTypesAndHierarchy extends App {

  //abstract - can't be instantiated
  //abstract classes can have both abstract and non abstract members
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  //can't be instantiated because is abstract
  //val animal = new Animal

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  //trait - Similar to Interface
  //can't have constructor parameter
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  //with - similar to implements
  class Crocodile extends Animal with Carnivore with ColdBlooded{
    override val creatureType: String = "Croc"
    override def eat: Unit = println("nomnomnom")
    override def eat(animal: Animal): Unit = println(s"I'm a crocodile and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  /*traits vs abstract classes
  1- traits do not have constructor parameters
  2- the class can extends only one class
  3 - you can mix in multiple traits right (with) - multiple traits may be inherited by the same class
  4 - traits = behavior represents/describe behavior of things, abstract class = "thing" represents/describe things
   */


}
