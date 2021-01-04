package lectures.part2oop

object InheritanceAndTraits extends App {


  //constructor
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  class Animal {
    val creatureType = "wild"
    protected def eat = println("nomnom")
    final def drink = println("Water")
    def sleep = println("At night")
  }

  class Cat extends Animal {
    //eat - ins't accessible because when is protected, in then needs to be called through another internal method
    def crunch = {
      eat //isn't accessible outside this class
      println("crunch crunch")
    }
  }

  val cat = new Cat

  //ins't accessible even inheritance
  //cat eat
  cat crunch


  //overriding
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat = println("crunch, crunch")
  }


  val dog = new Dog
    dog.eat
    println(dog creatureType)

  val cat2 = new Cat
  println(cat2 creatureType)

  //overriding in constructor
  //preventing overrides
  // 1- use final on member
  // 2 - use final on the entire(all the members of class can't be override) class
  // 3 - (sealed) the class = extend classes in THIS FILE, prevent extension in other files
  class Pig(override val creatureType: String) extends Animal{
    //override def drink = println("Juice") can't do it because is the final method
    override def sleep = {
      //calling the super
      super.sleep
      print (" and ")
      println("In the morning")
    }
  }
  final class Aircraft

  //Illegal inheritance because the super class is final
  //class Rotorcraft extends Aircraft

  //you can extends this class in this file
  sealed class Truck
  class Tractor extends Truck


  val pig = new Pig("K9")
  println(pig.creatureType)

  class Horse(horseType: String) extends Animal{
    override val creatureType: String = horseType
  }

  val horse = new Horse("k10")
  println(horse.creatureType)

  //type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Pig("K12")
  unknownAnimal.drink
  unknownAnimal.sleep

  val known: Pig = new Pig("K12")
  known.drink
  known.sleep

  //overRIDING vs overLOADING

  //super
  println("Super")
  unknownAnimal.sleep




}
