import java.sql.*;
/**
 *
 * @author vikpatha
 */
public class Conn {
public static void main(String...arg){    
try{
    //String url="jdbc:derby://localhost:1527/oracle";
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String url="jdbc:oracle:thin:@localhost:1521:XE";
    String user="oracle";
    String pwd="oracle";
   // Connection con=DriverManager.getConnection(url,user,pwd);
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oracle","oracle");
   //System.out.print("Connected");
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from employees");
    while(rs.next()){
    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
    con.close();
    }
    
}catch(Exception e){}
}}
