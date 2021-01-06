package exercises

abstract class MyListCovariant[+A] {
  def head: A
  def tail: MyListCovariant[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListCovariant[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: MyTransformer[A, B]): MyListCovariant[B]
  def flatMap[B](transformer: MyTransformer[A, MyListCovariant[B]]): MyListCovariant[B]
  def filter(predicate: MyPredicate[A]): MyListCovariant[A]
  //concatenation
  def ++[B >: A](list: MyListCovariant[B]):MyListCovariant[B]
}
  object Empty2 extends MyListCovariant[Nothing] {
    override def head: Nothing = throw new NoSuchElementException
    override def tail: MyListCovariant[Nothing] = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def add[B >: Nothing](element: B): MyListCovariant[B] = new Cons2(element, Empty2)
    override def printElements: String = ""
    def map[B](transformer: MyTransformer[Nothing, B]): MyListCovariant[B] = Empty2
    def flatMap[B](transformer: MyTransformer[Nothing, MyListCovariant[B]]): MyListCovariant[B] = Empty2
    def filter(predicate: MyPredicate[Nothing]): MyListCovariant[Nothing] = Empty2
    def ++[B >: Nothing](list: MyListCovariant[B]):MyListCovariant[B] = list
  }

  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(elem: A): B
  }

  class Cons2[+A] (h: A, t: MyListCovariant[A]) extends MyListCovariant[A] {
    override def head: A = h
    override def tail: MyListCovariant[A] = t
    override def isEmpty: Boolean = false
    override def add[B >: A](element: B): MyListCovariant[B] = new Cons2(element, this)
    override def printElements: String =
      if(t.isEmpty) "" + h
      else h + " " + t.printElements

    /*
      [1,2,3].map(n * 2)
       = new Cons(2, [2,3].map(n * 2))
       = new Cons(2, new Cons(4, [3].map(n * 2))
       = new Cons(2, new Cons(4, [new Cons(6, Empty.map(n * 2))
       = new Cons(2, new Cons(4, [new Cons(6, Empty)))
     */
    def map[B](transformer: MyTransformer[A, B]): MyListCovariant[B] = new Cons2(transformer.transform(h), t.map(transformer))

    /*
      [1,2] .flatMap(n => [n, n + 1])
      = [1,2] ++ [2].flatMap(n => [n, n+1])
      = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
      = [1,2] ++ [2,3] ++ Empty
      = [1,2,2,3]
     */
    def flatMap[B](transformer: MyTransformer[A, MyListCovariant[B]]): MyListCovariant[B] = transformer.transform((h) ++ t.flatMap(transformer))
    /*
      [1,2,3].filter(n % == 0 =
      [2,3].filter(n % == 0 =
      = new Cons(2, [3].filter(n % == 0))
      = new Cons(2, Empty.filter(n % == 0))
      = new Cons(2, Empty))
     */
    def filter(predicate: MyPredicate[A]): MyListCovariant[A]

    /*
      [1,2] ++ [3,4,5]
      = new Cons(1, [2] ++ [3.4.5]
      = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
     */
    def ++[B >: A](list: MyListCovariant[B]):MyListCovariant[B] = new Cons(h, t ++ list)
  }

  object ListTest2 extends App {
    val listOfIntegersEmpty: MyListCovariant[Int] = Empty2
    val listOfStringsEmpty: MyListCovariant[String] = Empty2
    val listOfIntegers: MyListCovariant[Int] = new Cons2(1, new Cons2[Int](2, new Cons2[Int](3, Empty2)))
    val anotherListOfIntegers: MyListCovariant[Int] = new Cons2[Int](4, new Cons2[Int](5, Empty2))
    val listOfStrings: MyListCovariant[String] = new Cons2("Hello", new Cons2("Scala", Empty2))

    println(listOfIntegers.toString)
    println(listOfStrings.toString)

    println(listOfIntegers.map(new MyTransformer[Int, Int] {
      override def transform(elem: Int): Int = elem * 2
    }).toString)

    println(listOfIntegers.filter(new MyTransformer[Int, Int] {
      override def test(elem: Int): Boolean = elem % == 0
    }).toString)

    println((listOfIntegers ++ anotherListOfIntegers).toString)

    println(listOfIntegers.flatMap(new MyListCovariant[Int, MyListCovariant[Int]] {
      override def transform(elem: Int): MyList[Int] = new Const(elem, new Cons(elem + 1, empty))
    }).toString)
  }


