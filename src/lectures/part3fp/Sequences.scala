package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  //Seq similar to general Interface for data structures that

  val aSequence = Seq(1,2,3,4)
  println(aSequence)//List
  println(aSequence.reverse)
  val index = 2
  println("Index 2" + aSequence(index))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  val aSequence2 = Seq(3,45,7,8,1,90,13)
  println(aSequence2.sorted)

  //Ranges
  println("Range To")
  val aRange: Seq[Int] = 1 to 10
  println("aRange: " + aRange)
  println("Seq foreach: ")
  aRange.foreach(print)
  println("Range Until")
  val aRangeUntil: Seq[Int] = 1 until 10//10 no inclusive
  aRangeUntil.foreach(print)

  println("Recursive function to print n times to _: ")
  (1 to 10).foreach(x => println("Hello: " + _))
  println("Recursive function to print n times toString: ")
  (1 to 10).foreach(x => println("Hello: " + x.toString))

  //List (LinearSeq is immutable linked list)
  val aList = List(1,2,3)
  println("List " + aList)

  //Sealed - has two subtypes(object Nil(empty) and class ::)
  val prepended = 42 :: aList //add 42 to aList
  println("List " + aList)
  println("Prepended " + prepended)
  val prepended2 = 43 +: aList
  println("Prepended2 " + prepended2)
  val appended = aList :+ 78
  println("Appended " + appended)
  val prependedAndAppended = 42 +: aList :+ 78
  println("Prepende4 " + prependedAndAppended)

  val apples5 = List.fill(5)("Apple")//create a list with fill N times with the value ("Apple")
  println(apples5)

  println("mkString to List, to concatenate the value in param mkString(\"-|-\") for example")
  println(apples5.mkString("-|-"))
  println(apples5.mkString(", "))
  println(aList.mkString("'"))

  //arrays it's equivalent to Java arrays
  println("Array")
  val numbers = Array(1,2,3,4)
  println(numbers)
  println("To access the index 2 of array: " + numbers(2))//to accesses the element array
 numbers.foreach(println)
  val threeElements = Array.ofDim[Int](3)//allocate 3 spaces at the memory in this array with the default values
  threeElements.foreach(println)
  val fiveElementsString  = Array.ofDim[String](5)
  fiveElementsString.foreach(println)

  val twoElementsBoolean = Array.ofDim[Boolean](2)
  twoElementsBoolean.foreach(println)

  //mutation
  println("numbers(1): " + numbers(1))
  println(numbers.mkString(" "))
  numbers.update(1, 500) // update element
  println("numbers(1) now is: " + numbers(1))
  println("numbers(2): " + numbers(2))
  numbers(2) = 320 // update element syntax sugar for numbers
  println(numbers.mkString(" "))
  println("numbers(2) now is: " + numbers(2))

  //arrays and seq
  println("Array and Seq")
  val numbersSeq: Seq[Int] = numbers //implicit conversion to WrappedArray
  println(numbersSeq)

  //Vector - the default implementation for immutable sequences
  println("Vector")

  val vectorNoElements = Vector.empty
  println("Vector without elements")
  println(vectorNoElements)

  var vectorNumbers = vectorNoElements :+1 :+2 :+3
  println("Vector with elements")
  vectorNumbers.foreach(println)
  println("using function updated(0, 100) to update the value of index 0 of vector")
  vectorNumbers = vectorNumbers updated(0, 100)
  println("vectorNumbers")
  vectorNumbers.foreach(println)

  val vectorNumbers2 = vectorNoElements :+1 :+2 :+3
  println("Vector with elements")
  vectorNumbers2.foreach(println)
  val modifiedVector = vectorNumbers2 updated(0, 300)
  //vectorNumbers2 = vectorNumbers updated(0, 100) // isn't works because the object is val instead var
  println("vectorNumbers2")
  vectorNumbers2.foreach(println)
  println("modifiedVector")
  modifiedVector.foreach(println)

  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  //vector vs list

    val maxRuns = 1000
    val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    //for comprehension
    val times = for {
      it <- 1 to maxRuns
    }yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      //operation
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  //keeps reference to tail
  //updating an element int the middle takes long
  println("executing getWriteTime to List:  " + getWriteTime(numbersList))
  //depth of the tree is smaill
  //needs to replace an entire 32-element chunk
  println("executing getWriteTime to Vector:  " + getWriteTime(numbersVector))
}
