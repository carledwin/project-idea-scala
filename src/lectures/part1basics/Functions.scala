package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction)

  def aReapeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aReapeatedFunction(aString, n-1)
  }

  println(aReapeatedFunction("hello", 7))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("E aeee")

  //when you need loops, use recursion

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  aBigFunction(10)

  def aBigFunctionPrint(n: Int): Int = {
    def aSmallerFunctionPrint(a: Int, b: Int): Int = {
      val result = a + b
      println(result)
      result
    }

    aSmallerFunctionPrint(n, n-1)
  }
  aBigFunctionPrint(10)

  /*
  * 1. A greeting function (name, age) -> "Hi, my name is $name and I am $age years old.
  * 2. Factorial function 1 * 2 * 3 * ..... * n
  * 3. A Fibonacci function
  *    f(1) = 1
  *    f(2) = 1
  *    f(n) = f(n -1) + f(n -2)
  * 4. Tests if a number is prime.
  * */

  def greeting(name:String, age:Int): String = {
    s"""Hi, my name is ${name} and I am ${age} years old.}"""
  }
  println(greeting("Carl Edwin", 37))

  def factorial(n: Int): Int ={
    if(n <= 0) 1
    else n * factorial(n-1)
  }
  val number = 5
  print("\n \nThe factorial of number " + number +" is: " + factorial(number))

  def fibonacci(n: Int): Int = {
    if(n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }
  val positionOnFibonacci = 6
  print("\n\nThe position " + positionOnFibonacci + " in Fibonacci has the value: "
    + fibonacci(positionOnFibonacci))

  def isPrime(num: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else num % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(num / 2)
  }

  def executePrime(num: Int): Unit ={
    val primeNum = num
    println("\n\n Is the number " + primeNum + " a prime? --> " + isPrime(primeNum))
  }

  executePrime(5)
  executePrime(37)
  executePrime(2003)
  executePrime(37 + 17)




}
