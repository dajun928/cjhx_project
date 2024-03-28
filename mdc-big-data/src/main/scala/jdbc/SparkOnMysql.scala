package jdbc

import org.apache.spark.sql.SparkSession

import java.sql.{Connection, Driver, DriverManager, DriverPropertyInfo}
import java.util.Properties
import java.util.logging.Logger

object SparkOnMysql {
  def main(args: Array[String]): Unit = {
    // 创建 ExampleJdbcConnectionProvider 的实例
    val connectionProvider = new ExampleJdbcConnectionProvider()

    // 获取数据库连接
    val properties = new java.util.Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "123456")

    val driver: Driver = new Driver() {
      override def connect(url: String, info: Properties): Connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/cdp", "root", "123456")

      override def acceptsURL(url: String): Boolean = true

      override def getPropertyInfo(url: String, info: Properties): Array[DriverPropertyInfo] = Array(new DriverPropertyInfo("",""))

      override def getMajorVersion: Int = 0

      override def getMinorVersion: Int = 0

      override def jdbcCompliant(): Boolean = true

      override def getParentLogger: Logger =null
    }

    val options: Map[String, String] = Map(
      "driver" -> "com.mysql.jdbc.Driver",
      "url" -> "jdbc:mysql://localhost:3306/cdp",
      "user" -> "root",
      "password" -> "123456"
    )
    val connection = connectionProvider.getConnection(driver, options)
    // 设置连接参数
    //    connectionProvider.setConnectionParameters("jdbc:mysql://localhost:3306/your_database", "root", "123456")
    try {
      // 执行数据库操作，这里只是一个示例
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM t_user")

      // 处理结果集
      while (resultSet.next()) {
        // 处理每一行数据
        val column1Value = resultSet.getString("user_name")
        val column2Value = resultSet.getInt("user_age")
        println(column1Value)
        println(column2Value)
      }
    } finally {
      // 确保在使用完成后关闭数据库连接
      if (connection != null) {
        connection.close()
      }
    }
  }
}


//def main (args: Array[String] ): Unit = {
//  val spark = SparkSession
//  .builder ()
//  .appName ("Spark Hive Example")
//  .master ("local[*]")
//  .getOrCreate ()
//  }