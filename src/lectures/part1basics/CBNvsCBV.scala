package lectures.part1basics

object CBNvsCBV extends App {

  //Get the value passed by param
  def calledByValue(x: Long): Unit ={
    println("by value: " + x)
    println("by value: " + x)
  }

  //Call the function each time at the function because it's received the name of function
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)
  printFirst(34, infinite())
}
