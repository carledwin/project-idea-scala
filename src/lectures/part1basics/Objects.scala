package lectures.part1basics

import lectures.part2oop.InheritanceAndTraits.Truck

object Objects {

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static)
  //Scala 'object' in a SINGLETON instance
  //Scala object = SINGLETON INSTANCE

  //Scala Applications = Scala object with have to be a main method
  //def main(args: Array[String]): Unit = {}
  //OR extends App
  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    //can't be extends becuase is sealed when can be extended only at the same file
    //class FireEngine extends Truck

    val mary = Person
    val jon = Person

    println(mary == jon)
    println(s"Mary and Jon have the same instance? -> ${mary == jon}")

    val ana = new Person
    val paul = new Person
    println(ana == paul)
    println(s"Ana and Paul have the same instance? -> ${ana == paul}")

    val personObject1 = Person
    val personObject2 = Person
    println(s"PersonObject1 and PersonObject2 have the same instance? -> ${personObject1 == personObject2}")

    val personInstance1 = new Person
    println(s"PersonObject1 and PersonInstance1 have the same instance? -> ${personObject1 == personInstance1}")

    val personInstance2 = new Person
    println(s"PersonInstance1 and PersonInstance2 have the same instance? -> ${personInstance1 == personInstance2}")

    val katy = new Person("Katy")
    val daniel = new Person("Daniel")
    println(s"${katy.name} and ${daniel.name} have the same instance? -> ${katy == daniel}")

    val jerry = new Person("Jerry")
    val jullian = new Person("Jullian")
    val pierry = new Person("Pierry")
    val mandum = new Person("Mandum")

    val bobbie = Person.apply(katy, daniel)
    val bobbie2 = Person(jerry, jullian)
    val bobbie3 = (pierry, mandum)
  }


  //COMPANIONS object and class in the same class
  object Person{ //type + its only instance
    //"static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String){
    //instance-level functionality
    def this() = this("")
  }










}
