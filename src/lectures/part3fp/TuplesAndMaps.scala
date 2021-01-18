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
  !!!! careful with mapping keys

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

  val phonebook2 = Map(("Jim", 600),("JIM", 3335))
  println(phonebook2)
  println(phonebook2.map(x => x._1.toLowerCase()))

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

    def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
      val friendsA = network(a)
      val friendsB = network(b)
      network + (a -> (friendsA + b)) + (b -> (friendsB + a))
    }

    def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
      val friendsA = network(a)
      val friendsB = network(b)
      network + (a -> (friendsA - b)) + (b -> (friendsB - a))
    }

    def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
      def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
        if(friends.isEmpty) networkAcc
        else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

        val unfriended = removeAux(network(person), network)
      unfriended - person
    }

    val empty: Map[String, Set[String]] = Map()
    val network = add(add(empty, "Bob"), "Mary")

  println(network)

  println(friend(network, "Bob", "Mary"))

  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))

  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  //Jim, Bob, Mary
  val people = add(add(add(add(empty, "Bob"), "Mary"), "Jim"),"Kevin")
  println(people)

  val jimBob = friend(people, "Bob", "Jim")
  println(jimBob)

  val maryBob = friend(jimBob, "Bob", "Mary")
  println(maryBob)

  def numberOfFriends(network: Map[String, Set[String]], person: String): Int =
    if(!network.contains(person)) 0
    else network(person).size

  println(numberOfFriends(maryBob, "Bob"))
  println(numberOfFriends(maryBob, "Mary"))
  println(numberOfFriends(maryBob, "Jim"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(network))

  def nPeopleWithNoFriendsFilter(network: Map[String, Set[String]]): Int =
    network.filterKeys(k => network(k).isEmpty).size

  println(nPeopleWithNoFriendsFilter(maryBob))

  def nPeopleWithNoFriendsCount(network: Map[String, Set[String]]): Int =
    network.count(pair => pair._2.isEmpty)

  println(nPeopleWithNoFriendsCount(maryBob))

  def nPeopleWithNoFriendsCountSxSugar(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  println(nPeopleWithNoFriendsCountSxSugar(maryBob))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else{
        val person = discoveredPeople.head
        if(person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person)) //++ append
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(maryBob, "Mary", "Jim"))
  println(socialConnection(maryBob, "Mary", "Bob"))
  println(socialConnection(maryBob, "Mary", "Kevin"))

}
