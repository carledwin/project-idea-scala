package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_+1))
  println(list.map(_+" is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println("One: " + list.flatMap(toPair))
  println("Two: " + list.flatMap((x: Int) => List(x, x+1)))
  println("Three " + list.flatMap((x: Int) => List(x, s" ('${x}'+1) "+x+1)))

  //print all combinations between two list
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  //List("a1", "a2", ...."d4)

  val toConcatenateChN = (num: Int) => chars.map(_+num.toString)
  println("Map Char Number: " + numbers.map(toConcatenateChN))// return one list for each element from the list
  println("FlatMap Char Number: " + numbers.flatMap(toConcatenateChN))// return only one list for all elements

  val toConcatenateNCh = (charr: Char) => numbers.map(charr.toString+_)
  println("Map Number Char: " + chars.map(toConcatenateNCh))//return on list for each element from the list
  println("FlatMap Number Char: " + chars.flatMap(toConcatenateNCh)) // return only one list for all elements

  //OR
  val combinations = numbers.flatMap(num => chars.map(charr => charr.toString + num))
  println("FlatMap and Map in one expression - Combinations: " + combinations)

  val combinations2 = chars.flatMap(charr => numbers.map(num => charr.toString + num))
  println("FlatMap and Map in one expression - Combinations2: " + combinations2)

  //three loops
  val colors = List("black", "white")
  /*
    for the combinations the lists don't need have the same quantity of elements
    notice that now with the new combination we have more elements, so for its
    the list combines:
    1º a + 1 + black
    2º a + 1 + white
    3º a + 2 + black
    .....
    nº d + 4 + black
    nº d + 4 + white
   */
  // "iterating"
  val combinations3 = chars.flatMap(charr => numbers.flatMap(num => colors.map(color => charr.toString + num + "=" + color)))
  println("FlatMap FlatMap Map - one list to three loops - Combinations3: " + combinations3)

  val combinations3FilterPair = chars.flatMap(ch => numbers.filter(n => n % 2 == 0).flatMap(n => colors.map(c => "" + ch + n + "-" + c)))
  println("Filter - Combinations3FilterPair: " + combinations3FilterPair)

  //foreach its similar to map
  //1,2,3
  list.foreach(print)
  list.foreach(println)

  //for-comprehensions
  val forCombinations = for {
    num <- numbers
    charr <- chars
    color <- colors
  } yield "" + charr + num + "-" + color
  println("For-Combinations: " + forCombinations)

  /*
    the declaration order of the lists influences the result
    forCombinations - who controls the order is the numbers
    already in the second case forCombinations2, who controls the list is chars
    because it was the fist element declared in the for-comprehensions
   */
  val forCombinations2 = for {
    charr <- chars
    num <- numbers
    color <- colors
  } yield "" + charr + num + "-" + color
  println("For-Combinations2 : " + forCombinations2)

  val forCombinations3Pair = for {
    charr <- chars
    num <- numbers if num % 2 == 0
    color <- colors
  } yield "" + charr + num + "-" + color
  println("For-Combinations3Pair with filter(if pair number): " + forCombinations3Pair)

  //for
  println("Looping for to numbers")
  for {
    num <- numbers
  }print(num + ",")

  println("\n----------------------------------------\n")

  /*
    syntax overload to Map
    val mapOverloaded = list.map { x =>
      x * 2
    }
   */

  val mapOverloaded = list.map { x =>
    val result = x * 2
    println("map -> " + x + " * 2 = " + result)
    result
  }

  println("Overloaded Map: " + mapOverloaded)

  /*
    1. MyList supports for comprehensions?
    map(f: A => B) =. MyList[A]
    filter(p: A => Boolean) => MyList[B]
    flatMap(f: A => MyList[B]) => MyList[B]
    2. A small collection of at most ONE element - Maybe[+T]
   */
}
