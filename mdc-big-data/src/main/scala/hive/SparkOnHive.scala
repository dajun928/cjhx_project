package hive


import org.apache.spark.sql.SparkSession

object SparkOnHive extends App {

  case class Record(key: Int, value: String)

  val spark = SparkSession
    .builder()
    .appName("Spark Hive Example")
    .master("local[*]")
    .enableHiveSupport()
    .getOrCreate()

  import spark.sql

  sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING)").show()
  sql("LOAD DATA LOCAL INPATH 'mdc-big-data/src/main/resources/kv1.txt' INTO TABLE src").show
  sql("SELECT * FROM src").show()
}

