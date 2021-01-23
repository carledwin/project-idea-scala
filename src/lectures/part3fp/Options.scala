package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  //WORK with unsafe APIs
  def unsafeMethod(): String = null

  val result = Some(unsafeMethod()) //WRONG-errado
  println(result)

  val result2 = Option(unsafeMethod())//Some or None
  println(result2)

  //chained-encadeado-acorrentado methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  //DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult)

  //function on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //USAFE - DO NOT USE THIS

  //map, flatMat, filter
  println(myFirstOption)
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(x => x > 10)) //It returns None instead false
  println(myFirstOption.filter(x => x < 10)) //It returns the element instead true
  println(myFirstOption.flatMap(x => Option(x * 9)))//It return the result of the multiplication 4 * 9

  //for-comprehensions

  /*
   * Exercise.
   *
   */
  val config: Map[String, String] = Map(
    // fetched from elsewhere-em outro lugar
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" //connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option [Connection] =
      if(random.nextBoolean()) Some(new Connection)
      else None
  }

  //try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")

  /*
  this code below is equivalent to 'host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))'
  * if(h != null)
  *   if(p != null)
  *   return Connection.apply(h, p)
  *
  * return null 'None' rs :)
  */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  println(connection)

  /*
    this code below is equivalent to 'connection.map(c => c.coneect)'
    if(c != null)
      return c.connect

     return null 'None' rs :) too
  */
  val connectionStatus = connection.map(c => c.connect)
  //if(connectionStatus == null) print(None) else print(Some(connectionStatus.get))
  println(connectionStatus) //print Some(Connected) 'object' or None 'if no exist or null' because is an option

  //if(status != null) println(status)  otherwise-de outra forma don't do anything-qualquer coisa

  connectionStatus.foreach(println) //print Connected 'value' or None 'if no exist or null' because is an option

  //short hand solution
  config.get("host")
    .flatMap(host => config.get("port")
    .flatMap(port => Connection(host, port))
    .map(c => c.connect))
    .foreach(println)

  //for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host,port)
  }yield connection.connect

  forConnectionStatus.foreach(println)
}
