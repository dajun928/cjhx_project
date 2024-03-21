package graphx

import org.apache.spark._
import org.apache.spark.graphx.{Edge, Graph, GraphLoader, VertexId}
import org.apache.spark.rdd.RDD

object GraphxExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("ConnectedComponentsExample")
    val sc = new SparkContext(conf)


    //顶点的数据类型是VD:(String,Int)
    val vertexArray = Array(
      (1L, ("Alice", 28)),
      (2L, ("Bob", 27)),
      (3L, ("Charlie", 65)),
      (4L, ("David", 42)),
      (5L, ("Ed", 55)),
      (6L, ("Fran", 50))
    )

    //边的数据类型ED:Int
    val edgeArray = Array(
      Edge(2L, 1L, 7),
      Edge(2L, 4L, 2),
      Edge(3L, 2L, 4),
      Edge(3L, 6L, 3),
      Edge(4L, 1L, 1),
      Edge(5L, 2L, 2),
      Edge(5L, 3L, 8),
      Edge(5L, 6L, 3)
    )


    //点集合
    val vertexRDD: RDD[(VertexId,  (String, Int))] = sc.parallelize(vertexArray)

    // 边集合
    val edgeRDD: RDD[Edge[Int]] = sc.parallelize(edgeArray)

    println("=======================================================================Graph start! ")
    val tinySocial: Graph[(String, Int), Int] = Graph(vertexRDD, edgeRDD)

    val graph = tinySocial.connectedComponents()
    val vertexRdd = graph.vertices
    println(vertexRdd)
    vertexRdd.collect.foreach(println(_))
    edgeRDD.collect.foreach(println(_))
    println("=======================================================================Graph end! ")

  }
}
