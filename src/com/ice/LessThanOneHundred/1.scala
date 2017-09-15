package com.ice.LessThanOneHundred
import scala.util.control.Breaks
/**
  * Created by baibing on 9/14/17.
  * For Q1:
  * 解决思路如下:
  * 从第一个数开始取，取到后依次和后面的数字相加判断值是否等于target.
  * 是则返回结果，并结束循环
  */

object Solution1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val result = new Array[Int](2)
    val loop = new Breaks
    loop.breakable {
      for (i <- 0 until nums.length - 1) {
        for (j <- i + 1 until nums.length) {
          if (nums(i) + nums(j) == target) {
            result(0) = i
            result(1) = j
            loop.break()
          }
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