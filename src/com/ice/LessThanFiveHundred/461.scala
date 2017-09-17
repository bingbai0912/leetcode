package com.ice.LessThanFiveHundred

/**
  * Created by baibing on 9/17/17.
  * For Q461: Hamming Distance
  * 解决思路如下:
  * 
  */

object Solution461 {
  def hammingDistance(x: Int, y: Int): Int = {
    var result = 0
    val (max,small) = if(x>y) (x,y) else (y,x)
    val maxStr = Integer.toBinaryString(max)
    val smallStr = Integer.toBinaryString(small)
    for(i<-0 until maxStr.length){
      if(i>=smallStr.length){
        if((maxStr(maxStr.length-1-i)-'0')!=0)
          result+=1
      }else if(maxStr(maxStr.length-1-i)!=smallStr(smallStr.length-1-i)){
        result+=1
      }
    }
    result
  }
}

object FourSixOne{
  def main(args: Array[String]): Unit = {
    val result = Solution461.hammingDistance(234433563,4)
    println("result:"+result)
  }
}