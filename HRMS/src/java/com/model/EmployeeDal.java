package com.model;
/**
 *
 * @author vikpatha
 */
import java.sql.*;
import com.getset.Employee;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDal {
    public int empInsert(Employee emp){
    String sql="insert into employee(org_name,dept_id,employee_id,first_name,last_name) "
            + "values('"+emp.getOrg_name()+"','"+emp.getDept_id()+"','"+emp.getEmployee_id()+"','"+emp.getFirst_name()+"','"+emp.getLast_name()+"')";
    JDBCConnection jdbc=new JDBCConnection();
    jdbc.execute(sql);
    return 1;
    }
    public ResultSet selectAll(){
        JDBCConnection jdbc=new JDBCConnection();
        String sql="select * from employee";
        ResultSet rs=jdbc.query(sql);
        
        /*List<Employee>listEmployee=new ArrayList<Employee>();
        try{
            while(rs.next()){
                Employee employee=new Employee();
                employee.setOrg_name(rs.getString(rs.findColumn("org_id")));
                employee.setDept_id(rs.getString(rs.findColumn("dept_id")));
                employee.setEmployee_id(rs.getInt(rs.findColumn("employee_id")));
                employee.setFirst_name(rs.getString(rs.findColumn("first_name")));
                employee.setLast_name(rs.getString(rs.findColumn("last_name")));
                listEmployee.add(employee);
            }
        }catch(SQLException e){
        e.printStackTrace();
        }*/
         return rs;
    }
    
}
