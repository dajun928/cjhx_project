package jdbc



//import java.sql.DriverManager
//import java.sql.{Connection, Driver}
//
//import org.apache.spark.internal.Logging
//import org.apache.spark.sql.jdbc.JdbcConnectionProvider
//
//class ExampleJdbcConnectionProvider extends JdbcConnectionProvider with Logging {
//  logInfo("ExampleJdbcConnectionProvider instantiated")
//
//  override val name: String = "ExampleJdbcConnectionProvider"
//
//  override def canHandle(driver: Driver, options: Map[String, String]): Boolean = false
//
//  override def getConnection(driver: Driver, options: Map[String, String]): Connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/cdp", "root", "123456")
//
//  override def modifiesSecurityContext(
//                                        driver: Driver,
//                                        options: Map[String, String]
//                                      ): Boolean = false
//}


