package com.ice.OneToOneHundred

/**
  * Created by baibing on 9/12/17.
  * For Q1:
  * 解决思路如下:
  * 
  */

object Solution1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val result = new Array[Int](2)
    for(i<-0 until nums.length-1){
      for(j<-i+1 until  nums.length){
        if(nums(i)+nums(j)==target){
          result(0)=i
          result(1)=j
        }
      }
    }
    result
  }
}

package object LeetCode {
  def main(args: Array[String]): Unit = {
    val nums = Array(2,7,11,15)
    val target = 18
    val result = Solution1.twoSum(nums, target)
    println(target+" = "+ nums(result(0))+" + "+ nums(result(1)))
  }
}