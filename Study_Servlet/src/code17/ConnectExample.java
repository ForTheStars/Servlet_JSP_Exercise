package code17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectExample {
	
	public static void driver(){
		//MySQL数据库
		String driverMySQL = "com.mysql.jdbc.Driver";
		//Oracle数据库
		String driverOracle = "oracle.jdbc.driver.OracleDriver";
		//SQL Server数据库
		String driverSQLServer = "com.microsoft.jdbc.sqlservlet.SQLServerDriver";
		try {
			Class.forName(driverMySQL); // 动态加载mysql驱动
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver:"+driverMySQL);
		}
	}
	public static Connection connection(){
		driver();
		//以MySQL为例
		String url = "jdbc:mysql://localhost:3306/msg";
		String username = "jhc";
		String password = "jhc123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String aaString = "asdasd";
		return connection;
	}
	
	public static void createStatement(){
		try {
			Statement statement = connection().createStatement();
			//该SQL语句需要采取字符串与变量的拼接，很容易进行 SQL 注入攻击
			statement.executeQuery("SQL语句");
			
			//使用PreparedStatement，预编译，安全
			PreparedStatement preparedStatement = connection().prepareStatement("SQL语句");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void affair(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			String sql = "delete from t_user where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 5);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.close(connection);
			DBUtil.close(preparedStatement);
			DBUtil.close(resultSet);
		}
	}
	
	public static void close(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
