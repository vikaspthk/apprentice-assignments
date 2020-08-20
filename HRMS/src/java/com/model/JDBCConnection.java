package com.model;

/**
 *
 * @author vikpatha
 */
import java.sql.*;
import java.util.logging.Logger;

public class JDBCConnection {
     Connection con=null;
     PreparedStatement stmt=null;
     ResultSet rs=null;
        Connection getConnection(){
           String driver="oracle.jdbc.driver.OracleDriver";
           String url="jdbc:oracle:thin:@localhost:1521:XE";
           String user="oracle";
           String password="oracle";
           try{
          Class.forName(driver); 
con = DriverManager.getConnection(url,user,password); 
       System.out.println("Connected");
       }
       catch(ClassNotFoundException e)
       {
           e.printStackTrace();
           Logger log = Logger.getLogger(JDBCConnection.class.getName());
           log.severe("Unable to connect to the database. "+e);
       }
           catch(SQLException e)
       {
           e.printStackTrace();
           Logger log = Logger.getLogger(JDBCConnection.class.getName());
           log.severe("Unable to connect to the database. "+e);
       }
       return con;
       }
       
       public int execute(String sql){
           Connection con=getConnection();
           try{
               stmt=con.prepareStatement(sql);
               stmt.executeUpdate(sql);
           }catch(SQLException e){
           e.printStackTrace();
           Logger log = Logger.getLogger(JDBCConnection.class.getName());
           log.severe("Unable to Insert into the database. "+e);
           }
           closeAll();
           return 1;
       
       }
       public ResultSet query(String sql){
       Connection con=getConnection();
       try{
           stmt=con.prepareStatement(sql);
           rs=stmt.executeQuery();
       }catch (SQLException e) {
			e.printStackTrace();
                        Logger log = Logger.getLogger(JDBCConnection.class.getName());
                        log.severe("Unable to Select from database. "+e);
		}
		return rs;
	}
       public void closeAll(){
           try
		{
			rs.close();
			rs=null;
		}
		catch(Exception e){
			rs=null;
		}
		try
		{
			stmt.close();
			stmt=null;
		}
		catch(Exception e){
			stmt=null;
		}
		try
		{
			con.close();
			con=null;
		}
		catch(Exception e){
			con=null;
		}
       
       }
       
}