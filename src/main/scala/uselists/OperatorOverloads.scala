package uselists

class RightAssociative(val x: String) {
  def =:(y:String) : String = x + y
}

object OperatorOverloads {
  def doStuff(index: Int): Int = index * 2

  // Scala ALLOWS "operator overloading"
  def +=+(i: Int): Int = i * 3

  def +-(i:Int, j:Int): Int = i * j

  def main(args: Array[String]): Unit = {
//    val res = OperatorOverloads.doStuff(3)
    // Scala allows "infix" invocation
    val res = OperatorOverloads doStuff 3
    println(s"value of res is ${res}")

    println(s"+=+(3) is ${ OperatorOverloads +=+ 9 }")
    println(s"+=+(3) is ${ OperatorOverloads +=+ 9 }")
    println(s"+-(3, 4) is ${ OperatorOverloads +- (3, 4) }")

    val ra = new RightAssociative("thefield")
    val joined = ra.=:("thearg")
    println(joined)

    println("anotherarg" =: ra)

  }
}
