package lectures.part4pm

//everywhere-toda a parte / 't o d o' lugar
object PatternsEverywhere extends App {

  //big idea #1
  try{
  //code
  }catch{
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  /* catches are actually MATCHES
  *
   try{
  //code
  }catch{
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }
  */

  //big ide #2
  val list = List(1,2,3,4)
  //even-até, evenOne-até mesmo um
  val evenOnes = for{
    x <- list if x % 2 == 0 // ?!
    //yield-produção/produz
  }yield 10 * x

  //generators are also based on PATTERN MATCHING
  val tuples = List((1,2), (3,4))
  val ilterTuples = for {
    (first, second) <- tuples
  }yield first * second
  //case classes, :: operators, ...

  //big ide #3
  val tuple = (1,2,3)
  val (a,b,c) = tuple

  println(b)
  //multiple value definitions based on PATTERN MATCHING
  //ALL THE POWER

  val head :: tail = list

  println(head)
  println(tail)

  //big idea #4 - NEW
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even-é mesmo"
    case 1 => "the one"
    case _ => "something else"
  }//partial function literal

  //It's equivalent to mappingList
  val mappedList2 = list.map { x => x match {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
    }
  }

  println(list)
  println(mappedList)
  println(mappedList2)
}

