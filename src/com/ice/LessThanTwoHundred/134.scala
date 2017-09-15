package com.ice.LessThanTwoHundred

/**
  * Created by baibing on 9/15/17.
  * For Q134:
  * 解决思路如下:
  * 
  */

object Solution134 {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    var result = -1
    val loop = new scala.util.control.Breaks
    for(i<-0 until gas.length){
      var storage = gas(i)
      if (storage >= cost(i)){
        if(gas.length==1) result = 0
        loop.breakable{
          for(j<-i+1 until i+gas.length){
            storage -= cost((j-1) % gas.length)
            storage += gas(j % gas.length)
            if(storage < cost(j % gas.length)){
              loop.break()
            }
            if(j == (i+gas.length-1)){
              //
              result = i
            }
          }
        }
      }
    }
    result
  }
}

package object LeetCode {
  def main(args: Array[String]) {
  }
}