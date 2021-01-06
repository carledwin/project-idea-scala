package lectures.part2oop

//import in group only 2 classes
//import playground.{Cinderella, PrinceCharming}

//import in group all classes of the group
//import playground._ //{Cinderella, PrinceCharming}

//alias to class imported
import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => DateSql}

object PackagingAndImports extends App {

  //package members are accessible by their simple name
  val writer = new Writer("Carl", "Edwin", 2000)

  //import the package
  //val princess = new Cinderella //simple name


  val princess2 = new playground.Cinderella //fully qualified name

  //you can use it when you have more then one class with the same name
  val princess = new Princess
  val date = new Date
  //using aliasing
  val dateS = new DateSql(2021,1,6)

  println("Date: " + date)
  println("DateS: " + dateS)


  //packages are in hierarchy
  //matching folder structure

  //package object - can only be one per package
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming

  /*
  default import
  java.lang - String, Object, Exception
  scala - Int, Nothing, Function
  scala.Predef - println, ???
   */


}
