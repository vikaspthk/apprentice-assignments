/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.model;
import java.sql.*;
import com.getset.Department;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vikpatha
 */
public class DepartmentDal {
     public int deptInsert(Department dept){
    String sql=String.format("insert into department(org_name,dept_id,dept_name,dept_desc)"
            + "values('%s','%s','%s','%s')",dept.getOrg_name(),dept.getDept_id(),dept.getDept_name(),dept.getDept_desc());
    JDBCConnection jdbc=new JDBCConnection();
    jdbc.execute(sql);
    return 1;
    }
     public ResultSet selectAll(){
        JDBCConnection jdbc=new JDBCConnection();
        String sql="select * from department";
        ResultSet rs=jdbc.query(sql);
        /* List<Department>listDepartment=new ArrayList<Department>();
        try{
            while(rs.next()){
                Department dep=new Department();
                dep.setOrg_name(rs.getString(rs.findColumn("org_name")));
                dep.setDept_id(rs.getString(rs.findColumn("dept_id")));
                dep.setDept_name(rs.getString(rs.findColumn("dept_name")));
                dep.setDept_desc(rs.getString(rs.findColumn("dept_desc")));
            }}catch(SQLException e){
            e.printStackTrace();
            }
        jdbc.closeAll(); */
         return rs;
     
     }
     
    
}
