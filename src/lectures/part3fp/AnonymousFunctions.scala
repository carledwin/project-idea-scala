package lectures.part3fp

object AnonymousFunctions extends App {

  /*val doubler: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }*/

  //arrow function(função de seta) --->>> anonymous function (LAMBDA)
  //val doubler: Int => Int = (v1: Int) => v1 * 2
  //val doubler = (v1: Int) => v1 * 2
  //if the type of return declared we can type a small function
  val doubler: Int => Int = v1 => v1 * 2

  //multiple params in lambda (arrow function)
  /*val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }*/
  //we use a (v1, v2) when we have many parameters
  val adder: (Int, Int) => Int = (v1, v2) => v1 + v2

  /* no parameters - arrow function
    return: () => Int
    result: =
    function: () => 3
   */
  val justDoSomething:() => Int = () => 3
  //careful
  println(justDoSomething) //(function itself) return the INSTANCE of the object-LAMBDA
  println(justDoSomething()) //(calling the function) return the value

  //curly braces with lambdas {}
  val stringToInt = { (str: String) =>
    str.toInt
  }

  /*
    MOAR syntactic sugar
    Incrementer
   */
  //val niceIncrementer: Int => Int = (v1: Int) => v1 + 1
  //  '(v1: Int) => v1 + 1' equivalent to '_' ---> we replaced the param to _
  // you can't use the '_' multiple times to represents a same param in a same expression(function)
  val niceIncrementer: Int => Int = _ + 1

  //Adder with arrow function
  //val niceAdder: (Int, Int) => Int = (v1: Int, v2: Int) => v1 + v2
  //'(v1: Int, v2: Int) => v1 + v2 ' equivalent to ' _ + _ ' ---> we replaced the params to _ + _
  val niceAdder: (Int, Int) => Int = _ + _

  /* PLEASE DON'T DO IT
    : (Int, Int) => Int
    *** if you remove the type of return the compiler won't know  which underscore means ***
    it isn't works
   */
  //val niceAdder = _ + _

  //elegant and sugar function with multiples calls
  val superAdd = (x: Int) => (y: Int) => x + y
  println("SuperAdd: " + superAdd(3)(4))

}
