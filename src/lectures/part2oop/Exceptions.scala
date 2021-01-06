package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length)
  //this ^^ wil crash with a NPE

  /*throwing and catching exceptions
    throwable classes extend the Throwable class
    Exception and Error are the MAJOR  Throwable subtypes
   */

  //throwing Exceptions
  //val aWeirdValue: String = throw new NullPointerException

  //how to catch exceptions

  def getInt(withException: Boolean): Int = {
    if(withException) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail =  try{
    //code tha might throw
    getInt(false)
  }catch {
    case e: RuntimeException => val error = "caught a Runtime exception"
      println(error)
      error
  }finally{
    /* code tha will get executed NO MATTER WHAT
    finally is optional, does not influence the return type of this expression,
    use finally only for side effects
     */
    println("finally")
  }
  println("Execution 1: " + potentialFail)

  /* how to define your own exceptions */
  class MyException extends Exception
  val exception = new MyException
  //throw exception

  //throw exception
  /*
  * 1 - Crash your program with an OutOfMemoryError
  * 2 - Crash wit SOError
  * 3 - PocketCalculator
  *     -add(x,y)
  *     -subtract(x,y)
  *     -multiply(x,y)
  *
  *     Throw
  *       -OverflowException if add(x,y) Int.MAX_VALUE
  *       -UnderflowException if substract(x,y) exceeds int.MIN_VALUE
  *       -MatchcalculationExcption for division by 0
  * */

  //OOM - OutOfMemory
  //val array = Array.ofDim(Int.MaxValue)

  //SO - StackOverflow
  def infinitive: Int = 1 + infinitive
  //val noLimit = infinitive

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException

  //object because we don't want to instantiate PocketCalculator, we only want to execute it's methods
  object PocketCalculator {

    def add(x: Int, y: Int): Int = {
      var result = x + y
        if (x>0 && y>0 && result<0) throw new OverflowException
        else if (x<0 && y<0 && result>0) throw new OverflowException
        else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x>0 && y<0 && result<0) throw new OverflowException
      else if (x<0 && y>0 && result>0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int ={
     val result = x * y
      if (x>0 && y>0 && result<0) throw new OverflowException
      else if (x<0 && y<0 && result<0) throw new OverflowException
      else if (x>0 && y<0 && result>0) throw new UnderflowException
      else if (x<0 && y>0 && result>0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Double = {
      if(y == 0) throw new MathCalculationException
      x / y
    }
  }
  println(Int.MaxValue)
  println(Int.MinValue)
  //print(5/0)

  //OverflowException
  // println(PocketCalculator.add(Int.MaxValue, 10))
  //MatchCalculationException
  println(PocketCalculator.divide(2,0))
}
