/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getset;

/**
 *
 * @author vikpatha
 */
public class Department {
    String org_name;
    String dept_id;
    String dept_name;
    String dept_desc;

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_desc() {
        return dept_desc;
    }

    public void setDept_desc(String dept_desc) {
        this.dept_desc = dept_desc;
    }
    
}
