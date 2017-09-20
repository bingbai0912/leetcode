package com.ice.LessThanThreeHundred

/**
  * Created by baibing on 9/12/17.
  * For Q258:
  * 解决思路如下:
  * 
  */

object Solution258 {
  def addDigits(num: Int): Int = {
    var result = num
    while(result > 9){
      var tmp = 0
      result.toString.foreach(x=>{tmp+=x.toString.toInt})
      result=tmp
    }
    result
  }
}

object TwoFiveEight{
  def main(args: Array[String]): Unit = {
    println(Solution258.addDigits(38))
  }
}