import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
  
    public RequestDispatcher rd;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = JDBCConnection.getInstance();
        try
        {
            String user_input = request.getParameter("user");
            String pass_input = request.getParameter("pass");
            String sql = "Select * from HRMS_LOGIN where USERNAME='"+user_input+"' and PASSWORD='"+pass_input+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            String user = rs.getString(1);
            String pass = rs.getString(2);
	    String user_type = rs.getString(3);
            if(user.equals(user_input) && pass.equals(pass_input) && user_type.equals("admin"))
            {
                this.rd = request.getRequestDispatcher("/MainFrame.html");
                rd.forward(request, response);
            }
            else if(user.equals(user_input) && pass.equals(pass_input) && !user_type.equals("admin"))
            {
		PrintWriter out = response.getWriter();
		out.println("<h2><center style='color:red;margin-top:15%'>User not authorized</center><h2>");
            }
        }
        catch(SQLException e)
        {        
		PrintWriter out = response.getWriter();
		out.println("<html><h2><center style='color:red;'>Invalid Credentials entered! <br>Please login again.</center><h2></html>");
		this.rd = request.getRequestDispatcher("/index.html");
		rd.include(request, response);
        }
    }
  
}