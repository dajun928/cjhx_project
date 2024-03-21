//package graphx
//
//
//import util.Murmurs
//import org.apache.spark.graphx.{Edge, Graph, VertexId}
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.{SaveMode, SparkSession}
//
//import scala.collection.mutable
//
//class DwdGraphResult(){
//
//  def main(args: Array[String]): Unit = {
//    val sparkSession = SparkSession
//      .builder()
//      .appName("HdfsTest")
//      .master("local[*]")
//      .getOrCreate()
//
//
//    process(sparkSession)
//  }
//
//
//
//
//  def process(sparkSession: SparkSession):Unit ={
//    import sparkSession.implicits._
//    val coalescePartitions = 200
//
//
//    //读取hive用户主数据
//    val baseTable = sparkSession.sql(transformSql1)
//
//    //点集合
//    val pointResult:RDD[(VertexId, String)]  =
//      baseTable
//        .map(line => {
//          line.getValuesMap("primary_key" +: baseFieldList)
//            .filter(x => x._2 != null && x._2.toString.replace(" ","").length > 0 && (!x._2.toString.toLowerCase.replace(" ","").equals("null")))
//            .map(x => (Murmurs.hash(x._1 + x._2.toString), ""))
//        })
//        .flatMap(_.map(x=>x))
//        .rdd
//
//    //边集合
//    type Connection = String
//    val edgeResult:RDD[Edge[Connection]] =
//      baseTable
//        .map(line => {
//          val currentList =
//            line.getValuesMap("primary_key" +: baseFieldList)
//              .filter(x => x._2 != null && x._2.toString.replace(" ","").length > 0 && (!x._2.toString.toLowerCase.replace(" ","").equals("null")))
//              .map(x => Murmurs.hash(x._1 + x._2.toString))
//              .toList
//          val resultList = new mutable.ListBuffer[(Long, Long, String)]()
//          for(i <- currentList.indices if i < currentList.length - 1){
//            resultList.+=((currentList(i),currentList(i+1),""))
//          }
//          resultList.map(x => Edge(x._1,x._2,x._3))
//        })
//        .flatMap(_.map(x=>x))
//        .rdd
//
//    println("=======================================================================Graph start! " + java.time.Instant.now().toEpochMilli)
//    val tinySocial: Graph[String, Connection] = Graph(pointResult, edgeResult)
//    val graph =  tinySocial.connectedComponents()
//    val vertexRdd = graph.vertices
//    val graphResult = vertexRdd.toDF("source_id","one_id")
//    println("=======================================================================Graph end! " + java.time.Instant.now().toEpochMilli)
//
//    //persist graph result
//    graphResult
//      .coalesce(coalescePartitions)
//      .selectExpr(s"cast(source_id as Decimal(20,0)) + cast(${Long.MaxValue} as Decimal(20,0)) + 1 as source_id", s"cast(one_id as Decimal(20,0)) + cast(${Long.MaxValue} as Decimal(20,0)) + 1 as one_id")
//      .selectExpr("cast(source_id as String) as source_id", "cast(one_id as String) as one_id")
//      .write
//      .format("Hive")
//      .mode(SaveMode.Overwrite)
//      .saveAsTable(graphTable)
//
//    //clean graph cache
//    vertexRdd.unpersist()
//    graph.unpersist()
//    tinySocial.unpersist()
//  }
//}