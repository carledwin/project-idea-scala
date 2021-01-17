package lectures.part3fp

object TuplesAndMaps extends App {

  //tuples is finite ordered "lists"
  val aTuple2 = new Tuple2[Int, String](2, "Hello, Scala")
  println(aTuple2)
  val aTuple2_2 = new Tuple2(2, "Hello, Scala") //syntax sugar
  println(aTuple2_2)
  val aTuple2_3 = Tuple2(2, "Hello, Scala") //syntax sugar
  println(aTuple2_3)
  val aTuple2_4 = (2, "Hello, Scala") //syntax sugar
  println(aTuple2_4)

  val aTupleHelloScala = (2, "Hello, Scala")
  println(aTupleHelloScala)

  //acesses elements _1 and _2
  println(aTupleHelloScala._1)
  println(aTupleHelloScala._2)

  //copy
  val aTupleGoodByeJava = aTupleHelloScala.copy(_2 = "Goodbye Java")
  println(aTupleGoodByeJava)

  //swap (troca)
  println(aTupleGoodByeJava.swap)//(Goodbye Java, 2)

  //Maps - keys -> values --> maps are immutable
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("Jim", 554543), ("Ana", 1000821))//tuple (a, b)
  println("First " + phonebook)
  //Map arrow function
  val phonebookArrowFunction = Map("Jim"-> 554543, "Ana" -> 1000821) //syntax sugar tuple (a -> b)
  println(phonebookArrowFunction)

  //basic map operations
  println(phonebook.contains("Jim"))
  println(phonebook.contains("Jima"))

  //to get a element by key and return a value
  println(phonebook("Jim"))
  //println(phonebook("Jima"))//It returns a exception NoSuchElementException, because key not found, not exist

  //map returns a default value
  val phonebookWithDefaultValue = Map(("Jim" -> 33333), ("Mary" -> 99088)).withDefaultValue(-1)
  println(phonebookWithDefaultValue.contains("Jim"))
  println(phonebookWithDefaultValue("Jim"))
  println(phonebookWithDefaultValue("jim"))

  //add a pairing
  println(phonebook)
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(phonebook)
  println(newPhonebook)

  //functions on maps
  //map, flatMap, filter

  //lowerCase with arrow function
  println("LowerCase with .map: " + phonebook.map(pair => pair._1.toLowerCase -> pair._2))
  println("upperCase with .map: " + phonebook.map(pair => pair._1.toUpperCase -> pair._2))

  //multiplication
  println("Multiplication with .map: " + phonebook.map(pair => pair._1 -> pair._2 * 2))

  //division
  println("Division with .map: " + phonebook.map(pair => pair._1 -> pair._2 / 2))

  //subtraction
  println("Subtraction with .map: " + phonebook.map(pair => pair._1 -> (pair._2 - 555000)))

  //addition
  println("Addition with .map: " + phonebook.map(pair => pair._1 -> (pair._2 + 1)))

  //filterKeys
  //filterKeys with lambda
  println("FilterKeys with lambda: " + phonebook.filterKeys(x => x.startsWith("J")))

  //filterKeys with arrow function
  println("FilterKeys with arrow function: " + phonebook.filterKeys(_.startsWith("J"))) //syntax sugar

  //mapValues to alter the values on map
  println("Phonebook: " + phonebook)
  println("Phonebook number: " + phonebook.mapValues(number => number))
  println("Phonebook number * 15: " + phonebook.mapValues(number => number * 15))
  println("Phonebook include a prefix to number: " + phonebook.mapValues(number => "(+5511) " + number))

  //conversions Map to T (other collections)
  println("Map to List: " + phonebook.toList)
  println("Map to Vector: " + phonebook.toVector)
  println("Map to Array: " + phonebook.toArray)
  println("Map to Seq: " + phonebook.toSeq)
  println("Map to Iterable: " + phonebook.toIterable)
  println("Map to Iterator: " + phonebook.toIterator)
  println("Map to Stream: " + phonebook.toStream)
  println("Map to String: " + phonebook.toString)

  //conversion Other collections to Map
  println("List to Map: " + List("Lim" -> 4232).toMap)

  //groupBy
  //It create a Map with the first Letter from name and group by letter creating a list of the letter
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println("GroupBy from charAt(0)/ from the first letter of name: " + names.groupBy(name => name.charAt(0)))

  val namesGroupedByFirstLetter = names.groupBy(name => name.charAt(0))
  println(namesGroupedByFirstLetter)
  println("All keys")
  namesGroupedByFirstLetter.map(_._1).foreach(println)
  println("All values toList by key return all lists by letter")
  namesGroupedByFirstLetter.map(key => key._2).foreach(println)


  //exercises
  /*

  1. what would happen if I had two original entries "Jim -> 555 and "JIM" -> 900?
  2. Overly simplified network based on maps
    Person = String
      - add a person to the network
      - remove
      - friend (mutual)
      - unfriend

      - number of friends of a person
      - person with most friends
      - how many people have NO friends
      - if there is a social connection between two people (direct or not)
   */


}
