package ch1

import scala.util.Random

object Ch1Exercises extends App {

  // 1a. is plus a pure function? why?
  def plus(a: Int, b: Int): Int = a + b

  // 1b. is div a pure function? why?
  def div(a: Int, b: Int): Int =
    if(b == 0) sys.error("Cannot divide by 0")
    else a / b

  // 1c. is times2 a pure function? why?
  var counterTimes2 = 0
  def times2(i: Int): Int = {
    counterTimes2 += 1
    i * 2
  }

  // 1d. is boolToInt a pure function? why?
  def boolToInt(b: Boolean): Int =
    if(b) 5
    else Random.nextInt() / 2

  // 1e. is mapLookup a pure function? why?
  def mapLookup(map: Map[String, Int], key: String): Int =
    map(key)

  // 1f. is times3 a pure function? why?
  def times3(i: Int): Int = {
    println("do something here") // could be a database access or http call
    i * 3
  }

  // 1g. is circleArea a pure function? why?
  val pi = 3.14
  def circleArea(radius: Double): Double =
    radius * radius * pi

  // 1h. is inc or inc_v2 a pure function? why?
  def inc(xs: Array[Int]): Unit =
    for { i <- 0 to xs.length } xs(i) = xs(i) + 1

  def inc_v2(xs: Array[Int]): Unit =
    for { i <- xs.indices } xs(i) = xs(i) + 1


  // 1i. is incAll a pure function? why?
  def incAll(value: Any): Any = value match {
    case x: Int    => x + 1
    case x: Long   => x + 1
    case x: Double => x + 1
  }

  // 1j. is incAll_v2 a pure function? why?
  def incAll_v2(value: Any): Any = value match {
    case x: Int    => x + 1
    case x: Long   => x + 1
    case x: Double => x + 1
    case _         => 0
  }

  // 1k. is sum a pure function? why?
  def sum(xs: List[Int]): Int = {
    var acc = 0
    xs.foreach(x => acc += x)
    acc
  }


  // 2a. Implement andThen and compose
  def andThen[A, B, C](f: A => B, g: B => C): A => C = ???

  def compose[A, B, C](f: B => C, g: A => B): A => C = ???

  // Implement the function f(x) = 2 * x + 1 using inc, double with compose or andThen
  val inc   : Int => Int = x => x + 1
  val double: Int => Int = x => 2 * x



  // Same for f(x) = 2 * (x + 1)


  // Transform triple method (def) into a function (val)
  def triple(x: Int): Int = x * 3


  // 2b. Implement identity
  def identity[A](x: A): A = ???


  // Transform identity into a function (val). See Eta expansion https://stackoverflow.com/a/39446986



  // 2.c Implement const
  def const[A, B](a: A)(b: B): A = ???

  // 2.x Implement curry and uncurry
  def curry[A, B, C](f: (A, B) => C): A => B => C = ???

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = ???

  // 2c. Implement join
  def join[A, B, C, D](f: A => B, g: A => C)(h: (B, C) => D): A => D = ???


  // 3a. Use recursion to implement sumList
  def sumList(xs: List[Int]): Int = ???


  // 3b. Run it with different size of list
  // What happens when the list is big enough? Why?
  // You can use `to` to generate a List from 1 to x
  val oneToTen = 1.to(10).toList


  // 3c. Re-write sumList recursively without the same issue
  def sumList2(xs: List[Int]): Int = ???


  // 3d. Run isEven / isOdd for small and large input. Search for mutual tail recursion in scala
  def isEven(x: Int): Boolean =
    if(x > 0) !isOdd(x - 1)
    else if (x < 0) !isOdd(x + 1)
    else true

  def isOdd(x: Int): Boolean =
    if(x > 0) !isEven(x - 1)
    else if (x < 0) !isEven(x + 1)
    else false


  // 2g. Implement euclideanDistance such as euclideanDistance(Point(x, y)) = squareRoot(x^2 + y^2)
  // try to use join, compose, andThen
  case class Point(x: Double, y: Double)

  val getX: Point => Double = _.x
  val getY: Point => Double = _.y
  val square: Double => Double = x => x * x
  val sum: (Double, Double) => Double = (x, y) => x + y
  val squareRoot: Double => Double = Math.sqrt

//  val euclideanDistance: Point => Double = ???

}
