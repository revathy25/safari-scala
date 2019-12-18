package hello

object Hello { // singleton...
  def main(args: Array[String]): Unit = {
    println("Hello Scala World!")

    val x:Int = 99 // explicit type
    val y = 99 // inferred type
//    x = 100 // val cannot be reassigned (c.f. final, const in Java, C#, JS)

    var count = 99 ; count += 1; count = count + 1
//    count++ // Scala does not have ++ --
    println("count is now " + count)
    // Scala is strongly STATICALLY typed
//    count = 99.9

    // mostly the usual suspects for arithmetic and comparisons
    // + - * / < <= > >= !=
    // what about == ... yes usually appropriate
    // == defers to equals() method
    
  }
}
