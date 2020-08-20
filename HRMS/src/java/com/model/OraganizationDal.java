/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;
import java.sql.*;
import com.getset.Organization;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikpatha
 */
public class OraganizationDal {
     public int orgInsert(Organization org){
    String sql=String.format("insert into organization(org_name,org_desc)"
            + "values('%s','%s')",org.getOrg_name(),org.getOrg_desc());
    JDBCConnection jdbc=new JDBCConnection();
    jdbc.execute(sql);
    return 1;
    }
     
     public ResultSet selectAll(){
        JDBCConnection jdbc=new JDBCConnection();
        String sql="select * from organization";
        ResultSet rs=jdbc.query(sql);
        /*List<Organization>listOrganization=new ArrayList<Organization>();
        try{
            while(rs.next()){
                Organization orgn=new Organization();
                orgn.setOrg_name(rs.getString(rs.findColumn("org_name")));
                orgn.setOrg_desc(rs.getString(rs.findColumn("org_desc")));
                
            }}catch(SQLException e){
            e.printStackTrace();
            }
        jdbc.closeAll();*/
         return rs;
     
     }
    
}
