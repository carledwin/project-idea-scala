package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 //Expression
  println(x)

  println(2 + 3 * 4) //expression comparison
  //+ - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x) // expression validation (boolean)
  // == != > >= < <=

  println(!(1 == x)) // expression logic
  // ! && ||

  var a = 2
  a += 3 //expression increment
  // also works with -= *= /= side effects

  //Instructions(To Do) vs Expressions(Value)

  //If expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }// never write this again, do not use while loops in Scala code

  var f = 0
  val aWhile = while(f < 10) {
    println(f)
    f += 1
  }
  println("f" + aWhile)

  //everything in Scala is an Expression!

  var aValriable = 0
  val aWeirdValue = (aValriable = 3) //Unit === void
  println(aWeirdValue)

  //side effects: println(), whiles, reassigning

  //Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye" //it's the return of the block the last line, in this case is a string of the expression
  }
  println(aCodeBlock)

  //return true or false
  val someValue = {
   2 < 3
  }
  println(someValue)

  //return 42
  val someOtherValue = {
    if(someValue) 223 else 9887
    42
  }
  println(someOtherValue)

  val stringHello = "string hello world" //returns a string and it's the value of string
  println(stringHello)

  //has a side effect
  val printlnFunction = println("string hello world") // returns Unit and it's an expression
  println("Result of printlnFunction --> " + printlnFunction)
}
