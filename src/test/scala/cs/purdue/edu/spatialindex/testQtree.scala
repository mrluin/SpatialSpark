package cs.purdue.edu.spatialindex

import cs.purdue.edu.spatialindex.quatree.{SBQTree}
import cs.purdue.edu.spatialindex.rtree.{Geom, Box}
import cs.purdue.edu.spatialindex.spatialbloomfilter.SBFilter

import scala.collection.immutable.HashMap

/**
 * Created by merlin on 10/24/15.
 */
object testQtree {

  def main(args: Array[String]): Unit = {


    /*val quertbox3=Box(0,0,5,5)
    val quertbox2=Box(1,1,10,10)
    val quertbox4=Box(1,1,100,100)
    val quertbox5=Box(100,100,122,133)

    val boxs=Array(quertbox2,quertbox3,quertbox4,quertbox5)

    val qtree=QTree(boxs.toIterator)*/

    val quertbox4=Box(800,80,900,100)

    val quertbox6= Box(-200,-120,200,200)

    val quertbox5=Box(-100,250,700,733)

    val qtree=SBQTree(quertbox6)

    qtree.insertBox(quertbox5)
    qtree.insertBox(quertbox4)

    qtree.printTreeStructure()

    val querybox=Box(0,0,100,100)
    println(qtree.queryBox(querybox))
    println(qtree.queryBoxWithP(querybox))

    println("*"*100)
    val sbfilter=SBFilter(qtree.getSBFilter())
    println(sbfilter.searchRectangle(querybox))
    println(sbfilter.searchRectangleWithP(querybox))

    println("*"*100)
    val sbfilterv2=SBFilter(qtree.getSBFilterV2())
    println(sbfilterv2.searchRectangleV2(querybox))
    println(sbfilter.searchRectangleWithPV2(querybox,0.9))


   // println(sbfilter.searchRectangleWithP(querybox))

    //println(querybox.area/quertbox5.area)

    //println(querybox.intersectionarea(quertbox5)/querybox.area)

  }

}
