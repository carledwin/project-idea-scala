package exercises

import scala.annotation.tailrec

abstract class MyList1 {
  def head: Int
  def tail: MyList1
  def isEmpty: Boolean
  def add(element: Int): MyList1
  def printElements: String
  //polymorphic call
  override def toString: String  = "[" + printElements + "]"
}

  object Empty1 extends MyList1 {

    def head: Int = throw new NoSuchElementException
    def tail: MyList1 = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Int) = new Cons1(element, Empty1)
    override def printElements: String = ""
  }

  class Cons1(h: Int, t: MyList1) extends MyList1 {
    def head: Int = h
    def tail: MyList1 = t
    def isEmpty: Boolean = false
    def add(element: Int) = new Cons1(element, this)
    //recursion to show all the elements
    override def printElements: String =
      if(t.isEmpty) "" + h
      else h + " " + t.printElements //recursion
  }

  object ListTest1 extends App{
    val list = new Cons1(1, Empty1)
    println(list.tail)

    val list2 = new Cons1(1, new Cons1(2, new Cons1(3, Empty1)))
    println(list2.tail.head)
    println(list2.add(4).head)
    println(list2.isEmpty)
    println(list2.isEmpty)
    println(list2) //call toString (indirectly calling) an then the recursion
    println(list2.toString) //call toString (directly calling) an then the recursion
    println(list2.printElements) //call the recursion
  }
