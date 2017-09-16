package com.ice.LessThanFiveHundred

/**
  * Created by baibing on 9/16/17.
  * For Q498: diagonal-traverse
  * 解决思路如下:
  * 把矩阵设想为一个坐标系中的点，左上角的点是坐标系中心
  * 路线一共分为两大类(up,down)，每大类下面分三小类
  * 1. up(指斜线方向朝上)
  * 1.1 x轴到top，下一个点需要换行，然后方向转为down
  *     x值不变，y+1
  * 1.2 y轴到end，下一个点需要换列，然后方向转为down
  *     x+1，y值不变
  * 1.3 继续向上走
  *     x+1，y-1
  * 2. down(指斜线方向朝下)
  * 2.1 y轴到top，下一个点需要换列，然后方向转为up
  *     y值不变，x+1
  * 2.2 x轴到end，下一个点需要换行，然后方向转为up
  *     x值不变，y+1
  * 2.1 继续向下走
  *     x-1，y+1
  *
  * 此外有两点要注意的地方
  * 1. 第一个值或者最后一个值要根据算法不同特殊处理
  * 2. up时如果x轴到top并且y轴到end，则以前者处理逻辑为准(所以if判断的顺序不能乱)。
  *    down时同理
  *
  * 作者注，
  */

object Solution498 {
  def findDiagonalOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if( matrix.length ==0 || matrix(0).length == 0)
      return new Array[Int](0)
    var up = true
    val y = matrix.length
    val x = matrix(0).length
    val coordinate = Array(0,0)
    val result = new Array[Int](x*y)
    for(i<-0 until x*y-1 ){
      println(coordinate(1)+","+coordinate(0))
      result(i) = matrix(coordinate(1))(coordinate(0))
      if(up){
        // x to top
        if(coordinate(0) == x-1){
          coordinate(1)+=1
          up = false
          println("x to top")
        // y to top
        }else if(coordinate(1) == 0) {
          coordinate(0)+=1
          up = false
          println("y to top")
        // continue up
        }else{
          coordinate(0)+=1
          coordinate(1)-=1
          println("continue up")
        }
      }else{
        // y to end
        if(coordinate(1) >= y-1){
          coordinate(0)+=1
          println("y to end")
          up = true
          // x to end
        }else if(coordinate(0) == 0) {
          coordinate(1)+=1
          println("x to end")
          up = true
        }else {
          // continue down
          coordinate(0) -= 1
          coordinate(1) += 1
          println("continue down")
        }
      }
    }
    result(x*y-1)=matrix(y-1)(x-1)
    result
  }
}

object FourNineEight {
  def main(args: Array[String]) {
//    val matrix = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))
//    val matrix = Array(Array(1,2,3),Array(4,5,6),Array(7,8,9),Array(10,11,12))
//    val matrix = Array(Array(1,2,3,1),Array(4,5,6,11),Array(7,8,9,12))
//    val matrix = Array(Array(1,2,3))
    val matrix = Array(Array(1),Array(2),Array(3))
    val result = Solution498.findDiagonalOrder(matrix)
    print("input:")
    for(i<-0 until matrix.length){
      println()
      for(j<-0 until matrix(0).length){
        print(matrix(i)(j)+" ")
      }
    }
    println("\nresult:")
    for(i<-result){
      print(i+" ")
    }
  }
}