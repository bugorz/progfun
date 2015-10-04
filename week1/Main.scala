package recfun
import common._
import scala.collection.mutable.Set

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) {
      1
    } else {
      pascal(c-1, r-1) + pascal(c, r-1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val parens = chars.filter(p => (p == '(' || p == ')'))
    //println(parens)

    def check(stack: List[Char], remain: List[Char]): Boolean = {
      if (remain.isEmpty) {
        stack.isEmpty
      } else {
        if (remain.head == ')') {
          stack.nonEmpty && check(stack.dropRight(1), remain.tail)
        } else {
          check(stack :+ remain.head, remain.tail)
        }
      }
    }

    val stack = List[Char]()
    check(stack, parens)
  }

  /**
   * Exercise 3
   */

  var visited = Set[String]()
  var changes = 0;
  def countChange(money: Int, coins: List[Int]): Int = {

    def dfs(s: StringBuilder, previous: Int, m: Int, c: List[Int]): Unit = {
      if (m == 0) {
        if (! visited.contains(s.toString())) {
          //println(s.toString())
          visited.add(s.toString())
          changes += 1
        }
      } else {
        //println(m)
        for (d <- c) {

          if (m >= d && previous >= d) {
            s.append(d)
            dfs(s, d, m - d, c)
            s.dropRight(1)
          }
        }
      }


    }

    visited.clear()
    changes = 0
    val sortedCoins = coins.sortWith(_ > _)
    // println(sortedCoins)
    var s = new StringBuilder
    dfs(s, Integer.MAX_VALUE, money, sortedCoins)

    return changes
  }


}
