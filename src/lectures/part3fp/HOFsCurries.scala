package lectures.part3fp

import scala.annotation.tailrec

//Higher Order Functions
object HOFsCurries extends App {

  //val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???

  /* examples of HOF
    map, flatMap, filter, in MyList
   */


  /* function that applies a function n times over a value x
    nTimes(f, n, x) //f- function, n - times applies, subobject

    example
    nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
    nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
   */
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if(n <= 0) x
    else nTimes(f, n-1, f(x))

  //this function receive a Int and return an Int, in then it is Int => Int
  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  /* ntb(f, n) = x => f(f(f....(x)))
    increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
    val y = increment10(1)
   */
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if(n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

   /*
   print only the name of instance
   println(nTimesBetter(plusOne, 10))
    */

    //It needs be used like this
    val increment10 = nTimesBetter(plusOne, 10)
    println(increment10(1))

    //curried function
    val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
    val superAdder1 = (x: Int) => (y: Int) => x + y
    val superAdder2: Int => Int => Int = (x: Int) => (y: Int) => x + y
    val superAdder3: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

    val add1 = superAdder1(1)
    val add2 = superAdder1(1)
    val add3 = superAdder1(1)
    val add4 = superAdder1(3)

    println(add1(10))
    println(add2(10))
    println(add3(10))
    println(add3(10))

    println(superAdder(1)(10))
    println(superAdder(3)(10))
    println(superAdder(5)(10))

    //functions with multiple parameter lists
    def curriedFormatter(c: String) (x: Double): String = c.format(x)
    val standardFormat: (Double => String) = curriedFormatter("%4.2f")
    val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

    println(standardFormat(50d))
    println(standardFormat(35.455d))
    println(standardFormat(Math.PI))

    println(preciseFormat(50d))
    println(preciseFormat(35.45d))
    println(preciseFormat(Math.PI))



}
