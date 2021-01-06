package lectures.part3fp

object WhatsAFunction extends App {

  /* DREAM: use functions as first class elements
    problem: OOP
   */

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  //function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3") + 4)

  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  val adder1 = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //aero function
  val adder2: ((Int, Int) => Int) = new ((Int, Int) => Int) {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //syntactic sugar
  val adder3 = new ((Int, Int) => Int) {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  //Function types Function2[A, B, R] == (A, B) => R
  //ALL SCALA FUNCTIONS ARE *** OBJECTS ****
  //higher-order functions receive or returns a function

  /*
    1. a function which takes 2 strings and concatenate them
    2. transform the MyPredicate and MyTransform into function types
    3. define a function which takes an int and returns another function which takes
    an int and returns an int
      - what's the type of this function
      - how to do it
   */

  //aero function
  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello ", "Scala"))

  //Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new  Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val adder4 = superAdder(3)
  println(adder4(4))
  println(superAdder(3)(4))//curried function


}

  trait MyFunction[A, B] {
    def apply(element: A): B
  }
