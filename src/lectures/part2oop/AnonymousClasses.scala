package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val animal = new Animal {
    override def eat: Unit = ???
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal{
    override def eat: Unit = println("ahahahahhahahhah")
  }
  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahhahahhah")
  }
  val funnyAnimal: Animal = new Anonymousclasses$$anon$1
   */

  val funnyAnimal2: Animal = new Animal{
    override def eat: Unit = println("ahahahahhahahhah")
  }

  println(animal.getClass)
  println(funnyAnimal.getClass)
  println(funnyAnimal2.getClass)

  /*console $$anon$1, $$anon$2 and $$anon$3
      class lectures.part2oop.AnonymousClasses$$anon$1
      class lectures.part2oop.AnonymousClasses$$anon$2
      class lectures.part2oop.AnonymousClasses$$anon$3
   */

  class Person(val name: String){
    def sayHi: Unit = print(s"Hi, my name is $name, how can I help?")
  }

  /*anonymous class
    can instantiate types and override fields or methods on the spot
   */
  val jim = new Person("Jim"){
    override def sayHi: Unit = print(s"Hi, my name is $name, how can I be of service?")
  }

  println((new Person("Person")).sayHi)
  println(jim.sayHi)

  trait Clothes{
    val hasPocket: Boolean
    val hasSleeve: Boolean
    val hasCollar: Boolean
    val hasLegs: Boolean
    val quantityButton: Int
    val cloth: String
    def itsIndicatedto: String
  }

  val shirt = new Clothes {
    override val hasPocket: Boolean = true
    override val hasSleeve: Boolean = true
    override val hasCollar: Boolean = true
    override val hasLegs: Boolean = false
    override val quantityButton: Int = 8
    override val cloth: String = "Cotton"
    override def itsIndicatedto: String = ???
  }

  val pants = new Clothes {
    override val hasPocket: Boolean = true
    override val hasSleeve: Boolean = false
    override val hasCollar: Boolean = false
    override val hasLegs: Boolean = true
    override val quantityButton: Int = 1
    override val cloth: String = "Jeans"
    override def itsIndicatedto: String = ???
  }


}
