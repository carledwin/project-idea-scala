package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  //@tailrec isn't works
  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else {
      println("Computing factorial of " + n + "I first need factorial of " + (n -1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))
  // println(factorial(5000)) --> StackOverFlow

  //return a BigInt to use number 5000..
  def anohterFactorial(n: Int): BigInt = {
    @tailrec //to see if will works
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x-1, x * accumulator) //tail recursion = use recursive call as the last expression

    factHelper(n, 1)
  }

  /*
   *anotherFactorial(10) = factorialHelper(10,1)
   * = factorHelper(9, 10 * 1)
   * = factorHelper(8, 9 * 10 * 1)
   * = factorHelper(7, 8 * 9 * 10 * 1)
   * = factorHelper(6, 7 * 8 * 9 * 10 * 1)
   * = factorHelper(5, 6 * 7 * 8 * 9 * 10 * 1)
   * =  ...
   * = factorHelper(2, 3 * 4 * 5, ... * 9 * 10 * 1)
   * = factorHelper(1, 2 * 3 * 4 .... * 10)
   * = 1, 2 * 3 * 4 .... * 10
   */

  println(anohterFactorial(10))
  //println(anohterFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
  * Concatenate a String n times
  * IsPrime function tail recursive
  * Fibonacci function, tail recursive
  * */

  def concatenateString(message: String, times: Int): BigInt = {
    @tailrec
    def concatenateHelper(message: String, times:Int, accumulator: BigInt): BigInt =
    if(times <= 1) accumulator
    else {
      print(message)
      concatenateHelper(message, times - 1,times * accumulator)
    }

    concatenateHelper(message, times, 10)
  }
  println(concatenateString("Hello ", 10))

  @tailrec
  def anotherConcatenateString(aString: String, times: Int, accumulator: String): String = {
    if(times <= 0)accumulator
    else anotherConcatenateString(aString, times - 1, aString + accumulator)
  }
  println(anotherConcatenateString("Hi ", 3, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t:Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <=1) true
      else isPrimeHelper(t - 1, n % t != 0 && isStillPrime)

      isPrimeHelper(n / 2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))
  println(isPrime(5))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fibonacciTailrec(i + 1, last + nextToLast, last)

    if(n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }
  println("Fibonacci: " + fibonacci(4)) // 1 1 2 3 5 8 13 21 34
}
