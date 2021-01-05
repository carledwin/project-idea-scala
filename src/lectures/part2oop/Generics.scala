package lectures.part2oop

object Generics extends App {

  //generic class
  class MyMap[Key, Value]

  class MyList[A]{
    //use the type A
  }

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /*
  1 - yes List[Cat] extends List[Animal] = COVARIANCE
  [+A] - means a covariant list
   */
  class CoVariantList[+A]
  val animal: Animal = new Cat
  val animalList: CoVariantList[Animal] = new CoVariantList[Cat]//it's works same isn't directly an Animal [type]
  //animalList.add(new Dog)

  class CoVariantMyList[+A]{
    def add[B >: A](element: B): CoVariantMyList[B] = ???
    /*
      A = Cat
      B = Animal
     */
  }
  val coVariantMyList: CoVariantMyList[Animal] = new CoVariantMyList[Cat]

  //2 - No INVARIANCE
  class InVariantList[A]
  val inVariantList: InVariantList[Animal] = new InVariantList[Animal]
  /*val inVariantListCat: InVariantList[Animal] = new InVariantList[Cat] //it isn't works because should be
  the same [type]
   */

  /*3 - Hell, no! CONTRAVARIANCE [-A]
    A subType/subclass can receive a superType/superclass
   */
  class ContraVariantList[-A]
  val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  /*bounded(limited) types
    the class only accepts type parameters which are subtypes/subclass of Animal or ITSELF
    [A <: Animal]
    [SUBCLASS or ITSELF]
   */

  /*bound SUBTYPE/SUBCLASS [A <: SUPERTYPE]
  bounded to receive only subtypes of Animal
   */
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  //val newCarCage = new Cage(new Car)
  /* will return an excpetion: inferred type arguments 'Car' do not conform to class Cage's type parameter bounds
  [A <: Animal]
  Car is not a type of Animal
   */

  class Cage2[A <: Animal] //gaiola
  //val cage2: Cage[Cat] = new Cage[Animal] //it isnt't works because the Cage class only support Cat class
  //val cage2: Cage[Animal] = new Cage[Dog] // it also not works because are diferent types super with sub class
  val cage2Cat: Cage2[Cat] = new Cage2[Cat]
  val cage2Dog: Cage2[Dog] = new Cage2[Dog]
  val cage2Animal: Cage2[Animal] = new Cage2[Animal]


  /*bound SUBTYPE/SUBCLASS [A >: SUBTYPE]
  bounded to receive only SUPERTYPE of Animal
   */



}
