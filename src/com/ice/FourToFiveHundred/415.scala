package com.ice.FourToFiveHundred

/**
  * Created by baibing on 9/13/17.
  * For Q415: Add Strings
  * 解决思路如下:
  * 先将字符串首位调换这样能使位数(个十百千..)对齐，同位向加并判断是否进位。
  * 最后再处理一下特殊情况--如果最高为相加进位则首位补1
  */

object Solution415 {
  def addStrings(num1: String, num2: String): String = {
    val (maxLen,big,small) = if (num1.length>num2.length) {
      (num1.length,num1.reverse,num2.reverse)
    } else (num2.length,num2.reverse,num1.reverse)

    val result :StringBuffer = new StringBuffer()
    var up = false
    for(i<-0 until maxLen){
      val tmp1 = big(i).toString.toInt
      val tmp2 = if (i < small.length) small(i).toString.toInt else 0
      val tmp3 = if (up) 1 else 0
      val temp4 = tmp1+tmp2+tmp3
      result.append(temp4 % 10)
      up = if(temp4 >= 10) true else false
      if (up && i==maxLen-1) result.append("1")
    }
    result.toString.reverse
  }
}

object FourOneFive {
  def main(args: Array[String]): Unit = {
    val num1 = "56567812312312334213123"
    val num2 = "42323412335234457783434456"
    val result = Solution415.addStrings(num1, num2)
    println(num1+" + "+num2+" = "+result)
  }
}