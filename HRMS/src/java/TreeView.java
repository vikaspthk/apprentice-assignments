
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TreeView extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet TreeView</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        try
        {
            //ResultSetController rsc = new ResultSetController();
            ResultSet rs = ResultSetController.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for(int i=1;i<=columnCount;i++)
            {
                out.print("<th>");
                rsmd.getColumnName(i);
                out.print("</th>");
            }
            while(rs.next())
            {
                out.println("<tr>");
                for(int i=1;i<=columnCount;i++)
                {
                out.println("<td>");
                rs.getObject(i);
                out.println("</td>");
                }
                out.println("</tr>");
            }
        }
        catch(Exception e)
        {
            out.print(e);
            e.printStackTrace();
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    
    }

}
