package jdbc

import org.apache.spark.sql.SparkSession

object SparkReadMysql {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Spark Hive Example")
      .master("local[*]")
      .getOrCreate()

    val url = "jdbc:mysql://localhost:3306/cdp"
    val table = "t_user"
    val properties = new java.util.Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "123456")

    val df = spark.read.jdbc(url, table, properties)

    df.show()

    spark.stop()
  }
}
