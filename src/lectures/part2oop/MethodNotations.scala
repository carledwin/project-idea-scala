package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){
    def this(name: String) = this(name, "", 0)
    def this(name: String, favoriteMovie: String) = this(name, favoriteMovie, 0)
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_~ : String = s"${this.name} with the age incrementer to ${this.age + 1}"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def unary_! : String = s"$name, what the heck?!"
    def ~ : String = "Hello !!"
    def unary_- : String = "Hello !!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name's $name and I like $favoriteMovie"
    def apply(times: Int) = s"${this.name} watched Inception $times times"
    def learns : String = s"${this.name} learns Scala"
    def learns(thing: String) : String = s"${this.name} learns $thing"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary.likes("Inceptionn"))
  println(mary likes "Inceptionn") //equivalent

  //infix notation = operator notation(syntactic sugar)
  //"operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary .+(tom))

  println(1 + 2)
  println(1.+(2))
  //ALL OPERATORS ARE METHODS
  //Akka actors have ! ?

  //prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_prefix only works with - + ~ !

  println(!mary) //prefix
  println(mary.unary_!)
  //println(~mary)//isn't works, needs to be declared with unary_- to use how prefix or sulfix
  println(-mary)
  println(mary unary_-)
  println(mary.unary_-)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply - the () and type of return are very important at the method declaration
  println(mary.apply())
  println(mary.apply)
  println(mary apply)
  println(mary()) //equivalent

  //exercises


  val maryE = new Person("Mary", "Inception")
  println(maryE + "the rockstar")
  println((maryE + "the rockstar")())
  println((maryE + "the rockstar").apply())

  val maryAge = new Person("Mary")
  println(~maryAge)
  println(+maryAge.age)
  println((+maryAge).age)
  println(maryAge learns)
  println(maryAge learns("Hadoop"))
  println(maryAge(10))
  println(maryAge.apply(2))
}

