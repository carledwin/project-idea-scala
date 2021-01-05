package exercises

abstract class MyListCovariant[+A] {
  def head: A
  def tail: MyListCovariant[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListCovariant[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}
  object Empty2 extends MyListCovariant[Nothing] {
    override def head: Nothing = throw new NoSuchElementException
    override def tail: MyListCovariant[Nothing] = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def add[B >: Nothing](element: B): MyListCovariant[B] = new Cons2(element, Empty2)
    override def printElements: String = ""
  }

  class Cons2[+A] (h: A, t: MyListCovariant[A]) extends MyListCovariant[A] {
    override def head: A = h
    override def tail: MyListCovariant[A] = t
    override def isEmpty: Boolean = false
    override def add[B >: A](element: B): MyListCovariant[B] = new Cons2(element, this)
    override def printElements: String =
      if(t.isEmpty) "" + h
      else h + " " + t.printElements
  }

  object ListTest2 extends App {
    val listOfIntegersEmpty: MyListCovariant[Int] = Empty2
    val listOfStringsEmpty: MyListCovariant[String] = Empty2
    val listOfIntegers: MyListCovariant[Int] = new Cons2(1, new Cons2[Int](2, new Cons2[Int](3, Empty2)))
    val listOfStrings: MyListCovariant[String] = new Cons2("Hello", new Cons2("Scala", Empty2))

    println(listOfIntegers.toString)
    println(listOfStrings.toString)
  }


