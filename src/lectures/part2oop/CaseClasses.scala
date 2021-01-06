package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
    1 - the parameters are fields
    2 - sensible toString
   */
  case class Person3(name: String, age: Int)

  //don't declare the param with val to use(to access) later
  val jim = new Person3("Jim", 34)
  println(jim.name)
  println(jim.toString)
  //syntactic sugar
  println(jim)
  //equals and hashCode implemented OOTB
  val jim2 = new Person3("Jim", 34)
  println(jim==jim2)

  //CC have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  /*CCs have companion objects, doesn't need of default constructor declared to create
    a object with a default constructor
   */
  val thePerson = Person3
  println(thePerson)
  val mary = Person3("Mary", 27)

  // CCs are serializable
  //AKKa

  //CCs have extractor patterns = CCs can be used in PATTERN MATCHING
  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }

}
