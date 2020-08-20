
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultSetController extends HttpServlet {

static ResultSet rs;
String tabSelected;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.tabSelected = request.getParameter("form");
        PrintWriter out = response.getWriter();
        Connection con = JDBCConnection.getInstance();
        try
        {
            Statement stmt = con.createStatement();
            String sqlOrg = "Select * from organization";
            String sqlDept = "Select * from department";
            String sqlEmp = "Select * from employee";
            
            if(tabSelected.equals("org_frame"))
            {
                this.rs = stmt.executeQuery(sqlOrg);
            }
            if(tabSelected.equals("dept_frame"))
            {
                this.rs = stmt.executeQuery(sqlDept);
            }
            if(tabSelected.equals("emp_frame"))
            {
                this.rs = stmt.executeQuery(sqlEmp);
            }
        }
        catch(SQLException e)
        {
            out.print(e);
        }
        getResultSet();
        RequestDispatcher rd = request.getRequestDispatcher("/FrameController");
        rd.forward(request, response);
    }
    public static ResultSet getResultSet()
    {
        return rs;
    }
    
}
