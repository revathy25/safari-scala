package mydates

import java.time.LocalDate

// case class args are imlicitly val fields
case class SimpleDate(day: Int, month: Int, year: Int)

object UseSimpleDate {
  def lookAt(x: Any): Unit = x match {
    case 3 => println("You send me 3")
    case SimpleDate(18, 12, 2019) => println("It's that date again!")
    case SimpleDate(d, m, _) => println(s"Date of day=${d}, month = ${m}")
    case x:String if x.length() < 4 => println(s"${x} is a short string")
    case x:String =>
      println(s"Bonjour, you sent me ${x}, of length ${x.length}")
    case _ => println("Don't recognize that!")
  }

  def main(args: Array[String]): Unit = {
    val x = SimpleDate(18, 12, 2019)
    println(s"x is ${x} and x.day is ${x.day}")
    val y = SimpleDate(18, 12, 2019)
    println(s"x == y? ${x == y}")

    var z: Any = x

    lookAt(z)
    lookAt(SimpleDate(1, 1, 2000))

    lookAt("Hello")
    lookAt(LocalDate.now())
    lookAt("Me")
  }
}
