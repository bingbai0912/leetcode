package com.ice.LessThanTwoHundred

/**
  * Created by baibing on 9/15/17.
  * For Q134: Gas Station
  * 解决思路如下:
  * 首先要注意几个地方:路线为环形、油箱无限大、出发时油箱为空、结果如果存在则唯一
  * 1. 将gas数组中的所有元素挨个取出
  * 2. 用该元素和其后面(因为三个环，所以它前面的元素要被当作最后的元素)的元素依次作处理
  * 3. 处理过程为
  *       首先处理个特殊情况即有且仅有一个gas元素时(虽然我个人觉得这种情况不应该算进去)
  *       其次进行减油和加油两个操作，并判断当前的油量是否足够抵达下个加油站(gas)
  *       满足条件则继续向前行驶，否则即位失败，然后从下一个起点重新计算
  *       当每一站的补给gas(i)够行驶一周时，标记该起点为想找寻的结果
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
              // 如果结果不唯一时，可以在这里记录所有满足的始发点
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