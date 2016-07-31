package code.author;

import java.io.*;
import java.sql.*;
import java.util.*;

/** Some simple utilities for building JDBC connections to
 *  databases from different vendors. The drivers loaded are
 *  hard-coded and specific to our local setup. You can
 *  either modify the loadDrivers method and recompile or
 *  use <CODE>DriverUtilities2</CODE> to load the driver
 *  information for each vendor from an XML file.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall and Larry Brown.
 *  May be freely used or adapted.  
 */

public class DriverUtilities {
  public static final String MSACCESS = "MSACCESS";
  public static final String MYSQL = "MYSQL";
  public static final String ORACLE = "ORACLE"; 

  // Add constant to refer to your database here ...
  
  protected static Map driverMap = new HashMap();

  /** Load vendor driver information. Here we have hard-coded
   *  driver information specific to our local setup.
   *  Modify the values according to your setup.
   *  Alternatively, you can use <CODE>DriverUtilities2</CODE>
   *  to load driver information from an XML file.
   *  <P>
   *  Each vendor is represented by a
   *  <CODE>DriverInfoBean</CODE> that defines a vendor
   *  name (keyword), description, driver class, and URL. The
   *  bean is stored in a driver map; the vendor name is 
   *  used as the keyword to retrieve the information.
   *  <P>
   *  The url variable should contain the placeholders
   *  [$host] and [$dbName] to substitute for the <I>host</I>
   *  and <I>database name</I> in <CODE>makeURL</CODE>.
   */

  public static void loadDrivers() {
	  // 供应商		描述			//驱动class	url连接
    String vendor, description, driverClass, url;
    DriverInfoBean info = null;

    // MSAccess
    vendor = MSACCESS;
    description = "MS Access 4.0";
    driverClass = "sun.jdbc.odbc.JdbcOdbcDriver";
    url = "jdbc:odbc:[$dbName]";
    info = new DriverInfoBean(vendor, description,
                              driverClass, url);
    addDriverInfoBean(info);
    
    // MySQL
    vendor = MYSQL;
    description = "MySQL Connector/J 3.0";
    driverClass = "com.mysql.jdbc.Driver";
    url = "jdbc:mysql://[$host]:3306/[$dbName]";
    info = new DriverInfoBean(vendor, description,
                              driverClass, url);
    addDriverInfoBean(info);

    // Oracle
    vendor = ORACLE;
    description = "Oracle9i Database";
    driverClass = "oracle.jdbc.driver.OracleDriver";
    url = "jdbc:oracle:thin:@[$host]:1521:[$dbName]";
    info = new DriverInfoBean(vendor, description,
                              driverClass, url);
    addDriverInfoBean(info);

    // Add info on your database here...
  }

  /** Add information (<CODE>DriverInfoBean</CODE>) about new
   *  vendor to the map of available drivers.
   */
  //根据各厂商驱动添加进Map
  public static void addDriverInfoBean(DriverInfoBean info) {
    driverMap.put(info.getVendor().toUpperCase(), info);
  }

  /** Determine if vendor is represented in the loaded
   *  driver information.
   */
  //判断Map中是否存在对应的厂商驱动
  public static boolean isValidVendor(String vendor) {
    DriverInfoBean info =
      (DriverInfoBean)driverMap.get(vendor.toUpperCase());
    return(info != null);
  }

  /** Build a URL in the format needed by the
   *  database drivers. In building of the final URL, the
   *  keywords [$host] and [$dbName] in the URL
   *  (looked up from the vendor's <CODE>DriverInfoBean</CODE>)
   *  are appropriately substituted by the host and dbName
   *  method arguments.
   */
   //创建URL，提供主机名和数据库名，根据供应商创建
  public static String makeURL(String host, String dbName,
                               String vendor) {
    DriverInfoBean info =
      (DriverInfoBean)driverMap.get(vendor.toUpperCase());
    if (info == null) {
      return(null);
    }
    StringBuffer url = new StringBuffer(info.getURL());
    //替换
    DriverUtilities.replace(url, "[$host]", host);
    DriverUtilities.replace(url, "[$dbName]", dbName);
    return(url.toString());
  }

  /** Get the fully qualified name of a driver. */

  public static String getDriver(String vendor) {
    DriverInfoBean info =
      (DriverInfoBean)driverMap.get(vendor.toUpperCase());
    if (info == null) {
      return(null);
    } else {
      return(info.getDriverClass());
    }
  }

  /** Perform a string substitution, where the first "match"
   *  is replaced by the new "value".
   */
  //根据给出的第一个关键词match，替换成对应的value
  private static void replace(StringBuffer buffer,
                              String match, String value) {
    int index = buffer.toString().indexOf(match);  //查找match
    if (index > 0) {
      buffer.replace(index, index + match.length(), value);
    }
  }
}   