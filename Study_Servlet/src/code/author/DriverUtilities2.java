package code.author;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/** Extends <CODE>DriverUtilities</CODE> to support the
 *  loading of driver information for different database vendors
 *  from an XML file (default is drivers.xml). Both DOM and
 *  JAXP are used to read the XML file.  The format for the
 *  XML file is:
 *  <P>
 *  <PRE>
 *    &lt;drivers&gt;
 *      &lt;driver&gt;
 *        &lt;vendor&gt;ORACLE&lt;/vendor&gt;
 *        &lt;description&gt;Oracle&lt;/description&gt;
 *        &lt;driver-class&gt;
 *          oracle.jdbc.driver.OracleDriver
 *        &lt;/driver-class&gt;
 *        &lt;url&gt;
 *          jdbc:oracle:thin:@[$host]:1521:[$dbName]
 *        &lt;/url&gt;
 *      &lt;/driver&gt;
 *      ...
 *    &lt;drivers&gt;
 *  </PRE>
 *  <P>
 *  The url element should contain the placeholders
 *  [$host] and [$dbName] to substitute for the host and
 *  database name in makeURL.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall and Larry Brown.
 *  May be freely used or adapted.
 */

public class DriverUtilities2 extends DriverUtilities {
  public static final String DEFAULT_FILE = "drivers.xml";

  /** Load driver information from default XML file,
   *  drivers.xml.
   */

  public static void loadDrivers() {
    DriverUtilities2.loadDrivers(DEFAULT_FILE);
  }

  /** Load driver information from specified XML file. Each
   *  vendor is represented by a <CODE>DriverInfoBean</CODE>
   *  object and stored in the map, with the vendor name as
   *  the key. Use this method if you need to load a
   *  driver file other than the default, drivers.xml.
   */
  
  // http://blog.csdn.net/lishuangzhe7047/article/details/19508821
  public static void loadDrivers(String filename) {
    File file = new File(filename);
    try {
      InputStream in = new FileInputStream(file);
      //创建文件解析工厂  
      DocumentBuilderFactory builderFactory =
        DocumentBuilderFactory.newInstance();
      //使用工厂创建文件解析类
      DocumentBuilder builder =
        builderFactory.newDocumentBuilder();
      //开始解析文件，将文件加载进内存，形成dom树
      Document document = builder.parse(in);
      //getDocumentElement	该属性允许直接文档的文档元素的各个子节点
      document.getDocumentElement().normalize();
      Element rootElement = document.getDocumentElement();
      //以文档顺序返回具有给定标记名称的所有后代 Elements 的 NodeList。
      NodeList driverElements =
        rootElement.getElementsByTagName("driver");
      // Build DriverInfoBean for each vendor
      for(int i=0; i<driverElements.getLength(); i++) {
    	  //获得结点
        Node node = driverElements.item(i);
        DriverInfoBean info =
          DriverUtilities2.createDriverInfoBean(node);
        if (info != null) {
          addDriverInfoBean(info);
        }
      }
    } catch(FileNotFoundException fnfe) {
      System.err.println("Can't find " + filename);
    } catch(IOException ioe) {
      System.err.println("Problem reading file: " + ioe);
    } catch(ParserConfigurationException pce) {
      System.err.println("Can't create DocumentBuilder");
    } catch(SAXException se) {
      System.err.println("Problem parsing document: " + se);
    }
  }

  /** Build a DriverInfoBean object from an XML DOM node
   *  representing a vendor driver in the format:
   *  <P>
   *  <PRE>
   *    &lt;driver&gt;
   *      &lt;vendor&gt;ORACLE&lt;/vendor&gt;
   *      &lt;description&gt;Oracle&lt;/description&gt;
   *      &lt;driver-class&gt;
   *         oracle.jdbc.driver.OracleDriver
   *      &lt;/driver-class&gt;
   *      &lt;url&gt;
   *        jdbc:oracle:thin:@[$host]:1521:[$dbName]
   *      &lt;/url&gt;
   *    &lt;/driver&gt;
   *  </PRE>
   */

  public static DriverInfoBean createDriverInfoBean(Node node) {
    Map map = new HashMap();
    //包含此节点的所有子节点的 NodeList。
    NodeList children = node.getChildNodes();
    for(int i=0; i<children.getLength(); i++) {
      Node child = children.item(i);
      String nodeName = child.getNodeName();
      //判断结点是不是一个元素
      if (child instanceof Element) {
        Node textNode = child.getChildNodes().item(0);
        if (textNode != null) {
        	//将名字和值压入map
          map.put(nodeName, textNode.getNodeValue());
        }
      }
    }
    return(new DriverInfoBean((String)map.get("vendor"),
                              (String)map.get("description"),
                              (String)map.get("driver-class"),
                              (String)map.get("url")));
  }
}           