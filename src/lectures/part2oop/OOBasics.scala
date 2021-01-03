package lectures.part2oop

import scala.annotation.tailrec

object OOBasics extends App {

  val person = new Person("Carl", 37)
  println(person)
  println(person.age)
  println(person.name)
  println(person.x)
  person.greet("Carl") //return Carl and Carl
  person.greet2("Antonio") //return Carl(this - value of constructor) and Antonio(param - value of parameter from method)
  person.greet //return value of this.name
  person.greet2 // return value of this.name too

  val counter = new Counter
  println("Counter increment")
  counter.currentCount(6, true)
  println("Counter decrement")
  counter.currentCount(6, false)

  val counter2A = new Counter2(10, true)
  println("Counter2A increment")
  counter2A.currentCount
  val counter2B = new Counter2(10)
  println("Counter2B decrement")
  counter2B.currentCount

  val author = new Writer("Carl", "Nascimento", 1985)
  val impostor = new Writer("Carl", "Nascimento", 1985)
  val impostor2 = new Writer("Carll", "Nascimento", 1985)
  val novel = new Novel(author, "The Code", 2018)

  println(novel.authorAge)
  println(novel.isWrittenBy(impostor))
  println(novel.isWrittenBy(impostor2))
  println(novel.isWrittenBy(author))

  //has default value at the attributes for this don't need to declare the correct constructor
  val counter3 = new Counter3
  counter3.inc.print
  counter3.dec.print
  counter3.inc(3).print
  counter3.dec(4).print
  println("another increment")
  counter3.inc.print
  counter3.inc.inc.inc.inc.print
  println("another decrement")
  counter3.dec(5).print
  counter3.inc(6).print
  counter3.inc.inc.print
  counter3.dec.dec.print





}

//constructor
//class Person( name: String, age: Int)
//class parameters are NOT FIELDS

//constructor
//class parameters are FIELDS with 'val'
class Person(val name: String, val age: Int) {
  //body
  //overloading - when has a different parameters, type of parameters and quantity of parameters

  //overloading to multiple constructors
  //def this() = this(null, null) // isn't works
  def this(name: String) = this(name, 0)
  def this() = this("Carl")
  val x =2
  def greet(name: String): Unit = println(s"$name says: Hi, $name")
  def greet2(name: String): Unit = println(s"${this.name} says; Hi, $name")
  def greet: Unit = println(s"Hi, I am $name") //overloading
  def greet2: Unit = println(s"Hi, I am ${this.name}")//overloading
  println(1 + 3)
}

  //Exercises
  //Novel and Writer
  class Novel(val writer: Writer, val name: String, val yearOfRelease: Int){
    def authorAge: Int = yearOfRelease - writer.year
    def isWrittenBy(author: Writer): Boolean = author == writer
    def copy(newYear: Int): Novel = new Novel(writer, name, newYear)
  }

  class Writer(val firstName: String, val surname: String, val year: Int) {
    def fullname: String = s"${this.firstName} ${this.surname}"
  }

  //Counter
  class Counter(val value: Int){

    def this() = this(0)

    def currentCount(n: Int, increment: Boolean): Int = {
      if(increment) this.counter(n, 1)
      else this.counter(n)
    }

    @tailrec
    private def counter(n: Int, accumulator: Int): Int = {
      if(n < 1) 1
      else {
        println(s"Counter: $accumulator")
        counter(n - 1, accumulator + 1)
      }
    }
    @tailrec
    private def counter(n: Int): Int = {
      if(n < 1) 1
      else{
        println(s"Counter: $n")
        counter(n - 1)
      }
    }

    @tailrec
    private def bla(n: Int): Int = {
      if(n < 1) 1
      else bla(n - 1)
    }
  }

  class Counter2(val value: Int, val increment: Boolean = false){

    def this() = this(0, false)
    def this(value: Int) = this(value, false)

    def currentCount: Int = {
      if(this.increment) this.counter(this.value, 1)
      else this.counter(this.value)
    }

    @tailrec
    private def counter(n: Int, accumulator: Int): Int = {
      if(n < 1) 1
      else {
        println(s"Counter: $accumulator")
        counter(n - 1, accumulator + 1)
      }
    }
    @tailrec
    private def counter(n: Int): Int = {
      if(n < 1) 1
      else{
        println(s"Counter: $n")
        counter(n - 1)
      }
    }

    @tailrec
    private def bla(n: Int): Int = {
      if(n < 1) 1
      else bla(n - 1)
    }
  }

  //don't need to call or declare the constructor with param when has default value at the attributes
  class Counter3(val count: Int = 0) {
    def inc = {
      println("Incrementing")
      new Counter3(count + 1)
    } //immutability

    def dec = {
      println("Decrementing")
      new Counter3(count - 1)
    } //immutability

    //@tailrec isn't works when is public
    def inc(n: Int): Counter3 =
      if(n <= 0) this
      else inc.inc(n-1)
    //mutability

    def dec(n: Int): Counter3 =
      if(n <= 0) this
      else dec.dec(n-1)
    //mutability

    def print = println(count)
  }



