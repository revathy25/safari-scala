package hello

object Hello { // singleton...
  def apply(index: Int): Unit =
    println(s"attempting to apply to ${index}")

  def update(index: Int, value: Any): Unit =
    println(s"doing update with index ${index}, and value ${value}")

  def noArgs():Unit = println("You called noargs") // convention is
  // functions with empty parens might cause side effects...

  def getValue:Int = /*computation*/ 10 + 100

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

    var thing : AnyVal = 99
    thing = ()
    println("thing is " + thing)

    println(s"The number is $x")
    // also f for formatted. like printf "7.2f" for conversions
    println(s"The larger number is ${x + 100}")

//    val numbers = Array(99, 1, 1, 2, 3, 5)
    val numbers = Array.apply(99, 1, 1, 2, 3, 5)
    println(numbers.apply(0)) // it actually IS a function call...

//    numbers = Array(3,3,3) // cannot reassign numbers
//    numbers(0) = 0 // can mutate the object to which numbers refers
    numbers.update(0, 0) // can mutate the object to which numbers refers
    // above is ALSO a FUNCTION CALL!
    println(numbers(0)) // it actually IS a function call...

    Hello.apply(99)
    Hello(101) // implicitly calls apply
    Hello.update(33, "Banana")
    Hello(33) = "Banana"

    val twoOf = (1, 2)
    val (a, b) = twoOf

    val c = twoOf._1
    println(s"twoOf is ${twoOf}, a is ${a}, b is ${b}")
    noArgs

    println(s"${getValue}")
  }
}
