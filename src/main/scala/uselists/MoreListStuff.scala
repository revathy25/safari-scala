package uselists

import scala.annotation.tailrec

object MoreListStuff {
  @tailrec // report error if not tailrecursive
  def infinite(x: Int): Unit = {
    println(x)
    infinite(x + 1)
//    val p = x - 1 // would prevent tailrecursion
  }

  def showAllNames(names: List[String]): Unit = names match {
    case Nil => ()
    case h :: t => println(s"Dear ${h}") ; showAllNames(t)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Fred", "Jim", "Sheila")
    showAllNames(names)

//    infinite(0)
//    println(s"Item zero is ${names(0)}")
//    var count = 0;
//    while (count < names.length) {
//      println(names(count))
//      count += 1
//    }
  }
}
