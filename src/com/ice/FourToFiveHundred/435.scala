package com.ice.FourToFiveHundred

/**
  * Created by baibing on 9/12/17.
  * For Q435:Non-overlapping Intervals
  * 解决思路如下:
  * 该问题可以理解为去除重叠区间，正面想可能有些不知如何下手，但采用逆向思维就简单多了,
  * 首先计算所有的非重叠区间，最后再用所有区间数减去非重叠区间即可。
  */

object Solution435 {
  def eraseOverlapIntervals(intervals: Array[Interval]): Int = {
    // 处理特殊情况，输入数组长度为0时直接返回结果。
    if (intervals.length==0) return 0
    // 记录非重叠区间个数
    var count = 1
    // 把所有区间按end点从小到达排序(按start点、从大到小均可以)。
    val orderedIntervals = intervals.sortBy( interval=>interval.end )
    // 把end值最小对象取出(即数组第一个)，然后和后面的所有做对比。
    val first = orderedIntervals(0)
    var end = first.end
    for(i<-1 until orderedIntervals.length){
      val interval = orderedIntervals(i)
      // 如果区间不重叠，则count+1并将end值更新,否则对比下一个。
      if(interval.start>=end){
        count+=1
        end = interval.end
      }
    }
    // 重叠区间 = 所有区间 - 非重叠区间
    orderedIntervals.length-count
  }
}

class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}

object LeetCode {
  def main(args: Array[String]) {
    //[ [1,2], [2,3], [3,4], [1,3] ]
    // val input = Array(new Interval(1,2),new Interval(2,3),new Interval(3,4),new Interval(1,3))
    val input = Array(new Interval(1,2),new Interval(1,2),new Interval(1,2))
    val result = Solution435.eraseOverlapIntervals(input)
    println(result)
  }
}